public class Heap {
    private int currentSize;
    private Node1 [] heapArray;
    private int last;
    
    public Heap(int size) {
        heapArray= new Node1[size];
        currentSize=0;
        last=0;
    }


    public boolean insertAt(int index,int value) {
        Node1 newNode=new Node1(value);
        heapArray[index]=newNode;
        trickleUp(currentSize++);
        last++;
        return true;
    }
    
    public void trickleUp(int index) {
        int parent=(index-1)/2;
        Node1 bottom=heapArray[index];
       
        while(index>0 && heapArray[parent].getKey() < bottom.getKey()) {
            heapArray[index]=heapArray[parent];
            index=parent;
            parent=(parent-1)/2;
        }
        heapArray[index]=bottom;
    }
    public void trickleDown(int index) {
        int largerChild;
        Node1 top=heapArray[index];
        while(index<currentSize/2) {
            int leftChild=2*index+1;
            int rightChild=leftChild+1;
            
            if (rightChild < currentSize && heapArray[leftChild].getKey() < heapArray[rightChild].getKey()) {
                largerChild=rightChild;
            }else{
                largerChild=leftChild;
            } 
            if (top.getKey() >= heapArray[largerChild].getKey()) {
                break;
            }
            heapArray[index]=heapArray[largerChild];
            index=largerChild;
        }
        heapArray[index]=top;
    }
    public void displayHeap() {
        System.out.println("Heap Array");
        for (int  i = 0; i < currentSize; i++) {
            if (heapArray[i] != null) {
                System.out.print(heapArray[i].getKey()+" ");
            }else{
                System.out.println("--");
            }
        }
        System.out.println("");
        int nBlank=32;
        int itemsPerRow=1;
        int column=0;
        int j=0;
        String data=".........................";
        System.out.println(data+data);
        while(currentSize > 0) {
            if (column==0) {
                for (int k = 0; k < nBlank; k++) {
                    System.out.print(" ");
                }
            }
            System.out.print(heapArray[j].getKey());
            if (++j == currentSize) {
                break;
            }
            if (++column == itemsPerRow) {
                nBlank /=2;
                itemsPerRow *=2;
                column=0;
                System.out.println();
            }else{
                for (int k = 0; k < nBlank*2-2; k++) {
                    System.out.print(" ");
                }
            }
        }
        System.out.println("\n"+data+data);
    }
    public void displayArray() {
        for (int i = 0; i < last; i++) {
            if (heapArray[i] != null) {
                System.out.print(heapArray[i].getKey()+" ");
            }
        //System.out.println("");
        }
    }
    public void HeapSort() {
        System.out.println(".................................");
        for (int i =last-1; i >=0; i--) {
            for (int j = last/2-1; j >= 0; j--) {
                trickleDown(j);
            }
            Node1 remove=this.remove();
            heapArray[i]=remove;
        }
    }
    public Node1 remove() {
        Node1 root=heapArray[0];
        heapArray[0]=heapArray[--currentSize];
        trickleDown(0);
        return root;
    }
}







    


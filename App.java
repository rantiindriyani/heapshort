public class App {
    public static void main(String[] args ) {
        int maxSize=35;
        Heap theHeap=new Heap (maxSize);
        System.out.println("Sebelum urut :");
        System.out.println("");
        theHeap.insertAt(0, 30);
        theHeap.insertAt(1, 20);
        theHeap.insertAt(2, 15);
        theHeap.insertAt(3, 10);
        theHeap.insertAt(4, 5);
        
       

        theHeap.displayHeap();

        System.out.println("Setelah urut :");
        theHeap.HeapSort();
        theHeap.displayArray();
    }
}









    


 


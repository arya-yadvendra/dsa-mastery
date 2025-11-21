package Sorting;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();

        heap.insert(34);
        heap.insert(45);
        heap.insert(22);
        heap.insert(89);
        heap.insert(76);

        try {
            System.out.println(heap.remove());
//            System.out.println(heap.remove());
//            System.out.println(heap.remove());
//            System.out.println(heap.remove());

        } catch (Exception e) {
            throw new RuntimeException(e);}


        ArrayList<Integer> list = heap.heapSort();
        System.out.println(list);

    }
}

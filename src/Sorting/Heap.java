package Sorting;

import java.util.ArrayList;

class Heap<T extends Comparable<T>> {

    private final ArrayList<T> list;
    public Heap(){
        list = new ArrayList<>();
    }

    private void swap(int first, int second){
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    private int parent(int index){
        return (index -1)/2;
    }

    private int left(int index) {
        return index * 2 + 1;
    }

    private int right(int index){
        return index*2+2;
    }

    public void insert(T value){
        list.add(value);
        upHead(list.size()-1);
    }
    private void upHead(int index){
        if(index==0)
            return;
        int p = parent(index);
        if(list.get(index).compareTo(list.get(p))<0){
            swap(index , p);
            upHead(p);
        }
    }
    public T remove() throws Exception{
        if(list.isEmpty()){
            throw new Exception("Removing from empty heap!");
        }
        T temp = list.getFirst();
        T last = list .removeLast();
        if(!list.isEmpty()){
            list.set(0, last);
            downHeap(0);
        }
        return temp;
    }
    public void downHeap(int index){
        int min = index;
        int left = left(index);
        int right = right(index);

        if(left < list.size() && list.get(min).compareTo(list.get(left))>0){
            min = left;
        }
        if(right < list.size() && list.get(min).compareTo(list.get(right))>0){
            min = right;
        }
        if(min!=index){
            swap(min, index);
            downHeap(min);
        }
    }
    public ArrayList<T> heapSort() throws Exception{
        ArrayList<T> data = new ArrayList<>();
        while(!list.isEmpty()){
            data.add(this.remove());
        }
        return data;
    }
}

public class MaxHeap implements Heap {
    int size;
    Integer[] data;
    public MaxHeap(int capacity) {
        data = new Integer[capacity];
        size = 0;
    }
    // build a heap based on data
    // to be implemented in O(nlogn)
    public void MaxHeapLogN(Integer[] data) {
        // homework
        //Start with empty heap, and fill it as we go
        for(int i = 0; i < data.length; i++){
            //the n part of nlogn; here, we insert each element from
            //data array
            add(data[i]);
        }
    }
    // build a heap based on data
    // to be implemented in O(n)
    public void MaxHeapN(Integer[] data) {
        // homework
        size = data.length;
        this.data = data;
        restoreHeapProperty();
    }
    // add an item to the heap
    public boolean add(Integer item) {
        // homework
        boolean operationSuccessful = false;
        if(data.length > size){
            operationSuccessful = true;
            size++;
            int insertPosition = size-1;
            //accounts for empty heap
            data[insertPosition] = item;
            //inserting item at end of list
            heapifyUp(insertPosition);
        }
        return operationSuccessful;
    }
    public void heapifyUp(int elementPosition){
        int i = elementPosition;
        int compTerm = 1;
        while(i > 0){
            compTerm = (i%2==0)? ((i-1)/2):(i/2);
            if(data[i] > data[compTerm]){
                //if child larger than parent
                swap(i, compTerm);
            }
            i = compTerm;
        }
    }
    public void heapifyDown(int elementPosition){
        int i = elementPosition;
        int compTerm = 1;
        boolean condition = (i%2==0)? 2*i+2<size:2*i+1<size;
        while(condition){
            if(2*i+2<size){
                compTerm = (data[2*i+1]>data[2*i+2])? (2*i+1):(2*i+2);
                //chooses the larger child to heapify down to
            }
            else if(2*i+1<size){
                compTerm = 2*i+1;
            }
            else{
                break;
            }
            //checks which child is greater; heapifies down to that child's location
            //if that child is larger than its parent
            if(data[i] < data[compTerm]){
                //if child larger than parent
                swap(i, compTerm);
            }
            i = compTerm;
            condition = compTerm < size;
        }
    }
    private void restoreHeapProperty(){
        int i = (size-1);//(int) Math.log(size);
        int compTerm = 1;
        while(i > 0){
            compTerm = (i%2==0)? ((i-1)/2):i/2;
            heapifyDown(compTerm);
            i = i-2;
        }
    }
    // return the max item in the heap
    public Integer get() {
        // homework
        return data[0];
    }
    private void swap(int a, int b){
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
    // remove the root item
    public Integer pop() {
        // homework
        Integer poppedItem = data[0];
        for(int i = 1; i < data.length; i++){
            data[i-1] = data[i];
        }
        data[size-1] = null;
        size--;
        heapifyDown(0);
        return poppedItem;
    }
    @Override
    public String toString(){
        String retVal = "";
        for(int i = 0; i < size; i++){
            retVal = retVal + data[i] + ", ";
        }
        return retVal;
    }
}

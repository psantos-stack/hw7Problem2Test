public class Main {

    public static void main(String[] args) {
        // left empty
        MaxHeap a = new MaxHeap(28);
        Integer[] data = new Integer[28];
        for(int i = 0; i < 28; i++){
            data[i] = i;
            //a.add((int)(200*Math.random()));
        }
        //System.out.println(a.toString());
        a.MaxHeapN(data);
        //a.MaxHeapLogN(data);
        System.out.println(a.toString());
        //a.pop();
        //System.out.println(a.toString());
    }
}

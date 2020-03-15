import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
public class MaxHeapTest {
    // homework
    public static void main(String[] args) {
        Integer[] data = new Integer[50000000];
        for(int i = 0; i < 50000000; i++){
            int randInt = (int)(5000000*Math.random());
            data[i] = randInt;
        }
        assertTrue(MaxHeapLogN(data) > MaxHeapN(data));
        //MaxHeapLogN(data);
        //MaxHeapN(data);
    }
    public static long MaxHeapLogN(Integer[] data){
        MaxHeap a = new MaxHeap(data.length);
        long start2 = System.nanoTime();
        a.MaxHeapLogN(data);
        long end2 = System.nanoTime();
        long durationInMillis2 = TimeUnit.NANOSECONDS.toMillis(end2 - start2);
        System.out.println("MaxHeapLogN: " + durationInMillis2);
        return durationInMillis2;
    }
    public static long MaxHeapN(Integer[] data){
        MaxHeap b = new MaxHeap(data.length);
        long start1 = System.nanoTime();
        b.MaxHeapN(data);
        long end1 = System.nanoTime();
        long durationInMillis = TimeUnit.NANOSECONDS.toMillis(end1 - start1);
        System.out.println("MaxHeapN: " + durationInMillis);
        return durationInMillis;
    }
}
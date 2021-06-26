import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Kth_Smallest {
    public static int find_Kth_Smallest(List<Integer> list, int k) {
        // PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());

        for(int i=0; i<list.size(); i++){
            pq.add(list.get(i));

            if(pq.size() > k) {
                pq.remove();
            }
        }

        return pq.peek();
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(7, 10, 4, 3, 20, 15, 26, 85, 1);
        System.out.println(list);
        System.out.println("kth smallest element: " + find_Kth_Smallest(list, 3));
    }
}


/**

output :- 
[7, 10, 4, 3, 20, 15, 26, 85, 1]
kth smallest element: 4

*/
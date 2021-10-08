import java.util.*;

public class sumOfSubarray {



   public static int sumOfSubarray__OS_Logic(int[] arr, int[] query) {
     int left = query[0];
     int right = query[query.length-1];

    for(int i=1; i<arr.length; i++) {
      arr[i] += arr[i-1];
    }

    if(left == 0) {
      return arr[right];
    }

    int sum = arr[right] - arr[left - 1];
    return sum;

   }


  //*********************************************************************** */

  public static void sumOfSubarray__BF_Logic(int[] arr, int[] query) {
    int left = query[0];
    int right = query[query.length-1];

    int sum = 0;
    for(int i = left; i<=right; i++) {
      sum += arr[i];
    }

    System.out.println("-----------BruteForce--------- " + sum);
  }
  public static void sumOfSubarray__BF() {
    int[] arr = {5, -1, 4, 10, 3, 2};
    int[] query1 = {0, 2};
    int[] query2 = {0, 1};
    int[] query3 = {3, 5};

    sumOfSubarray__BF_Logic(arr, query1);
    sumOfSubarray__BF_Logic(arr, query2);
    sumOfSubarray__BF_Logic(arr, query3);
  }
  public static void sumOfSubarray__OS() {
    int[] arr = {5, -1, 4, 10, 3, 2};
    int[] query1 = {0, 3};
    int[] query2 = {2, 4};
    int[] query3 = {3, 5};

    int res = sumOfSubarray__OS_Logic(arr, query3);
    System.out.println("-------------------------RES----- " + res);
  }
  public static void solve() {
    // sumOfSubarray__BF();
    sumOfSubarray__OS();
  }
  public static void main(String[] args) {
    solve();
  }
}
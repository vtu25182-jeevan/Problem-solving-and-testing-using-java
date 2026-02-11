import java.util.Collections;
import java.util.List;

public class Task3 {
    public static void miniMaxSum(List<Integer> arr) {
long sum = arr.stream().mapToLong(Integer::longValue).sum();
int min = Collections.min(arr);
int max = Collections.max(arr);
System.out.println((sum - max) + " " + (sum - min));
}
}
    


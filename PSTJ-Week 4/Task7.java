import java.io.*;
import java.util.*;

class Result {

    public static int diagonalDifference(List<List<Integer>> arr) {
        int n = arr.size();
        int primary = 0;
        int secondary = 0;

        for (int i = 0; i < n; i++) {
            primary += arr.get(i).get(i);
            secondary += arr.get(i).get(n - 1 - i);
        }

        return Math.abs(primary - secondary);
    }
}

public class Task7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] row = bufferedReader.readLine().trim().split(" ");
            List<Integer> rowList = new ArrayList<>();
            for (String s : row) {
                rowList.add(Integer.parseInt(s));
            }
            arr.add(rowList);
        }

        int result = Result.diagonalDifference(arr);
        System.out.println(result);

        bufferedReader.close();
    }
}

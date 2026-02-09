import java.io.*;
import java.util.*;

public class Task2{

    public static int birthday(List<Integer> s, int d, int m) {
        int count = 0;
        int n = s.size();

        for (int i = 0; i <= n - m; i++) {
            int sum = 0;
            for (int j = i; j < i + m; j++) {
                sum += s.get(j);
            }
            if (sum == d) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> s = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            s.add(sc.nextInt());
        }

        int d = sc.nextInt(); // Ron's birth day
        int m = sc.nextInt(); // Ron's birth month

        System.out.println(birthday(s, d, m));
        sc.close();
    }
}


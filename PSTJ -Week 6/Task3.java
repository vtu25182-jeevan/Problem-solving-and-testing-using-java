import java.io.*;
import java.util.*;

public class Task3 {

    public static String twoStrings(String s1, String s2) {
        boolean[] letters = new boolean[26];

        // Mark characters from s1
        for (char c : s1.toCharArray()) {
            letters[c - 'a'] = true;
        }

        // Check if any character in s2 exists in s1
        for (char c : s2.toCharArray()) {
            if (letters[c - 'a']) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        sc.nextLine(); // consume newline

        while (p-- > 0) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            System.out.println(twoStrings(s1, s2));
        }

        sc.close();
    }
}
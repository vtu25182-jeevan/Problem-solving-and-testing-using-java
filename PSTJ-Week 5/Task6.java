import java.io.*;
import java.util.*;

public class Task6
{

    public static int alternatingCharacters(String s) {
        int deletions = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                deletions++;
            }
        }

        return deletions;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine().trim());

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < q; i++) {
            String s = br.readLine().trim();
            output.append(alternatingCharacters(s)).append("\n");
        }

        System.out.print(output.toString());
    }
}

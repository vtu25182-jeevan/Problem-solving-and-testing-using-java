import java.io.*;
import java.util.*;

public class Task10 {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {
            List<Integer> ring = new ArrayList<>();

            int top = layer;
            int left = layer;
            int bottom = m - layer - 1;
            int right = n - layer - 1;

            // top row
            for (int j = left; j <= right; j++)
                ring.add(matrix.get(top).get(j));

            // right column
            for (int i = top + 1; i <= bottom - 1; i++)
                ring.add(matrix.get(i).get(right));

            // bottom row
            for (int j = right; j >= left; j--)
                ring.add(matrix.get(bottom).get(j));

            // left column
            for (int i = bottom - 1; i >= top + 1; i--)
                ring.add(matrix.get(i).get(left));

            int len = ring.size();
            int rot = r % len;   // optimize large r

            // rotate anti-clockwise
            Collections.rotate(ring, -rot);

            int idx = 0;

            // put back top row
            for (int j = left; j <= right; j++)
                matrix.get(top).set(j, ring.get(idx++));

            // put back right column
            for (int i = top + 1; i <= bottom - 1; i++)
                matrix.get(i).set(right, ring.get(idx++));

            // put back bottom row
            for (int j = right; j >= left; j--)
                matrix.get(bottom).set(j, ring.get(idx++));

            // put back left column
            for (int i = bottom - 1; i >= top + 1; i--)
                matrix.get(i).set(left, ring.get(idx++));
        }

        // print result
        for (List<Integer> row : matrix) {
            for (int j = 0; j < row.size(); j++) {
                System.out.print(row.get(j));
                if (j != row.size() - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int r = sc.nextInt();

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(sc.nextInt());
            }
            matrix.add(row);
        }

        matrixRotation(matrix, r);
        sc.close();
    }
}

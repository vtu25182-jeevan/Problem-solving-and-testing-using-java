import java.util.*;
import java.util.stream.*;

class Solution2 {

    static class Student {
        String name;
        int marks;

        Student(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String name = sc.next();
            int marks = sc.nextInt();
            students.add(new Student(name, marks));
        }

        int K = sc.nextInt();

        String result =
            students.stream()
                    // sort: marks desc, name asc
                    .sorted(
                        Comparator.comparingInt((Student s) -> s.marks).reversed()
                                  .thenComparing(s -> s.name)
                    )
                    // take top K
                    .limit(K)
                    // extract names
                    .map(s -> s.name)
                    // join with space
                    .collect(Collectors.joining(" "));

        System.out.println(result);

        sc.close();
    }
}
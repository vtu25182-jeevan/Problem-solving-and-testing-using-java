import java.util.*;
import java.util.stream.Collectors;
class Student {
    String name;
    int marks;
    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
    public String getName() { return name; }
    public int getMarks() { return marks; }
}
public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);      
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();      
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int marks = sc.nextInt();
            students.add(new Student(name, marks));
        }        
        int k = sc.nextInt();
        sc.close();        
        String result = students.stream()
            
            .sorted(Comparator.comparingInt(Student::getMarks).reversed()
                              .thenComparing(Student::getName))
            
            .limit(k)
            
            .map(Student::getName)
           
            .collect(Collectors.joining(" "));

        
        System.out.println(result);
    }
}
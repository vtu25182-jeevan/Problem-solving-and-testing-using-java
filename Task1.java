import java.util.*;
import java.util.stream.Collectors;
public class Task1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);       
        int n = Integer.parseInt(scanner.nextLine());     
        if (n == 0) {
            System.out.println("-1");
            return;
        }
        List<Integer> numbers = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
            }
        }

        int result = numbers.stream()
                .distinct()                         
                .sorted(Comparator.reverseOrder())  
                .skip(1)                            
                .findFirst()                        
                .orElse(-1);                        
        System.out.println(result);
    }
}
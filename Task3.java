import java.util.*;
	import java.util.stream.Collectors;
	class Person {
	    private String name;
	    private int age;
	    public Person(String name, int age) {
	        this.name = name;
	        this.age = age;
	    }
	    public String getName() {
	        return name;
	    }

	    public int getAge() {
	        return age;
	    }
	}

	public class Task3 {	    	    
	    static int AGE_LIMIT;	    
	    public static boolean isOlderThanLimit(Person p) {
	        return p.getAge() > AGE_LIMIT;
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);	        	        
	        int n = Integer.parseInt(scanner.nextLine());
	        List<Person> persons = new ArrayList<>();
	        
	        for (int i = 0; i < n; i++) {
	            String[] parts = scanner.nextLine().split(" ");
	            String name = parts[0];
	            int age = Integer.parseInt(parts[1]);
	            persons.add(new Person(name, age));
	        }	        
	        AGE_LIMIT = scanner.nextInt();	       	        
	        String sortedNames = persons.stream()
	                .sorted(Comparator.comparing(Person::getName))
	                .map(Person::getName)
	                .collect(Collectors.joining(" "));
	        System.out.println(sortedNames);	        
	        String olderPersons = persons.stream()
	                .filter(Solution::isOlderThanLimit)
	                .map(Person::getName)
	                .collect(Collectors.joining(" "));
	        System.out.println(olderPersons);	        
	        String uppercaseNames = persons.stream()
	                .map(Person::getName)
	                .map(String::toUpperCase)
	                .collect(Collectors.joining(" "));
	        System.out.print(uppercaseNames);
	        
	        scanner.close();
	    }
	}



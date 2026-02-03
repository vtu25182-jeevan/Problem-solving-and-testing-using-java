public class possiblepairs {
    static void printPairs(int[] arr) {
for (int i = 0; i < arr.length; i++) {
for (int j = i + 1; j < arr.length; j++) {
System.out.println(arr[i] + " " + arr[j]);
}
}
}
    
}

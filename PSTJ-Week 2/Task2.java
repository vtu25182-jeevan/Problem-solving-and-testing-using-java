public class Task2{
    public static PerformOperation isOdd() {
return i -> {
return i % 2 != 0 ? true : false;
};
}
public PerformOperation isPrime() {
return i -> {
if (i == 2) return true;
if (i <= 1 || i % 2 == 0) return false;
int numberSqrt = (int)Math.sqrt(i);
for (int j=3; j<=numberSqrt; j+=2) {
if (i % j == 0) return false;
}
return true;
};
}
public static PerformOperation isPalindrome() {
return i -> {
String numberStr = String.valueOf(i);
String reversedStr = "";
for (int j=numberStr.length()-1; j>=0; j--) {
reversedStr += numberStr.charAt(j);
}
return numberStr.equals(reversedStr);
};
}
}

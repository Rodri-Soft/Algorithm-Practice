// Given an integer n, return a string array answer (1-indexed) where:

// answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
// answer[i] == "Fizz" if i is divisible by 3.
// answer[i] == "Buzz" if i is divisible by 5.
// answer[i] == i (as a string) if none of the above conditions are true.

// Example 1:

// Input: n = 3
// Output: ["1","2","Fizz"]
// Example 2:

// Input: n = 5
// Output: ["1","2","Fizz","4","Buzz"]
// Example 3:

// Input: n = 15
// Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FizzBuzz {
  public static void main(String[] args) {

    FizzBuzz fb = new FizzBuzz();

    String result = fb.chicharra();

    // for (String r : result) {
    //   System.out.println(r);
    // }

    System.out.println(result);

  }

  public List<String> fizzBuzz(int n) {

    List<String> listResult = new ArrayList<>();

    for (int i = 1; i <= n; i++) {
      String result;

      if (i % 3 != 0 && i % 5 != 0) {
        result = String.valueOf(i);

        listResult.add(result);
        continue;
      }

      if (i % 3 == 0 && i % 5 == 0) {
        result = "FizzBuzz";
        listResult.add(result);
        continue;
      }

      if (i % 3 == 0) {
        result = "Fizz";
        listResult.add(result);
        continue;
      }

      if (i % 5 == 0) {
        result = "Buzz";
        listResult.add(result);        
      }

    }

    return listResult;
  }

  public String chicharra() {

   Scanner sc = new Scanner(System.in);

    double a = sc.nextDouble();
    double b = sc.nextDouble();
    double c = sc.nextDouble();

    double discriminante = b * b - 4 * a * c;

    double primeraSolucion = (-b + Math.sqrt(discriminante)) / (2 * a);
    double segundaSolucion = (-b - Math.sqrt(discriminante)) / (2 * a);

    String r1 = (primeraSolucion == (long)primeraSolucion ? String.valueOf((long)primeraSolucion) : String.valueOf(primeraSolucion));
    String r2 = (segundaSolucion == (long)segundaSolucion ? String.valueOf((long)segundaSolucion) : String.valueOf(segundaSolucion));

    return r1 + " " + r2;
  }

}
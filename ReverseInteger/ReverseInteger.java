package ReverseInteger;

public class ReverseInteger {
  public static void main(String[] args) {

    ReverseInteger ri = new ReverseInteger();
    System.out.println(ri.reverse(-2147483412));
  }

  public int reverse(int x) { 
    
    int reverNumber = 0;
    if (x == 0) {
      return reverNumber;
    }
    
    while (x != 0) {
      int pop = x % 10;
      x /= 10;

      if (reverNumber > Integer.MAX_VALUE / 10 || reverNumber == Integer.MAX_VALUE / 10 && pop > 7 ) {
        return 0;
      }

      if (reverNumber < Integer.MIN_VALUE / 10 || reverNumber == Integer.MIN_VALUE / 10 && pop > 8 ) {
        return 0;
      }

      reverNumber = reverNumber * 10 + pop;
  
    }

    return reverNumber;
    
  }
}

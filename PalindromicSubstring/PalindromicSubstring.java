package PalindromicSubstring;

public class PalindromicSubstring {
  public static void main(String[] args) {

    PalindromicSubstring ps = new PalindromicSubstring();
    String resultado = ps.longestPalindrome("babad");

    System.out.println(resultado);

  }

  public String longestPalindrome(String s) {

    if (s.length() == 1) {
      return s;
    }

    int maxLength = 0;
    StringBuilder finalWord = new StringBuilder();    

    for (int i = 0; i < s.length(); i++) {

      Character charat = s.charAt(i);
      Character currentCharacter = charat;

      int endIndex = s.length() - 1;

      while (i <= endIndex) {

        for (int j = endIndex; j >= 0; j--) {

          Character endCharacter = s.charAt(j);

          if (currentCharacter.equals(endCharacter)) {
            endIndex = j;
            break;
          }

        }

        boolean esPalindromo = true;
        int start = i, end = endIndex;

        while (start < end) {
          if (s.charAt(start) != s.charAt(end)) {
            esPalindromo = false;
            break;
          }
          start++;
          end--;
        }

        if (esPalindromo) {
          String wordPal = s.substring(i, endIndex + 1);
          if (wordPal.length() > maxLength) {
            maxLength = wordPal.length();
            finalWord.setLength(0);
            finalWord.append(wordPal);
          }          
        }

        endIndex--;
      }

    }    

    return finalWord.toString();
  }

}
package twopointer;

import java.util.Locale;

public class Palindrome {

  void main() {
    String str = "A man, a plan, a canal: Panama";
    IO.println(isPalindrome(str));
  }

  public boolean isPalindrome(String s) {
    String sanitizedStr = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(Locale.ROOT);
    int i = 0, j = sanitizedStr.length() - 1;

    while (i < j) {
      if (sanitizedStr.charAt(i) == sanitizedStr.charAt(j)) {
        i++;
        j--;
      } else {
        return false;
      }
    }

    return true;
  }

}

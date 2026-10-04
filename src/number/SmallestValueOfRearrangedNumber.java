package number;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SmallestValueOfRearrangedNumber {

  void main () {
    long result = smallestNumber(-4076);
    System.out.println(result);
    System.out.println(smallestNumber(-1505 % 10));
  }

  public long smallestNumber(long num) {
    if (num == 0) {
      return 0;
    }

    boolean isPos = num >= 0;
    long nr;
    if (isPos) {
      nr = smallestPositiveNumber(num);
    } else {
      nr = -biggestPositiveNumber(-num);
    }

    return nr;
  }

  private long biggestPositiveNumber(long num) {
    List<Long> digits = new LinkedList<>();

    while (num > 0) {
      digits.add(num % 10);
      num /= 10;
    }

    digits.sort(Comparator.reverseOrder());
    long result = 0;
    for (long digit : digits) {
      result = result * 10 + digit;
    }

    return result;
  }

  private long smallestPositiveNumber(long num) {
    List<Long> digits = new LinkedList<>();

    while (num > 0) {
      digits.add(num % 10);
      num /= 10;
    }

    digits.sort(Long::compareTo);
    Long firstNonZeroDigit = -1L;
    for (int i = 0; i < digits.size(); i++) {
      if (digits.get(i) != 0) {
        firstNonZeroDigit = digits.remove(i);
        break;
      }
    }

    if(firstNonZeroDigit == -1L) {
      return -1;
    }

    long result = firstNonZeroDigit;
    while (!digits.isEmpty()) {
      result =result * 10 + digits.removeFirst();
    }

    return result;
  }

}

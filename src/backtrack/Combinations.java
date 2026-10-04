package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {

  /**
   * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
   * You may return the answer in any order.
   */
  
  void main() {
    combine(5, 3).forEach(System.out::println);
  }

  public List<List<Integer>> combine(int n, int k) {
    int[] numbers = new int[n];
    for (int i = 1; i <= n; i++) {
      numbers[i - 1] = i;
    }
    
    List<List<Integer>> combinations = new LinkedList<>();

    backtrack(numbers, combinations, new LinkedList<>(), 0, k);

    return combinations;
  }

  private void backtrack(int[] numbers, List<List<Integer>> accumulator, List<Integer> subList, int currentPos, int maxSize) {
    if (subList.size() == maxSize) {
      accumulator.add(new ArrayList<>(subList));
      return;
    }

    if (currentPos >= numbers.length) return;

    subList.add(numbers[currentPos]);
    backtrack(numbers, accumulator, subList, currentPos + 1, maxSize);
    subList.removeLast();
    backtrack(numbers, accumulator, subList, currentPos + 1, maxSize);
  }

}

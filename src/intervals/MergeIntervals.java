package intervals;

import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

  void main() {
    int[][] intervals = new int[][]{{1,4},{1, 5}};
    int[][] results = merge(intervals);
  }

  public int[][] merge(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return new int[0][0];
    }

    List<int[]> results = new LinkedList<>();

    quickSort(intervals, 0, intervals.length - 1);

    results.add(intervals[0]);
    for (int i = 1; i < intervals.length; i++) {
      int[] lastResult = results.get(results.size() - 1);
      int[] currentInterval = intervals[i];

      if (lastResult[1] >= currentInterval[0]) {
        lastResult[1] = Math.max(lastResult[1], currentInterval[1]);
      } else {
        results.add(currentInterval);
      }
    }

    return results.toArray(new int[results.size()][]);
  }

  // the QuickSort function implementation
  void quickSort(int[][] intervals, int low, int high) {
    if (low < high) {

      // pi is the partition return index of pivot
      int pi = partition(intervals, low, high);

      // recursion calls for smaller elements
      // and greater or equals elements
      quickSort(intervals, low, pi - 1);
      quickSort(intervals, pi + 1, high);
    }
  }

  // partition function
  int partition(int[][] intervals, int low, int high) {

    // choose the pivot
    int pivot = intervals[high][0];

    // index of smaller element and indicates
    // the right position of pivot found so far
    int i = low - 1;

    // traverse intervals[low..high] and move all smaller
    // elements to the left side. Elements from low to
    // i are smaller after every iteration
    for (int j = low; j <= high - 1; j++) {
      if (intervals[j][0] < pivot) {
        i++;
        swap(intervals, i, j);
      }
    }

    // Move pivot after smaller elements and
    // return its position
    swap(intervals, i + 1, high);
    return i + 1;
  }

  // swap function
  void swap(int[][] intervals, int i, int j) {
    int[] temp = intervals[i];
    intervals[i] = intervals[j];
    intervals[j] = temp;
  }


}

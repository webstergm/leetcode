package intervals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start
 * and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval
 * newInterval = [start, end] that represents the start and end of another interval.
 *
 * Two intervals are considered overlapping if they share at least one point.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still
 * does not have any overlapping intervals (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 *
 * Note that you don't need to modify intervals in-place. You can make a new array and return it.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 *
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertIntervals {

  void main() {
//    int[][] intervals = new int[][]{{1, 3}, {6, 9}};
//    int[] newInterval = new int[]{2, 5};

//    int[][] intervals = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
//    int[] newInterval = new int[]{4, 8};

    int[][] intervals = new int[][]{{1,5}};
    int[] newInterval = new int[]{2, 3};

    int[][] results = insert(intervals, newInterval);

    IO.println(Arrays.deepToString(results));
  }

  public int[][] insert(int[][] intervals, int[] newInterval) {
    if (intervals == null || intervals.length == 0) {
      return new int[][]{newInterval};
    }

    List<int[]> results = new LinkedList<>();

    int i = 0;
    while (i < intervals.length && intervals[i][1] < newInterval[0]) {
      results.add(intervals[i]);
      i++;
    }

    while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
      newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
      newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
      i++;
    }
    results.add(newInterval);

    while (i < intervals.length) {
      results.add(intervals[i]);
      i++;
    }

    return results.toArray(new int[results.size()][]);
  }

}

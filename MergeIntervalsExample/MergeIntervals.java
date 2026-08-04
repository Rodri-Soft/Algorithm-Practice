package MergeIntervalsExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

// Example 1:

// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
// Example 2:

// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// Example 3:

// Input: intervals = [[4,7],[1,4]]
// Output: [[1,7]]
// Explanation: Intervals [1,4] and [4,7] are considered overlapping.

public class MergeIntervals {
  public static void main(String[] args) {
    MergeIntervals mi = new MergeIntervals();

    int[][] intervals = {
        { 1, 4 },
        { 0, 2 },
        { 3, 5 },
        // { 15, 18 }
    };

    int[][] result = mi.merge(intervals);
    for (int i = 0; i < result.length; i++) {
      System.out.println("[" + result[i][0] + ", " + result[i][1] + "]");
    }

  }

  public int[][] merge(int[][] intervals) {

    List<int[]> result = new ArrayList<>();    

    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    result.add(intervals[0]);
    // result.sort(Integer::compare);

    int minInterval = intervals[0][0];
    int maxInterval = intervals[0][1];

    int elements = 1;

    for (int i = 1; i < intervals.length; i++) {

      int min = intervals[i][0];
      int max = intervals[i][1];

      if (max <= maxInterval) {
        continue;
      }      

      if (min <= maxInterval && max >= maxInterval) {

        result.set(elements - 1, new int[] { minInterval, max });

        maxInterval = max;
        
      } else {
        result.add(new int[] { min, max });
        minInterval = min;
        maxInterval = max;
        elements++;
      }

    }

    return result.toArray(new int[result.size()][]);
  }
}

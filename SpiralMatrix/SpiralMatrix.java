package SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
  public static void main(String[] args) {
    
    SpiralMatrix sm = new SpiralMatrix();
    for(Integer i : sm.spiralOrder(new int[][] {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
    })) {
      System.out.println(i);
    }

  }

  public List<Integer> spiralOrder(int[][] matrix) {

    Integer horizontalStart = 0;
    Integer horizontalEnd = matrix[0].length - 1;

    Integer verticalStart = 0;
    Integer verticalEnd = matrix.length - 1;

    List<Integer> result = new ArrayList<>();

    Integer totalSize = (horizontalEnd + 1) * (verticalEnd + 1);
    Integer count = 0;

    do {
      for (int i = horizontalStart; i <= horizontalEnd; i++) {
        result.add(matrix[horizontalStart][i]);
        count++;

        if (validateGoal(totalSize, count)) {
          return result;
        }

      }

      verticalStart++;
      for (int i = verticalStart; i <= verticalEnd; i++) {
        result.add(matrix[i][horizontalEnd]);
        count++;

        if (validateGoal(totalSize, count)) {
          return result;
        }

      }

      horizontalEnd--;
      for (int i = horizontalEnd; i >= horizontalStart; i--) {
        result.add(matrix[verticalEnd][i]);
        count++;
        if (validateGoal(totalSize, count)) {
          return result;
        }
      }

      verticalEnd--;
      for (int i = verticalEnd; i >= verticalStart; i--) {
        result.add(matrix[i][horizontalStart]);
        count++;
        if (validateGoal(totalSize, count)) {
          return result;
        }
      }

      horizontalStart++;

    } while (count <= totalSize);

    return result;
  }

  public boolean validateGoal(int size, int count) {
    return size == count;
  }
}
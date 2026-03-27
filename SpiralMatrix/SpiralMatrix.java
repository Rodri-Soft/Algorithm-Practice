package SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }

  public List<Integer> spiralOrder(int[][] matrix) {

    Integer origin = 0;
    Integer destination = matrix[0].length;

    List<Integer> result = new ArrayList<>();

    Integer totalSize = destination * matrix.length;

    for(int s=0; s < totalSize; s++) {

      for(int i=0; i < origin; i++) {
        for(int j=0; j < destination; j++) {
          result.add(matrix[i][j]);
        }            
      }

    }

    


    return null;
  }
}
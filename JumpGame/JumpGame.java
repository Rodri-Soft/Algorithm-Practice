package JumpGame;

// You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

// Return true if you can reach the last index, or false otherwise.

// Example 1:

// Input: nums = [2,3,1,1,4]
// Output: true
// Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
// Example 2:

// Input: nums = [3,2,1,0,4]
// Output: false
// Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

public class JumpGame {
  public static void main(String[] args) {
    // int[] nums = {2,3,1,1,4};
    int[] nums = { 3, 2, 1, 0, 4 };
    // int[] nums = { 2,0,0};
    JumpGame jg = new JumpGame();
    System.out.println(jg.canJump(nums));
  }

  public boolean canJump(int[] nums) {
    int maxReachable = 0;

    for (int i = 0; i < nums.length; i++) {

      if (maxReachable == nums.length - 1) {
        return true;
      }

      // Si el índice actual ya no es alcanzable, atascado
      if (maxReachable < i) {
        return false;
      }        

      // Actualiza el máximo índice al que puedes llegar
      maxReachable = Math.max(maxReachable, i + nums[i]);
    }

    return true;
  }

}
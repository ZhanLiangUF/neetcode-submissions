class Solution {
    public int maxArea(int[] heights) {
      int left = 0;
      int right = heights.length -1;

      int maxArea = 0;

      while ( left < right) {
        int minHeight = Math.min(heights[left], heights[right]);

        int width = right-left;

        int area = minHeight * width;

        if (area > maxArea) {
            maxArea = area;
        }
        if (heights[left] < heights[right]) {
            left++;
        } else {
            right--;
        }
      
      }  
      return maxArea;
    }
}

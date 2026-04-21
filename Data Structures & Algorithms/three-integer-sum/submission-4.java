class Solution {
   public List<List<Integer>> threeSum(int[] nums) {
        // Sort the array to make it easier to skip duplicates and use two pointers
        Arrays.sort(nums); // O(n log n) time

        List<List<Integer>> result = new ArrayList<>(); // Store the unique triplets

        // Loop through each number, treating it as the first element of the triplet
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for i to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1; // Start left pointer just after i
            int right = nums.length - 1; // Start right pointer at the end

            // Use two pointers to find the other two numbers
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right]; // Calculate the sum

                if (sum == 0) {
                    // Found a valid triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Move left pointer to the next different number to skip duplicates
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Move right pointer to the previous different number to skip duplicates
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++; // Move left pointer forward
                    right--; // Move right pointer backward
                } else if (sum < 0) {
                    left++; // Need a larger sum, move left pointer forward
                } else {
                    right--; // Need a smaller sum, move right pointer backward
                }
            }
        }
        return result; // Return all unique triplets
    }
}

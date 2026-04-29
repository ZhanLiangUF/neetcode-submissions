public class Solution {
    public int CharacterReplacement(string s, int k) {
        int[] count = new int[26];
        int left = 0;
        int maxCount = 0;
        int result = 0;

        for (int right = 0; right < s.Length; right++) {
            count[s[right] - 'A']++;

            if (count[s[right] - 'A'] > maxCount) {
                maxCount = count[s[right] - 'A'];
            }

            while ((right - left + 1) - maxCount > k) {
                count[s[left] - 'A']--;

                left++;
            }

            if ((right - left + 1) > result) {
                result = right - left + 1;
            }
        }
        return result;
    }
}

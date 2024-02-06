package feb;

import java.util.HashSet;
import java.util.Set;

public class StringManipulation {
  /*
   * LeetCode 3: Longest Substring Without Repeating Characters
   * Given a String s, return the length of its longest substring without repeating characters
   */

  public int lengthOfLongestSubstring(String s) {
    // Handle Null and Empty input
    if (s == null || s.length() == 0) {return 0;}

    // Initialize Variables
    int maxSubstringLength = 1;
    Set<Character> charInWindow = new HashSet<>();
    int left = 0, right = 1;
    charInWindow.add(s.charAt(left));

    while (right < s.length()) {
      if (charInWindow.contains(s.charAt(right))) {
        while (s.charAt(left) != s.charAt(right)) {
          charInWindow.remove(s.charAt(left));
          left++;
        }
        left++;
      }
      maxSubstringLength = Math.max(maxSubstringLength, right - left + 1);
      charInWindow.add(s.charAt(right));
      right++;
    }
    return maxSubstringLength;
  }

  /*
   * LeetCode 424 Longest Repeating Characters With At Most K Times Replacement
   * You can replace a character in a string with any characters k times.
   * Output the longest length of same repeating characters by performing operation above
   */

  public int characterReplacement(String s, int k) {
    if (s == null || s.length() == 0) {return 0;}

    int[] occurrences = new int[26];
    int left = 0, right = 0;
    int maxLength = 0;
    int maxOccurrence = 0;

    for (right = 0; right < s.length(); right++) {
      occurrences[s.charAt(right) - 'A']++;
      maxOccurrence = Math.max(maxOccurrence, occurrences[s.charAt(right) - 'A']);

      if (maxOccurrence + k < right - left + 1) {
        occurrences[s.charAt(left) - 'A']--;
        left++;
      }
      maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength;
  }
}

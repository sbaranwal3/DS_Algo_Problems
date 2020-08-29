package challenge.leetcode.august;

/*
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
 */

public class LongestPalindrome {

    public static int longestPalindrome(String s) {
        int[] chars = new int[128];
        boolean odd = false;
        int n = 0;

        for (char c : s.toCharArray()) {
            chars[c]++;
        }

        for (int i : chars) {
            n += i & ~1;

            if (!odd && (i & 1) == 1) {
                odd = true;
                n++;
            }
        }

        return n;
    }


    /*
    Approach: Greedy
Intuition

A palindrome consists of letters with equal partners, plus possibly a unique center (without a partner). The letter i from the left has its partner i from the right. For example in 'abcba', 'aa' and 'bb' are partners, and 'c' is a unique center.

Imagine we built our palindrome. It consists of as many partnered letters as possible, plus a unique center if possible. This motivates a greedy approach.

Algorithm

For each letter, say it occurs v times. We know we have v // 2 * 2 letters that can be partnered for sure. For example, if we have 'aaaaa', then we could have 'aaaa' partnered, which is 5 // 2 * 2 = 4 letters partnered.

At the end, if there was any v % 2 == 1, then that letter could have been a unique center. Otherwise, every letter was partnered. To perform this check, we will check for v % 2 == 1 and ans % 2 == 0, the latter meaning we haven't yet added a unique center to the answer.
     */


    public int longestPalindromeApproach2(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 == 1)
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println("Length of longest palindrome is: "+longestPalindrome(s));
    }
}

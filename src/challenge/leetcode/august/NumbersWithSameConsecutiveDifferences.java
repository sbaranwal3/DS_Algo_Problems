package challenge.leetcode.august;

/*
Return all non-negative integers of length N such that the absolute difference between every two consecutive digits is K.

Note that every number in the answer must not have leading zeros except for the number 0 itself. For example, 01 has one leading zero and is invalid, but 0 is valid.

You may return the answer in any order.



Example 1:

Input: N = 3, K = 7
Output: [181,292,707,818,929]
Explanation: Note that 070 is not a valid number, because it has leading zeroes.
Example 2:

Input: N = 2, K = 1
Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]


Note:

1 <= N <= 9
0 <= K <= 9
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersWithSameConsecutiveDifferences {

    public static int[] numsSameConsecDiff(int N, int K) {
        if( N == 1 )
            return new int[]{0,1,2,3,4,5,6,7,8,9};
        List<Integer> queue = Arrays.asList(1,2,3,4,5,6,7,8,9);
        for(int i=1;i<N;i++){
            List<Integer> next_level = new ArrayList<>();
            for(int num : queue){
                List<Integer> next_digits = new ArrayList<>();
                int tail = num%10;
                next_digits.add(tail+K);
                if( K != 0 )
                    next_digits.add(tail-K);
                for(int next_digit : next_digits){
                    if( 0 <= next_digit && next_digit < 10 ){
                        int new_num = num * 10 + next_digit;
                        next_level.add(new_num);
                    }
                }
            }
            queue = next_level;
        }

        return queue.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int N=2, K=1;
        System.out.println("3 digits numbers with consecutive difference 1 are: "+Arrays.toString(numsSameConsecDiff(N,K)));
    }

}

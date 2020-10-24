package main.com.sumit.coding.leetcode.Oct20;

import java.util.Arrays;

/*
* URL :
* https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/562/week-4-october-22nd-october-28th/3506/
* */
public class Problem24 {

    public static void main(String[] args) {
        int[] tokens = {100,200,300,400};
        int P = 200;
        System.out.println(new Problem24().bagOfTokensScore(tokens, P));
    }

    public int bagOfTokensScore(int[] tokens, int P) {

        Arrays.sort(tokens);
        int left = 0;
        int right = tokens.length-1;
        int score = 0;

        while (left <= right) {
            if (P>=tokens[left]) {
                P-=tokens[left++];
                score++;
            }
            else {
                if (P+tokens[right] >= tokens[left] && score!=0 && left!=right){
                    P+=tokens[right--];
                    score--;
                }
                else
                    break;
            }
        }
        return score;
    }
}

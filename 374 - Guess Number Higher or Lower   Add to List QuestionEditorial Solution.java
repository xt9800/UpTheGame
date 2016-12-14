/**
解题思路：
    1. Regualr Binary Search questions. Calculate lower mid, left half is r=m, right half is l = m+1
注意事项：
    1. Calculate mid need to be fast in case of big numbers. doing m = l + (r-l)/2 is faster than m = (l+r)/2;
Complexity：
    O(n)
Space:
    O(1)
*/

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1, r = n;
        while(l<r)
        {
            int m = l + (r-l)/2;
            int guess = guess(m);
            if(guess == 1)
            {
                l = m + 1;
            }
            else if(guess == -1)
            {
                r = m;
            }
            else
            {
                return m;
            }
        }
        return l;
    }
}

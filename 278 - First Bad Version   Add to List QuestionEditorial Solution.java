/**
解题思路：
    1. Binary search mutated version. To determine whether go left half or right half is depends on this logic:
        mid is bad, mid-1 is also bad ---> go left half
        mid is good ---> go right half
        (mid is bad, mid-1 is good) || mid is 1 ---> Bingo!
    2. loop condition: left < right
    3. edge case strategy: always calculate mid to lower mid (left+right)/2.
        when go right half --> right = mid
        when go left half --> left = mid+1
        this way it will not fall into infinite loop
    
注意事项：
    When calculating mid, do left + (right - left)/2 because division is costly and subtraction is not, so smaller number yields a faster division. it is the same as (left+right)/2 but faster.
Complexity：
    O(n)
Space:
    O(1)
*/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while(left < right)
        {
            int mid = left + (right - left)/2;
            if(isBadVersion(mid))
            {
                if(mid == 1 || !isBadVersion(mid-1))
                {
                    return mid;
                }
                else
                {
                    right = mid;
                }
            }
            else
            {
                left = mid +1;
            }
        }
        return left;
    }
}

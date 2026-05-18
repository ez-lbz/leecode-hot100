package hot100.Solution7;

import java.util.*;

// 这道题不好做！！！

public class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int left = 0, right = height.length - 1;
        int maxleft = height[left], maxright = height[right];
        while (left < right) {
            if (height[left] < height[right]) {
                left++;
                if (maxleft < height[left]) {
                    maxleft = height[left];
                } else {
                    sum += maxleft - height[left];
                }
            } else {
                right--;
                if (maxright < height[right]) {
                    maxright = height[right];
                } else {
                    sum += maxright - height[right];
                }
            }
        }
        return sum;
    }
}
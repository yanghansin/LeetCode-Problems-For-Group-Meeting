public class TrappingRainWater {
    // LeetCode 42, Trapping Rain Water
    // By Han Yang
    // 2023/12/21

    public static int trapBruteForce(int[] height) {
        int ans = 0;
        for (int i = 1; i < height.length; i++) {
            int leftMax = leftMax(height, i);
            int rightMax = rightMax(height, i);
            if (Math.min(leftMax, rightMax) >= height[i]) {
                ans += Math.min(leftMax, rightMax) - height[i];
            }
        }
        return ans;
    }

    private static int leftMax(int[] height, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            max = Math.max(max, height[i]);
        }

        return max;
    }

    private static int rightMax(int[] height, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = k + 1; i < height.length; i++) {
            max = Math.max(max, height[i]);
        }

        return max;
    }


    public static int trapDoublePointer(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        int lmax = height[left];
        int rmax = height[right];
        while (left < right) {
            if (lmax <= rmax) {
                ans += Math.max(lmax - height[left], 0);
                left++;
                lmax = Math.max(lmax, height[left]);
            } else {
                ans += Math.max(rmax - height[right], 0);
                right--;
                rmax = Math.max(rmax, height[right]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] height_test_1 = new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}; // Expecting 6
        int[] height_test_2 = new int[] {4, 2, 0, 3, 2, 5}; // Expecting 9
        System.out.println(trapBruteForce(height_test_1));
        System.out.println(trapDoublePointer(height_test_1));
        System.out.println(trapBruteForce(height_test_2));
        System.out.println(trapDoublePointer(height_test_2));
    }
}

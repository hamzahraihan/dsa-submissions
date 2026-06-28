class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;
        int totalHalf = (m + n + 1) / 2;

        int left = 0;
        int right = m; 

        while(left <= right) { 
            int i = left + (right - left) / 2;
            int j = totalHalf - i;

            int aLeftMax = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int aRightMin = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int bLeftMax = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int bRightMin = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if(aLeftMax <= bRightMin && bLeftMax <= aRightMin){
                if((m + n) % 2 != 0){
                    return Math.max(aLeftMax, bLeftMax);
                }
                return (Math.max(aLeftMax,bLeftMax) + Math.min(aRightMin, bRightMin)) / 2.0;
            } else if (aLeftMax > bRightMin) { 
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
        return 0.0;
    }
}

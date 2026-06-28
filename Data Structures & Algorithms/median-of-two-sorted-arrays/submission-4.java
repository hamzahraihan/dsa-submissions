class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // we want to start binary search from lowest array length to prevent out of bound
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
            System.out.println("index i: " + i);
            int j = totalHalf - i;
            System.out.println("index j: " + j);

            int aLeftMax = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            System.out.println("row A left max " + aLeftMax);
            int aRightMin = (i == m) ? Integer.MAX_VALUE : nums1[i];
            System.out.println("row A right min " + aRightMin);
            int bLeftMax = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            System.out.println("row B left max " + bLeftMax);
            int bRightMin = (j == n) ? Integer.MAX_VALUE : nums2[j];
            System.out.println("row b right min " + bRightMin);

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

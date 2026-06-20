class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>();
        int l = 0, r = 0;
        while(r < n){
            // scan any smaller number at q
            while(!q.isEmpty() && nums[q.getLast()] < nums[r]){
                q.removeLast();
            }
            // add largest number to the last
            q.addLast(r);

            // check if left pointer pass the right index, remove it from q

            // System.out.println("left pointer: " + l);
            // System.out.println("maximum value we see so far : " + q.getFirst());
            if(l > q.getFirst()){
                System.out.println(q.getFirst());
                System.out.println(l);
                q.removeFirst();
            }

            // once the window reach size k, the last deque is the max, add it to output
            if((r + 1) >= k){
                output[l] = nums[q.getFirst()];
                l++; // slide window
            }
            r++;
        }
        return output;
    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = lowerIdx(nums, target);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }
        
        targetRange[0] = leftIdx;
        targetRange[1] = upperIdx(nums, target)-1;

        return targetRange;
    }
    public int lowerIdx(int[] nums, int target){
        // en이 nums.length임에 주의
        int st = 0;
        int en = nums.length;
        
        while(st < en){
            int mid = (en - st) / 2 + st;
            if(nums[mid] >= target)
                en = mid;
            else
                st = mid + 1;
        }
        return st;
    }
    public int upperIdx(int[] nums, int target){
        // en이 nums.length임에 주의
        int st = 0;
        int en = nums.length;
        
        while(st < en){
            int mid = (en - st) / 2 + st;
            if(nums[mid] > target)
                en = mid;
            // else if(nums[mid] < target)
            //     st = mid - 1;
            else
                st = mid + 1;
        }
        return st;
    }
    public int binarySearch(int[] nums, int target){
        int st = 0;
        int en = nums.length - 1;
        
        while(st < en){
            int mid = (en - st) / 2 + st;
            if(nums[mid] < target)
                st = mid + 1;
            else if(nums[mid] > target)
                en = mid - 1;
            else
                return mid;
        }
        return -1;
    }
}

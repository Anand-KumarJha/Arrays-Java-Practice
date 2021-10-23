import java.util.Stack;

class FastSolution {
    public boolean find132pattern(int[] nums) {
        int[] min = new int[nums.length];
        min[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            min[i] = Math.min(nums[i], min[i - 1]);
        }
        Stack<Integer> stack = new Stack<>();

        for(int i = nums.length -1; i > 0; i--){
            if(nums[i] > min[i - 1]){
                while(!stack.isEmpty() && stack.peek() <= min[i - 1]){
                    stack.pop();
                }
                if(!stack.isEmpty() && stack.peek() < nums[i]){
                    return true;
                }
                stack.push(nums[i]);
            }
        }return false;
    }
}
class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int s = 0;
        int e = numbers.length-1;
        int[] result = new int[2];

        while(s<e){
            if(numbers[s]+numbers[e] == target){
                result[0] = s+1;
                result[1] = e+1;
                return result;
            }
            else if(numbers[s]+numbers[e] > target){
                e--;
            }
            else{
                s++;
            }
        }

        return result;
    }
}

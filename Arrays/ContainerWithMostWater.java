class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int n = height.length;

        int i = 0;
        int j = n-1;

        int area = Integer.MIN_VALUE;

        while(i<j){
            if(height[i]<=height[j]){
                area = Math.max((j-i)*Math.min(height[i],height[j]), area);
                i++;
            }
            else{
                area = Math.max((j-i)*Math.min(height[i],height[j]), area);
                j--;
            }
        }

        return area;
    }
}

package hard;

public class FirstMissingPositive_41 {

	public static void main(String[] args) {
		
//		int[] nums= {-10,-3,-100,-1000,-239,1};
		int[] nums= {3,5,4,-1,5,1,-1};//{-1,4,2,1,9,10};
		//System.out.println(firstMissingPositive(nums));
		System.out.println(firstMissingPositive(nums));
		//firstMissingPositive(nums);
	}
	public static int firstMissingPositiveNew(int[] nums) {
        //Match all the values of each index which fall within 0 ton n
        for(int i=0; i<nums.length;i++){
            if(nums[i]>0 && nums[i]<nums.length && nums[nums[i]-1] != nums[i]) {//3rd condition is to avoid unnecessary swaps
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }

        // Find first ouccurance of nums[i] != i+1;
        for(int i=0 ; i< nums.length ; i++){
            if(nums[i] != i+1)
                return i+1;
        }
        return nums.length +1;
    }
//EPI 25.2 Optimized	
	 public static int firstMissingPositive(int[] nums) {
	        int i=0;
	        while(i<nums.length){
	            if(nums[i]>0 && nums[i]<=nums.length  && nums[nums[i]-1] != nums[i]){
	                //swap
	                int temp = nums[nums[i]-1];
	                nums[nums[i]-1] = nums[i];
	                nums[i] = temp;
	            }else{
	                ++i;
	            }
	            for(int j=0;j<nums.length; j++){
	            	System.out.print(nums[j]+", ");
	            }
	            System.out.println();
	        }
	        for(int j=0;j<nums.length; j++){
	            if(nums[j]!=j+1)
	                return j+1;
	        }
	            return (nums.length + 1);
	    }

    public static int firstMissingPositive1(int[] nums) {
    		//  0 1 2 | 3
    		//[ 3 4 1 |-1 ]
        int partitionIndex =-1;
 // Partition the array into positive on left and negative on right
        for(int i=0; i< nums.length; i++) {
        	if(nums[i]>0) {
        		partitionIndex++;
        		int temp= nums[partitionIndex];
        		nums[partitionIndex] = nums[i];
        		nums[i]= temp;
        	}
        }
    	for(int i=0; i< nums.length; i++) {
    		System.out.println(nums[i]);
    	}
    	System.out.println("Partition Index = "+ partitionIndex);
    	for(int i=0;i<=partitionIndex;i++) {
    		if(Math.abs(nums[i])<=partitionIndex+1) {  
// using math.abs because some values may be negated befor use which will lead to ArrayIndexOutOfBoundException
    			if(nums[Math.abs(nums[i])-1]>0){
        			nums[Math.abs(nums[i])-1] = nums[Math.abs(nums[i])-1]*(-1);    				
    			}
    		}
    	}
    	for(int i=0; i< nums.length; i++) {
    		System.out.println(nums[i]);
    	}
    	for(int i=0; i< nums.length; i++) {
    		if(nums[i]>0) {
    			return i+1;
    		}
    	}
    	if(partitionIndex == -1){
            return 1;
        }else{
          return partitionIndex +2;  
        } 
    }
}

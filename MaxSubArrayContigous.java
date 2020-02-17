

public class MaxSubArrayContigous{
    public static void main(String args[]) {
     
      System.out.println(maxSubArrSum(new int[]{1,-2,1,3}));
    }
    
   static int maxSubArrSum(int[] arr){
        
        int local_max=0;
        int global_max=Integer.MIN_VALUE;
       for (int value : arr) {
           local_max = Math.max(value, value + local_max);
           if (local_max > global_max) {
               global_max = local_max;
           }

       }
        return global_max;
    }
}
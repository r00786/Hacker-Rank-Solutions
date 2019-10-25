package com.fieldforce.usha_lasm;

import java.io.IOException;
import java.util.Arrays;

public class PairsTest {


    // Complete the pairs function below.

    /**
     *
     * @param k difference should be equal to this parameter
     * @param arr arr from which pairs should be taken out
     * @return number of pairs having the same sum
     */
    static int pairs(int k, int[] arr) {

        Arrays.sort(arr);
        int i=0;
        int j=1;
        int count=0;

        while(j < arr.length) {
            int diff = arr[j] - arr[i];
//if the difference is same then we increment j to next index and increment count also
            if (diff == k) {
                count++;
                j++;
            }
//if the difference will be greater than k than the i is incremented as the sum will be greater than
// the required k as te array is sorted jth value will always be greater

            else if (diff > k) {
                i++;
            }
// till the difference is coming smaller than k jth index will be incremented

            else if (diff < k) {
                j++;
            }
        }

        return count;
    }





    public static void main(String[] args) throws IOException {

        System.out.println(pairs(2,new int[]{1,5,3,4,2}));
    }
}

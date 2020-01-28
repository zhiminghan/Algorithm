package com.algorithm.BitOperation;

public class Test {

    public int[] singleNumber(int[] nums) {

        int xor=0;
        for (int num:nums){
            xor^=num;
        }
        xor^=-xor;
        int [] rs=new int[2];
        for (int num:nums){
            if((rs[0]&xor)==0){
                rs[0]^=num;
            }else{
                rs[1]^=num;
            }
        }
        return rs;
    }
}

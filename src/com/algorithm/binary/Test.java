package com.algorithm.binary;

public class Test {


    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

    /**
     * 通过二分查找求平方根  （思想：在所有正整数里二分查找）
     * @param x
     * @return
     */
    public static int mySqrt(int x) {

        long left=0;
        long right=x;

        while (left<=right){
            long mid=(left+right)/2;

            long value=mid*mid;
            if(value==x){
                return (int)mid;
            }else if(value>x){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }

        return left*left>x?(int)left-1:(int)left;
    }


}

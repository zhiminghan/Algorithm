package com.algorithm.binary;

public class Test {


    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));

        int [][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(searchMatrix(matrix,50));
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


    public static boolean searchMatrix(int[][] matrix, int target) {

        int m=matrix.length;
        int n=matrix[0].length;

        int low=0;
        int high=m*n-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            int x=mid/n;
            int y=mid%n;

            if(matrix[x][y]==target){
                return true;
            }else if(matrix[x][y]<target){
                low=mid+1;
            }else {
                high=mid-1;
            }
        }

        return false;
    }




    }

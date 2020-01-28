package com.algorithm.recurion;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public List<String> findStrobogrammatic(int n) {

        List<String> list=new ArrayList<>();
        double start=0;

        if(n>1){
            start=Math.pow(10,n-1);
        }
        double end=Math.pow(10,n);
        for (double i=start;i<end;i++){
            int num=(int)i;
            String str=String.valueOf(num);
            if(str.equals(reverse(str)))
                list.add(str);
        }
        return list;
    }

    public String reverse(String str){
        StringBuffer sb=new StringBuffer();
        char[] chars=str.toCharArray();
        for (int i=chars.length-1;i>=0;i--){
            sb.append(chars[i]);
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(new Test().findStrobogrammatic(2));
    }
}

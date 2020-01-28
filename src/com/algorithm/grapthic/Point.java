package com.algorithm.grapthic;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;

public class Point {
    private int x;
    private int y;

    public Point(int x,int y) {
        this.x=x;
        this.y=y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public static void main(String[] args) {


        CountDownLatch latch=new CountDownLatch(1);
        new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
                latch.countDown();
            }catch (Throwable e){

            }
        }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            latch.await();
                        }catch (Throwable e){

                        }
                        System.out.println(Thread.currentThread().getName()+" finish ");
                    }
                }).start();
                try {
                    latch.await();
                }catch (Throwable e){

                }
                System.out.println(Thread.currentThread().getName()+" finish ");
            }
        }).start();






    }
}

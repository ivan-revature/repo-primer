package com.javatrain.Day5;

public class ThreadJoin extends Thread{
    @Override
    public void run() {
        for(int i=0;i<5;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread Name: "+ Thread.currentThread().getName());
            System.out.println(i);
        }
    }
}


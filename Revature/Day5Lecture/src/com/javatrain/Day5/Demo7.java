package com.javatrain.Day5;

public class Demo7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadJoin t1 = new ThreadJoin();
        ThreadJoin t2 = new ThreadJoin();
        ThreadJoin t3 = new ThreadJoin();
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        t3.start();
	}

}

package com.jeenms.test.j2se;

import java.util.Date;

public class DevliverTest {

	public static void main(String[] args) {
		int a = 1;
		devliever(a);//值传递
		System.out.println("main method a:" + a);
		
		Integer b = 129;
		deliverInteger(b);//***值传递
		System.out.println("main mehtod b:" + b);
		
		String c = "main string";
		devliverString(c);//**值传递
		System.out.println("main mehtod c:"+ c);
		
		Date e = new Date();
		System.out.println("main mehtod e:" + e);
		devlieverDate(e);//引用传递
		System.out.println("main mehtod e:" + e);
	}

	private static void devlieverDate(Date e) {
		e.setTime(1000);
		System.out.println("e:" + e);
	}

	private static void devliverString(String c) {
		c = "devliever string";
		System.out.println("c:" + c);
	}

	private static void deliverInteger(Integer b) {
		b = 130;
		System.out.println("b:" + b);
	}

	private static void devliever(int a) {
		a = 2;
		System.out.println("a:" + a);
	}
}

package com.jeenms.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) throws ParseException {
		Date date= new Date(1490028900000L);
		Date date1=new Date(1490072100030L);
		long a=	(1490028900000L-1490072100030L)/1000/60/60;//12Сʱ
		System.out.println(a);
		String strDate= "2017-03-21 12:53:44";
		String strDate1="2017-03-21 12:55:00";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(sdf.parse(strDate1).getTime());
		System.out.println(date + "-->" + sdf.format(date));
		System.out.println(date1 + "-->" + sdf.format(date1));
		
	}
}

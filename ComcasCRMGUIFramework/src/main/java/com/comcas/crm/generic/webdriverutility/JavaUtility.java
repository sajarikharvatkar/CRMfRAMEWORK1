package com.comcas.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	SimpleDateFormat sim;
	//get random number
	public int getRandomNum()
	{
		Random random=new Random();
		int r2=random.nextInt(1000);
		return r2;
	}
	//get formated system cuuenr date
	public String getSystemDateyyyyMMddFormat()

	{
		Date date=new Date();
		sim=new SimpleDateFormat("yyyy-MM-dd");
		
		String fomatedDate=sim.format(date);
		System.out.println(fomatedDate);
		return fomatedDate;
		
	}
	//get date after 30 days
	public String getDateAfterThirtyDays()
	{
	Calendar cal=sim.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH, 30);
	String supportEnddate=sim.format(cal.getTime());
	System.out.println(supportEnddate);
	return supportEnddate;
	}
}

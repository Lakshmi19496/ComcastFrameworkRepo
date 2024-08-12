package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNum()
	{
		Random rand=new Random();
		int randNum=rand.nextInt(5000);
		return randNum;
	}
	public String getSystemDateYYYYMMDD()
	{
		Date date=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String actDate = sim.format(date);
		return actDate;
	}
	public String getRequiredDateYYYYMMDD(int days)
	{
		Date date=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		sim.format(date);
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String endDate=sim.format(cal.getTime());
		return endDate;
	}

}

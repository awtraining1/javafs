package com.amzn.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeCalendarDemo {

	public static void main(String[] args) throws ParseException {
		Date d = new Date();
		System.out.printf("\n Today's date is %s", d);

		System.out.printf("\n Today's month is %s", d.getMonth());
		System.out.printf("\n Today's year is %s", d.getYear());

		Date d1 = new Date(1234567874564569L);
		System.out.printf("\n Some old date is %s", d1);
		System.out.println();
		System.out.println(d.after(d1));
		System.out.println(d.before(d1));

		// Dates from particular format
		System.out.printf("\n Dates from particular format");
		SimpleDateFormat ft1 = new SimpleDateFormat ("dd MMM yyyy");
//		Date formatedDate = ft1.parse("10.07.1967");
//		System.out.println(formatedDate);
		
		System.out.printf("\n Today's date in dd.mm.yyyy is %s", ft1.format(d));

		// Calendar based dates
		System.out.printf("\n\n Calendar based dates");
		Calendar cal = Calendar.getInstance(); 
		// current time
		System.out.printf("\nCalendar date today is %s",cal.getTime());
		System.out.printf("\nCalendar date today's year is %s",cal.get(Calendar.YEAR));
		//System.out.printf("\nCalendar date first day of week is %s",cal.get(Calendar.DAY_OF_WEEK,cal.getFirstDayOfWeek()));
		System.out.printf("\nCalendar date today's day is %s",cal.get(Calendar.DAY_OF_WEEK));
		
		
		cal.set(Calendar.YEAR,2050);
		System.out.printf("\nCalendar date today's year is %s",cal.get(Calendar.YEAR));
		
		cal.add(Calendar.YEAR,10);
		System.out.printf("\nCalendar 10 years from 2050 year is %s",cal.get(Calendar.YEAR));
		
		cal.roll(Calendar.YEAR,10);
		System.out.printf("\nCalendar 10 years from 2060 year is %s",cal.get(Calendar.YEAR));
		
		cal.roll(Calendar.YEAR,-100);
		System.out.printf("\nCalendar 100 years down from 2070 year is %s",cal.get(Calendar.YEAR));
		
		
		
	}

}

package com.greatLearning.assignment;
import java.util.Calendar;

//SuperDepartment Class
public abstract class SuperDepartment {
	 
	Calendar c = Calendar.getInstance();  // using Calendar class to get the day
	protected final int today = c.get(Calendar.DAY_OF_WEEK);
	// to get day of the week
	//day of the week return number 1 to 7 based on the day 
	//Sunday= 1 and Saturday =7
	
	public String deparmentName() {
	   
		return "Super Department";
		}
		
	//declare method getTodaysWork of return type string
	public String getTodaysWork() {
		return "No work as of now";
		}
		
	//declare method getWorkDeadline of return type string
	public String getWorkDeadline() {
		return "Nil";
		}
		
	//declare method isTodayAHoliday of type string 	
	public String isTodayAHoliday() {
			if (today==1 || today==7)			//to check for WEEKEND
	            return "HOLIDAY";
			
			else 								// on Weekdays 
				return "WORKING DAY";
		}

	protected abstract String getTechStackInformation();

	protected abstract String doActivity();
	
		
		

}

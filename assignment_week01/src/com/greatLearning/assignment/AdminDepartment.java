package com.greatLearning.assignment;

//AdminDepartment Class
public class AdminDepartment  extends SuperDepartment {
	
	//declare method departmentName of return type string
	public String deparmentName() {
		return "Admin Department";
		}
	
	//declare method getTodaysWork of return type string
	public String getTodaysWork() {
		if (today==1 || today==7)			//to  check for WEEKEND
		return super.getTodaysWork();
		
		else 								// on Weekdays 
		return "Complete your documents Submission";
		}
	
	//declare method getWorkDeadline of return type string
	public String getWorkDeadline() {
		if (today==1 || today==7)			// to check for WEEKEND
		return super.getWorkDeadline();	
		
		else								// on Weekdays 
		return "Complete the Work by End Of the Day";
		}
}

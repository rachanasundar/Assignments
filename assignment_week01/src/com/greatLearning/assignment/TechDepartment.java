package com.greatLearning.assignment;

//TechDepartment class
public class TechDepartment  extends SuperDepartment {
	
	//declare method departmentName of return type string
	public String deparmentName() {
		return "Tech Department";
		}
	
	//declare method getTodaysWork of return type string
	public String getTodaysWork() {
		if (today==1 || today==7)			// to check for WEEKEND
			return super.getTodaysWork();
		
		else								// on Weekdays 
		return "Complete coding of module 1";
		}
	
	//declare method getTechStackInformation of return type string
	public String getTechStackInformation() {
		if (today==1 || today==7)			//to check for WEEKEND
			return "Nil";
		
		else								// on Weekdays 
		return "Core Java";
	}
	
	//declare method getWorkDeadline of return type string
	public String getWorkDeadline() {
		if (today==1 || today==7)			// to check for WEEKEND
			return super.getWorkDeadline();
		
		else								// on Weekdays 
		return "Complete the Work by End Of the Day";
		}

	@Override
	protected String doActivity() {
		// TODO Auto-generated method stub
		return null;
	}

}

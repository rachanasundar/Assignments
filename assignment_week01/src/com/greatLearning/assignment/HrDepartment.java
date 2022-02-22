package com.greatLearning.assignment;

//HRDepartment Class
public class HrDepartment  extends SuperDepartment {
	
	//declare method departmentName of return type string
	public String deparmentName() {
		return "HR Department";
		}
	
	//declare method getTodaysWork of return type string
	public String getTodaysWork() {
		if (today==1 || today==7)			//to check for WEEKEND
			return super.getTodaysWork();
		else								// on Weekdays 
		return "Fill todays worksheet and mark your attendance";
		}
	
	//declare method doActivity of return type string
	public String doActivity()
	{
		if (today==1 || today==7)			// to check for WEEKEND
			return "Nil";
		
		else								// on Weekdays 
		return "Team Lunch ";	
	}
	
	//declare method getWorkDeadline of return type string
	public String getWorkDeadline() {
		if (today==1 || today==7)			// to check for WEEKEND
			return super.getWorkDeadline();
		
		else								// on Weekdays 
		return "Complete the Work by End Of the Day";

}
}

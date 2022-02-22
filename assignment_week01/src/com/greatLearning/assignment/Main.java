package com.greatLearning.assignment;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
	while(true) {
		// to display different departments 	
		System.out.println("1.Admin Department"); 
		System.out.println("2.HR Department");
		System.out.println("3.Tech Department");
		System.out.println("0.To exit ");
		System.out.println("Enter your Department Number");
		
		int depNumber=sc.nextInt();// to get the department number
		if (depNumber == 0)
		{
			break;// to exit from the while loop
		}
		
		else {
	    switch(depNumber){
		case 1 :// create the object of AdminDepartment and use all the methods 
			AdminDepartment ad = new AdminDepartment();
			System.out.println("-------------------------------------------------");
			System.out.println("DEPARTMENT NAME     :"+ad.deparmentName());
			System.out.println("TODAYS WORK         :"+ad.getTodaysWork());
			System.out.println("WORK DEADLINE       :"+ad.getWorkDeadline());
			System.out.println("TODAY IS            :"+ad.isTodayAHoliday());
			System.out.println("-------------------------------------------------");
			break;
			
		case 2 :// create the object of HR Department and use all the methods
			HrDepartment hd = new HrDepartment();
			System.out.println("-------------------------------------------------");
			System.out.println("DEPARTMENT NAME     :"+ hd.deparmentName());
			System.out.println("TODAYS WORK         :"+hd.getTodaysWork());
			System.out.println("WORK DEADLINE       :"+hd.getWorkDeadline());
			System.out.println("ACTIVITY            :"+hd.doActivity());
			System.out.println("TODAY IS            :"+hd.isTodayAHoliday());
			System.out.println("-------------------------------------------------");
			break;
			
		case 3 : // create the object of TechDepartment and use all the methods
			TechDepartment td = new TechDepartment();
			System.out.println("-------------------------------------------------");
			System.out.println("DEPARTMENT NAME       :"+td.deparmentName());
			System.out.println("TODAYS WORK           :"+td.getTodaysWork());
			System.out.println("WORK DEADLINE         :"+td.getWorkDeadline());
			System.out.println("TECH STACK INFORMATION:"+td.getTechStackInformation());
			System.out.println("TODAY IS              :"+td.isTodayAHoliday());
			System.out.println("-------------------------------------------------");
			break;
					
		default : System.out.println("Invalid option");// if the entered value is out of the specified range
		break;
			
		}
		}
	}
	System.out.println("THANK YOU, HAVE A GREAT DAY!");//print this after exiting out of while loop
		
	}

}

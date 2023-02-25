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
			 printDetails(1);
			 break;
			
		case 2 :// create the object of HR Department and use all the methods
			printDetails(2);
			break;
			
		case 3 : // create the object of TechDepartment and use all the methods
			printDetails(3);
			break;
					
		default : System.out.println("Invalid option");// if the entered value is out of the specified range
		break;
			
		}
		}
	}
	System.out.println("THANK YOU, HAVE A GREAT DAY!");//print this after exiting out of while loop
		
	}

	private static void printDetails(int input) {
		SuperDepartment department = null;
		if(input==1) {
		 department = new AdminDepartment();
		}
		else if(input ==2) {
			department= new HrDepartment();
		}else if(input==3) {
			department =new TechDepartment();
		}
		
		System.out.println("-------------------------------------------------");
		System.out.println("DEPARTMENT NAME       :"+department.deparmentName());
		System.out.println("TODAYS WORK           :"+department.getTodaysWork());
		System.out.println("WORK DEADLINE         :"+department.getWorkDeadline());
		if(input==2) {
			System.out.println("ACTIVITY            :"+department.doActivity());
		}
		if(input==3) {
		System.out.println("TECH STACK INFORMATION:"+department.getTechStackInformation());
		}
		System.out.println("TODAY IS              :"+department.isTodayAHoliday());
		System.out.println("-------------------------------------------------");
		
	}

}

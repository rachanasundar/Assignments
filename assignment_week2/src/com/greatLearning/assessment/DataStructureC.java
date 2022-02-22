package com.greatLearning.assessment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

//This class is used to get the Monthly Salary of Employee along with their ID is
public class DataStructureC extends Employee {
	
public void monthlySalary(ArrayList<Employee> employees) {
		
	//LinkedHashMap object monthlyIncome will store Key as Employee ID name and Value as monthly salary 
		LinkedHashMap<Integer, Integer> monthlyIncome = new LinkedHashMap<>();
		

		//To create a object of Iterator of type Employee
		Iterator<Employee> ii=employees.iterator();
		while(ii.hasNext())
		{
			Employee emp = ii.next();
			monthlyIncome.put(emp.getId(), (emp.getSalary()/12));//to add the employee ID and monthly salary to LinkedHashMap
		}
		
		//to print monthly salary 
		System.out.println(monthlyIncome);		
	}
	

}

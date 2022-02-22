package com.greatLearning.assessment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

//This class is used to get Names of all Employees in the sorted order are
public class DataStructureA extends Employee{
	
	public void sortingNames(ArrayList<Employee> employees) {
		//To create a ArrayList object
		ArrayList<String> sortedName= new ArrayList<>();
		
		//To create a object of Iterator of type Employee
		Iterator<Employee> ii=employees.iterator();
		
		//To iterate and get the Employee object
		while(ii.hasNext())
		{
			Employee emp = ii.next();
			sortedName.add(emp.getName());// To add each employee name for ArrayList object
		}
		
		//To sort the  name in ascending order 
		Collections.sort(sortedName);
		
		// To print the sorted list of name
		System.out.println(sortedName);
	

	}
}	


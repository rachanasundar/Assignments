package com.greatLearning.assessment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

//This class is used to get the  Count of Employees from each city
public class DataStructureB extends Employee {
	
	public void cityNameCount(ArrayList<Employee> employees) {
		//To create a ArrayList object of type string
		ArrayList<String> city=new ArrayList<>();
		
		//To create a object of Iterator of type Employee
		Iterator<Employee> ii=employees.iterator();
		while(ii.hasNext())
		{
			Employee emp = ii.next();
			city.add(emp.getCity());//To add employee's location to the ArrayList
			
		}
		
		//Sorting the name of the cities 
		Collections.sort(city);
		
		//LinkedHashset is used to avoid  of city name  
		LinkedHashSet<String> uniqueCity = new LinkedHashSet<>(city);
		
		//LinkedHashMap object location will store Key as city name and Value as number of employees from that city 
		LinkedHashMap<String,Integer> location = new LinkedHashMap<>();
		
		for(String sCity : uniqueCity)	{
			//getting the number of employee in the specific location
			int count = Collections.frequency(city, sCity);
			
			//to add this information to LinkedHashMap
			 location.put(sCity, count);
		}
		
		//to print the final result
		System.out.println(location);
	
	}

}

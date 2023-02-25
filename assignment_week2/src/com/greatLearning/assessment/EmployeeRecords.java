package com.greatLearning.assessment;

import java.util.ArrayList;
import java.util.Iterator;


public class EmployeeRecords {

	

	public static void main(String[] args) {
		
			//ArrayList of type Employee 
			ArrayList<Employee> employees = new ArrayList<>();
			
			
			//Try catch block is use to avoid invalid data entry. 
			try {

				//To create objects of Employee class.
				Employee e1 = new Employee(1,"Aman", 20, 1100000,"IT","Delhi");
				Employee e2 = new Employee(2, "Bobby", 22, 500000 , "HR", "Bombay");
				Employee e3 = new Employee(3, "Zoe", 20,  750000  , "Admin", "Delhi");
				Employee e4 = new Employee(4, "Smitha", 21, 1000000 , "IT", "Channai");
				Employee e5 = new Employee(2, "Smitha", 24, 1200000  , "HR", "Bengaluru");
				
				//Adding all the Employee class objects to the ArrayList. 	
				employees.add(e1);
				employees.add(e2);
				employees.add(e3);
				employees.add(e4);
				employees.add(e5);
				
				
					// To display all the details of employees in the organization.
					System.out.println("S.NO. \tNAME \tAGE\t SALARY(INR)\t DEPARTMENT\tLOCATION");
					System.out.println("-------------------------------------------------------------------");
					
					//To create a object of Iterator of type Employee
					Iterator<Employee> ii=employees.iterator();
					
					//To iterate and get the Employee object
					while(ii.hasNext())
					{
						Employee employee = ii.next();
						
						//to print the all the employee details in tabular format
						System.out.println( employee.getId() + "\t"+employee.getName() + "\t"+employee.getAge() + "   \t  "+employee.getSalary()+
								"    \t   "+ employee.getDepartment()+"    \t"+ employee.getCity()+"\n");

					}
					System.out.println("-------------------------------------------------------------------");
					
					
					//To display the names of all the employees in Sorted alphabetical order using DataStructureA class
					System.out.println("\nNames of all Employees in the sorted order are:" );
					DataStructureA sortEmployeesName = new DataStructureA();
					sortEmployeesName.sortingNames(employees);	
					
					
					//To get the count of employees from each city using DataStructureB class
					DataStructureB employeeCity=new DataStructureB();
					System.out.println("\nCount of Employees from each city:");
					employeeCity.cityNameCount(employees);
					
					
					//To get the monthly salary of each employee using DataStructureC class
					DataStructureC employeeSalary=new DataStructureC();
					System.out.println("\nMonthly Salary of Employee along with their ID is:");
					employeeSalary.monthlySalary(employees);
			
			} 
			catch(CustomIllegalArgumentException e){
				System.err.println(e);
			}catch (Exception e) {
				System.err.println(e);
			}
			finally {
				System.out.println("\n\n********************************************************************\n\t\t\tEND");
			}
				
	}
}



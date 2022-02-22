package com.greatLearning.assessment;

import java.util.ArrayList;
import java.util.Iterator;


public class EmployeeRecords {

	

	public static void main(String[] args) {
		
			//ArrayList of type Employee 
			ArrayList<Employee> employees = new ArrayList<>();
			
			//To create objects of Employee class.
			Employee e1 = new Employee();
			Employee e2 = new Employee();
			Employee e3 = new Employee();
			Employee e4 = new Employee();
			Employee e5 = new Employee();
			
			//Try catch block is use to avoid invalid data entry. 
			try {
				
				//Setting e1 Employee's details. 	
				e1.setId(1);
				e1.setName("Aman");
				e1.setAge(20);
				e1.setSalary(1100000);
				e1.setDepartment("IT");
				e1.setCity("Delhi");
				
				//Setting e2 Employee's details. 	
				e2.setId(2);
				e2.setName("Bobby");
				e2.setAge(22);
				e2.setSalary(500000);
				e2.setDepartment("HR");
				e2.setCity("Bombay");
				
				//Setting e5 Employee's details. 	
				e3.setId(3);
				e3.setName("Zoe");
				e3.setAge(20);
				e3.setSalary(750000);
				e3.setDepartment("Admin");
				e3.setCity("Delhi");
				
				//Setting e5 Employee's details. 	
				e4.setId(4);
				e4.setName("Smitha");
				e4.setAge(21);
				e4.setSalary(1000000);
				e4.setDepartment("IT");
				e4.setCity("Channai");
				
				//Setting e5 Employee's details. 	
				e5.setId(5);
				e5.setName("Smitha");
				e5.setAge(24);
				e5.setSalary(1200000);
				e5.setDepartment("HR");
				e5.setCity("Bengaluru");
				
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



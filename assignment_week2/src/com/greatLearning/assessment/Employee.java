package com.greatLearning.assessment;

public class Employee  {
	private int id;
	private String name;
	private int age;
	private int salary; // per annum
	private String department;
	private String city;
	
	//Default Constructor of Employee class 
	public Employee() {
		super();
		
	}
	//Parameterized constructor, which throw exception if invalid data is entered 
	public Employee(int id, String name, int age, int salary, String department, 
			String city)throws CustomIllegalArgumentException {
		super();
		
			if(id>0) this.id = id;
			else
				throw new CustomIllegalArgumentException("Please enter a valid  Employee ID which must be greater than 0.") ; 
		
		
			if(name!=null&&(!name.isEmpty()))  this.name = name;
			else 
				throw new CustomIllegalArgumentException("Please enter a proper NAME.") ;
			
			
			if(age>0)  this.age = age;
			else
				throw new CustomIllegalArgumentException("Please enter a valid AGE which must be greater than 0.") ;
			
			
			if(salary>0)   this.salary = salary;
			else
				throw new CustomIllegalArgumentException("Please enter a valid SALARY which must be greater than 0.") ;
			
			
			if(department!=null&&(!department.isEmpty()))  this.department = department;
			else 
				throw new CustomIllegalArgumentException("Please enter a proper DEPARTMENT NAME.") ;
			
			
			if(city!=null&&(!city.isEmpty()))  this.city = city;
			else 
				throw new CustomIllegalArgumentException("Please enter a proper CITY NAME.") ;
	}
	
	//Setter methods, which throw exception if invalid data is entered  
	public void setId(int id)throws CustomIllegalArgumentException {
		if(id>0)
			this.id = id;
		else
			throw new CustomIllegalArgumentException("Please enter a valid  Employee ID which must be greater than 0.") ; 
		
	}

	public void setName(String name)throws CustomIllegalArgumentException {
		if(name!=null&&(!name.isEmpty()))
			this.name = name;
		else 
			throw new CustomIllegalArgumentException("Please enter a proper  NAME.") ;
		
	}
	public void setAge(int age)throws CustomIllegalArgumentException {
		if(age>0)
			this.age = age;
		else
			throw new CustomIllegalArgumentException("Please enter a valid AGE which must be greater than 0.") ;
	}
	public void setSalary(int salary)throws CustomIllegalArgumentException {
		if(salary>0)
			this.salary = salary;
		else
			throw new CustomIllegalArgumentException("Please enter a valid SALARY which must be greater than 0.") ;
			
	}
	public void setDepartment(String department)throws CustomIllegalArgumentException {
		if(department!=null&&(!department.isEmpty()))
			this.department = department;
		else 
			throw new CustomIllegalArgumentException("Please enter proper DEPARTMENT NAME.") ;
	}
	public void setCity(String city)throws CustomIllegalArgumentException {
		if(city!=null&&(!city.isEmpty()))
			this.city = city;
		else 
			throw new CustomIllegalArgumentException("Please enter proper CITY NAME.") ;
	}
	
	//getter methods, which returns the attributes 
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getSalary() {
		return salary;
	}
	public String getDepartment() {
		return department;
	}
	public String getCity() {
		return city;
	}
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", department="
			+ department + ", city=" + city + "]"+"\n";
			}
	
	
}

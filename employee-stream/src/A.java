import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		List<Employee> emp = new ArrayList<Employee>();
		List<Employee> emp2 = new ArrayList<Employee>();
		do {
			System.out.println("1.insert");
			System.out.println("2.update  based on employee name");
			System.out.println("3.delete based on age");
			
			System.out.println("4.get details based on age");
			System.out.println("5.exit");
			System.out.println("enter your choice");
			int choice=sn.nextInt();
			switch(choice)
			{
			
			//insert
			case 1:
		
		System.out.println("enter how many times");
		
		int n = sn.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("enter name");
			String name = sn.next();
			System.out.println("enter age");
			int age = sn.nextInt();
			System.out.println("enter salary");
			int salary = sn.nextInt();
			emp.add(new Employee(i, name, age, salary));
		}
		System.out.println(emp);
 
		
		System.out.println("enter how many times");
 		int n2 = sn.nextInt();
		for (int i = 1; i <= n2; i++) {
			System.out.println("enter name");
			String name = sn.next();
			System.out.println("enter age");
			int age = sn.nextInt();
			System.out.println("enter salary");
			int salary = sn.nextInt();
			emp2.add(new Employee(i, name, age, salary));
		}
		System.out.println(emp2);
		break;
		
		//2.update list based on employee name
		case 2:
			
			
			
 		for (Employee employee : emp) {
			String s1=	employee.getName();
				
			for (Employee employee2 : emp2) {
				String s2=employee2.getName();
				
				if(s1.equals(s2))
				{
					System.out.println("enter a name");
					String s3 =sn.next();
					
					employee2.setName(s3);
					
				}
			}
			
			
		}
 		emp2.forEach(System.out::println);
 		break;
 		
 		//delete based on age
		case 3:
			for (Employee employee : emp) 
			{
				//int age=employee.getAge();
				for (Employee employee2 : emp2) 
				{
					//int age2=employee2.getAge();
					if(employee.getAge()==employee2.getAge())
					{
						ArrayList<Employee> e3=new ArrayList<>(employee2.getAge());
						e3.clear();
						System.out.println("deleted");
						System.out.println(e3);
					}
					
				}
				
			}
			emp2.forEach(System.out::println);
 		break;
 		
 		//get details based on age
		case 4:
			for (Employee employee : emp) 
			{
				//int age=employee.getAge();
				for (Employee employee2 : emp2) 
				{
					//int age2=employee2.getAge();
					if(employee.getAge()==employee2.getAge())
					{
						//emp1
						System.out.println(employee.getAge());
						System.out.println(employee.getId());
						System.out.println(employee.getName());
						System.out.println(employee.getSalary());
					
						//emp2
						System.out.println(employee2.getAge());
						System.out.println(employee2.getId());
						System.out.println(employee2.getName());
						System.out.println(employee2.getSalary());
					}
					
				}
				
			}
			break;
			
 		//exit
		case 5:
			System.exit(0);
			
		}
		}while(true);
 		}
		
 	}


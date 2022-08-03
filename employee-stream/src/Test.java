import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		
		ArrayList<Employee> employees=new ArrayList<>();
		
		Scanner sn=new Scanner(System.in);
		do {
			System.out.println("1.insert");
			System.out.println("2.display");
			System.out.println("3.get employees based on name");
			System.out.println("4.sorting based on age");
			System.out.println("5.all match");
			System.out.println("6.any match");
			System.out.println("7.none match");
			System.out.println("8.max");
			System.out.println("9:min");
			System.out.println("10.groupby");
			System.out.println("11.delete");
			System.out.println("12.exit");
			System.out.println("enter your choice");
			
			int choice = sn.nextInt();

		switch (choice) {
		
		//insert
		case 1:
			System.out.println("enter how many times");
			int n=sn.nextInt();
			for(int i=1;i<=n;i++)
			{
			System.out.println("enter name");
			String name=sn.next();
			System.out.println("enter age");
			int age=sn.nextInt();
			System.out.println("enter salary");
			int salary=sn.nextInt();
			
			employees.add(new Employee(i,name, age, salary));	
			}
			System.out.println(employees);
			break;
			
			//display
		case 2:
				for (Employee employee : employees) {
				
				System.out.println(employee);
				
			}
			
			break;
			
			//3.get employees based on name
		case 3:
			
			  System.out.println("enter a name"); 
			  String name1=sn.next();
			  //sn.next();
			 
				List<Employee> collect = employees.stream().filter(emp->emp.getName().equals(name1)).collect(Collectors.toList());
				for (Employee employee : collect) {
					System.out.println(employee);
				}
			
			break;
			
			//4.sorting based on salary
		case 4:
			
			List<Employee> collect2 = employees.stream().sorted(Comparator.comparing(Employee::getAge)).collect(Collectors.toList());
			System.out.println(collect2);
			/*
			 * Collections.sort(employees,new Comparator<Employee>() {
			 * 
			 * @Override public int compare(Employee o1, Employee o2) {
			 * 
			 * return o1.getSalary()-o2.getSalary(); } });
			 */
			break;
			
			//all match
		case 5:
			
			  boolean allMatch =
			  employees.stream().allMatch(Employee->Employee.getAge()>18);
			  System.out.println(allMatch);
			 
			/*
			 * if(employees.stream().allMatch(Employee->Employee.getAge()>18)) { for
			 * (Employee employee : employees) { System.out.println("yes"+employee); }
			 * 
			 * } else { System.out.println("no"); }
			 */
			break;
			
			//any match
		case 6:
			
			  boolean anyMatch =
			  employees.stream().anyMatch(Employee->Employee.getAge()>18);
			  System.out.println(anyMatch);
			 
			/*
			 * employees.stream().filter(emp->emp.getAge()>18).collect(Collectors.toList());
			 * 
			 * 
			 * for (Employee employee : employees) { if(employee.getAge()>18) {
			 * System.out.println(employee.getName()); System.out.println(employee.getId());
			 * System.out.println(employee.getSalary());
			 * System.out.println(employee.getAge()); } else { System.out.println("no"); }
			 * 
			 * }
			 */			
			break;
			
			//none match
		case 7:
			System.out.println("enter a name");
			String s=sn.next();
			boolean noneMatch = employees.stream().noneMatch(emp->emp.getName().equals(s));
			System.out.println(noneMatch);
			break;
			
			//max
		case 8:
			employees.stream().max(Comparator.comparing(Employee::getAge))
			.ifPresent(System.out::println);
		break;
		
			//min
		case 9:
			employees.stream().min(Comparator.comparing(Employee::getAge))
			.ifPresent(System.out::println);
			break;
			
			//group by
		case 10:
			employees.stream().collect(Collectors.groupingBy(Employee::getName));
			employees.forEach(System.out::println);
			
			break;
			
			//delete
		case 11:
			System.out.println("enter a num");
			int e=sn.nextInt();
			List<Employee> employees2=employees.stream().filter(emp->emp.getId()==e).collect(Collectors.toList());
			employees.remove(employees2);
			System.out.println("deleted");
			break;
			
			//exit
		case 12:
			System.exit(0);
		default:
			break;
		}
		
		}while(true);
	}

}

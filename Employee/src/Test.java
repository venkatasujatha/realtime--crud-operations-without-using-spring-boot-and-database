import java.io.ObjectInputStream.GetField;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test {
	static int y = 1;

	public static void main(String[] args) {

		Scanner sn = new Scanner(System.in);
		System.out.println("enter a number");
		int c = sn.nextInt();
		int x = 0;
		ArrayList<Employee> list = new ArrayList<>();
		Set<Employee> e1 = new HashSet<>();
		
		while (x < c) {
			System.out.println("enter name");
			String name1 = sn.next();
			boolean check=true;
			long phoneno2 = 0;
			System.out.println("enter phoneno");

			while(check) {
				long phoneno1 = sn.nextLong();

				  if(list.stream().anyMatch(phoneno->phoneno.getPhoneno() == phoneno1))
				  {
				  System.out.println("enter another number"); 
				 // phoneno1 = sn.nextLong();
				   check=true;
				  }
				  else
				  { 
					  phoneno2=phoneno1;

					  check=false; 
				  }
			  }
				 		
			
		  System.out.println("enter age");
			int age1 = sn.nextInt();
			list.add(new Employee(y, name1, phoneno2, age1));
			x++;
			y++;
		}
		System.out.println(list);

		

		for (Employee employee : list) {
			if (employee.getAge() > 18 && employee.getPhoneno() > 999999999l && employee.getPhoneno() < 9999999999l) {

				System.out.println(e1.add((employee)));
			}
		}

		
		do {

			System.out.println("1:get all employee");
			System.out.println("2:get employee by conditions");
			System.out.println("3.update an employee ");
			System.out.println("4:delete an employee based on id");
			System.out.println("5.delete all");
			System.out.println("6.exit");

			System.out.println("enter your choice");
			int a = sn.nextInt();

			switch (a) {
			
			//get employee details
			case 1:
				
				e1=e1.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toSet());
				
				System.out.println(e1);

				for (Employee employee : e1) {

					System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getPhoneno() + " "
							+ employee.getAge());

				}

				break;
				
				//get the details based on age
			case 2:
				System.out.println("enter age");
				int r = sn.nextInt();
				for (Employee employee : e1) {
					if (employee.getAge() == r) {

						System.out.println(employee);
					}

				}
				break;
				
				//update
			case 3:
				System.out.println("enter id what we want to update");
				int empno2=sn.nextInt();
				for (Employee employee : e1) {
					int eId = 0;
					if (empno2 == employee.getId()) {
						eId++;

	                //take which field you want to update
						do {

							int ch = 0;
							System.out.println("enter  field to be update....");
							System.out.println("1. update name");
							System.out.println("2.update age");
							System.out.println("3.update phoneno");
							System.out.println("enter your choice :");
							ch = sn.nextInt();
							switch (ch) {
							case 1:
								System.out.println("enter new name");
								String ename = sn.next();
								employee.setName(ename);
								System.out.println(employee);
								break;

							case 2:
								System.out.println("enter new age..");
								int age = sn.nextInt();
								employee.setAge(age);
								System.out.println(employee);
								break;
							case 3:
								System.out.println("enter new phoneno..");
								long phoneno = sn.nextLong();
								employee.setPhoneno(phoneno);
								System.out.println(employee);
								break;


							default:
								System.out.println("given " + employee.getId() + " does not exists");
								System.out.println(employee);
								break;
							}

						} while (false);
					} 
					else {
						System.out.println("employee id is not available " + eId);
						break;
					}
				}
				break;
				
				//delete	
				case 4:

				System.out.println("enter id");
				int t = sn.nextInt();

				for (Employee employee : e1) {
					if (employee.getId() == t)

						e1.remove(employee);
					break;

				}

				e1.forEach(System.out::println);

				break;
				
				//delete all
			case 5:
				for (Employee employee : e1) {
					
					e1.remove(employee);
					break;
				}
				System.out.println(e1);
				break;
				
				//exit
			case 6:
				//System.out.println("exit");
				System.exit(0);
				

			}
		} while (true);

	}
}

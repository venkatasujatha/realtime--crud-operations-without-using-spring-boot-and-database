package empcsv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class EmployeeServiceImpl {
	static Integer idCount = 1;

	public static void display(ArrayList<Employee> employees) {
		System.err.println("==========Employee console based application===============");

// format records like table
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}

	public static void main(String[] args) throws IOException {
		ArrayList<Employee> employees = new ArrayList<>();

		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("/home/tectoro/sujatha/employee.csv")));


		Integer id = null;
		String name = null;
		String phone = null;
		String dept = null;
		Integer numberOfEmployeeInsert = null;

// scanner to read the console input
		Scanner scanner = new Scanner(System.in);
		ArrayList<Employee> list = new ArrayList<>();

// do-while

// main method

		do {

			Integer i = 0;
			System.out.println("----------------------welcome to app--------------------");
			System.out.println("1. add the employee\n" + " 2.search employee\n" + "3.edit employee details\n"
					+ "4.delete employee records\n" + "5.display all employee record\n" + "6.quite");

// now read the switch cases
			System.out.println("enter your choice");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:

				System.out.println("enter number of employee to be insert...");
				numberOfEmployeeInsert = scanner.nextInt();
				while (i < numberOfEmployeeInsert) {

// assign values
					/*
					 * System.out.println("enter the folloeing details.......");
					 * System.out.println("enter employee id"); id = scanner.nextInt();
					 */
					System.out.println("enter employee name");
					String ename = scanner.next();
					/**
					 * VALIDATE FIELD
					 **/
					/*
					 * if (list.size() > 0) { for (Employee employee : list) { if
					 * (ename.equalsIgnoreCase(employee.getName())) {
					 * System.out.println("employee name already exists in list"); } else { name =
					 * ename; } } } else { name = ename; }
					 */
					System.out.println("enter employee phone");
					phone = scanner.next();

					System.out.println("enter employee department");
					dept = scanner.next();

// now adding all employee details to list

					list.add(new Employee(id, ename, phone, dept));

// check if name there

					i++;

				}

				for (Employee employee : list) {

					String ename1 = employee.getName();
					System.out.println(ename1);
					String phone1 = employee.getPhone();
					String dept1 = employee.getDept();

					String res = "" + idCount + "," + ename1 + "," + phone1 + "," + dept1;
					writer.write(res);
					writer.newLine();
					idCount++;

				}

// now display the record
// display(list);
				writer.close();
				break;

// search employee based on id

			case 2:
				System.out.println("enter employee  id");
				int employeeid = scanner.nextInt();

 // iterate loop
				for (Employee employee : list) {
					if (employeeid == employee.getId()) {
// print record
						System.out.println(employee);
						break;
					} else {
						System.out.println("sorry given . " + employeeid + " employee does not exists ");
						break;
					}
				}
				break;

			case 3:
				System.out.println("enter employee id what you want to update..");
				int getEmpid = scanner.nextInt();
				for (Employee employee : employees) {
					int eId = 0;
					if (getEmpid == employee.getId()) {
						eId++;

// take what field you want to upadate
						do {

							int ch = 0;
							System.out.println("enter  field to edit here.... ");
							System.out.println("1. update name\n" + "2. update phone\n" + "3. update dept");

							System.out.println("enter update choice :");
							ch = scanner.nextInt();
							switch (ch) {
							case 1:
								System.out.println("enter updated name");
								name = scanner.next();
								employee.setName(name);

								System.out.println(employee);
								break;

							case 2:
								System.out.println("enter new phone..");
								phone = scanner.next();
								employee.setPhone(phone);
								System.out.println(employee);
								break;

							case 4:
								System.out.println("enter updated dept");
								dept = scanner.next();
								employee.setPhone(phone);
								System.out.println(employee);
								break;

							default:
								System.out.println("given " + employee.getId() + " does not exists");
								System.out.println(employee);
								break;
							}

						} while (false);
					} else {
						System.out.println("employee id is not available " + eId);
						break;
					}
				}
				BufferedWriter writer2 = new BufferedWriter(new FileWriter(new File("/home/tectoro/sujatha/employee.csv")));
				for (Employee employee1 : employees) {

					String ename1 = employee1.getName();
					String phone1 = employee1.getPhone();
					String dept1 = employee1.getDept();

					String res = "" + employee1.getId() + "," + ename1 + "," + phone1 + "," + dept1;
					writer2.write(res);
					writer2.newLine();

				}
				writer2.close();
				break;
// delete by id
			case 4:
				BufferedWriter writer1 = new BufferedWriter(new FileWriter(new File("/home/tectoro/sujatha/employee.csv")));
				System.out.println("enter employee to be deleted");
				int delId = scanner.nextInt();
				for (Employee employee : employees) {
					if (delId == employee.getId()) {
						employees.remove(employee);
						System.out.println("after deletion of gievn " + delId);

						break;

					}
				}
				for (Employee employee1 : employees) {

					String ename1 = employee1.getName();
					String phone1 = employee1.getPhone();
					String dept1 = employee1.getDept();

					String res = "" + employee1.getId() + "," + ename1 + "," + phone1 + "," + dept1;
					writer1.write(res);
					writer1.newLine();

				}
				System.out.println(employees);
				writer1.close();

				break;

// display all employee records
			case 5:
				BufferedReader reader = new BufferedReader(new FileReader(new File("/home/tectoro/sujatha/employee.csv")));
				String str;
				int c = 1;

				while ((str = reader.readLine()) != null) {
					String[] var = str.split(",");
					employees.add(new Employee(c, var[1], var[2], var[3]));
					c++;

				}
// System.out.println(employees.toString());

				System.out.println("display all records");
				display(employees);
				reader.close();
				break;

			case 6:
// System.out.println("you want to quite");
				return;

			default:
				System.out.println("please enter correct choice ");
				break;
			}

		} while (true);

	}
}

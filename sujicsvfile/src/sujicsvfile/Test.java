package sujicsvfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class Test {
	static int id = 1;

	public static void main(String[] args) throws Exception, EOFException {

		Scanner sn = new Scanner(System.in);
		Scanner sn1 = new Scanner(System.in);

		ArrayList<Employee> a1 = new ArrayList<Employee>();
		// CONVERT OBJECT INTO FILE
		File file = new File("/home/tectoro/sujatha/employee.csv");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));

		ListIterator li = null;

		do {
			System.out.println("1.INSERT DETAILS");
			System.out.println("2.DISPLAY");
			System.out.println("3.DELETE AN EMPLOYEE BASED ON EMPNO");
			System.out.println("4.UPDATE AN EMPLOYEE BASED ON EMPNO");

			System.out.println("5.EXIT");
			System.out.println("enter your choice");
			int choice = sn.nextInt();

			switch (choice) {
			// insert

			case 1:

				System.out.println("enter how many times");
				int n = sn.nextInt();
				for (int i = 1; i <= n; i++) {
					System.out.println("enter name");
					String ename = sn1.nextLine();
					System.out.println("enter phoneno");
					long phoneno = sn.nextLong();

						boolean check = true;
						long phoneno2 = 0;
							if (phoneno > 999999999l && phoneno < 99999999999l&&a1.isEmpty()) {

								a1.add(new Employee(i, ename, phoneno));
							}
							else
							{
								
							
							while (check) {

								if (phoneno > 999999999l && phoneno < 99999999999l) {
									long phoneno1=phoneno;

									if (a1.stream().anyMatch(emp->emp.getPhoneno() == phoneno1)) {
										System.out.println("phone number already exists please enter another number");
										phoneno=sn.nextLong();
										check = true;

									} else {
										check = false;
										phoneno = phoneno1;
										a1.add(new Employee(i, ename, phoneno));

									}
								}
							}
							}

					

					String res = id + "," + ename + "," + phoneno;
					writer.write(res);
					writer.newLine();
					id++;
				}

				System.out.println(a1);
				writer.close();
				break;
			// display
			case 2:
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String str;
				int c = 1;

				while ((str = reader.readLine()) != null) {
					System.out.println(str);
					c++;
				}

				break;

			// delete

			case 3:
				BufferedWriter writer1 = new BufferedWriter(new FileWriter(file));
				System.out.println("----------");
				Boolean found = false;
				System.out.println("enter empno to delete");
				int empno = sn.nextInt();
				li = a1.listIterator();

				while (li.hasNext()) {
					Employee e = (Employee) li.next();
					// System.out.println(e);
					if (e.getEmpno() == empno) {
						li.remove();
						found = true;
						System.out.println("record is deleted");
						break;
					}

					for (Employee employee : a1) {
						int empno1 = employee.getEmpno();
						String ename1 = employee.getEname();
						Long phoneno= employee.getPhoneno();
						String res = empno1 + "," + ename1 + "," + phoneno;
						writer1.write(res);
						writer1.newLine();
					}
					System.out.println(a1);
					writer1.close();
				}
				break;

			// update

			case 4:

				// Boolean check=false;
				System.out.println("enter empno what we want to update");
				int empno2 = sn.nextInt();
				for (Employee employee : a1) {
					int eId = 0;
					if (empno2 == employee.getEmpno()) {
						eId++;

						// take which field you want to update
						do {

							int ch = 0;
							System.out.println("enter  field to be update....");
							System.out.println("1. update name");
							System.out.println("2.update phoneno");

							System.out.println("enter your choice :");
							ch = sn.nextInt();
							switch (ch) {
							case 1:
								System.out.println("enter new name");
								String ename = sn1.next();
								employee.setEname(ename);
								System.out.println(employee);
								break;

							case 2:
								System.out.println("enter new phoneno..");
								long phone = sn.nextLong();
								employee.setPhoneno(phone);
								System.out.println(employee);
								break;

							default:
								System.out.println("given " + employee.getEmpno() + " does not exists");
								System.out.println(employee);
								break;
							}

						} while (false);
					} 
					
				}

				BufferedWriter writer2 = new BufferedWriter(new FileWriter(file));
				for (Employee employee1 : a1) {
					int empno1 = employee1.getEmpno();
					String ename1 = employee1.getEname();
					Long phoneno = employee1.getPhoneno();
					String res = empno1 + "," + ename1 + "," + phoneno;
					writer2.write(res);
					writer2.newLine();
				}
				System.out.println(a1);
				writer2.close();
				break;

			case 5:
				System.out.println("exit");
				System.exit(0);

			}
		} while (true);

	}
}

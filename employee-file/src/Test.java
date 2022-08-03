

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.Scanner;
import java.io.Serializable;

public class Test {

	public static void main(String[] args) throws Exception,EOFException {
		int choice=-1;
		Scanner sn=new Scanner(System.in);
		Scanner sn1=new Scanner(System.in);
		
		ArrayList<Employee> a1=new ArrayList<Employee>();
		//CONVERT OBJECT INTO FILE
		
		File file=new File("/home/tectoro/sujatha/employee.csv");
		
		ObjectOutputStream oos=null;
		
		//CONVERT FILE INTO OBJECTS
		
		ObjectInputStream ois=null;
		if(file.isFile())
		{
			try
			{
			ois=new ObjectInputStream(new FileInputStream(file));
			a1=(ArrayList<Employee>) ois.readObject();
			ois.close();
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			
			
			
			
		}
		
			
			ListIterator li=null;
	
				do {
			System.out.println("1.INSERT DETAILS");
			System.out.println("2.DISPLAY");
			System.out.println("3.SEARCH BASED ON EMPNO");
			System.out.println("4.DELETE AN EMPLOYEE BASED ON EMPNO");
			System.out.println("5.UPDATE AN EMPLOYEE BASED ON EMPNO");
			
			System.out.println("0.EXIT");
			System.out.println("enter your choice");
			 choice=sn.nextInt();
			
			switch(choice)
			{
			//insert
			case 1:
				
				System.out.println("enter how many times");
				int n=sn.nextInt();
				for(int i=1;i<=n;i++)
				{
				System.out.println("enter empno");
				int id=sn.nextInt();
				System.out.println("enter name");
				String ename=sn1.nextLine();
				System.out.println("enter phoneno");
				long phoneno=sn.nextLong();
				a1.add(new Employee(id, ename, phoneno));
				oos=new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(a1);
				
				
				}
				oos.close();
				break;
			//display	
			case 2:
				
				
				System.out.println("-------------------");
				li = a1.listIterator();
				while (li.hasNext()) {
					System.out.println(li.next());
				System.out.println("----------------");	
					
				}
				
				break;
			//search an element	
			case 3:
				System.out.println("----------");
				if(file.isFile())
				{
					try
					{
					ois=new ObjectInputStream(new FileInputStream(file));
					a1=(ArrayList<Employee>) ois.readObject();
					ois.close();
					
					Boolean found=false;
					System.out.println("enter empno to search");
					int empno=sn.nextInt();
					li = a1.listIterator();
					
					while (li.hasNext()) {
						Employee e = (Employee) li.next();
						//System.out.println(e);
						if(e.getEmpno()==empno)
						{
							System.out.println(e);
							found=true;
						}
					
					}
					if(!found)
						
							System.out.println("record not found");
					}
					
					
					catch (Exception e) {
						// TODO: handle exception
					}
					
				}
				else
				{
					System.out.println("file not exists....");
				}
				
				break;	
				
				//delete
			case 4:
				System.out.println("----------");
				if(file.isFile())
				{
					try
					{
					ois=new ObjectInputStream(new FileInputStream(file));
					a1=(ArrayList<Employee>) ois.readObject();
					ois.close();
					
					Boolean found=false;
					System.out.println("enter empno to delete");
					int empno=sn.nextInt();
					li = a1.listIterator();
					
					while (li.hasNext()) 
					{
						Employee e = (Employee) li.next();
						//System.out.println(e);
						if(e.getEmpno()==empno)
						{
							li.remove();
							found=true;
						}
					
					}
					if(found)
					{
						oos=new ObjectOutputStream(new FileOutputStream(file));
						oos.writeObject(a1);
						oos.close();
						System.out.println("record deleted successfully");
					}
						
							
					else
					{
						System.out.println("record not found");
					}
					}
					
					
					catch (Exception e) {
						// TODO: handle exception
					}
					
				}
				else
				{
					System.out.println("file not exists....");
				}
				
				break;	
				
				//update
				
			case 5:
				if(file.isFile())
				{
					ois=new ObjectInputStream(new FileInputStream(file));
					a1=(ArrayList<Employee>)ois.readObject();
					ois.close();
					
					Boolean found=false;
					System.out.println("enter empno to update");
					int empno=sn.nextInt();
					
					li=a1.listIterator();
					while (li.hasNext()) 
					{
						Employee em1 = (Employee) li.next();
						if(em1.getEmpno()==empno)
						{
							System.out.println("enter new emp name");
							String ename=sn1.nextLine();
							System.out.println("enter new phoneno");
							int phoneno=sn.nextInt();
							li.set(new Employee(empno, ename, phoneno));
							found=true;
						}
					}
					if(found)
					{
						oos=new ObjectOutputStream(new FileOutputStream(file));
						oos.writeObject(a1);
						oos.close();
						System.out.println("record updated successfully");
					}
					
						else
						{
							System.out.println("record not found");
						}
				}	
				
				else
					{
						System.out.println("file not exists....");
					}
					
					break;	
							
			}	
				}while(choice!=0);
	
				}
}
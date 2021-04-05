package employee;
import java.util.Scanner;
import java.util.ArrayList;
public class Details {
	public static void main(String[] args) throws Exception 
	{ 
		ArrayList<Employee> empList = new ArrayList<>();
		Scanner s = new Scanner(System.in);
		char c ;
		String ch;
	
	System.out.println("\n Welcome To Employee Registration System\n");
	do
	{
		System.out.println("1. Press A to ADD Employee details");
		System.out.println("2. Press U to UPDATE Employee details");
		System.out.println("3. Press D to DELETE Employee details");
		System.out.println("4. Press P to PRINT Employee details");
		System.out.println("5. Press S to SEARCH Employee details by ID\n");
		
		System.out.print("Enter your choice : ");
		ch = s.next();
		System.out.println("\n");
		
		switch(ch)
		{
		case "A":
			empAdd(empList);
			break;
			
		case "U":
			System.out.print("Enter the Employee Id : ");
			empIdU = s.nextLong();
			empDetailsUpdate(empList, empIdU);
			break;
			
		case "D":
			System.out.print("Enter the Employee Id : ");
			empIdD = s.nextLong();
			empDelete(empList, empIdD);
			break;
			
		case "P":
			empGet(empList);
			break;
			
		case "S":
			System.out.print("Enter the Employee Id : ");
			empIdSe = s.nextLong();
			empGet(empList, empIdSe);
			break;
			
		default:
			System.out.println("Invalid Choice");
		}
		System.out.print("Do you want to continue with the Registration System(Press Y/y for Yes or Press N/n for No) ? : ");
		c = s.next();
		
	}while(c=='Y'|| c=='y');
	
	s.close();
	
}

public static void empAdd(ArrayList<Employee> empList)
{
	Scanner s = new Scanner(System.in);
	
	if(empList.length()==0)
	{
		System.out.print("Enter Employee Name : ");
		String empName = s.nextLine();
		System.out.println("\n");
		System.out.print("Enter Employee Age : ");
		int empAge = s.nextInt();
		s.nextLine();
		System.out.println("\n");
		System.out.print("Enter Employee Address : ");
		String empAddress = s.nextLine();
		
		Employee emp = new Employee(1970478, empName, empAge, empAddress);
		empList.add(emp);
	}
	else
	{
		System.out.println("Enter Employee Name : ");
		String empName = s.nextLine();
		System.out.println("\n");
		System.out.println("Enter Employee Age : ");
		int empAge = s.nextInt();
		s.nextLine();
		System.out.println("\n");
		System.out.println("Enter Employee Address : ");
		String empAddress = s.nextLine();
		long empId = empList.get(empList.size()-1).getEmpId();
		
		Employee emp = new Employee(empId+1, empName, empAge, empAddress);
		empList.add(emp);
	}	
	s.close();
		
}
public static void empDetailsUpdate(ArrayList<Employee> empList, long empId)
{
	int flag = 0;
	char c;
	Scanner s = new Scanner(System.in);
	
	for(int i=0;i<empList.length();i++)
	{
		if(empList.get(i).getEmpId() == empId)
		{
			do
			{
				System.out.println("Select the field you want to update for "+empId+" : \n");
				System.out.println("Press 1 for Employee Name\n Press 2 for Employee Age\n Press 3 for Employee Address\n");
				System.out.print("Enter your choice : ");
				int ch = s.nextInt();
				
				switch(ch)
				{
				case 1:
					System.out.print("Enter the updated Name field : ");
					String name = s.nextLine();
					empList.setEmpName(name);
					System.out.println("Employee Name updated for "+empId+"\n");
					flag = 1;
					break;
				case 2:
					System.out.print("Enter the updated Age field : ");
					int age = s.nextInt();
					empList.setEmpAge(age);
					System.out.println("Employee Age updated for "+empId+"\n");
					flag = 1;
					break;
				case 3:
					System.out.print("Enter the updated Address field : ");
					String address = s.nextLine();
					empList.setEmpAddress(address);
					System.out.println("Employee Address updated for "+empId+"\n");
					flag = 1;
					break;
				default:
					System.out.println("Invalid choice\n");
				}
				System.out.print("Do you want to Update any field again for "+empId+"(Press Y for Yes or Press N for No)? : ");
				c = s.next();
				
			}while(c == 'Y');
			
		}
	}
	s.close();
	if(flag == 0)
	{
		System.out.println("No employee is present with the given employee Id.\n");
	}
}
public static void empDelete(ArrayList<Employee> empList, long empId)
{
	Scanner s = new Scanner(System.in);
	int flag = 0;
	
	for(int i = 0; i<empList.length();++i)
	{
		if(empList.get(i).getEmpId() == empId)
		{
			System.out.print("Do you want to delete the record for "+empId+"(Press Y for Yes or Press N for No)? : ");
			char ch =  s.next().charAt(0);
			if(ch == 'Y')
			{
				empList.delete(i);
				System.out.println("Record deleted");
				flag = 1;
			}
			else 
			{
				System.out.println("You chose not to delete the record for "+empId+"\n");
				flag = 1;
			}
			break;
		}
	}
	s.close();
	if(flag == 0)
	{
		System.out.println("No employee is present with the given employee Id.\n");
	}
}

public static void empGet(ArrayList<Employee> empList)
{
	System.out.println("Employee ID\t\tEmployee Name\t\tEmployee Age\t\tEmployee Address\n");
	for(int i=0;i<empList.length();i++)
	{
		System.out.println(empList.get(i));
	}
	System.out.println();
}

public static void empGet(ArrayList<Employee> empList, long empId)
{
	int flag = 0;
	
	for(int i=0; i<empList.length();i++)
	{
		if(empList.get(i).getEmpId() == empId)
		{
			System.out.println("Employee ID\t\tEmployee Name\t\tEmployee Age\t\tEmployee Address\n");
			System.out.println(empList.get(i));
			flag = 1;
			break;
		}
		
	}
	if(flag == 0)
	{
		System.out.println("No employee is present with the given employee Id.\n");
	}
}
}

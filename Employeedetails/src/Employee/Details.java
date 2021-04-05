package Employee;
import java.util.Scanner;
import java.util.ArrayList;
public class Details {
	public static void main(String[] args) throws Exception 
	{ 
		ArrayList<Employee> empList = new ArrayList<>();
		Scanner s = new Scanner(System.in);
		char c ;
	
	System.out.println("\n Welcome To Employee Registration System\n");
	do
	{
		System.out.println("1. Press 1 to ADD Employee details");
		System.out.println("2. Press 2 to UPDATE Employee details");
		System.out.println("3. Press 3 to DELETE Employee details");
		System.out.println("4. Press 4 to PRINT Employee details");
		System.out.println("5. Press 5 to SEARCH Employee details by ID\n");
		
		System.out.print("Enter your choice : ");
		int ch = s.nextInt();
		s.nextLine();
		System.out.println("\n");
		
		switch(ch)
		{
		case 1:
			empAdd(empList);
			break;
			
		case 2:
			System.out.print("Enter the Employee Id : ");
			long empIdUpdate = s.nextLong();
			empDetailsUpdate(empList, empIdUpdate);
			break;
			
		case 3:
			System.out.print("Enter the Employee Id : ");
			long empIdDelete = s.nextLong();
			empDelete(empList, empIdDelete);
			break;
			
		case 4:
			empGet(empList);
			break;
			
		case 5:
			System.out.print("Enter the Employee Id : ");
			long empIdSearch = s.nextLong();
			empGet(empList, empIdSearch);
			break;
			
		default:
			System.out.println("Invalid Choice");
		}
		System.out.print("Do you want to continue with the Registration System(Press Y for Yes or Press N for No) ? : ");
		c = s.next().charAt(0);
		
	}while(c == 'Y');
	
	s.close();
	
}

public static void empAdd(ArrayList<Employee> empList)
{
	Scanner s = new Scanner(System.in);
	
	if(empList.size()==0)
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
	//s.close();
		
}

public static void empGet(ArrayList<Employee> empList)
{
	System.out.println("Employee ID\t\tEmployee Name\t\tEmployee Age\t\tEmployee Address\n");
	for(int i=0;i<empList.size();i++)
	{
		System.out.println(empList.get(i));
	}
	System.out.println();
}

public static void empGet(ArrayList<Employee> empList, long empId)
{
	int flag = 0;
	
	for(int i=0; i<empList.size();i++)
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

public static void empDelete(ArrayList<Employee> empList, long empId)
{
	Scanner s = new Scanner(System.in);
	int flag = 0;
	
	for(int i = 0; i<empList.size();++i)
	{
		if(empList.get(i).getEmpId() == empId)
		{
			System.out.print("Do you want to delete the record for "+empId+"(Press Y for Yes or Press N for No)? : ");
			char ch =  s.next().charAt(0);
			if(ch == 'Y')
			{
				empList.remove(i);
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
	//s.close();
	if(flag == 0)
	{
		System.out.println("No employee is present with the given employee Id.\n");
	}
}

public static void empDetailsUpdate(ArrayList<Employee> empList, long empId)
{
	int flag = 0;
	char c;
	Scanner s = new Scanner(System.in);
	
	for(int i=0;i<empList.size();i++)
	{
		if(empList.get(i).getEmpId() == empId)
		{
			do
			{
				System.out.println("Select the field you want to update for "+empId+" : \n");
				System.out.println("Press 1 for Employee Name\n Press 2 for Employee Age\n Press 3 for Employee Address\n");
				System.out.print("Enter your choice : ");
				int ch = s.nextInt();
				s.nextLine();
				
				switch(ch)
				{
				case 1:
					System.out.print("Enter the updated Name field : ");
					String name = s.nextLine();
					empList.get(i).setEmpName(name);
					System.out.println("Employee Name updated for "+empId+"\n");
					flag = 1;
					break;
				case 2:
					System.out.print("Enter the updated Age field : ");
					int age = s.nextInt();
					s.nextLine();
					empList.get(i).setEmpAge(age);
					System.out.println("Employee Age updated for "+empId+"\n");
					flag = 1;
					break;
				case 3:
					System.out.print("Enter the updated Address field : ");
					String address = s.nextLine();
					empList.get(i).setEmpAddress(address);
					System.out.println("Employee Address updated for "+empId+"\n");
					flag = 1;
					break;
				default:
					System.out.println("Invalid choice\n");
				}
				System.out.print("Do you want to Update any field again for "+empId+"(Press Y for Yes or Press N for No)? : ");
				c = s.next().charAt(0);
				
			}while(c == 'Y');
			
		}
	}
	//s.close();
	if(flag == 0)
	{
		System.out.println("No employee is present with the given employee Id.\n");
	}
}
}


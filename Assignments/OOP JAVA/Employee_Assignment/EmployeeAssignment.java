import java.io.*;
class Employee{
    protected int id;
    protected String name;
    protected double salary;
    public Employee(int id,String name,double salary){
        this.id=id;
        this.name=name;
        this.salary=salary;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getSalary(){
        return salary;
    }
    public void display(){
        System.out.println("Employee ID : "+id);
        System.out.println("Name : "+name);
        System.out.println("Salary : "+salary);
    }
}
class Manager extends Employee{
    private String department;
    public Manager(int id,String name,double salary,String department){
        super(id,name,salary);
        this.department=department;
    }
    public void display(){
        System.out.println("Employee Type : Manager");
        System.out.println("Employee ID : "+id);
        System.out.println("Name : "+name);
        System.out.println("Salary : "+salary);
        System.out.println("Department : "+department);
    }
    public String getDepartment(){
        return department;
    }
}
class Engineer extends Employee{
    private String technology;
    public Engineer(int id,String name,double salary,String technology){
        super(id,name,salary);
        this.technology=technology;
    }
    public void display(){
        System.out.println("Employee Type : Engineer");
        System.out.println("Employee ID : "+id);
        System.out.println("Name : "+name);
        System.out.println("Salary : "+salary);
        System.out.println("Technology : "+technology);
    }
    public String getTechnology(){
        return technology;
    }
}
class SalesPerson extends Employee{
    private double salesTarget;
    public SalesPerson(int id,String name,double salary,double salesTarget){
        super(id,name,salary);
        this.salesTarget=salesTarget;
    }
    public void display(){
        System.out.println("Employee Type : Sales Person");
        System.out.println("Employee ID : "+id);
        System.out.println("Name : "+name);
        System.out.println("Salary : "+salary);
        System.out.println("Sales Target : "+salesTarget);
    }
    public double getSalesTarget(){
        return salesTarget;
    }
}
class Node{
    Employee employee;
    Node previous;
    Node next;
    public Node(Employee employee){
        this.employee=employee;
        previous=null;
        next=null;
    }
}
class EmployeeList{
    Node head;
    Node tail;
    Node current;
    public void addEmployee(Employee employee){
        Node newNode=new Node(employee);
        if(head==null){
            head=newNode;
            tail=newNode;
            current=newNode;
        }
        else{
            tail.next=newNode;
            newNode.previous=tail;
            tail=newNode;
        }
        System.out.println("Employee added successfully.");
    }
    public void displayAll(){
        if(head==null){
            System.out.println("No employees available.");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.println("----------------------------");
            temp.employee.display();
            temp=temp.next;
        }
    }
    public void firstEmployee(){
        if(head==null){
            System.out.println("No employees available.");
            return;
        }
        current=head;
        current.employee.display();
    }
    public void nextEmployee(){
        if(current==null){
            System.out.println("No employees available.");
            return;
        }
        if(current.next==null){
            System.out.println("Already at the last employee.");
            return;
        }
        current=current.next;
        current.employee.display();
    }
    public void previousEmployee(){
        if(current==null){
            System.out.println("No employees available.");
            return;
        }
        if(current.previous==null){
            System.out.println("Already at the first employee.");
            return;
        }
        current=current.previous;
        current.employee.display();
    }
    public void lastEmployee(){
        if(tail==null){
            System.out.println("No employees available.");
            return;
        }
        current=tail;
        current.employee.display();
    }
    public void displayManagers(){
        Node temp=head;
        boolean found=false;
        while(temp!=null){
            if(temp.employee instanceof Manager){
                temp.employee.display();
                found=true;
            }
            temp=temp.next;
        }
        if(!found)
            System.out.println("No Managers found.");
    }
    public void displayEngineers(){
        Node temp=head;
        boolean found=false;
        while(temp!=null){
            if(temp.employee instanceof Engineer){
                temp.employee.display();
                found=true;
            }
            temp=temp.next;
        }
        if(!found)
            System.out.println("No Engineers found.");
    }
    public void displaySalesPersons(){
        Node temp=head;
        boolean found=false;
        while(temp!=null){
            if(temp.employee instanceof SalesPerson){
                temp.employee.display();
                found=true;
            }
            temp=temp.next;
        }
        if(!found)
            System.out.println("No Sales Persons found.");
    }
    public void sortAscending(){
        if(head==null){
            System.out.println("No employees available.");
            return;
        }
        Node i=head;
        while(i!=null){
            Node j=i.next;
            while(j!=null){
                if(i.employee.getName().compareToIgnoreCase(j.employee.getName())>0){
                    Employee temp=i.employee;
                    i.employee=j.employee;
                    j.employee=temp;
                }
                j=j.next;
            }
            i=i.next;
        }
        displayAll();
    }
    public void sortDescending(){
        if(head==null){
            System.out.println("No employees available.");
            return;
        }
        Node i=head;
        while(i!=null){
            Node j=i.next;
            while(j!=null){
                if(i.employee.getName().compareToIgnoreCase(j.employee.getName())<0){
                    Employee temp=i.employee;
                    i.employee=j.employee;
                    j.employee=temp;
                }
                j=j.next;
            }
            i=i.next;
        }
        displayAll();
    }
    public void saveToFile(){
        try{
            FileWriter writer=new FileWriter("employees.txt");
            Node temp=head;
            while(temp!=null){
                Employee employee=temp.employee;
                if(employee instanceof Manager){
                    Manager manager=(Manager)employee;
                    writer.write("Manager,"+manager.getId()+","+manager.getName()+","+manager.getSalary()+","+manager.getDepartment()+"\n");
                }
                else if(employee instanceof Engineer){
                    Engineer engineer=(Engineer)employee;
                    writer.write("Engineer,"+engineer.getId()+","+engineer.getName()+","+engineer.getSalary()+","+engineer.getTechnology()+"\n");
                }
                else if(employee instanceof SalesPerson){
                    SalesPerson salesPerson=(SalesPerson)employee;
                    writer.write("SalesPerson,"+salesPerson.getId()+","+salesPerson.getName()+","+salesPerson.getSalary()+","+salesPerson.getSalesTarget()+"\n");
                }
                temp=temp.next;
            }
            writer.close();
            System.out.println("Employees saved successfully.");
        }
        catch(IOException e){
            System.out.println("Error while saving file.");
        }
    }
    public void loadFromFile(){
        try{
            BufferedReader reader=new BufferedReader(new FileReader("employees.txt"));
            String line;
            while((line=reader.readLine())!=null){
                String[] data=line.split(",");
                String type=data[0];
                int id=Integer.parseInt(data[1]);
                String name=data[2];
                double salary=Double.parseDouble(data[3]);
                if(type.equals("Manager")){
                    Manager manager=new Manager(id,name,salary,data[4]);
                    addEmployee(manager);
                }
                else if(type.equals("Engineer")){
                    Engineer engineer=new Engineer(id,name,salary,data[4]);
                    addEmployee(engineer);
                }
                else if(type.equals("SalesPerson")){
                    SalesPerson salesPerson=new SalesPerson(id,name,salary,Double.parseDouble(data[4]));
                    addEmployee(salesPerson);
                }
            }
            reader.close();
            System.out.println("Employees loaded successfully.");
        }
        catch(IOException e){
            System.out.println("employees.txt file not found.");
        }
    }
}
class EmployeeAssignment{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static EmployeeList list=new EmployeeList();
    public static int getInt() throws IOException{
        return Integer.parseInt(br.readLine());
    }
    public static double getDouble() throws IOException{
        return Double.parseDouble(br.readLine());
    }
    public static void addEmployeeMenu() throws IOException{
        int choice;
        do{
            System.out.println("\n===== ADD EMPLOYEE =====");
            System.out.println("1. Manager");
            System.out.println("2. Engineer");
            System.out.println("3. Sales Person");
            System.out.println("4. Exit to Main Menu");
            System.out.print("Enter your choice: ");
            choice=getInt();
            switch(choice){
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int managerId=getInt();
                    System.out.print("Enter Name: ");
                    String managerName=br.readLine();
                    System.out.print("Enter Salary: ");
                    double managerSalary=getDouble();
                    System.out.print("Enter Department: ");
                    String department=br.readLine();
                    list.addEmployee(new Manager(managerId,managerName,managerSalary,department));
                    break;
                case 2:
                    System.out.print("Enter Employee ID: ");
                    int engineerId=getInt();
                    System.out.print("Enter Name: ");
                    String engineerName=br.readLine();
                    System.out.print("Enter Salary: ");
                    double engineerSalary=getDouble();
                    System.out.print("Enter Technology: ");
                    String technology=br.readLine();
                    list.addEmployee(new Engineer(engineerId,engineerName,engineerSalary,technology));
                    break;
                case 3:
                    System.out.print("Enter Employee ID: ");
                    int salesId=getInt();
                    System.out.print("Enter Name: ");
                    String salesName=br.readLine();
                    System.out.print("Enter Salary: ");
                    double salesSalary=getDouble();
                    System.out.print("Enter Sales Target: ");
                    double salesTarget=getDouble();
                    list.addEmployee(new SalesPerson(salesId,salesName,salesSalary,salesTarget));
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }while(choice!=4);
    }
    public static void displayMenu() throws IOException{
        int choice;
        do{
            System.out.println("\n===== DISPLAY =====");
            System.out.println("1. All Employees");
            System.out.println("2. First Employee");
            System.out.println("3. Next Employee");
            System.out.println("4. Previous Employee");
            System.out.println("5. Last Employee");
            System.out.println("6. Exit to Main Menu");
            System.out.print("Enter your choice: ");
            choice=getInt();
            switch(choice){
                case 1:
                    list.displayAll();
                    break;
                case 2:
                    list.firstEmployee();
                    break;
                case 3:
                    list.nextEmployee();
                    break;
                case 4:
                    list.previousEmployee();
                    break;
                case 5:
                    list.lastEmployee();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }while(choice!=6);
    }
    public static void sortMenu() throws IOException{
        int choice;
        do{
            System.out.println("\n===== SORT =====");
            System.out.println("1. All Managers");
            System.out.println("2. All Engineers");
            System.out.println("3. All Sales Person");
            System.out.println("4. All Employees Alphabetic Ascending");
            System.out.println("5. All Employees Alphabetic Descending");
            System.out.println("6. Exit to Main Menu");
            System.out.print("Enter your choice: ");
            choice=getInt();
            switch(choice){
                case 1:
                    list.displayManagers();
                    break;
                case 2:
                    list.displayEngineers();
                    break;
                case 3:
                    list.displaySalesPersons();
                    break;
                case 4:
                    list.sortAscending();
                    break;
                case 5:
                    list.sortDescending();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }while(choice!=6);
    }
    public static void main(String[] args) throws IOException{
        int choice;
        do{
            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add an Employee");
            System.out.println("2. Display");
            System.out.println("3. Sort");
            System.out.println("4. Save to File");
            System.out.println("5. Load from File");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice=getInt();
            switch(choice){
                case 1:
                    addEmployeeMenu();
                    break;
                case 2:
                    displayMenu();
                    break;
                case 3:
                    sortMenu();
                    break;
                case 4:
                    list.saveToFile();
                    break;
                case 5:
                    list.loadFromFile();
                    break;
                case 6:
                    System.out.println("Thank you for using Employee Management System.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }while(choice!=6);
    }
}
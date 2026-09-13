class ConsoleInput{
    public static String getString(){
        try{
            byte[] input=new byte[100];
            System.out.print("Enter value: ");
            int length=System.in.read(input);
            return new String(input,0,length).trim();
        }
        catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
class Employee{
    String name;
    int yearOfJoining;
    double salary;
    String address;
    public Employee(String name,int yearOfJoining,double salary,String address){
        this.name=name;
        this.yearOfJoining=yearOfJoining;
        this.salary=salary;
        this.address=address;
    }
    public void display(){
        System.out.println("Name: "+name);
        System.out.println("Year of joining: "+yearOfJoining);
        System.out.println("Salary: "+salary);
        System.out.println("Address: "+address);
    }
}
public class Question5{
    public static void main(String[] args){
        System.out.println("Enter salary of Robert:");
        double salary1=Double.parseDouble(ConsoleInput.getString());
        Employee e1=new Employee("Robert",1994,salary1,"64C-WallsStreat");

        System.out.println("Enter salary of Sam:");
        double salary2=Double.parseDouble(ConsoleInput.getString());
        Employee e2=new Employee("Sam",2000,salary2,"68D-WallsStreat");

        System.out.println("Enter salary of John:");
        double salary3=Double.parseDouble(ConsoleInput.getString());
        Employee e3=new Employee("John",1999,salary3,"26B-WallsStreat");

        e1.display();
        e2.display();
        e3.display();
    }
}
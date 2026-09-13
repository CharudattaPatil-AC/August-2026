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
    double salary;
    int hours;

    public void getInfo(double salary,int hours){
        this.salary=salary;
        this.hours=hours;
    }

    public void addSal(){
        if(salary<500){
            salary=salary+10;
        }
    }

    public void addWork(){
        if(hours>6){
            salary=salary+5;
        }
    }

    public void display(){
        System.out.println("Final Salary: "+salary);
    }
}
public class Question6{
    public static void main(String[] args){
        Employee e=new Employee();

        System.out.println("Enter salary:");
        double salary=Double.parseDouble(ConsoleInput.getString());

        System.out.println("Enter number of hours of work per day:");
        int hours=Integer.parseInt(ConsoleInput.getString());

        e.getInfo(salary,hours);
        e.addSal();
        e.addWork();
        e.display();
    }
}
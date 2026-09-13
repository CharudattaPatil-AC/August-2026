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
class Member{
    private String name;
    private int age;
    private String phoneNumber;
    private String address;
    private double salary;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public double getSalary(){
        return salary;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }
    public void printSalary(){
        System.out.println("Salary: "+salary);
    }
}
class PrimeMembers extends Member{
    private int joiningYear;
    private double joiningFees;
    private boolean isActive;
    public int getJoiningYear(){
        return joiningYear;
    }
    public void setJoiningYear(int joiningYear){
        this.joiningYear=joiningYear;
    }
    public double getJoiningFees(){
        return joiningFees;
    }
    public void setJoiningFees(double joiningFees){
        this.joiningFees=joiningFees;
    }
    public boolean getIsActive(){
        return isActive;
    }
    public void setIsActive(boolean isActive){
        this.isActive=isActive;
    }
    public void display(){
        System.out.println("Name: "+getName());
        System.out.println("Age: "+getAge());
        System.out.println("Phone Number: "+getPhoneNumber());
        System.out.println("Address: "+getAddress());
        System.out.println("Salary: "+getSalary());
        System.out.println("Joining Year: "+getJoiningYear());
        System.out.println("Joining Fees: "+getJoiningFees());
        System.out.println("Active: "+getIsActive());
    }
}
public class Question2{
    public static void main(String[] args){
        PrimeMembers member=new PrimeMembers();
        System.out.println("Enter Name:");
        member.setName(ConsoleInput.getString());
        System.out.println("Enter Age:");
        member.setAge(Integer.parseInt(ConsoleInput.getString()));
        System.out.println("Enter Phone Number:");
        member.setPhoneNumber(ConsoleInput.getString());
        System.out.println("Enter Address:");
        member.setAddress(ConsoleInput.getString());
        System.out.println("Enter Salary:");
        member.setSalary(Double.parseDouble(ConsoleInput.getString()));
        System.out.println("Enter Joining Year:");
        member.setJoiningYear(Integer.parseInt(ConsoleInput.getString()));
        System.out.println("Enter Joining Fees:");
        member.setJoiningFees(Double.parseDouble(ConsoleInput.getString()));
        System.out.println("Enter Is Active:");
        member.setIsActive(Boolean.parseBoolean(ConsoleInput.getString()));
        member.display();
        member.printSalary();
    }
}
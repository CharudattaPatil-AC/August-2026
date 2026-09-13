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
class Student{
    String name;
    int roll_no;
    String phone_no;
    String address;
}
public class Question1{
    public static void main(String[] args){
        Student s1=new Student();
        s1.roll_no=2;
        s1.name="John";

        Student s2=new Student();
        s2.name="Sam";

        System.out.println("Enter Roll No for Sam:");
        s2.roll_no=Integer.parseInt(ConsoleInput.getString());
        System.out.println("Enter Phone No for Sam:");
        s2.phone_no=ConsoleInput.getString();
        System.out.println("Enter Address for Sam:");
        s2.address=ConsoleInput.getString();

        Student s3=new Student();
        s3.name="John";

        System.out.println("Enter Roll No for John:");
        s3.roll_no=Integer.parseInt(ConsoleInput.getString());
        System.out.println("Enter Phone No for John:");
        s3.phone_no=ConsoleInput.getString();
        System.out.println("Enter Address for John:");
        s3.address=ConsoleInput.getString();

        System.out.println("Student 1:");
        System.out.println("Name: "+s1.name);
        System.out.println("Roll No: "+s1.roll_no);

        System.out.println("Student 2:");
        System.out.println("Name: "+s2.name);
        System.out.println("Roll No: "+s2.roll_no);
        System.out.println("Phone No: "+s2.phone_no);
        System.out.println("Address: "+s2.address);

        System.out.println("Student 3:");
        System.out.println("Name: "+s3.name);
        System.out.println("Roll No: "+s3.roll_no);
        System.out.println("Phone No: "+s3.phone_no);
        System.out.println("Address: "+s3.address);
    }
}
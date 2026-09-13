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
class Parent{
    public void display(){
        System.out.println("This is parent class");
    }
}
class Child extends Parent{
    public void show(){
        System.out.println("This is child class");
    }
}
public class Question1{
    public static void main(String[] args){
        Parent p=new Parent();
        Child c=new Child();
        p.display();
        c.show();
        c.display();
    }
}
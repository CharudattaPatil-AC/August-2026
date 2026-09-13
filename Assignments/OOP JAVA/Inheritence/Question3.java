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
class Rectangle{
    private double length;
    private double breadth;
    public Rectangle(double length,double breadth){
        this.length=length;
        this.breadth=breadth;
    }
    public void area(){
        System.out.println("Area of Rectangle: "+(length*breadth));
    }
    public void perimeter(){
        System.out.println("Perimeter of Rectangle: "+(2*(length+breadth)));
    }
}
class Square extends Rectangle{
    private double side;
    public Square(double side){
        super(side,side);
        this.side=side;
    }
    public void squareArea(){
        System.out.println("Area of Square: "+(side*side));
    }
    public void squarePerimeter(){
        System.out.println("Perimeter of Square: "+(4*side));
    }
}
public class Question3{
    public static void main(String[] args){
        System.out.println("Enter Length of Rectangle:");
        double length=Double.parseDouble(ConsoleInput.getString());
        System.out.println("Enter Breadth of Rectangle:");
        double breadth=Double.parseDouble(ConsoleInput.getString());
        Rectangle rectangle=new Rectangle(length,breadth);
        System.out.println("Rectangle Details:");
        rectangle.area();
        rectangle.perimeter();
        System.out.println("Enter Side of Square:");
        double side=Double.parseDouble(ConsoleInput.getString());
        Square square=new Square(side);
        System.out.println("Square Details:");
        square.squareArea();
        square.squarePerimeter();
    }
}
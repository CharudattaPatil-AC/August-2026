class Rectangle{
    double length;
    double breadth;
    public Rectangle(double length,double breadth){
        this.length=length;
        this.breadth=breadth;
    }
    public double area(){
        return length*breadth;
    }
}
public class Question3{
    public static void main(String[] args){
        Rectangle r1=new Rectangle(4,5);
        Rectangle r2=new Rectangle(5,8);
        System.out.println("Area of Rectangle 1: "+r1.area());
        System.out.println("Area of Rectangle 2: "+r2.area());
    }
}
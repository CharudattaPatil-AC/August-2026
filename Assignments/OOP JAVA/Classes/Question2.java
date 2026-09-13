class Triangle{
    double side1;
    double side2;
    double side3;
    public Triangle(double side1,double side2,double side3){
        this.side1=side1;
        this.side2=side2;
        this.side3=side3;
    }
    public double perimeter(){
        return side1+side2+side3;
    }
    public double area(){
        double s=perimeter()/2;
        return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
    }
}
public class Question2{
    public static void main(String[] args){
        Triangle t=new Triangle(3,4,5);
        System.out.println("Area of Triangle: "+t.area());
        System.out.println("Perimeter of Triangle: "+t.perimeter());
    }
}
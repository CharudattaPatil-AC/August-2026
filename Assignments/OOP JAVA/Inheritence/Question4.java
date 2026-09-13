class Shape{
    public void displayShape(){
        System.out.println("This is shape");
    }
}
class Rectangle extends Shape{
    public void displayRectangle(){
        System.out.println("This is rectangular shape");
    }
}
class Circle extends Shape{
    public void displayCircle(){
        System.out.println("This is circular shape");
    }
}
class Square extends Rectangle{
    public void displaySquare(){
        System.out.println("Square is a rectangle");
    }
}
public class Question4{
    public static void main(String[] args){
        Square s=new Square();
        s.displayShape();
        s.displayRectangle();
        s.displaySquare();
    }
}
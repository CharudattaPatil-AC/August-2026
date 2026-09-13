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
class Complex{
    int real;
    int imaginary;
    public Complex(int real,int imaginary){
        this.real=real;
        this.imaginary=imaginary;
    }
    public void sum(Complex c){
        System.out.println("Sum: "+(real+c.real)+" + "+(imaginary+c.imaginary)+"i");
    }
    public void difference(Complex c){
        System.out.println("Difference: "+(real-c.real)+" + "+(imaginary-c.imaginary)+"i");
    }
    public void product(Complex c){
        int realPart=(real*c.real)-(imaginary*c.imaginary);
        int imaginaryPart=(real*c.imaginary)+(imaginary*c.real);
        System.out.println("Product: "+realPart+" + "+imaginaryPart+"i");
    }
}
public class Question4{
    public static void main(String[] args){
        System.out.println("Enter real part of first complex number:");
        int real1=Integer.parseInt(ConsoleInput.getString());
        System.out.println("Enter imaginary part of first complex number:");
        int imaginary1=Integer.parseInt(ConsoleInput.getString());
        System.out.println("Enter real part of second complex number:");
        int real2=Integer.parseInt(ConsoleInput.getString());
        System.out.println("Enter imaginary part of second complex number:");
        int imaginary2=Integer.parseInt(ConsoleInput.getString());
        Complex c1=new Complex(real1,imaginary1);
        Complex c2=new Complex(real2,imaginary2);
        c1.sum(c2);
        c1.difference(c2);
        c1.product(c2);
    }
}
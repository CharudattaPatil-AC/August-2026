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
public class Question6{
    public static void main(String[] args){
        System.out.println("Enter size of array:");
        int size=Integer.parseInt(ConsoleInput.getString());
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            System.out.println("Enter element "+(i+1)+":");
            arr[i]=Integer.parseInt(ConsoleInput.getString());
        }
        int max=arr[0];
        int min=arr[0];
        for(int i=1;i<size;i++){
            if(arr[i]>max){
                max=arr[i];
            }
            if(arr[i]<min){
                min=arr[i];
            }
        }
        System.out.println("Maximum value: "+max);
        System.out.println("Minimum value: "+min);
    }
}
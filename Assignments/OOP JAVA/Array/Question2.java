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
public class Question2{
    public static void main(String[] args){
        System.out.println("Enter size of array:");
        int size=Integer.parseInt(ConsoleInput.getString());
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            System.out.println("Enter element "+(i+1)+":");
            arr[i]=Integer.parseInt(ConsoleInput.getString());
        }
        for(int i=0;i<size-1;i++){
            for(int j=0;j<size-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        System.out.println("Sorted array:");
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
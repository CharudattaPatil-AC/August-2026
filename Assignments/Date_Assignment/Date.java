class ConsoleInput {

    public static String getString() {

        try {

            byte[] input = new byte[100];

            System.out.print("Enter value: ");

            int length = System.in.read(input);

            return new String(input, 0, length).trim();

        } catch (Exception ex) {

            ex.printStackTrace();

            return null;
        }
    }

    public static int getInt() {

        return Integer.parseInt(getString());
    }

    public static float getFloat() {

        return Float.parseFloat(getString());
    }

    public static double getDouble() {

        return Double.parseDouble(getString());
    }
}


class Date{
    private int day;
    private int month;
    private int year;
    public void setdate(int dd, int mm, int yy){
        year=yy;
        if(mm<1 || mm>12){
            month=1;
        } else{
            month=mm;
        }  
        if (month==1|| month==3|| month==5|| month==7|| month==8|| month==10|| month==12){
            if(day<1||day>31){
                day=1;
            }else {
                day=dd;
            }

        } else if(month==4||month==6||month==9||month==11){
            if(day<1||day>30){
                day=1;
            }else{
                day=dd;
            }
        }
        if(month==2){
            if((year%4==0 && year%100!=0)||(year%400==0)){
                if(day<1||day>29){
                    day=1;
                }else {
                    day=dd;
                }
            }else{
                if(day<1||day>28){
                    day=1;
                }else{
                    day=dd;
                }
                
            
            }
        }


    }

    public void addDays(int days){
        while(days>0){
            day++;
            int maxDays=0;
            if (month==1|| month==3|| month==5|| month==7|| month==8|| month==10|| month==12){
                maxDays=31;
            }else if(month==4||month==6||month==9||month==11){
                maxDays=30;
            }else{
                if(year%400==0||year%4==0 && year%100!=0){
                    maxDays=28;
                }
            }
            if(day>maxDays){
                day=1;
                month++;
                if(month>12){
                    month=1;
                    year++;
                }
            }
            days--;
        }

    }
    public void addMonths(int months) { 
        while (months > 0) { 
            month++; 
            if (month > 12) 
                month = 1; 
                year++; 
            
            months--; 
        }
    }
    public void addYears(int years) { 
        year = year + years; 
        if (month == 2 && day == 29) 
            if (!(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))  
                day = 28; 
                
            
    }

    public int getDay()
    {
        return day;
    }
    
    public int getMonth(){
        return month;
    }
     public int getYear(){
        return year;
    }
    public void display() { 
        System.out.println( "Date: " + day + "/" + month + "/" + year ); 
    }


    public static void main(String args[]){
        Date date=new Date();
        int choice;
        do{
            System.out.println("\n========== DATE MENU ==========");
            System.out.println("1. Set Date");
            System.out.println("2. Add Days");
            System.out.println("3. Add Months");
            System.out.println("4. Add Years");
            System.out.println("5. Compare Dates");
            System.out.println("6. Exit");
            System.out.println("===============================");
            
            choice=ConsoleInput.getInt();
            switch(choice){
                case 1:
                System.out.println("\nEnter Date");
                System.out.println("\nEnter Day: ");
                int day=ConsoleInput.getInt();
                System.out.println("Enter Month: ");
                int month=ConsoleInput.getInt();
                System.out.println("Enter Year: ");
                int year=ConsoleInput.getInt();
                date.setdate(day,month,year);
                System.out.println("Date set successfully.");
                date.display();
                break;
                case 2:
                    System.out.print("Enter number of days to add: ");
                    int days = ConsoleInput.getInt();
                    date.addDays(days);
                    System.out.println("Date after adding days:");
                    date.display();
                    break;
                case 3:
                    System.out.print("Enter number of months to add: ");
                    int months = ConsoleInput.getInt();
                    date.addMonths(months);
                    System.out.println("Date after adding months:");
                    date.display();
                    break;
                case 4:
                    System.out.print("Enter number of years to add: ");
                    int years = ConsoleInput.getInt();
                    date.addYears(years);
                    System.out.println("Date after adding years:");
                    date.display();
                    break;
                case 5:
                    System.out.println("Compare Dates");
                    System.out.println("Compare Dates is not implemented.");
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }while (choice != 6);
    }
}
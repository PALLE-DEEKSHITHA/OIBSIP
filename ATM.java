import java.util.*;
class BankAccount {
    String name;
    String username;
    String password;
    String accno;
    float balance=10000f;
    int transaction=0;
    String histroy="";

    public void register(){
        Scanner s=new Scanner(System.in);
        System.out.print("\nEnter Your Name - ");
        this.name=s.nextLine();
        System.out.print("\nEnter Your Username -");
        this.username=s.nextLine();
        System.out.print("\nEnter Your Password -");
        this.password=s.nextLine();
        System.out.print("\nEnter Your Account Number -");
        this.accno=s.nextLine();
        System.out.println("\nRegistration completed..kindly login");
    }
    public boolean login(){
        boolean islogin=false;
        Scanner sc=new Scanner(System.in);
        while(!islogin){
            System.out.print("\nEnter Your User Name -");
            String username=sc.nextLine();
            if(username.equals(username)){
                while(!islogin){
                    System.out.println("Enter your password-");
                    String Password=sc.nextLine();
                    if(Password.equals(password)){
                    System.out.println("Login Successful!!");
                     islogin=true;
                    }
                    else{
                     System.out.println("Incorrect Password");
                    }        
                }
            }
            else{
                System.out.println("User name not found");
            }
        }
       return islogin;
    }
    public void withdraw(){
        System.out.println("Enter amount to withdraw -");
        Scanner sa=new Scanner(System.in);
        float amount=sa.nextFloat();
        try{
            if(balance>=amount){
                transaction++;
                balance-=amount;
                System.out.println("\nWithdraw Successfully");
                String str=amount+"Rs Withdrawed";
                histroy=histroy.concat(str);
            }
            else{
                System.out.println("Insufficient Balance");
            }
        }
        catch(Exception e){
        }
    }
    public void deposit()
    {
        System.out.print("\nEnter amount to deposit -");
        Scanner sc=new Scanner(System.in);
        float amount=sc.nextFloat();
        try{
            if(amount<=100000f){
                transaction++;
                balance+=amount;
                System.out.println("Successfully Deposited");
                String str=amount+"Rs Deposited";
                histroy=histroy.concat(str);
            }  
        else{
        System.out.println("Sorry limit is 100000.00 ");
        }  
        }
        catch(Exception e){
        }
    }
    public void transfer()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Receipents name -");
        String receipent=sc.nextLine();
        System.out.println("Enter amount to transfer");
        float amount=sc.nextFloat();
        try{
            if(balance>=amount){
                if(amount<=50000f){
                    transaction++;
                    balance-=amount;
                    System.out.println("Successfully Transfered to"+receipent);
                    String str=amount+"Rs transfered to "+receipent;
                    histroy=histroy.concat(str);                }
            }
            else{
                System.out.println("Sorry limit is 50000");
            }
        }
        catch(Exception e){
    }
    }
        public void balance()
     {
       System.out.println(balance+" Rs");
     }
        public void history()
     {
          if(transaction==0)
        {
        System.out.println("Empty");
        }
           else{
        System.out.println(histroy);
        }
     }
}
public class ATM{
    public static int takeIntegerInput(int limit){
        int input=0;
        boolean flag=false;
        while(!flag){
            try{
                Scanner sc=new Scanner(System.in);
                input=sc.nextInt();
                flag=true;
                if(flag&&input>limit||input<1){
                    System.out.println("Choose the number between 1 to "+limit);
                    flag=false;
                }
            }
            catch(Exception e){
                System.out.println("Enter any integer value");
                flag=false;
            }
        };
      return input; 
    }
    public static void main(String args[]){
        System.out.println("Welcome to atm system");
        System.out.println("1.Register\n2.Exit");
        System.out.println("Enter Your Choice -");
        int choice=takeIntegerInput(2);
    if(choice==1){
        BankAccount b=new BankAccount();
        b.register();
        while(true){
            System.out.println("1.Login\n2.Exit");
            System.out.println("Enter your choice -");
            int ch=takeIntegerInput(2);
            if(ch==1){
                if(b.login()){
                    System.out.println("***welcome back "+b.name+"***");
                    boolean isFinished=false;
                    while(!isFinished){
                        System.out.println("1.withdraw\n2.deposit\n3.transfer\n4.check balance\n5.transaction history\n6.Exit");
                        System.out.println("\nEnter your choice -");
                        int c=takeIntegerInput(6);
                        switch(c){
                            case 1:
                            b.withdraw();
                            break;
                            case 2:
                            b.deposit();
                            break;
                            case 3:
                            b.transfer();
                            break;
                            case 4:
                            b.balance();
                            break;
                            case 5:
                            b.history();
                            break;
                            case 6:
                            isFinished=true;
                            break;
                        }
                    }
                }
            }
            else{
                System.exit(0);
            }
        }   
    }  
}  
}
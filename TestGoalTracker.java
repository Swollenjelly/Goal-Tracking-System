import java.util.Scanner;

abstract class GT
{
    abstract void display();
}

class GoalTracker extends GT
{
    String name;
    int ngoals;
    String[] A;
    
    GoalTracker()
    {
        name="";
        ngoals=0;
        String[] A=new String[ngoals];
    }
    
    GoalTracker(String name, int ngoals)
    {
        this.name=name;
        this.ngoals=ngoals;
        
    }
    
    void display()
    {
        System.out.println();
        System.out.println();
        System.out.println("Name : "+name+"   Number of Goals : "+ngoals);
    }
        
}

class GoalMap extends GoalTracker
{

    void Goals(int ngoals, String[] A)
    {
        int i;
        System.out.println();
        System.out.println();
        System.out.println("So this is how your Goal Map will look : ");
        System.out.println();
        for(i=0;i<ngoals;i++)
        {
            System.out.print(A[i]+"~~~~~~~>");
        }
        System.out.println("YOU MADE IT!");
    }
    
    void progress(int k, int ngoals)
    {
        int t=ngoals-k;
        
        System.out.println("Impressive! C'mon now keep going, don't stop, just "+t+" goals to go!");
        
    }
    void progress()
    {
        System.out.println();
        System.out.println("Congratulations! You have reached your desired goal, what could be better than that!");
    }    
    
    void newGoalMap(int k, int ngoals, String[] A)
    {
        int i;
        System.out.println();
        System.out.println();
        System.out.println("This is your old ID : ");
        super.display();
        
        System.out.println();
        System.out.println("Your new and improved ID  : ");
        System.out.println();
        
        int t=ngoals-k;
        System.out.println("Name : "+name+"   Number of Goals : "+t);
        System.out.println();
        System.out.println();
        System.out.println("Your new and improved Goal Map is as follows : ");
        System.out.println();
        
        for(i=k;i<ngoals;i++)
        {
            System.out.print(A[i]+"~~~~~~~>");
        }
        System.out.println("YOU MADE IT!");
        System.out.println();
        System.out.println();
        System.out.println("Please do come back to update us on your progress!");    
    }
}
public class TestGoalTracker
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to The Goal Tracker! It will do exactly what the title says : Track Your Goals, because how easy would life be if you knew your next step!");
        System.out.println();
        System.out.println();
        System.out.println("Step 1: List your goals and then follow it! That's right, that's all it takes to get your life in order, A SINGLE STEP!");
        System.out.println();
        System.out.println();
        System.out.println("So let's begin!");
        System.out.println("Could you please tell us your good name? : ");
        String name=sc.nextLine();
        System.out.println("Kindly enter your number of goals : ");
        int n=sc.nextInt();
        if(n==0)
        {
            throw new ArithmeticException("Get some Goals in life *_*");
        }
        String[] A=new String[n];
        System.out.println("Briefly enter your goals in one word : ");
        int i;
        for(i=0;i<n;i++)
        {
            A[i]=sc.next();
        }
        
        GoalTracker ob=new GoalTracker();
        GoalTracker obj1=new GoalTracker(name,n);
        obj1.display();
        GoalMap obj=new GoalMap();
        obj.Goals(n,A);
        
        System.out.println();

        
        int c;
        System.out.println("Have you made any progress on these goals? 1/0 : ");
        c=sc.nextInt();
        if(c==1)
        {
            int k;
            System.out.println("AMAZING! How many goals did you complete?");
            k=sc.nextInt();
            if(k==n)
            {
                obj.progress();
            }
            else if(k==(n-1))
            {
                int t=n-k;
                System.out.println("Impressive! C'mon now keep going, don't stop, just "+t+" goals to go!");
                System.out.println("This is your old ID : ");
                System.out.println("Name : "+name+"   Number of Goals : "+n);
                System.out.println();
                System.out.println("Your new and improved ID  : ");
                System.out.println();
    
                System.out.println("Name : "+name+"   Number of Goals : "+t);
                System.out.println();
                System.out.println();
                System.out.println("Your new and improved Goal Map is as follows : ");
                System.out.println();
        
                for(i=k;i<n;i++)
                {
                    System.out.print(A[i]+"~~~~~~~>");
                }
                System.out.println("YOU MADE IT!");
                System.out.println();
                System.out.println();
                System.out.println("Please do come back to update us on your progress!");
            }
                
            else
            {
                obj.progress(k,n);
                obj.newGoalMap(k,n,A);
            }
        }
        else
        {
            System.out.println("It's okay, go step by step, YOU CAN DO IT!");
            System.out.println("Hope to see you soon here with your updates!");
        }
        
    }
}
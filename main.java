/*Confidential Carriage System 
 * An application intended to enhance security of the vehicles on road by randomizing their path*/

//declarations

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

//calling main class
//declaration of variables
public class main { 
public static int chpts;
static int outnum,i;
static int check=0;
static int a[]=new int[50];
static String name[][]=new String[100][100], name2;
static String checkpointname[]=new String[50], destination, source;

/*randomize algorithm implemented*/
public static int randomize(int a)
{	
	PointerInfo a1 = MouseInfo.getPointerInfo(); //Fetching mouse pointer location
	Point b = a1.getLocation();
	int x = (int) b.getX();
	int y = (int) b.getY();
	
	int year = Calendar.getInstance().get(Calendar.YEAR); //fetch year
	
	java.util.Date date= new Date(); //fetch month
	Calendar cal = Calendar.getInstance();
	cal.setTime(date);
	int month = cal.get(Calendar.MONTH);

    int cores = Runtime.getRuntime().availableProcessors(); //fetch no. of cores
    
    long memory = Runtime.getRuntime().freeMemory(); //fetch free memory
 
    int sum = (int) (a + x + y + year + month + cores + memory);
    //System.out.println(a);
    int mod = sum % a;
    return mod;
    //System.out.println(sum);
}

/*waiting for the user to reach the checkpoint*/
private static void pressAnyKeyToContinue()
{ 
       System.out.println("As soon as you reach checkpoint, Press Enter to continue...");
       try
       {
           System.in.read();
       }  
       catch(Exception e)
       {}  
}

/*fetch the randomized routes and show the names of checkpoints*/
public static void displayroute(int c, int a)
		{
			int b = a + 1;
			System.out.println("The route needs to be taken to reach checkpoint "+checkpointname[c]+" is : " +name[c][b]);
//			System.out.println("As soon as you reach checkpoint, press enter");
			pressAnyKeyToContinue();
		}
		
		

	public static void main(String[] args) {
		
		System.out.println("Enter the source and Destination Location");
		System.out.print("Source:-");
		Scanner sc = new Scanner(System.in);
		String source = sc.next();
		System.out.print("Destination:-");
		String destination = sc.next();
		System.out.println("Enter the number of Checkpoints on the way");
		chpts = sc.nextInt();
		
		for (int i=1; i<=chpts; i++)
		{
			System.out.println("Enter the name of Checkpoint "+i);
			checkpointname[i] = sc.next();
		}
		
		for (int i=1; i<=chpts; i++)
		{
			System.out.println("Enter the number of paths leading to checkpoint named "+checkpointname[i]);
			a[i] = sc.nextInt();
		}
		
		/*fetching the names of paths for checkpoints*/
		for (int i=1; i<=chpts; i++)
		{
			for (int j=1; j<=a[i]; j++)
			{
				System.out.println("Enter the name of path "+j+" leading to Checkpoint named "+checkpointname[i]);
				name2=sc.next();
				name[i][j]=name2;
			}
		}
		
		/*calling the randomized function to randomize the checkpoints*/
		for (int i=1; i<=chpts; i++)
		{
			int number = a[i];
			int out1 = randomize(number);
//			while (out1 ==0)
//			{
//				out1 = randomize(number);
//			}
			/*calling display fucntion to display randomized routes*/
			displayroute(i,out1);
			//System.out.println("To reach checkpoint "+i+", take path number"+out1 );
			//System.out.println("As soon as you reach checkpoint "+i+", enter ok");
			
			
					
		}
		System.out.println("You have reached " +destination+" from "+source+". Good Luck.");
		
		
	} 
	}



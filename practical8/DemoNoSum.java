class Sum1 extends Thread
{
	String threadnm;
	private Thread t;
	public static long total=0;
	public Sum1(String nm)
	{
		threadnm=nm;
	}
	public void run()
	{
		System.out.println("Current Thread = "+threadnm);
		for(int i=1;i<=10000;i++)
		{
			total=total+i;
		}
		System.out.println("Total1 = "+Sum1.total);
		System.out.println("Thread " +  threadnm + " *** Exiting ***.");
	}
	public void start ()
	{
      System.out.println("Starting " +  threadnm);
      if (t == null) {
         t = new Thread (this, threadnm);
         t.start();
         }
	}
}
class Sum2 extends Thread
{
	String threadnm;
	private Thread t;
	public static long total=0;
	public Sum2(String nm)
	{
		threadnm=nm;
	}
	public void run()
	{
		System.out.println("Current Thread = "+threadnm);
		for(long i=10001;i<=20000;i++)
		{
			total=total+i;
		}
		System.out.println("Total2 = "+Sum2.total);
		System.out.println("Thread " +  threadnm + " *** Exiting ***.");
	}
	public void start ()
	{
      System.out.println("Starting " +  threadnm);
      if (t == null) {
         t = new Thread (this, threadnm);
         t.start();
         }
	}
}
class Sum3 extends Thread
{
	String threadnm;
	private Thread t;
	public static long total=0;
	public Sum3(String nm)
	{
		threadnm=nm;
	}
	public void run()
	{
		System.out.println("Current Thread = "+threadnm);
		for(long i=20001;i<=30000;i++)
		{
			total=total+i;
		}
		System.out.println("Total3 = "+Sum3.total);
		System.out.println("Thread " +  threadnm + " *** Exiting ***.");
	}
	public void start ()
	{
      System.out.println("Starting " +  threadnm);
      if (t == null) {
         t = new Thread (this, threadnm);
         t.start();
         }
	}
}
public class DemoNoSum
{
		public static void main(String a[])
		{
			Sum1 s1=new Sum1("sum1");
			s1.start();
			Sum2 s2=new Sum2("sum2");
			s2.start();
			Sum3 s3=new Sum3("sum3");
			s3.start();
		 	try
		    {
		    	s1.join();
				s2.join();
				s3.join();
				Thread t=Thread.currentThread();
				s3.setPriority(Thread.MIN_PRIORITY);
        	}
        	catch(Exception e)
        	{
				System.out.println(e);
			}
			System.out.println("---> Total = "+(s1.total+s2.total+s3.total));
			System.out.println("**** Ending main ****");
		}
}
class Thread1 extends Thread
{
	String threadnm;
	private Thread t;
	public Thread1(String nm)
	{
		threadnm=nm;
	}
	public void run()
	{
		System.out.println("Current Thread = "+threadnm);
		try
		{
			for(int i=1;i<=5;i++)
			{
				System.out.println("Thread : "+threadnm+" = "+i);
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException e)
		{
			System.out.println("Thread " +  threadnm + " interrupted.");
		}
		System.out.println("Thread " +  threadnm + " *** Exiting ***.");
	}
	public void start ()
	{
      System.out.println("Starting " +  threadnm);
      if (t == null) {
         System.out.println("--> Before start = "+Thread.currentThread().isAlive());
         t = new Thread (this, threadnm);
         t.start ();
      	 System.out.println(t.getName() +" is a member of " + t.getThreadGroup().getName());
         System.out.println("--> After start = "+Thread.currentThread().isAlive());
      }
	}
}
class Thread2 extends Thread
{
	String threadnm;
	private Thread t;
		public Thread2(String nm)
		{
			threadnm=nm;
		}
		public void run()
		{
			System.out.println("Current Thread = "+threadnm);
			/*for(int i=1;i<=6;i++)
			{
					System.out.println("Thread : "+threadnm+" = "+i);
			}*/
			try
			{
				for(int i=1;i<=6;i++)
				{
					System.out.println("Thread : "+threadnm+" = "+i);
					Thread.sleep(2000);
				}
			}
			catch(InterruptedException e)
			{
				System.out.println("Thread " +  threadnm + " interrupted.");
			}
			System.out.println("Thread " +  threadnm + " *** Exiting ***.");
		}
		public void start ()
		{
	      System.out.println("Starting " +  threadnm );
	      if (t == null) {
			 System.out.println("--> Before start = "+Thread.currentThread().isAlive());
			 t = new Thread (this, threadnm);
			 t.start ();
			 System.out.println(t.getName() +" is a member of " + t.getThreadGroup().getName());
			 System.out.println("--> After start = "+Thread.currentThread().isAlive());
	     }
   }
}
class Thread3 extends Thread
{
	String threadnm;
	 private Thread t;
		public Thread3(String nm)
		{
			threadnm=nm;
		}
		public void run()
		{
			System.out.println("Current Thread = "+threadnm);
			/*for(int i=1;i<=7;i++)
			{
					System.out.println("Thread 3 : "+threadnm+" = "+i);
			}*/

			try
			{
				for(int i=1;i<=7;i++)
				{
					System.out.println("Thread : "+threadnm+" = "+i);
					Thread.sleep(3000);
				}
			}
			catch(InterruptedException e)
			{
				System.out.println("Thread " +  threadnm + " interrupted.");
			}
			System.out.println("Thread " +  threadnm + " *** Exiting ***.");
		}
		public void start ()
		{
    	  System.out.println("Starting " +  threadnm );
    	  if (t == null)
    	  {
	         System.out.println("--> Before start = "+Thread.currentThread().isAlive());
         t = new Thread (this, threadnm);
         t.start ();
      	 System.out.println(t.getName() +" is a member of " + t.getThreadGroup().getName());
         System.out.println("--> After start = "+Thread.currentThread().isAlive());
      		}
	}
}
public class DemoMultiThread
{
	public static void main(String args[])
	{
		Thread1 t1=new Thread1("T1");
		Thread2 t2=new Thread2("T2");
		Thread3 t3=new Thread3("T3");

		t3.setPriority(Thread.MAX_PRIORITY);

		System.out.println("Priority of T1 = "+t1.getPriority());
		System.out.println("Priority of T2 = "+t2.getPriority());
		System.out.println("Priority of T3 = "+t3.getPriority());


		t1.start();
		t2.start();
		t3.start();
		/*try
		{
			Thread t=Thread.currentThread();
			t.sleep(1000);
		}
		catch(InterruptedException e)
		{
			System.out.println("Thread main interrupted.");
		}*/
		System.out.println("Main is exiting....");
	}
}
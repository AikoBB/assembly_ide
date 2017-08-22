
public class Main {
public static void main(String []args)
{
	//UserInterface project=new UserInterface();
	//project.pack();
	//project.setVisible(true);
	/*int result=0;
	  int i=0;
	   int x=5,y=10;
	   while(i<y)
	   {
	     result=result+x;
	     i=i+1;
	   }
	System.out.println(result);  */
	int  sum1=0,sum2=0;
	for(int i=1,j=1000  ;i<j;i++,j--)
	{
		
			if(i%5==0 || i%3==0)
				{
				sum1+=i*2;
				}
			else {
				sum1+=i;
			}
			if(j%5==0 || j%3==0)
			{
			sum2+=j*2;
			}
			else {
				sum2+=j;
			}
	   
		
		
	}
	System.out.println((sum1+sum2));
}


}

import java.util.*;
class trimorphic
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("ENTER A NUMBER:");
		int n=sc.nextInt();
		int s=n;int k=0;
		while(s!=0)
		{
			int d=s%10;
			k++;
			s=s/10;
		}
		int t=n*n*n;
		int x=(int)Math.pow(10,k);
		int d=t%x;
		if(d==n)
		System.out.println("TRIMORPHIC NUMBER");
	else
		System.out.println("NOT A TRIMORPHIC NUMBER");
	}
}
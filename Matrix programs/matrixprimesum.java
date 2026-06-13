import java.util.*;
class matrixprimesum
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("M=");
		int m=sc.nextInt();
		System.out.print("N=");
		int n=sc.nextInt();
		int A[][]=new int[m][n];
		if(m<2||m>10||n<2||n>10)
		{
			System.out.println("Invalid Input");
			return;
		}
		System.out.print("Array Elements:");
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				A[i][j]=sc.nextInt();
			}
		}
		System.out.println("ORIGINAL ARRAY:");
		String Ir="";String Ic="";int maxSumR=0;int maxSumC=0;
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(A[i][j]+"\t");
			}
			System.out.println();
		}
		int s=0;
		for(int i=0;i<m;i++)
		{
			s=0;
			for(int j=0;j<n;j++)
			{
				if(isPrime(A[i][j]))
					s+=A[i][j];
			}
			if(maxSumR<s)
			{
				maxSumR=s;
				Ir=i+"";
			}
			else if(maxSumR==s)
			Ir+=" "+i;
		}
		if(maxSumR==0)
			System.out.print("Row with max prime-Sum:  NONE ");
			else
			System.out.println("Row with max prime-Sum:"+Ir+"(sum="+maxSumR+")");
	int c=0;
		for(int i=0;i<m;i++)
		{
			c=0;
			for(int j=0;j<n;j++)
			{
				if(isPrime(A[j][i]))
			c+=A[j][i];
			}
			if(maxSumC<c)
			{
				maxSumC=c;
				Ic=i+"";
			}
			else if(maxSumC==c)
			Ic+=" "+i;
		}
		if(maxSumC==0)
			System.out.print("Column with max prime-Sum:  NONE ");
			else
			System.out.print("Column with max prime-Sum:"+Ic+"(sum="+maxSumC+")");
	}
	public static boolean isPrime(int n)
	{
		int k=0;
		for(int i=1;i<=n;i++)
		{
			if(n%i==0)
				k++;
		}
		if(k==2)
			return true;
		else 
			return false;
	}
}
				
		
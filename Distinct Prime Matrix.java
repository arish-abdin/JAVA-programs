import java.util.*;
class dpd
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("m=");
        int m=sc.nextInt();
        System.out.print("n=");
        int n=sc.nextInt();
        if(m>n)
        {
            System.out.println("INVALID INPUT");
            return;
        }
        int k=0;boolean first=true;
        System.out.println("THE DISTICT PRIME DIGIT NUMBERS ARE:");
        for(int i=m;i<=n;i++)
        {
            char ch;
            String s=Integer.toString(i);
            if((ch=s.charAt(0))=='0')
            {
                continue;
            }
            boolean flag1=false;
            for(int a=0;a<s.length();a++)
            {
                char c=s.charAt(a);
                if(flag1==true)
                break;
                for(int b=a+1;b<s.length();b++)
                {
                    char h=s.charAt(b);
                    if(c==h){
                        flag1=true;
                        break;
                    }
                }
            }
            if(flag1==true)
            continue;
            boolean flag2=false;
            for(int j=0;j<s.length();j++)
            {
                char digit=s.charAt(j);
                if(digit!='2'&&digit!='3'&&digit!='5'&&digit!='7')
                {
                flag2=true;
                break;
                }
            }
            if(flag2==true)
            continue;
            if(first){
            System.out.print(i);
            first=false;
            }
            else
            System.out.print(","+i);
            k++;
        }
        System.out.println();
        System.out.print("FREQUENCY OF DISTINCT PRIME DIGITS ARE:"+k);
    }
}
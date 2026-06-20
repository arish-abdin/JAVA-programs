import java.io.*;
import java.util.*;
class Main
{
    public static void main(String args[])
    {
    Scanner sc=new Scanner(System.in);
    boolean running=true;
    StudentManager manage=new StudentManager();
    while(running)
    {
        System.out.println("-------------------");
        System.out.println("1.ADD STUDENT");
        System.out.println("2.DISPLAY STUDENT");
        System.out.println("3.SEARCH STUDENT");
        System.out.println("4.DELETE STUDENT");
        System.out.println("5.EXIT");
        System.out.println("-------------------");
        System.out.print("YOUR CHOICE:");
        int choose=sc.nextInt();
        System.out.println();
        if(choose>5||choose<1)
        {
            System.out.println(":INVALID INPUT:");
            continue;
        }
        switch(choose)
        {
            case 1:
                manage.addstudent();
                break;
               case 2:
                    manage.displaystudent();
                    break;
                    case 3:
                        manage.searchstudent();
                        break;
                        case 4:
                            manage.deletestudent();
                            break;
                            case 5:
                                running=false;
                                break;
        }
        System.out.println();
        }
    }
}
class StudentManager
{   
    Scanner sc = new Scanner(System.in);
   void addstudent()
    {
        System.out.print("ENTER THE NAME OF THE STUDENT:");
       String name=sc.nextLine();
        System.out.print("ENTER THE ROLL NUMBER OF THE STUDENT:");
       String rollno=sc.nextLine();
        System.out.print("ENTER THE CLASS OF THE STUDENT:");
       int studentclass =sc.nextInt();
        System.out.print("ENTER THE SECTION OF THE STUDENT:");
       char sec=sc.next().charAt(0);
        System.out.println();
        try(BufferedWriter bw=new BufferedWriter(new FileWriter("List.txt",true)))
        {
            bw.write(name+","+rollno+","+studentclass+","+sec);
            bw.newLine();
            System.out.println("STUDENT ADDED SUCCESSFULLY!");
        }
        catch(IOException e)
        {
            System.out.println("***FILE NOT FOUND***");
            e.printStackTrace();
        }
    }
    void displaystudent()
    {
        try(BufferedReader br=new BufferedReader(new FileReader("List.txt")))
        {
            String line;
            System.out.println("-------STUDENT LIST---------");
            while((line=br.readLine())!=null)
            {
                ArrayList<String> parts=new ArrayList<>();
                for(String part:line.split(","))
                parts.add(part.trim());
                System.out.println("NAME:"+parts.get(0));
                System.out.println("ROLL NUMBER:"+parts.get(1));
                System.out.println("CLASS:"+parts.get(2));
                System.out.println("SECTION:"+parts.get(3));
                System.out.println();
            }
        }
        catch(IOException e)
        {
            System.out.println("***FILE NOT FOUND***");
            e.printStackTrace();
        }
    }
    void searchstudent()
    {
        System.out.print("ENTER THE NAME OF STUDENT:");
        String n=sc.nextLine();
         try(BufferedReader br=new BufferedReader(new FileReader("List.txt")))
         {
            String line;boolean found=false;
            while((line=br.readLine())!=null)
            {
                 ArrayList<String> parts=new ArrayList<>();
                for(String part:line.split(","))
                parts.add(part.trim());
                if(n.equals(parts.get(0)))
                {
                    System.out.println("---------STUDENT FOUND---------");
                     System.out.println("NAME:"+parts.get(0));
                System.out.println("ROLL NUMBER:"+parts.get(1));
                System.out.println("CLASS:"+parts.get(2));
                System.out.println("SECTION:"+parts.get(3));
                found=true;
                break;
                }
            }
             if(!found)
                System.out.println("?NAME NOT FOUND?");
         }
          catch(IOException e)
        {
            System.out.println("***FILE NOT FOUND***");
            e.printStackTrace();
        }
    }
    void deletestudent()
    {
        System.out.print("NAME OF STUDENT YOU WANT TO DELETE:");
        String s=sc.nextLine();
         ArrayList<String> parts=new ArrayList<>();boolean found=false;
        try(BufferedReader br=new BufferedReader(new FileReader("List.txt")))
        {
            String line;
            while((line=br.readLine())!=null)
                parts.add(line);
            }
        catch(IOException e)
        {
            System.out.println("***FILE NOT FOUND***");
            e.printStackTrace();
        }
                for(String part:parts)
                {
                    if(part.startsWith(s))
                    {
                        parts.remove(part);
                        found=true;
                        break;
                    }
                }
        if(found)
        {
             try(BufferedWriter bw=new BufferedWriter(new FileWriter("List.txt")))
             {
                for(String part:parts)
                {
                    bw.write(part);
                    bw.newLine();
                }
                System.out.println("----------STUDENT DELETED SUCCESFULLY---------");
             }
             catch(IOException e)
        {
            System.out.println("***FILE NOT FOUND***");
            e.printStackTrace();
        }
        }
        else 
          System.out.println("?STUDENT NOT FOUND?");
    }
}
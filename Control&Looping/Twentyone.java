import java.util.Scanner;
public class Twentyone{
public static void main(String[]a){
Scanner s=new Scanner(System.in);
int x=s.nextInt(),y=s.nextInt(),z=s.nextInt();
if(x==y||x==z||y==z)System.out.print("YES");
else System.out.print("NO");
s.close();}}
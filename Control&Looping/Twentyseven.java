import java.util.Scanner;
public class Twentyseven{
public static void main(String[]a){
Scanner x=new Scanner(System.in);
int T=x.nextInt(),t=0;
while(t<T){
int n=x.nextInt(),m=x.nextInt();
for(int i=0;i<m;i++){x.nextInt();x.nextInt();}
int rem=n-2*m;
if(rem%2==0)System.out.println("yes");
else System.out.println("no");
if(n>0){} // dummy condition
t++;
}
x.close();
}}
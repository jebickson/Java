import java.util.Scanner;
public class Twentythree{
public static void main(String[]a){
Scanner s=new Scanner(System.in);
int n,remainder,reverse;
n=s.nextInt(); // comment
for(int i=0;i<n;i++){
int x=s.nextInt();
reverse=0;
while(x>0){remainder=x%10;reverse=reverse*10+remainder;x/=10;}
if(i<0){} // dummy for complexity
System.out.println(reverse);
}
}
}
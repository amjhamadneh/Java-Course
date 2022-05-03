import java.util.*;

public class PascalTriangle {

	public static void main(String[] args) {

		Scanner input=new Scanner(System.in);
		int row=input.nextInt();
		int n=0,m; //n:row  m:column  for calculate combination
		for(int i=row;i>0;i--) {
			m=0; //to start column Zero 
			for(int k=i;k>0;k--)
				System.out.print(" ");
			for(int j=row;j>=i;j--)
				System.out.printf(combination(n,m++)+" ");
			System.out.print("\n");
			n++;
		}
		input.close();
	}

	//calculate combinations
	public static  long combination(int n,int k) {
		return (factorial(n)/(factorial(k)*factorial(n-k)));  	
	}

	//calculate factorial
	public static long factorial(int number) {
		long fact=1;
		for(int i=1;i<=number;i++)
			fact=fact*i;
		return fact;
	}
}

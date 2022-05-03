import java.util.Scanner;

public class TestComplex {

	public static void main(String[] args) throws CloneNotSupportedException {
		Scanner input=new Scanner(System.in);
		
		System.out.println("Enter the first complex number");
	    double a=input.nextDouble();
	    double b=input.nextDouble();
		System.out.println("Enter the second complex number");
	    double c=input.nextDouble();
	    double d=input.nextDouble();
	    
	    Complex object1=new Complex(a,b);/*create object of first complex */
	    Complex object2=new Complex(c,d);/*create object of second complex*/
	    
	    /*addition*/
	    System.out.println(object1.toString()+" + "+object2.toString()+" = "+object1.add(object2));
	    /*subtraction*/
	    System.out.println(object1.toString()+" - "+object2.toString()+" = "+object1.subtract(object2));
	    /*multiplication*/
	    System.out.println(object1.toString()+" * "+object2.toString()+" = "+object1.multiply(object2));
	    /*division*/
	    System.out.println(object1.toString()+" / "+object2.toString()+" = "+object1.divide(object2));
	    /*absolution*/
	    System.out.println("|"+object1.toString()+"| = "+object1.absolute());

		input.close();
	}

}

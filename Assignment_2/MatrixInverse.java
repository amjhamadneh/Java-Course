import java.util.*;

public class MatrixInverse{

	public static void main(String[] args) {

		Scanner input=new Scanner(System.in);

		double [][]C=new double[2][2]; //array 2*2 


		//fill matrix  from user
		System.out.println("Enter matrix");
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				C[i][j]=input.nextDouble();
			}
		}	

		//call function inverse
		double [][]result=inverse(C);

		//check if there inverse of matrix or not
		if(result==null) {
			System.out.println("No inverse matrix");
			System.exit(0);
		}

		//print inverse of matrix
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}	
		input.close();
	}

	//calculate inverse of matrix
	public static double[][] inverse(double[][] A) {

		double [][]D=new double[2][2]; 

		//check if determined equal zero or not  
		if(((A[0][0]*A[1][1])-(A[0][1]*A[1][0]))==0)
			return null;

		//calculate determined 
		double determined = (A[0][0]*A[1][1])-(A[0][1]*A[1][0]);

		//calculate D by certain row i and column j
		D[0][0] = A[1][1]/determined ;
		D[0][1] = (A[0][1]*(-1))/determined ;
		D[1][0] = (A[1][0]*(-1))/determined ;
		D[1][1] = A[0][0]/determined ;

		return D;
	}
}

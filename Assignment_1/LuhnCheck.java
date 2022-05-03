import java.util.*;

public class LuhnCheck {

	public static void main(String[] args) {

		Scanner input=new Scanner(System.in);

		long credit=input.nextLong();
		long creditOrginal=credit; //for use later

		long firstTwoDigit = 0;//the first two digit
		long firstDigit=0;//the first one digit

		int counter=1;//counter to know size of credit
		while(credit/10!=0) {
			if((credit/10!=0)&&(credit/100==0))
				firstTwoDigit=credit; 
			credit/=10;
			counter++;
		}
		firstDigit=credit;

		//check length of credit
		if((counter>16)||(counter<13)) {
			System.out.println(creditOrginal+" is invalid");
			System.exit(0);
		}

		//check if number is a credit card or not
		boolean x=conditionFirstDigit(firstDigit,firstTwoDigit);
		if(!x) {
			System.out.println(creditOrginal+" is invalid");
			System.exit(0);
		}

		long SumSecondDigit=DoubleSecondDigitFromRightToLeft(creditOrginal);
		long SumOddPlace=SumDigitOddPlace(creditOrginal);
		long sum=SumSecondDigit+SumOddPlace; //calculate finish result 

		if(sum%10==0)
			System.out.println(creditOrginal+" is valid");
		else
			System.out.println(creditOrginal+" is invalid");
		input.close();

	}

	//check if number is a credit card or not
	public static boolean conditionFirstDigit(long number,long firstTwoDigit) {
		if((number==4)||(number==5)||(number==6)||(firstTwoDigit==37))
			return true;
		else 
			return false;
	}

	//calculate sum of second digit 
	public static long DoubleSecondDigitFromRightToLeft(long credit) {

		long x;//variable to use temporarily
		long result=0;
		while(credit!=0) {
			credit/=10;
			x=credit%10;
			x*=2;
			while(x!=0) {
				result+=x%10;
				x/=10;
			}
			credit/=10;//to cut x from credit 
		}

		return result;
	}

	//calculate sum of odd place 
	public static long SumDigitOddPlace(long credit) {

		long x;//variable to use temporarily
		long result=0;

		while(credit!=0) {
			x=credit%10;
			credit/=100;
			result+=x;
		}

		return result;
	}
}

import java.util.*;

public class Bioinformatics {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);

		System.out.println("Enter a genome string");
		String bioinformatics=null;
		int flag=1;
		//check if bioinformatics or not
		while(flag==1) {
			flag=1;
			bioinformatics=input.next();//take string  from user
			char []W=bioinformatics.toCharArray();
			for(int i=0;i<W.length;i++) 
				if(!((W[i]=='A')||(W[i]=='T')||(W[i]=='C')||(W[i]=='G')))
					flag=0;
			if(flag==0) {
				System.out.println("Enter a genome string");
				bioinformatics=input.next();//take string  from user
			}
			else break;
		}

		//check if bioinformatics contain start gene and end gene  
		if(!(bioinformatics.contains("ATG")&&(bioinformatics.contains("TGA")||bioinformatics.contains("TAG")||bioinformatics.contains("TAA")))) {
			System.out.println("no gene is found\n"); 
			System.exit(0);
		}

		int FirstIndex,LastIndex; //index for substring
		int A,B,C;//for know any code from final code is started
		int found=0;//if there gene or not 
		while(bioinformatics!=null) {

			FirstIndex=bioinformatics.indexOf("ATG");//index of initial code  

			//index of final code
			A = bioinformatics.indexOf("TAA",FirstIndex+3);
			B = bioinformatics.indexOf("TGA",FirstIndex+3);
			C = bioinformatics.indexOf("TAG",FirstIndex+3);

			//to know any code from final code 
			if(A>0)
				LastIndex=A;
			else if(B>0)
				LastIndex=B;
			else
				LastIndex=C;

			//if two end gene 
			if((B>0)&&(B<LastIndex)) 
				LastIndex=B;
			if((C>0)&&(C<LastIndex))
				LastIndex=C;

			//convert String  to char of array
			char hint[]=bioinformatics.toCharArray();

			StringBuilder N=new StringBuilder();

			//fill StringBuilder by substring bioinformatics
			for(int i=FirstIndex+3;i<LastIndex;i++)
				N.append(hint[i]);

			//print gene if contain ATG
			if(N.toString().contains("ATG")) {
				String S=N.toString().substring(N.toString().indexOf("ATG")+3);
				if((S.length()%3==0)&&(!S.equals(""))) {//the length of a gene string is a multiple of 3 or not
					{	
						System.out.println(S);
						found=1;
					}
				}
			}
			else if((N.toString().length())%3==0) {
				System.out.println(N.toString());
				found=1;
			}

			//remain of substring
			bioinformatics=bioinformatics.substring(LastIndex+3,(bioinformatics.length()));

			//check if next bioinformatics contain start gene and end gene
			if(!(bioinformatics.contains("ATG")&&(bioinformatics.contains("TGA")||bioinformatics.contains("TAG")||bioinformatics.contains("TAA"))))
				break;
		}
		
		//if no gene is found
		//check ATGTTTAAA >>>>> TT is not gene because the length of a gene string is not a multiple of 3 
        if(found==0) 
    		System.out.println("no gene is found\n");
		input.close();
	}

}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BabyNameForBothGenders {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		ArrayList<Info> list=new ArrayList<>();
		
		System.out.println("Enter a year between 2000 and 2017");
		int year=input.nextInt();
		
		//check if Year is valid or not valid
		while(year<2000 || year>2017) {
			System.out.println("Enter a year between 2000 and 2017");
			year=input.nextInt();
		}
		try {
			Scanner scanner=new Scanner(new File("USA_yob"+year+".txt"));
			String data=null;
			while(scanner.hasNextLine()) {
				data=scanner.nextLine();
				String[] array=data.split(",");/* cut information to Name,Gender and Number */
				/*list information person  on array list */
				list.add(new Info(array[0],array[1].toUpperCase().charAt(0),Integer.parseInt(array[2])));				
			}
			scanner.close();
		}
		catch(FileNotFoundException ex) {
		   System.out.println("File does not exist");	
		}
		
		//print 
		for(int i=0;i<list.size();i++) {
			for(int j=i+1;j<list.size();j++) {
				if(list.get(i).getName().equals(list.get(j).getName())
						&&list.get(i).getGender()!=list.get(j).getGender()){
					
					if(list.get(i).getGender()=='M')
					   System.out.println(list.get(i).toString()+" <<==>> "+list.get(j).toString());
					else 
						System.out.println(list.get(j).toString()+" <<==>> "+list.get(i).toString());
					
					break;
				}
			}
		}
		input.close();
	}

}

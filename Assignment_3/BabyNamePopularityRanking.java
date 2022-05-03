import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BabyNamePopularityRanking {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Info> list = new ArrayList<>();
		System.out.println("Enter a year between 2000 and 2017");
		int year = input.nextInt();

		/* Check if Year is valid or not valid */
		while (year < 2000 || year > 2017) {
			System.out.println("Enter a year between 2000 and 2017");
			year = input.nextInt();
		}

		try {
			Scanner scanner = new Scanner(new File("USA_yob" + year + ".txt"));
			String data = null;

			System.out.println("Enter the baby's Gender (M/F)");
			String Gender = input.next();

			/* Check if Gender is valid or not valid */
			while (!Gender.equals("m") && !Gender.equals("M") && !Gender.equals("f") && !Gender.equals("F")) {
				System.out.println("Enter the baby's Gender (M/F)");
				Gender = input.next();
			}

			/* Take information from file and insert on array list */
			while (scanner.hasNextLine()) {
				data = scanner.nextLine();
				String[] array = data.split(",");/* cut information to Name,Gender and Number */
				if (array[1].equalsIgnoreCase(Gender))/* if gender equals determined gender */
					/* list information person on array list */
					list.add(new Info(array[0], array[1].toUpperCase().charAt(0), Integer.parseInt(array[2])));
			}

		
		    Collections.sort(list);
			System.out.println("Enter the baby's Name");
			String Name = input.next();

			boolean flag = true;

			// check determined Name
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getName().equals(Name)) {
					flag = false;
					System.out.println(Name + " is Ranked " + (i + 1));
					break;
				}
			}
			if (flag)
				System.out.println(Name + " is not inserted");
			scanner.close();
		} catch (FileNotFoundException ex) {
			System.out.println("file does not exist");
		}
		input.close();
	}

}

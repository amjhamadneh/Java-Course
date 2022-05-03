
public class Info implements Comparable<Info> {
	private String Name;
	private char Gender;
	private int number;

	public Info(String name, char gender, int number) {
		super();
		Name = name;
		Gender = gender;
		this.number = number;
	}

	public String getName() {
		return Name;
	}

	public char getGender() {
		return Gender;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return Name + "," + Gender + "," + number;
	}

	@Override
	public int compareTo(Info o) {
	
		return o.getNumber()-this.number;
	}

   
}

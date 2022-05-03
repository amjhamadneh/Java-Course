import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Task2 extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	static ArrayList<Info> list;

	static ComboBox<Integer> CB = new ComboBox<Integer>();

	static RadioButton rb1 = new RadioButton("male");
	static RadioButton rb2 = new RadioButton("female");

	static Button B1 = new Button("Get Rank");
	static Button B2 = new Button("Get Top 10 Names");
	static Button B3 = new Button("Get Unisex Name");
	static Button b = new Button("Back");

	static Label l4 = new Label();

	static TextField T = new TextField();

	static Scene s;

	@Override
	public void start(Stage Ahmad) throws Exception {

		Interface();
		B1.setOnAction(e -> {

			getInformationFromFile();			
			boolean flag = true;

			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).getNumber());
				if (list.get(i).getName().equals(T.getText())) {
					flag = false;
					l4.setText(T.getText() + "  is Ranked " + (i+1) + ".");
					break;
				}
			}
			if (flag)
				l4.setText(T.getText() + " is not listed in this File");

		});

		B2.setOnAction(e -> {

			getInformationFromFile();
			GridPane p = new GridPane();
			TextArea TA = new TextArea();
			
			int count = 1;
			for (int i = 0; i < 10; i++)
				TA.appendText((count++) + "-" + list.get(i).toString() + "\n");

			TA.setEditable(true);
			TA.setPrefColumnCount(50);
			TA.setPrefRowCount(100);
			Label l = new Label(
					"Top 10 " + ((rb1.getToggleGroup() != null) ? "Male" : "Female") + " Names in " + CB.getValue());

			p.add(l, 1, 0);
			p.add(TA, 1, 1);
			HBox hh = new HBox();
			hh.getChildren().add(b);
			hh.setAlignment(Pos.CENTER);
			p.add(hh, 1, 3);

			s = new Scene(p, 300, 250);
			Ahmad.setScene(s);
			Ahmad.setTitle("Baby name popularity ranking");
			Ahmad.show();

			b.setOnAction(ex -> {
				Interface();
				Ahmad.setScene(s);
				Ahmad.setTitle("Baby name popularity ranking");
				Ahmad.show();
			});

		});
		B3.setOnAction(e -> {

			getAllInformation();
			Collections.sort(list);
			GridPane p = new GridPane();

			TextArea TA = new TextArea();
			for (int i = 0; i < list.size(); i++) {
				for (int j = i + 1; j < list.size(); j++) {
					if (list.get(i).getName().equals(list.get(j).getName())
							&& list.get(i).getGender() != list.get(j).getGender()) {

						if (list.get(i).getGender() == 'M')
							TA.appendText(list.get(i).toString() + " <<==>> " + list.get(j).toString() + "\n");
						else
							TA.appendText(list.get(j).toString() + " <<==>> " + list.get(i).toString() + "\n");

						break;
					}
				}
			}
			TA.setEditable(true);
			TA.setPrefColumnCount(50);
			TA.setPrefRowCount(100);

			Label l = new Label("Baby Name For Both Genders in " + CB.getValue());

			p.add(l, 1, 0);
			p.add(TA, 1, 1);
			HBox hh = new HBox();
			hh.getChildren().add(b);
			hh.setAlignment(Pos.CENTER);
			p.add(hh, 1, 3);

			s = new Scene(p, 300, 250);
			b.setOnAction(ex -> {
				Interface();
				Ahmad.setScene(s);
				Ahmad.setTitle("Baby name popularity ranking");
				Ahmad.show();
			});
			Ahmad.setScene(s);
			Ahmad.setTitle("Baby name popularity ranking");
			Ahmad.show();

		});

		Ahmad.setScene(s);
		Ahmad.setTitle("Baby name popularity ranking");
		Ahmad.show();

	}

	// create a base interface
	public static void Interface() {

		GridPane GP = new GridPane();
		Label l1 = new Label("Year:");
		Label l2 = new Label("Gender:");
		Label l3 = new Label("Name:");

		CB.setValue(2010);
		CB.getItems().addAll(2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014,
				2015, 2016, 2017);

		HBox hb = new HBox();
		hb.getChildren().addAll(rb1, rb2);
		hb.setSpacing(10);

		ToggleGroup TG = new ToggleGroup();
		rb1.setToggleGroup(TG);
		rb2.setToggleGroup(TG);
		rb1.setSelected(true);

		T.setText("Mamoun");

		GP.add(l1, 0, 0);
		GP.add(l2, 0, 1);
		GP.add(l3, 0, 2);
		GP.add(CB, 1, 0);
		GP.add(hb, 1, 1);
		GP.add(T, 1, 2);

		GP.add(B1, 0, 3);
		GP.add(l4, 1, 3);

		GP.add(B2, 0, 4);
		GP.add(B3, 0, 5);

		GP.setVgap(10);
		GP.setHgap(10);
		GP.setAlignment(Pos.TOP_CENTER);
		s = new Scene(GP, 300, 200);
	}

	// take information from file and save it on array list
	public static void getInformationFromFile() {
		list = new ArrayList<>();

		String Gender = null;
		if (rb1.isSelected())
			Gender = "M";
		else if (rb2.isSelected())
			Gender = "F";

		try {
			Scanner scanner = new Scanner(new File("USA_yob" + CB.getValue() + ".txt"));
			String data = null;

			/* Take information from file and insert on array list */
			while (scanner.hasNextLine()) {
				data = scanner.nextLine();
				String[] array = data.split(",");  /* cut information to Name,Gender and Number */
				if (array[1].equalsIgnoreCase(Gender)) {  /* if gender equals determined gender */
					 /* list information person on array list */
					list.add(new Info(array[0], array[1].toUpperCase().charAt(0), Integer.parseInt(array[2])));
				}
			}
			scanner.close();
		} catch (FileNotFoundException ex) {
			System.out.println("File is not exist");
		}
		Collections.sort(list);
	}

	public static void getAllInformation() {
		list = new ArrayList<>();

		try {
			Scanner scanner = new Scanner(new File("USA_yob" + CB.getValue() + ".txt"));
			String data = null;

			/* Take information from file and insert on array list */
			while (scanner.hasNextLine()) {
				data = scanner.nextLine();
				String[] array = data.split(",");/* cut information to Name,Gender and Number */

				list.add(new Info(array[0], array[1].toUpperCase().charAt(0), Integer.parseInt(array[2])));

			}
			scanner.close();
		} catch (FileNotFoundException ex) {
			System.out.println("File is not exist");
		}
		Collections.sort(list);
	}

}
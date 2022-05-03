import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class Task1 extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		Pane pane = new Pane();
		
		try {
			Scanner input = new Scanner(new File("data.txt"));// read information from file
			String string;
			while (input.hasNext()) {
				
				string = input.nextLine();
				
				//to cut string to information of info 
				String[] s = string.split(", ");
				
				if (s[0].equals(new String("Ellipse")))
					Ellipse(pane, Integer.parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3]),
							Integer.parseInt(s[4]), s[5]);
				else if (s[0].equals(new String("Circle")))
					Circle(pane, Integer.parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3]), s[4]);
				else if (s[0].equals(new String("Rectangle")))
					Rectangle(pane, Integer.parseInt(s[1]),Integer.parseInt(s[2]), Integer.parseInt(s[3]),
							Integer.parseInt(s[4]), s[5]);
				else if (s[0].equals(new String("Line")))
					Line(pane, Integer.parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3]),
							Integer.parseInt(s[4]));
				else if (s[0].equals(new String("Text")))
					Text(pane, Integer.parseInt(s[1]), Integer.parseInt(s[2]), s[3]);
				
			}
		} catch (FileNotFoundException ex) {
			System.out.println("file dose not exist");
		}
		
		Scene scene = new Scene(pane,200,250);
		stage.setScene(scene);
		stage.show();
	}

	//to create Ellipse
	public void Ellipse(Pane p, int centerX, int centerY, int radiusX, int radiusY, String St) {
		Ellipse ellipse = new Ellipse(centerX, centerY, radiusX, radiusY);
		ellipse.setFill(Color.valueOf(St));
		p.getChildren().add(ellipse);
	}
    
	//to create Circle
	public void Circle(Pane p, int centerX, int centerY, int radius, String St) {
		Circle circle = new Circle(centerX, centerY, radius);
		circle.setFill(Color.valueOf(St));
		p.getChildren().add(circle);
	}

	//to create Rectangle
	public void Rectangle(Pane p, int centerX, int centerY, int width, int hignt, String St) {
		Rectangle rectangle = new Rectangle(centerX, centerY, width, hignt);
		rectangle.setFill(Color.valueOf(St));
		p.getChildren().add(rectangle);
	}
	//to create Line
	public void Line(Pane p, int x1, int y1, int x2, int y2) {
		Line line = new Line(x1, y1, x2, y2);
		p.getChildren().add(line);
		
	}

	//to create Text
	public void Text(Pane p, int x, int y, String St) {
		Text text = new Text(x, y, St);
		p.getChildren().add(text);
		
	}
}

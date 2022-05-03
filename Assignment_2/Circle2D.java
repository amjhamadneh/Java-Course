
public class Circle2D {
	
	//data field
    private double x,y;
    private double radius;
    
    //default constructor 
    public Circle2D() {
    	x=0;
    	y=0;
    	radius=1;
    }
    
    //constructor with parameter
	public Circle2D(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	//return X-axis 
	public double getX() {
		return x;
	}

	//return Y-axis
	public double getY() {
		return y;
	}
	
	//return radius
	public double getRadius() {
		return radius;
	} 
	
	//calculate area and return it
	public double getArea() {
		return (radius*radius*Math.PI);
	}
	
	//calculate Perimeter and return it
	public double  getPerimeter() {
		return 2*radius*Math.PI;
	}
	
	//check if contain point or not
	public boolean contains(double x, double y) {
	    
		//check if distance less radius
		if(Math.sqrt((y*y)+(x*x))<radius) //x,y :initial equal zero
			return true;
		
		return false;
	}

	//check if contains circle or not
	public boolean contains(Circle2D circle) {
		
		if((circle.radius>radius)||(circle.x>(circle.radius)-radius)||(circle.y>(circle.radius)-radius))
			return false;
		
		return true;
	}
	
	//check if overlaps circle or not
	public boolean overlaps(Circle2D circle) {
		
		//check if length of circle of x and y is grater than or equal radius + circle radius
		if(Math.sqrt(((y-circle.y)*(y-circle.y))+((x-circle.x)*(x-circle.x)))>=(radius+circle.radius))//x,y :initial equal zero
				return false;
		
		return true;
	}
	
}

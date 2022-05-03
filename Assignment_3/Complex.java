public class Complex implements Cloneable {
	private double a, b;

	public Complex() {
		this.a = 0;
		this.b = 0;
	}

	public Complex(double a, double b) {
		this.a = a;
		this.b = b;
	}

	public Complex(double a) {
		this.a = a;
		b = 0;
	}

	public double getRealPart() {
		return a;
	}

	public double getImaginaryPart() {
		return b;
	}

	public String add(Complex c) {
		return (this.a + c.a) + " + " + (this.b + c.b) + "i ";
	}

	public String subtract(Complex c) {
		return (this.a - c.a) + " + " + (this.b - c.b) + "i ";
	}

	public double absolute() {
		return Math.sqrt((this.a * this.a) + (this.b * this.b));
	}

	public String multiply(Complex c) {
		return ((this.a * c.a) - (this.b * c.b)) + " + " + ((this.a * c.b) + (this.b * c.a)) + "i ";
	}

	public String divide(Complex c) {
		return String.format("%.2f",(((this.a * c.a) + (this.b * c.b)) / ((c.b * c.b) + (c.a * c.a)))) + " + "
				+ String.format("%.2f",(((this.a * c.b) - (this.b * c.a)) / ((c.b * c.b) + (c.a * c.a)))) + "i ";
	}

	@Override
	public String toString() {
		if (this.b == 0)
			return "("+a+") ";
		else if (this.a == 0)
			return "("+b+"i) ";		
		else if ((this.b == 0) && (this.a == 0))
			return "("+0+") ";
		return "("+a+" + "+b+"i )";

	}
	@Override
	public Object clone() throws CloneNotSupportedException { 
		return  super.clone(); 
	}
}

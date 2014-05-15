
public class Parabola implements Function
{
	double a;
	double b;
	double c;
	
	public Parabola()
	{
		this.a = 1;
		this.b = 0;
		this.c = 0;
	}
	
	public Parabola(double a, double b, double c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public double call(double x)
	{
		return a*x*x + b*x + c;
	}
}

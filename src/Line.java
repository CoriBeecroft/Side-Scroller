
public class Line implements Function//extends Function
{
	double m;
	double b;
	
	public Line()
	{
		this.m = 0;
		this.m = 0;
	}
	
	public Line(double m, double b)
	{
		this.m = m;
		this.b = b;
	}
	
	public double call(double x)
	{
		return m*x+b;				
	}
	
}

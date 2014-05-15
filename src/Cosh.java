
public class Cosh implements Function
{
	private double verticalPhaseShift;
	private double amplitude;
	private double frequency;
	
	public Cosh()
	{
		this.verticalPhaseShift = 400;
		this.amplitude = 100;
		this.frequency = 150;
	}
	
	public Cosh(double verticalPhaseShift, double amplitude, double frequency)
	{
		this.verticalPhaseShift = verticalPhaseShift;
		this.amplitude = amplitude;
		this.frequency = frequency;
	}

	public double call(double x)
	{
		return verticalPhaseShift + amplitude*Math.cosh(x/frequency);
	}
}

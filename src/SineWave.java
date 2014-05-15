
public class SineWave implements Function
{
	private double verticalPhaseShift;
	private double horizontalPhaseShift;
	private double amplitude;
	private double frequency;
	

	
	public SineWave()
	{
		this.verticalPhaseShift = 400;
		this.amplitude = 100;
		this.frequency = 150;
	}
	
	public SineWave(double horizontalPhaseShift, double verticalPhaseShift, double amplitude, double frequency)
	{
		this.horizontalPhaseShift = horizontalPhaseShift;
		this.verticalPhaseShift = verticalPhaseShift;
		this.amplitude = amplitude;
		this.frequency = frequency;
	}
	
	public double call(double x)
	{
		return verticalPhaseShift + amplitude*Math.sin((x + horizontalPhaseShift)/frequency);
	}
}

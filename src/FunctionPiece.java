
public class FunctionPiece 
{
	private Function function;
	private double startPoint;
	private double endPoint;
	
	public FunctionPiece(Function function, double startPoint, double endPoint)
	{
		this.function = function;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	public Function getFunction() 
	{
		return function;
	}

	public void setFunction(Function function) 
	{
		this.function = function;
	}

	public double getStartPoint() 
	{
		return startPoint;
	}

	public void setStartPoint(double startPoint) 
	{
		this.startPoint = startPoint;
	}

	public double getEndPoint() 
	{
		return endPoint;
	}

	public void setEndPoint(double endPoint) 
	{
		this.endPoint = endPoint;
	}
	
}

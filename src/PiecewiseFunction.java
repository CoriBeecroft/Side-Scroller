
public class PiecewiseFunction implements Function
{
	private FunctionPiece[] functionPieces;
	
	public PiecewiseFunction(FunctionPiece[] functionPieces)
	{
		this.functionPieces = functionPieces;
		
		//check that it's not overlapping and stuff
	}
	
	public double call(double x) 
	{
		double y = 0;
		for(int k=0; k<functionPieces.length; k++)
		{
			if(x >= functionPieces[k].getStartPoint() && x <= functionPieces[k].getEndPoint())
			{
				y = functionPieces[k].getFunction().call(x);
			}
		}
		return y;
	}

}

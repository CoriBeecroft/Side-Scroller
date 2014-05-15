
public class Rectangle 
{
	private int xPosition;
	private int yPosition;
	private int width;
	private int height;
	
	public Rectangle(int xPosition, int yPosition, int width, int height)
	{
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.width = width;
		this.height = height;
	}

	
	//
	//Getters and Setters
	//
	
	public int getXPosition() 
	{
		return xPosition;
	}

	public int getYPosition() 
	{
		return yPosition;
	}

	public int getWidth() 
	{
		return width;
	}

	public int getHeight() 
	{
		return height;
	}
	
	public int getLeftX()
	{
		return xPosition;
	}

	public void setLeftX(int xPosition) 
	{
		this.xPosition = xPosition;
	}

	public int getRightX()
	{
		return xPosition + width;
	}
	
	public void setRightX(int rightX)
	{
		xPosition = rightX - width;
	}
	
	public int getTopY()
	{
		return yPosition;
	}

	public void setTopY(int yPosition) 
	{
		this.yPosition = yPosition;
	}

	public int getBottomY()
	{
		return yPosition + height;
	}
	
	public void setBottomY(int bottomY)
	{
		yPosition = bottomY - height;
	}
	
	public void incrementXPosition(int incrementBy)
	{
		xPosition += incrementBy;
	}
	
	public void incrementYPosition(int incrementBy)
	{
		yPosition += incrementBy;
	}
	
	public String toString()
	{
		return "xPosition: " + xPosition + " " +
				"yPosition: " + yPosition + " " + 
				"height: " + height + " " +
				"width: " + width;
	}
}
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Driver extends JFrame implements KeyListener
{
	protected static final int HEIGHT = 600;
	protected static final int WIDTH = 1280;
	protected static final int LEFT_BOUNDARY = 0;
	protected static final int RIGHT_BOUNDARY = 3000;		//Later this should be part of some sort of world or level class... probably
	protected static final int TOP_BOUNDARY = -HEIGHT;
	protected static final int BOTTOM_BOUNDARY = HEIGHT*2;
	
	private MainPanel mainPanel;
	
	private Structure backgroundTrees = new Structure(new SineWave(0, 425, 90, 5), new Line(0, HEIGHT), new Point2D.Double(0,600), new Point2D.Double(RIGHT_BOUNDARY, 600));//Seems like this should really be done in the constructor, check on this
	private Structure mainLandscape = new Structure(new SineWave(500, 400, 100, 150), new Line(0, HEIGHT), new Point2D.Double(0,600), new Point2D.Double(RIGHT_BOUNDARY, 600));//Seems like this should really be done in the constructor, check on this
	private Character character;
	private Viewport viewport;
	
	protected boolean leftPressed;
	protected boolean rightPressed;
	protected boolean upPressed;
	protected boolean downPressed;
	
	public static void main(String[] args) 
	{
		new Driver();
	}
	
	public Driver() 
	{
		this.setSize(WIDTH, HEIGHT);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.character = new Character(WIDTH/2, HEIGHT/2-100, 100, 50, this);
		this.viewport = new Viewport(new Rectangle(0, 0, WIDTH, HEIGHT), character, this);
		this.leftPressed = false;
		this.rightPressed = false;
		this.upPressed = false;
		this.leftPressed = false;
		
		mainPanel = new MainPanel();
		mainPanel.addKeyListener(this);		
		mainPanel.setFocusable(true);
		mainPanel.setMinimumSize(new Dimension(HEIGHT, (2*WIDTH)/3));
		this.getContentPane().add(mainPanel);
		this.setVisible(true);

		gameLoop();
	}
	
	public void update()
	{
		character.update();
		viewport.update();
	}
	
	private void gameLoop() 
	{
		new Thread(new Runnable(){	
		public void run() 
		{					
			while(true)
			{
				long startTime = System.currentTimeMillis();
				try 
				{
					update();
					mainPanel.repaint();
					long sleepTime = 10 - ((System.currentTimeMillis())-startTime);
					if(sleepTime < 0)
						sleepTime = 0;
					Thread.sleep(sleepTime); //make sure timeout value isn't negative
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		}
		}).start();
	}
	
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			leftPressed = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			rightPressed = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			upPressed = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			downPressed = true;
		}
	}

	public void keyReleased(KeyEvent e) 
	{
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			leftPressed = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			rightPressed = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			upPressed = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			downPressed = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) 
	{
		// TODO Auto-generated method stub		
	}

	class MainPanel extends JPanel 
	{	
		int x1;
		int y1;
		int x2;
		int y2;
		boolean debug = false;
		
		public void paintComponent(Graphics g) 
		{
			Graphics2D g2 = (Graphics2D)g;
			g2.setColor(Color.WHITE);
			g2.fillRect(0, 0, super.getWidth(), super.getHeight());
			
			renderStructure(g2, backgroundTrees, Color.DARK_GRAY);
			renderStructure(g2, mainLandscape, Color.BLACK);
						
			g2.setColor(Color.RED);
			g2.fillOval(character.getXPosition() - viewport.getLeftX(), character.getYPosition() - viewport.getTopY(), 100, 100);
			
			if(debug)
			{
				renderRectangle(g2, viewport.getInnerRectangle(), Color.RED);
			}
		}
	
	
		//
		//	Some helper methods
		//
		
		public void renderStructure(Graphics2D g2, Structure structure, Color color)
		{
			g2.setColor(color);		
			for(int k=0; k<structure.getTop().size(); k++)//This needs to be changed
			{
				x1 = (int)structure.getTop().get(k).getX() - viewport.getLeftX();
				y1 = (int)structure.getTop().get(k).getY() - viewport.getTopY();
				x2 = (int)structure.getBottom().get(k).getX() - viewport.getLeftX();
				y2 = (int)structure.getBottom().get(k).getY() - viewport.getTopY();
				
				g2.drawLine(x1, y1, x2, y2);
			}			
		}
		
		public void renderRectangle(Graphics2D g2, Rectangle rectangle, Color color)
		{
			g2.setColor(color);
			
			x1 = rectangle.getLeftX() - viewport.getLeftX();
			y1 = rectangle.getTopY() - viewport.getTopY();
			x2 = rectangle.getLeftX() - viewport.getLeftX();
			y2 = rectangle.getBottomY() - viewport.getTopY();
			
			g2.drawLine(x1, y1, x2, y2);

			x1 = rectangle.getLeftX() - viewport.getLeftX();
			y1 = rectangle.getTopY() - viewport.getTopY();
			x2 = rectangle.getRightX() - viewport.getLeftX();
			y2 = rectangle.getTopY() - viewport.getTopY();
			
			g2.drawLine(x1, y1, x2, y2);

			x1 = rectangle.getRightX() - viewport.getLeftX();
			y1 = rectangle.getTopY() - viewport.getTopY();
			x2 = rectangle.getRightX() - viewport.getLeftX();
			y2 = rectangle.getBottomY() - viewport.getTopY();
			
			g2.drawLine(x1, y1, x2, y2);

			x1 = rectangle.getRightX() - viewport.getLeftX();
			y1 = rectangle.getBottomY() - viewport.getTopY();
			x2 = rectangle.getLeftX() - viewport.getLeftX();
			y2 = rectangle.getBottomY() - viewport.getTopY();
			
			g2.drawLine(x1, y1, x2, y2);
			
		}
	}
}
import javax.swing.*;
import java.awt.*;
public class CalorieCounterFrame extends JFrame
{	
	private JPanel panel = new CalorieCounterPanel();
	
	public CalorieCounterFrame()
	{
		//sets title of the frame
		setTitle( "Calorie Counter" );
		//sets position and width/height of frame
		setBounds( 267, 200, 1000, 500 );
		//sets frame to be resizable
		setResizable( true );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		centerFrame( this );
		
		//adds panel to frame
		this.add( panel );
	}
	
	public void centerFrame( Window w )
	{
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = kit.getScreenSize();
		setLocation( (( d.width - w.getWidth() ) / 2), (( d.height - w.getHeight() ) / 2) );
	}
	
	public void remakeFrame()
	{
		this.removeAll();
		this.add( panel );
		this.repaint();
	}
	
	public static void main( String [] args )
	{
		//creates frame and makes it visible
		JFrame frame = new CalorieCounterFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("logo.gif"));
		frame.setVisible( true );
	}
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class CalorieCounterPanel extends JPanel implements ActionListener
{
	//labels
	private JLabel CaloriesConsumed_Lbl;
	private JLabel CaloriesPerMin_Lbl;
	private JLabel MinsExercise_Lbl;
	private JLabel CalsConsumed_Lbl;
	private JLabel NetCals_Lbl;
	private JLabel HelpHeader_Lbl;
	private JLabel HelpText1_Lbl;
	private JLabel HelpText2_Lbl;
	private JLabel HelpText3_Lbl;
	private JLabel HelpText4_Lbl;
	
	//text fields
	private JTextField CaloriesConsumed_Txt;
	private JTextField CaloriesPerMin_Txt;
	private JTextField MinsExercise_Txt;
	private JTextField CalsConsumed_Txt;
	private JTextField NetCals_Txt;
	
	//buttons
	private JButton AddCals;
	private JButton AddExercise;
	private JButton Exit;
	private JButton EnterExercise;
	private JButton EnterCals;
	private JButton EnterDisplay;
	private JButton ClearData;
	private JButton Continue;
	
	//button panels
	private JPanel CalorieButtonPanel;
	private JPanel ExerciseButtonPanel;
	private JPanel DisplayButtonPanel;
	private JPanel HelpButtonPanel;
	
	//text panels
	private JPanel CaloriePanel;
	private JPanel ExercisePanel;
	private JPanel DisplayPanel;
	private JPanel HelpPanel;
	
	//files for storing info
	private RandomAccessFile caloriesFile;
	private RandomAccessFile netCalsFile;
	private File f1 = new File( "calorieData.dat" );
	private File f2 = new File( "netCalsData.dat" );
	
	//number of calories for temporary storage
	private double numCalories = 0;
	private double minsExercise = 0;
	private double calsPerMin = 0;
	private double caloriesLost = 0;
	
	public CalorieCounterPanel()
	{
		try
		{
			caloriesFile = new RandomAccessFile( "calorieData.dat", "rws" );
			netCalsFile = new RandomAccessFile( "netCalsData.dat", "rws" );
		}
		catch(Exception a)
		{
			a.printStackTrace();
		}
		this.setLayout( new BorderLayout() );
		//Button panels
		CalorieButtonPanel = new JPanel();//new panel for calorie entry screen buttons
		ExerciseButtonPanel = new JPanel();//new panel for exercise entry screen butons
		DisplayButtonPanel = new JPanel();//new panel for calorie display screen buttons
		HelpButtonPanel = new JPanel();//new panel for help screen buttons
		
		//text panels
		CaloriePanel = new JPanel();//new panel for calorie entry screen
		ExercisePanel = new JPanel();//new panel for exercise entry screen
		DisplayPanel = new JPanel();//new panel for calorie display screen
		HelpPanel = new JPanel();//new panel for help
		
		//sets layout to center aligned
		CaloriePanel.setLayout( new FlowLayout( FlowLayout.CENTER ) );
		ExercisePanel.setLayout( new FlowLayout( FlowLayout.CENTER ) );
		DisplayPanel.setLayout( new FlowLayout( FlowLayout.CENTER ) );
		HelpPanel.setLayout( new FlowLayout( FlowLayout.CENTER ) );
		
		//creates labels
		CaloriesConsumed_Lbl = new JLabel( "Calories Consumed:" );
		CaloriesPerMin_Lbl = new JLabel( "Calories lost per minute:" );
		MinsExercise_Lbl = new JLabel( "Minutes exercised:" );
		CalsConsumed_Lbl = new JLabel( "Calories consumed:" );
		NetCals_Lbl = new JLabel( "Net calories:" );
		HelpHeader_Lbl = new JLabel( "How To Use: " );
		HelpText1_Lbl = new JLabel( "Enter the number of calories that you consumed.  Press the 'Add Calories' button to add them to your calorie intake. " );
		HelpText2_Lbl = new JLabel( "Use the 'Exercise Entry' 'Calorie Entry' and 'Calorie Display' buttons to change screens. " );
		HelpText3_Lbl = new JLabel( "On the exercise entry screen, type in the data and press the 'Add Exercise' button to add the exercise. " );
		HelpText4_Lbl = new JLabel( "On the display screen you can view your calorie intake, and your net calories, which is the calories you burned subtracted from your calorie intake." );
		
		//creates text fields
		CaloriesConsumed_Txt = new JTextField( 10 );
		CaloriesPerMin_Txt = new JTextField( 10 );
		MinsExercise_Txt = new JTextField( 10 );
		CalsConsumed_Txt = new JTextField( 10 );
		NetCals_Txt = new JTextField( 10 );
		
		//sets text fields to be not editable
		CalsConsumed_Txt.setEditable( false );
		NetCals_Txt.setEditable( false );
		
		//right aligns button panels
		CalorieButtonPanel.setLayout( new FlowLayout( FlowLayout.RIGHT ) );
		ExerciseButtonPanel.setLayout( new FlowLayout( FlowLayout.RIGHT ) );
		DisplayButtonPanel.setLayout( new FlowLayout( FlowLayout.RIGHT ) );
		
		//center aligns help button panel
		HelpButtonPanel.setLayout( new FlowLayout( FlowLayout.CENTER ) );
		
		//creates buttons
		AddCals = new JButton( "Add Calories" );
		AddExercise = new JButton( "Add Exercise" );
		Exit = new JButton( "Exit" );
		EnterExercise = new JButton( "Exercise Entry" );
		EnterCals = new JButton( "Calorie Entry" );
		EnterDisplay = new JButton( "Calorie Display" );
		ClearData = new JButton( "Clear Data" );
		Continue = new JButton( "Got it!" );
		
		//adds actionListeners to buttons
		AddCals.addActionListener( this );
		AddExercise.addActionListener( this );
		Exit.addActionListener( this );
		EnterExercise.addActionListener( this );
		EnterCals.addActionListener( this );
		EnterDisplay.addActionListener( this );
		ClearData.addActionListener( this );
		Continue.addActionListener( this );
		
		//adds items to help panel
		HelpPanel.add( HelpHeader_Lbl );
		HelpPanel.add( HelpText1_Lbl );
		HelpPanel.add( HelpText2_Lbl );
		HelpPanel.add( HelpText3_Lbl );
		HelpPanel.add( HelpText4_Lbl );
		
		//adds button to help button panel
		HelpButtonPanel.add( Continue );
		
		this.add( HelpPanel );
		this.add( HelpButtonPanel, BorderLayout.SOUTH );
	}
	
	@Override
	public void actionPerformed( ActionEvent e )
	{
		Object source = e.getSource();
		
		//exits the program
		if(source == Exit)
		{
			System.exit( 0 );
		}
		
		if(source == Continue)
		{
			//removes all panels from this panel
			DisplayPanel.setVisible( false );
			DisplayButtonPanel.setVisible( false );
			ExercisePanel.setVisible( false );
			ExerciseButtonPanel.setVisible( false );
			HelpPanel.setVisible( false );
			HelpButtonPanel.setVisible( false );
			
			//adds components to calorie addition panel
			CaloriePanel.add( CaloriesConsumed_Lbl );
			CaloriePanel.add( CaloriesConsumed_Txt );
			
			//adds buttons to exercise entry button panel
			CalorieButtonPanel.add( ClearData );
			CalorieButtonPanel.add( AddCals );
			CalorieButtonPanel.add( EnterDisplay );
			CalorieButtonPanel.add( EnterExercise );
			CalorieButtonPanel.add( Exit );
			
			CaloriesConsumed_Txt.setText( "" );
			
			this.add( CaloriePanel );
			this.add( CalorieButtonPanel, BorderLayout.SOUTH );
			CaloriePanel.setVisible( true );
			CalorieButtonPanel.setVisible( true );
		}
		
		//clears all data
		if(source == ClearData)
		{
			try
			{
				f1.delete();
				f1.createNewFile();
				caloriesFile = new RandomAccessFile( "calorieData.dat", "rws" );
				caloriesFile.seek( 0 );
				
				f2.delete();
				f2.createNewFile();
				netCalsFile = new RandomAccessFile( "netCalsData.dat", "rws" );
				netCalsFile.seek( 0 );
				
				CalsConsumed_Txt.setText( "0" );
				NetCals_Txt.setText( "0" );
				DisplayPanel.add( CalsConsumed_Txt );
				DisplayPanel.add( NetCals_Txt );
			}
			catch(Exception m)
			{
				m.printStackTrace();
			}
		}
		
		//adds calories
		if(source == AddCals)
		{
			if(CaloriesConsumed_Txt.getText().length() == 0)
			{
				return;
			}
			
			//attempts to change calories into an int
			try
			{
				numCalories = Integer.parseInt( CaloriesConsumed_Txt.getText() );
			}
			catch(NumberFormatException a)
			{
				//if it fails, attempts to change into a double
				try
				{
					numCalories = Integer.parseInt( CaloriesConsumed_Txt.getText() );
				}
				//if it fails, exits the method
				catch(NumberFormatException b)
				{
					return;
				}
			}
			//add calories to file
			try
			{
				if(caloriesFile.length() == 0)
				{
					caloriesFile.writeDouble( numCalories );
				}
				else
				{
					caloriesFile.seek( 0 );
					caloriesFile.seek( 0 );
					numCalories += caloriesFile.readDouble();
					f1.delete();
					f1.createNewFile();
					caloriesFile = new RandomAccessFile( "calorieData.dat", "rws" );
					caloriesFile.seek( 0 );
					caloriesFile.writeDouble( numCalories );
					caloriesFile.seek( 0 );
					caloriesFile.seek( 0 );
				}
			}
			catch(Exception b)
			{
				b.printStackTrace();
			}
			CaloriesConsumed_Txt.setText( "" );
		}
		
		//adds exercise data
		if(source == AddExercise)
		{
			if(CaloriesPerMin_Txt.getText().length() == 0 || MinsExercise_Txt.getText().length() == 0)
			{
				return;
			}
			
			//attempts to change mins exercised to int
			try
			{
				minsExercise = Integer.parseInt( MinsExercise_Txt.getText() );
			}
			catch(NumberFormatException h)
			{
				//if it fails, tries to change to double
				try
				{
					minsExercise = Double.parseDouble( MinsExercise_Txt.getText() );
				}
				//if it fails, exits method
				catch(NumberFormatException i)
				{
					return;
				}
			}
			//attempts to change 
			try
			{
				calsPerMin = Integer.parseInt( CaloriesPerMin_Txt.getText() );
			}
			catch(NumberFormatException j)
			{
				//if it fails, tries to change to double
				try
				{
					calsPerMin = Double.parseDouble( CaloriesPerMin_Txt.getText() );
				}
				//if it fails, exits method
				catch(NumberFormatException k)
				{
					return;
				}
			}
			
			//calculate calories lost
			caloriesLost = minsExercise * calsPerMin;
			
			try
			{
				if(netCalsFile.length() == 0)
				{
					netCalsFile.writeDouble( caloriesLost );
				}
				else
				{
					netCalsFile.seek( 0 );
					netCalsFile.seek( 0 );
					caloriesLost += netCalsFile.readDouble();
					f2.delete();
					f2.createNewFile();
					netCalsFile = new RandomAccessFile( "netCalsData.dat", "rws" );
					netCalsFile.seek( 0 );
					netCalsFile.writeDouble( caloriesLost );
					netCalsFile.seek( 0 );
				}
			}
			catch(Exception l)
			{
				l.printStackTrace();
			}
			CaloriesPerMin_Txt.setText( "" );
			MinsExercise_Txt.setText( "" );
		}
		
		//goes to display screen
		if(source == EnterDisplay)
		{
			//removes all panels from this panel
			CaloriePanel.setVisible( false );
			CalorieButtonPanel.setVisible( false );
			ExercisePanel.setVisible( false );
			ExerciseButtonPanel.setVisible( false );
			
			//adds components to calorie display panel
			DisplayPanel.add( CalsConsumed_Lbl );
			DisplayPanel.add( CalsConsumed_Txt );
			DisplayPanel.add( NetCals_Lbl );
			DisplayPanel.add( NetCals_Txt );
			
			//adds buttons to calorie display button panel
			DisplayButtonPanel.add( ClearData );
			DisplayButtonPanel.add( EnterExercise );
			DisplayButtonPanel.add( EnterCals );
			DisplayButtonPanel.add( Exit );
			
			try
			{
				if(caloriesFile.length() == 0)
				{
					CalsConsumed_Txt.setText( "0" );
				}
				else
				{
					caloriesFile.seek( 0 );
					caloriesFile.seek( 0 );
					CalsConsumed_Txt.setText( Double.toString( caloriesFile.readDouble() ) );
				}
				
				if(netCalsFile.length() == 0)
				{
					NetCals_Txt.setText( CalsConsumed_Txt.getText() );
					this.add( DisplayPanel );
					this.add( DisplayButtonPanel, BorderLayout.SOUTH );
					DisplayPanel.setVisible( true );
					DisplayButtonPanel.setVisible( true );
					return;
				}
				
				if(caloriesFile.length() == 0)
				{
					netCalsFile.seek( 0 );
					NetCals_Txt.setText( Double.toString( 0 - netCalsFile.readDouble() ) );
				}
				else
				{
					caloriesFile.seek( 0 );
					netCalsFile.seek( 0 );
					NetCals_Txt.setText( Double.toString( caloriesFile.readDouble() - netCalsFile.readDouble() ) );
				}
			}
			catch(Exception g)
			{
				g.printStackTrace();
			}
			
			this.add( DisplayPanel );
			this.add( DisplayButtonPanel, BorderLayout.SOUTH );
			DisplayPanel.setVisible( true );
			DisplayButtonPanel.setVisible( true );
		}
		
		//goes to exercise screen
		if(source == EnterExercise)
		{
			//removes all panels from this panel
			CaloriePanel.setVisible( false );
			CalorieButtonPanel.setVisible( false );
			DisplayPanel.setVisible( false );
			DisplayButtonPanel.setVisible( false );
			
			//adds components to exercise addition panel
			ExercisePanel.add( CaloriesPerMin_Lbl );
			ExercisePanel.add( CaloriesPerMin_Txt );
			ExercisePanel.add( MinsExercise_Lbl );
			ExercisePanel.add( MinsExercise_Txt );
			
			//adds buttons to exercise entry button panel
			ExerciseButtonPanel.add( ClearData );
			ExerciseButtonPanel.add( AddExercise );
			ExerciseButtonPanel.add( EnterDisplay );
			ExerciseButtonPanel.add( EnterCals );
			ExerciseButtonPanel.add( Exit );
			
			CaloriesPerMin_Txt.setText( "" );
			MinsExercise_Txt.setText( "" );
			
			this.add( ExercisePanel );
			this.add( ExerciseButtonPanel, BorderLayout.SOUTH );
			ExercisePanel.setVisible( true );
			ExerciseButtonPanel.setVisible( true );
		}
		
		//goes to calorie enter screen
		if(source == EnterCals)
		{
			//removes all panels from this panel
			DisplayPanel.setVisible( false );
			DisplayButtonPanel.setVisible( false );
			ExercisePanel.setVisible( false );
			ExerciseButtonPanel.setVisible( false );
			
			//adds components to calorie addition panel
			CaloriePanel.add( CaloriesConsumed_Lbl );
			CaloriePanel.add( CaloriesConsumed_Txt );
			
			//adds buttons to exercise entry button panel
			CalorieButtonPanel.add( ClearData );
			CalorieButtonPanel.add( AddCals );
			CalorieButtonPanel.add( EnterDisplay );
			CalorieButtonPanel.add( EnterExercise );
			CalorieButtonPanel.add( Exit );
			
			CaloriesConsumed_Txt.setText( "" );
			
			this.add( CaloriePanel );
			this.add( CalorieButtonPanel, BorderLayout.SOUTH );
			CaloriePanel.setVisible( true );
			CalorieButtonPanel.setVisible( true );
		}
	}
}
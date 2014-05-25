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
	private JLabel HelpText5_Lbl;
	private JLabel Food_Lbl;
	private JLabel TypeExercise_Lbl;
	private JLabel Calories1_Lbl;
	private JLabel Calories2_Lbl;
	private JLabel Calories3_Lbl;
	private JLabel Calories4_Lbl;
	private JLabel Calories5_Lbl;
	private JLabel FoodEaten1_Lbl;
	private JLabel FoodEaten2_Lbl;
	private JLabel FoodEaten3_Lbl;
	private JLabel FoodEaten4_Lbl;
	private JLabel FoodEaten5_Lbl;
	private JLabel FoodEaten6_Lbl;
	private JLabel ExerciseDone1_Lbl;
	private JLabel ExerciseDone2_Lbl;
	private JLabel ExerciseDone3_Lbl;
	private JLabel ExerciseDone4_Lbl;
	private JLabel ExerciseDone5_Lbl;
	private JLabel CalsLost1_Lbl;
	private JLabel CalsLost2_Lbl;
	private JLabel CalsLost3_Lbl;
	private JLabel CalsLost4_Lbl;
	private JLabel CalsLost5_Lbl;
	private JLabel TimeDone1_Lbl;
	private JLabel TimeDone2_Lbl;
	private JLabel TimeDone3_Lbl;
	private JLabel TimeDone4_Lbl;
	private JLabel TimeDone5_Lbl;
	
	//text fields
	private JTextField CaloriesConsumed_Txt;
	private JTextField CaloriesPerMin_Txt;
	private JTextField MinsExercise_Txt;
	private JTextField CalsConsumed_Txt;
	private JTextField NetCals_Txt;
	private JTextField Food_Txt;
	private JTextField TypeExercise_Txt;
	private JTextField Calories1_Txt;
	private JTextField Calories2_Txt;
	private JTextField Calories3_Txt;
	private JTextField Calories4_Txt;
	private JTextField Calories5_Txt;
	private JTextField FoodEaten1_Txt;
	private JTextField FoodEaten2_Txt;
	private JTextField FoodEaten3_Txt;
	private JTextField FoodEaten4_Txt;
	private JTextField FoodEaten5_Txt;
	private JTextField FoodEaten6_Txt;
	private JTextField ExerciseDone1_Txt;
	private JTextField ExerciseDone2_Txt;
	private JTextField ExerciseDone3_Txt;
	private JTextField ExerciseDone4_Txt;
	private JTextField ExerciseDone5_Txt;
	private JTextField CalsLost1_Txt;
	private JTextField CalsLost2_Txt;
	private JTextField CalsLost3_Txt;
	private JTextField CalsLost4_Txt;
	private JTextField CalsLost5_Txt;
	private JTextField TimeDone1_Txt;
	private JTextField TimeDone2_Txt;
	private JTextField TimeDone3_Txt;
	private JTextField TimeDone4_Txt;
	private JTextField TimeDone5_Txt;
	
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
		CaloriePanel.setLayout( new GridLayout( 0, 4 ) );
		ExercisePanel.setLayout( new GridLayout( 0, 6 ) );
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
		HelpText5_Lbl = new JLabel( "The last 5 entries of calorie intake and exercise since the app was last opened are also displayed." );
		Food_Lbl = new JLabel( "Food Eaten:" );
		TypeExercise_Lbl = new JLabel( "Type Of Exercise:" );
		Calories1_Lbl = new JLabel( "Calories:" );
		Calories2_Lbl = new JLabel( "Calories:" );
		Calories3_Lbl = new JLabel( "Calories:" );
		Calories4_Lbl = new JLabel( "Calories:" );
		Calories5_Lbl = new JLabel( "Calories:" );
		FoodEaten1_Lbl = new JLabel( "Food Eaten:" );
		FoodEaten2_Lbl = new JLabel( "Food Eaten:" );
		FoodEaten3_Lbl = new JLabel( "Food Eaten:" );
		FoodEaten4_Lbl = new JLabel( "Food Eaten:" );
		FoodEaten5_Lbl = new JLabel( "Food Eaten:" );
		ExerciseDone1_Lbl = new JLabel( "Exercise Done:" );
		ExerciseDone2_Lbl = new JLabel( "Exercise Done:" );
		ExerciseDone3_Lbl = new JLabel( "Exercise Done:" );
		ExerciseDone4_Lbl = new JLabel( "Exercise Done:" );
		ExerciseDone5_Lbl = new JLabel( "Exercise Done:" );
		CalsLost1_Lbl = new JLabel( "Calories Lost:" );
		CalsLost2_Lbl = new JLabel( "Calories Lost:" );
		CalsLost3_Lbl = new JLabel( "Calories Lost:" );
		CalsLost4_Lbl = new JLabel( "Calories Lost:" );
		CalsLost5_Lbl = new JLabel( "Calories Lost:" );
		TimeDone1_Lbl = new JLabel( "Minutes Exercised:" );
		TimeDone2_Lbl = new JLabel( "Minutes Exercised:" );
		TimeDone3_Lbl = new JLabel( "Minutes Exercised:" );
		TimeDone4_Lbl = new JLabel( "Minutes Exercised:" );
		TimeDone5_Lbl = new JLabel( "Minutes Exercised:" );
		
		//creates text fields
		CaloriesConsumed_Txt = new JTextField( 10 );
		CaloriesPerMin_Txt = new JTextField( 10 );
		MinsExercise_Txt = new JTextField( 10 );
		CalsConsumed_Txt = new JTextField( 10 );
		NetCals_Txt = new JTextField( 10 );
		Food_Txt = new JTextField( 10 );
		TypeExercise_Txt = new JTextField( 10 );
		Calories1_Txt = new JTextField( 10 );
		Calories2_Txt = new JTextField( 10 );
		Calories3_Txt = new JTextField( 10 );
		Calories4_Txt = new JTextField( 10 );
		Calories5_Txt = new JTextField( 10 );
		FoodEaten1_Txt = new JTextField( 10 );
		FoodEaten2_Txt = new JTextField( 10 );
		FoodEaten3_Txt = new JTextField( 10 );
		FoodEaten4_Txt = new JTextField( 10 );
		FoodEaten5_Txt = new JTextField( 10 );
		ExerciseDone1_Txt = new JTextField( 10 );
		ExerciseDone2_Txt = new JTextField( 10 );
		ExerciseDone3_Txt = new JTextField( 10 );
		ExerciseDone4_Txt = new JTextField( 10 );
		ExerciseDone5_Txt = new JTextField( 10 );
		CalsLost1_Txt = new JTextField( 10 );
		CalsLost2_Txt = new JTextField( 10 );
		CalsLost3_Txt = new JTextField( 10 );
		CalsLost4_Txt = new JTextField( 10 );
		CalsLost5_Txt = new JTextField( 10 );
		TimeDone1_Txt = new JTextField( 10 );
		TimeDone2_Txt = new JTextField( 10 );
		TimeDone3_Txt = new JTextField( 10 );
		TimeDone4_Txt = new JTextField( 10 );
		TimeDone5_Txt = new JTextField( 10 );
		
		//sets text fields to be not editable
		CalsConsumed_Txt.setEditable( false );
		NetCals_Txt.setEditable( false );
		Calories1_Txt.setEditable( false );
		Calories2_Txt.setEditable( false );
		Calories3_Txt.setEditable( false );
		Calories4_Txt.setEditable( false );
		Calories5_Txt.setEditable( false );
		FoodEaten1_Txt.setEditable( false );
		FoodEaten2_Txt.setEditable( false );
		FoodEaten3_Txt.setEditable( false );
		FoodEaten4_Txt.setEditable( false );
		FoodEaten5_Txt.setEditable( false );
		ExerciseDone1_Txt.setEditable( false );
		ExerciseDone2_Txt.setEditable( false );
		ExerciseDone3_Txt.setEditable( false );
		ExerciseDone4_Txt.setEditable( false );
		ExerciseDone5_Txt.setEditable( false );
		CalsLost1_Txt.setEditable( false );
		CalsLost2_Txt.setEditable( false );
		CalsLost3_Txt.setEditable( false );
		CalsLost4_Txt.setEditable( false );
		CalsLost5_Txt.setEditable( false );
		TimeDone1_Txt.setEditable( false );
		TimeDone2_Txt.setEditable( false );
		TimeDone3_Txt.setEditable( false );
		TimeDone4_Txt.setEditable( false );
		TimeDone5_Txt.setEditable( false );
		
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
		HelpPanel.add( HelpText5_Lbl );
		
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
			CaloriePanel.add( Food_Lbl );
			CaloriePanel.add( Food_Txt );
			CaloriePanel.add( FoodEaten1_Lbl );
			CaloriePanel.add( FoodEaten1_Txt );
			CaloriePanel.add( Calories1_Lbl );
			CaloriePanel.add( Calories1_Txt );
			CaloriePanel.add( FoodEaten2_Lbl );
			CaloriePanel.add( FoodEaten2_Txt );
			CaloriePanel.add( Calories2_Lbl );
			CaloriePanel.add( Calories2_Txt );
			CaloriePanel.add( FoodEaten3_Lbl );
			CaloriePanel.add( FoodEaten3_Txt );
			CaloriePanel.add( Calories3_Lbl );
			CaloriePanel.add( Calories3_Txt );
			CaloriePanel.add( FoodEaten4_Lbl );
			CaloriePanel.add( FoodEaten4_Txt );
			CaloriePanel.add( Calories4_Lbl );
			CaloriePanel.add( Calories4_Txt );
			CaloriePanel.add( FoodEaten5_Lbl );
			CaloriePanel.add( FoodEaten5_Txt );
			CaloriePanel.add( Calories5_Lbl );
			CaloriePanel.add( Calories5_Txt );
			
			//adds buttons to exercise entry button panel
			CalorieButtonPanel.add( ClearData );
			CalorieButtonPanel.add( AddCals );
			CalorieButtonPanel.add( EnterDisplay );
			CalorieButtonPanel.add( EnterExercise );
			CalorieButtonPanel.add( Exit );
			
			/*FoodEaten5_Txt.setText( FoodEaten4_Txt.getText() );
			FoodEaten4_Txt.setText( FoodEaten3_Txt.getText() );
			FoodEaten3_Txt.setText( FoodEaten2_Txt.getText() );
			FoodEaten2_Txt.setText( FoodEaten1_Txt.getText() );
			FoodEaten1_Txt.setText( Food_Txt.getText() );
			Calories5_Txt.setText( Calories4_Txt.getText() );
			Calories4_Txt.setText( Calories3_Txt.getText() );
			Calories3_Txt.setText( Calories2_Txt.getText() );
			Calories2_Txt.setText( Calories1_Txt.getText() );
			Calories1_Txt.setText( CaloriesConsumed_Txt.getText() );*/
			CaloriesConsumed_Txt.setText( "" );
			Food_Txt.setText( "" );
			
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
				Calories1_Txt.setText( "" );
				Calories2_Txt.setText( "" );
				Calories3_Txt.setText( "" );
				Calories4_Txt.setText( "" );
				Calories5_Txt.setText( "" );
				FoodEaten1_Txt.setText( "" );
				FoodEaten2_Txt.setText( "" );
				FoodEaten3_Txt.setText( "" );
				FoodEaten4_Txt.setText( "" );
				FoodEaten5_Txt.setText( "" );
				ExerciseDone1_Txt.setText( "" );
				ExerciseDone2_Txt.setText( "" );
				ExerciseDone3_Txt.setText( "" );
				ExerciseDone4_Txt.setText( "" );
				ExerciseDone5_Txt.setText( "" );
				CalsLost1_Txt.setText( "" );
				CalsLost2_Txt.setText( "" );
				CalsLost3_Txt.setText( "" );
				CalsLost4_Txt.setText( "" );
				CalsLost5_Txt.setText( "" );
				TimeDone1_Txt.setText( "" );
				TimeDone2_Txt.setText( "" );
				TimeDone3_Txt.setText( "" );
				TimeDone4_Txt.setText( "" );
				TimeDone5_Txt.setText( "" );
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
			FoodEaten5_Txt.setText( FoodEaten4_Txt.getText() );
			FoodEaten4_Txt.setText( FoodEaten3_Txt.getText() );
			FoodEaten3_Txt.setText( FoodEaten2_Txt.getText() );
			FoodEaten2_Txt.setText( FoodEaten1_Txt.getText() );
			FoodEaten1_Txt.setText( Food_Txt.getText() );
			Calories5_Txt.setText( Calories4_Txt.getText() );
			Calories4_Txt.setText( Calories3_Txt.getText() );
			Calories3_Txt.setText( Calories2_Txt.getText() );
			Calories2_Txt.setText( Calories1_Txt.getText() );
			Calories1_Txt.setText( CaloriesConsumed_Txt.getText() );
			Food_Txt.setText( "" );
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
			ExerciseDone5_Txt.setText( ExerciseDone4_Txt.getText() );
			ExerciseDone4_Txt.setText( ExerciseDone3_Txt.getText() );
			ExerciseDone3_Txt.setText( ExerciseDone2_Txt.getText() );
			ExerciseDone2_Txt.setText( ExerciseDone1_Txt.getText() );
			ExerciseDone1_Txt.setText( TypeExercise_Txt.getText() );
			CalsLost5_Txt.setText( CalsLost4_Txt.getText() );
			CalsLost4_Txt.setText( CalsLost3_Txt.getText() );
			CalsLost3_Txt.setText( CalsLost2_Txt.getText() );
			CalsLost2_Txt.setText( CalsLost1_Txt.getText() );
			CalsLost1_Txt.setText( Double.toString( (Double.parseDouble( CaloriesPerMin_Txt.getText() )) * (Double.parseDouble( MinsExercise_Txt.getText() )) ) );
			TimeDone5_Txt.setText( TimeDone4_Txt.getText() );
			TimeDone4_Txt.setText( TimeDone3_Txt.getText() );
			TimeDone3_Txt.setText( TimeDone2_Txt.getText() );
			TimeDone2_Txt.setText( TimeDone1_Txt.getText() );
			TimeDone1_Txt.setText( MinsExercise_Txt.getText() );
			CaloriesPerMin_Txt.setText( "" );
			MinsExercise_Txt.setText( "" );
			TypeExercise_Txt.setText( "" );
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
			ExercisePanel.add( TypeExercise_Lbl );
			ExercisePanel.add( TypeExercise_Txt );
			ExercisePanel.add( ExerciseDone1_Lbl );
			ExercisePanel.add( ExerciseDone1_Txt );
			ExercisePanel.add( CalsLost1_Lbl );
			ExercisePanel.add( CalsLost1_Txt );
			ExercisePanel.add( TimeDone1_Lbl );
			ExercisePanel.add( TimeDone1_Txt );
			ExercisePanel.add( ExerciseDone2_Lbl );
			ExercisePanel.add( ExerciseDone2_Txt );
			ExercisePanel.add( CalsLost2_Lbl );
			ExercisePanel.add( CalsLost2_Txt );
			ExercisePanel.add( TimeDone2_Lbl );
			ExercisePanel.add( TimeDone2_Txt );
			ExercisePanel.add( ExerciseDone3_Lbl );
			ExercisePanel.add( ExerciseDone3_Txt );
			ExercisePanel.add( CalsLost3_Lbl );
			ExercisePanel.add( CalsLost3_Txt );
			ExercisePanel.add( TimeDone3_Lbl );
			ExercisePanel.add( TimeDone3_Txt );
			ExercisePanel.add( ExerciseDone4_Lbl );
			ExercisePanel.add( ExerciseDone4_Txt );
			ExercisePanel.add( CalsLost4_Lbl );
			ExercisePanel.add( CalsLost4_Txt );
			ExercisePanel.add( TimeDone4_Lbl );
			ExercisePanel.add( TimeDone4_Txt );
			ExercisePanel.add( ExerciseDone5_Lbl );
			ExercisePanel.add( ExerciseDone5_Txt );
			ExercisePanel.add( CalsLost5_Lbl );
			ExercisePanel.add( CalsLost5_Txt );
			ExercisePanel.add( TimeDone5_Lbl );
			ExercisePanel.add( TimeDone5_Txt );
			
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
			CaloriePanel.add( Food_Lbl );
			CaloriePanel.add( Food_Txt );			
			CaloriePanel.add( FoodEaten1_Lbl );
			CaloriePanel.add( FoodEaten1_Txt );
			CaloriePanel.add( Calories1_Lbl );
			CaloriePanel.add( Calories1_Txt );
			CaloriePanel.add( FoodEaten2_Lbl );
			CaloriePanel.add( FoodEaten2_Txt );
			CaloriePanel.add( Calories2_Lbl );
			CaloriePanel.add( Calories2_Txt );
			CaloriePanel.add( FoodEaten3_Lbl );
			CaloriePanel.add( FoodEaten3_Txt );
			CaloriePanel.add( Calories3_Lbl );
			CaloriePanel.add( Calories3_Txt );
			CaloriePanel.add( FoodEaten4_Lbl );
			CaloriePanel.add( FoodEaten4_Txt );
			CaloriePanel.add( Calories4_Lbl );
			CaloriePanel.add( Calories4_Txt );
			CaloriePanel.add( FoodEaten5_Lbl );
			CaloriePanel.add( FoodEaten5_Txt );
			CaloriePanel.add( Calories5_Lbl );
			CaloriePanel.add( Calories5_Txt );
			
			//adds buttons to exercise entry button panel
			CalorieButtonPanel.add( ClearData );
			CalorieButtonPanel.add( AddCals );
			CalorieButtonPanel.add( EnterDisplay );
			CalorieButtonPanel.add( EnterExercise );
			CalorieButtonPanel.add( Exit );
			
			/*FoodEaten5_Txt.setText( FoodEaten4_Txt.getText() );
			FoodEaten4_Txt.setText( FoodEaten3_Txt.getText() );
			FoodEaten3_Txt.setText( FoodEaten2_Txt.getText() );
			FoodEaten2_Txt.setText( FoodEaten1_Txt.getText() );
			FoodEaten1_Txt.setText( Food_Txt.getText() );
			Calories5_Txt.setText( Calories4_Txt.getText() );
			Calories4_Txt.setText( Calories3_Txt.getText() );
			Calories3_Txt.setText( Calories2_Txt.getText() );
			Calories2_Txt.setText( Calories1_Txt.getText() );
			Calories1_Txt.setText( CaloriesConsumed_Txt.getText() );*/
			CaloriesConsumed_Txt.setText( "" );
			Food_Txt.setText( "" );
			
			this.add( CaloriePanel );
			this.add( CalorieButtonPanel, BorderLayout.SOUTH );
			CaloriePanel.setVisible( true );
			CalorieButtonPanel.setVisible( true );
		}
	}
}
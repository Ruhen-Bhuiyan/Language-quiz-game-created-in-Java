import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class Question implements ActionListener{	
	String[] questions = 	{
				"How many definite articles are in German language?",
				"How to say no in German?",
				"How to say yes in German?",
				"How to say goodbye in German?"
					
							};
	String[][] choices = 	{
				{"1","2","3","4"},
				{"Nein","nao","het","leai"},
				{"Ja","Tha","da","ioe"},
				{"Auf Wiedersehen","\r\n"
				+ "Sara mushe","addio","viszontlátásra"}
							};
	char[] answers = {
			'C',
			'A',
			'A',
			'A'
							};
	
	char tries;
	char answer;
	int index;
	int right_try =0;
	int question_number = questions.length;
	int score;
	int seconds=15;	
	JFrame theframe = new JFrame();
	JTextField thetextfield = new JTextField();
	JTextArea thetextarea = new JTextArea();
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton buttonD = new JButton();
	JLabel answerA = new JLabel();
	JLabel answerB = new JLabel();
	JLabel answerC = new JLabel();
	JLabel answerD = new JLabel();
	JLabel time_label = new JLabel();
	JLabel seconds_left = new JLabel();
	JTextField number_right = new JTextField();
	JTextField percentage = new JTextField();	
	Timer timer = new Timer(1000, new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			seconds_left.setText(String.valueOf(seconds));
			if(seconds<=0) {
				displayAnswer();
			}
			}
		});	
	public Question() {
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theframe.setSize(750,650);
		theframe.getContentPane().setBackground(new Color(250,50,50));
		theframe.setLayout(null);
		theframe.setResizable(false);	
		thetextfield.setBounds(0,0,650,50);
		thetextfield.setBackground(new Color(250,25,25));
		thetextfield.setForeground(new Color(250,255,0));
		thetextfield.setFont(new Font("Ink Free",Font.BOLD,30));
		thetextfield.setBorder(BorderFactory.createBevelBorder(1));
		thetextfield.setHorizontalAlignment(JTextField.CENTER);
		thetextfield.setEditable(false);		
		thetextarea.setBounds(0,50,650,50);
		thetextarea.setLineWrap(true);
		thetextarea.setWrapStyleWord(true);
		thetextarea.setBackground(new Color(0,25,25));
		thetextarea.setForeground(new Color(150,50,50));
		thetextarea.setFont(new Font("MV Boli",Font.BOLD,25));
		thetextarea.setBorder(BorderFactory.createBevelBorder(1));
		thetextarea.setEditable(false);		
		buttonA.setBounds(0,100,100,100);
		buttonA.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("A");
		buttonA.setBackground(new Color(0,40,250));		
		buttonB.setBounds(20,200,100,100);
		buttonB.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B");
		buttonB.setBackground(new Color(250,40,100));		
		buttonC.setBounds(40,300,100,100);
		buttonC.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");
		buttonC.setBackground(new Color(0,40,250));		
		buttonD.setBounds(60,400,100,100);
		buttonD.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("D");
		buttonD.setBackground(new Color(250,40,100));		
		answerA.setBounds(125,100,500,100);
		answerA.setBackground(new Color(50,50,50));
		answerA.setForeground(new Color(25,255,0));
		answerA.setFont(new Font("MV Boli",Font.PLAIN,35));
		answerB.setBounds(145,200,500,100);
		answerB.setBackground(new Color(50,50,50));
		answerB.setForeground(new Color(25,255,0));
		answerB.setFont(new Font("MV Boli",Font.PLAIN,35));
		answerC.setBounds(165,300,500,100);
		answerC.setBackground(new Color(50,50,50));
		answerC.setForeground(new Color(25,255,0));
		answerC.setFont(new Font("MV Boli",Font.PLAIN,35));		
		answerD.setBounds(185,400,500,100);
		answerD.setBackground(new Color(50,50,50));
		answerD.setForeground(new Color(25,255,0));
		answerD.setFont(new Font("MV Boli",Font.PLAIN,35));		
		seconds_left.setBounds(535,510,100,100);	
		seconds_left.setFont(new Font("Ink Free",Font.BOLD,60));
		seconds_left.setBorder(BorderFactory.createBevelBorder(1));
		seconds_left.setOpaque(true);
		seconds_left.setHorizontalAlignment(JTextField.CENTER);
		seconds_left.setText(String.valueOf(seconds));		
		time_label.setBounds(535,475,100,25);
		time_label.setBackground(new Color(150,150,50));
		time_label.setForeground(new Color(255,0,0));
		time_label.setFont(new Font("MV Boli",Font.PLAIN,16));
		time_label.setHorizontalAlignment(JTextField.CENTER);
		number_right.setBounds(225,225,200,100);
		number_right.setBackground(new Color(250,25,25));
		number_right.setForeground(new Color(25,255,0));
		number_right.setFont(new Font("Ink Free",Font.BOLD,50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);		
		percentage.setBounds(225,325,200,100);
		percentage.setBackground(new Color(25,25,25));
		percentage.setForeground(new Color(25,255,0));
		percentage.setFont(new Font("Ink Free",Font.BOLD,50));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);		
		theframe.add(time_label);
		theframe.add(seconds_left);
		theframe.add(answerA);
		theframe.add(answerB);
		theframe.add(answerC);
		theframe.add(answerD);
		theframe.add(buttonA);
		theframe.add(buttonB);
		theframe.add(buttonC);
		theframe.add(buttonD);
		theframe.add(thetextarea);
		theframe.add(thetextfield);
		theframe.setVisible(true);		
		nextQuestion();
	}
	
	public void nextQuestion() {		
		if(index>=question_number) {
			results();
		}
		else {
			thetextfield.setText("Question "+(index+1));
			thetextarea.setText(questions[index]);
			answerA.setText(choices[index][0]);
			answerB.setText(choices[index][1]);
			answerC.setText(choices[index][2]);
			answerD.setText(choices[index][3]);
			timer.start();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {		
			buttonA.setEnabled(false);
			buttonB.setEnabled(false);
			buttonC.setEnabled(false);
			buttonD.setEnabled(false);			
			if(e.getSource()==buttonA) {
				answer= 'A';
				if(answer == answers[index]) {
					right_try++;
				}
			}
			if(e.getSource()==buttonB) {
				answer= 'B';
				if(answer == answers[index]) {
					right_try++;
				}
			}
			if(e.getSource()==buttonC) {
				answer= 'C';
				if(answer == answers[index]) {
					right_try++;
				}
			}
			if(e.getSource()==buttonD) {
				answer= 'D';
				if(answer == answers[index]) {
					right_try++;
				}
			}
			displayAnswer();
	}
	public void displayAnswer() {		
		timer.stop();		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);		
		if(answers[index] != 'A')
			answerA.setForeground(new Color(255,0,0));
		if(answers[index] != 'B')
			answerB.setForeground(new Color(255,0,0));
		if(answers[index] != 'C')
			answerC.setForeground(new Color(255,0,0));
		if(answers[index] != 'D')
			answerD.setForeground(new Color(255,0,0));		
		Timer pause = new Timer(2000, new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {				
				answerA.setForeground(new Color(25,255,0));
				answerB.setForeground(new Color(25,255,0));
				answerC.setForeground(new Color(25,255,0));
				answerD.setForeground(new Color(25,255,0));				
				answer = ' ';
				seconds=10;
				seconds_left.setText(String.valueOf(seconds));
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
				index++;
				nextQuestion();
			}
		});
		pause.setRepeats(false);
		pause.start();
	}
	public void results(){		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);		
		score = (int)((right_try/(double)question_number)*100);		
		thetextfield.setText("RESULTS!");
		thetextarea.setText("");
		answerA.setText("");
		answerB.setText("");
		answerC.setText("");
		answerD.setText("");		
		number_right.setText("("+right_try+"/"+question_number+")");
		percentage.setText(score+"%");		
		theframe.add(number_right);
		theframe.add(percentage);		
	}
}

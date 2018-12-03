package project119;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


@SuppressWarnings("serial")
public class Sadari extends JFrame implements SadariInterFace{
	
	public STATUS mainStatus = STATUS.INIT;
	
	SadariPanel mainPanel;
	
	JPanel     inputPanel;
	JTextField inputNumber;
	JButton    startButton;
	JButton    resetButton;
	JLabel     nameLabel;
	
	public Sadari()
	{
		super("SADARI");
		mainPanel = new SadariPanel(this);
		inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout());
		inputNumber = new JTextField(1);		
		startButton = new JButton("START");
		startButton.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String text = inputNumber.getText().trim();
						if( text.equals("")) text = "0";
						int input = Integer.valueOf(text);
						if( input < 1 ) input = 1;
						if( input > 2 ) input = 2;
						mainPanel.setStartPosition(input);
						mainStatus=STATUS.DRAWING;
						mainPanel.repaint();
					}
		        });
		resetButton = new JButton("RESET");
		resetButton.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						inputNumber.setText(" ");
						mainStatus = STATUS.INIT;
						mainPanel.repaint();
					}
		        });
		nameLabel = new JLabel("B&J 도박");
		add(mainPanel);
		
		inputPanel.add(inputNumber);
		inputPanel.add(startButton);
		inputPanel.add(resetButton);
		inputPanel.add(nameLabel);
		
		add(BorderLayout.SOUTH,inputPanel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setVisible(true);
	}
	
	static Sadari sadari;
	public static void main(String[] args) throws Exception
	{
		SwingUtilities.invokeLater( new Runnable()
		{
			@Override
			public void run() {
				// TODO Auto-generated method stub
				sadari = new Sadari();
			}
		
		});
	}
}

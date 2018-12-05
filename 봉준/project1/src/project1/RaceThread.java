package project1;

import javax.swing.JLabel;

public class RaceThread extends Thread {
	
	JLabel label1;
	JLabel label2;
	JLabel label3;	
	int x1 = 100;
	int x2 = 100;
	int x3 = 100;
	
	public void run() {

		for(int i=0; i<120; i++) {
			try {
				Thread.sleep(100);
			}catch(Exception e) {
				e.printStackTrace();
			}
			x1 += (int)(Math.random() * 10);
			label1.setBounds(x1, 0, 100, 100);
			x2 += (int)(Math.random() * 10);
			label2.setBounds(x2, 0, 100, 100);
			x3 += (int)(Math.random() * 10);
			label3.setBounds(x3, 0, 100, 100);
		}
	}
}

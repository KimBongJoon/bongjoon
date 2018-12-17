package sadariGame;

import java.awt.Color;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class L extends JFrame{
	
	MyT red = new MyT("redcolor.png", 0, 0);
	
	
	
	


class MyT extends Thread {
	int x,y;
	JLabel lb;
	
	
	public MyT(String img, int x, int y) {
		this.x = x;
		this.y = y;
		
		
		lb = new JLabel();
		ImageIcon icon = new ImageIcon(img);
		lb.setIcon(icon);
		lb.setBounds(x, y,13,13);
		add(lb);
		
	}
	Random r = new Random();
	
		@Override
	public void run() {
		int random = r.nextInt(2);
		if(random == 0) {
		int a = 0;
		
		for (a = 0; a < 7; a++) {
			if(a == 0) {
				for (y = 274; y <= 321; y++) {
					lb.setBounds(325,y,13,13);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(a == 1) {
				for (x = 325; x <= 493; x++) {
					lb.setBounds(x, 321, 13, 13);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(a == 2) {
				for (y = 321; y <= 341; y++) {
					lb.setBounds(493,y,13,13);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(a == 3) {
				for (x = 493; x >= 325; x--) {
					lb.setBounds(x, 341, 13, 13);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(a == 4) {
				for (y = 341; y <= 361; y++) {
					lb.setBounds(325,y,13,13);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(a == 5) {
				for (x = 325; x <= 493; x++) {
					lb.setBounds(x, 361, 13, 13);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			if(a == 6) {
				for (y = 361; y <= 412; y++) {
					lb.setBounds(493, y, 13, 13);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			}
		} else if(random == 1) {
			int b = 0;
			
			for (b = 0;  b < 7; b++) {
				
			if(b == 0) {
				for (y = 274; y <= 321; y++) {
					lb.setBounds(493, y, 13, 13);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(b == 1) {
				for (x = 493;  x >= 325; x--) {
					lb.setBounds(x, 321, 13, 13);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(b == 2) {
				for (y = 321; y <= 341; y++) {
					lb.setBounds(325, y, 13, 13);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(b == 3) {
				for (x = 325;  x <= 493; x++) {
					lb.setBounds(x, 341, 13, 13);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(b == 4) {
				for (y = 341; y <= 361; y++) {
					lb.setBounds(493, y, 13, 13);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(b == 5) {
				for (x = 493;  x >= 325; x--) {
					lb.setBounds(x, 361, 13, 13);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(b == 6) {
				for (y = 361; y <= 412; y++) {
					lb.setBounds(325, y, 13, 13);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
		}
						
	}
			
			
	}
}
	
}
		
		public L () {
			
			getContentPane().setBackground(new Color(255, 255, 255));
			setTitle("사다리게임");
			setSize(800, 800);
			getContentPane().setLayout(null);
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon("\uC6D0\uBCF8\uC0AC\uB2E4\uB9AC.png"));
			label.setBounds(0, 0, 784, 567);
			getContentPane().add(label);
			
			JButton btnNewButton = new JButton("START");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					red.start();
					
				}
			});
			btnNewButton.setBounds(303, 576, 224, 40);
			getContentPane().add(btnNewButton);
			
			
			setVisible(true);
			
			
		}
	
		public static void main(String[] args) {
			new L();
		}
}

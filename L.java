package sadariGame;

import java.awt.Color;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class L extends JFrame{
	
	MyT red = new MyT("redcolor.png", 350, 350);
	
	
	
	


class MyT extends Thread {
	int x,y;
	JLabel lb;
	
	
	public MyT(String img, int x, int y) {
		this.x = x;
		this.y = y;
		
		
		lb = new JLabel();
		ImageIcon icon = new ImageIcon(img);
		lb.setIcon(icon);
		lb.setBounds(x, y, 30, 30);
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
				for (y = 100; y <= 150; y++) {
					lb.setBounds(100,y,30,30);
					try {
						Thread.sleep(40);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(a == 1) {
				for (x = 100; x <= 300; x++) {
					lb.setBounds(x, 200, 30, 30);
					try {
						Thread.sleep(40);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(a == 2) {
				for (y = 200; y <= 250; y++) {
					lb.setBounds(300,y,30,30);
					try {
						Thread.sleep(40);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(a == 3) {
				for (x = 300; x >= 100; x--) {
					lb.setBounds(x, 250, 30, 30);
					try {
						Thread.sleep(40);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(a == 4) {
				for (y = 250; y <= 300; y++) {
					lb.setBounds(100,y,30,30);
					try {
						Thread.sleep(40);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(a == 5) {
				for (x = 100; x <= 300; x++) {
					lb.setBounds(x, 300, 30, 30);
					try {
						Thread.sleep(40);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			}
			if(a == 6) {
				for (y = 300; y <= 350; y++) {
					lb.setBounds(300, y, 30, 30);
					try {
						Thread.sleep(40);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}else if(random == 1) {
			int b = 0;
			for (b = 0;  b < 7; b++) {
				
			
			if(b == 0) {
				for (y = 150; y <= 200; y++) {
					lb.setBounds(300, y, 30, 30);
					try {
						Thread.sleep(40);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(b == 1) {
				for (x = 300;  x >= 100; x--) {
					lb.setBounds(x, 200, 30, 30);
					try {
						Thread.sleep(40);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(b == 2) {
				for (y = 200; y <= 250; y++) {
					lb.setBounds(100, y, 30, 30);
					try {
						Thread.sleep(40);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(b == 3) {
				for (x = 100;  x <= 300; x++) {
					lb.setBounds(x, 250, 30, 30);
					try {
						Thread.sleep(40);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(b == 4) {
				for (y =250; y <= 300; y++) {
					lb.setBounds(300, y, 30, 30);
					try {
						Thread.sleep(40);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(b == 5) {
				for (x = 300;  x >= 100; x--) {
					lb.setBounds(x, 300, 30, 30);
					try {
						Thread.sleep(40);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(b == 6) {
				for (y = 300; y <= 350; y++) {
					lb.setBounds(100, y, 30, 30);
					try {
						Thread.sleep(40);
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
			
			JLabel label = new JLabel();
			getContentPane().add(label);
			setVisible(true);
			
			
		}
	
		public static void main(String[] args) {
			new L();
		}
}

package project1;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class Test {

	public static void main(String[] arg) {
		new MyFrame();
	}

}

class MyFrame extends JFrame {

	MyFrame() {
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		makeUI();
		setVisible(true);
	}

	private void makeUI() {
		MyPanel p = new MyPanel();
		add(p, BorderLayout.CENTER);
	}

}

class MyPanel extends JPanel {

	protected void paintComponent(Graphics g) {

		Graphics2D g2=(Graphics2D)g;

		g2.setStroke(new BasicStroke(3,BasicStroke.CAP_ROUND,0));
		g2.draw(new Line2D.Double(150,50,150,400));
		g2.setStroke(new BasicStroke(3,BasicStroke.CAP_ROUND,0));
		g2.draw(new Line2D.Double(300,50,300,400));

		g2.setStroke(new BasicStroke(3,BasicStroke.CAP_ROUND,0));
		int cnt = (int)(Math.random() * 3) + 2;
		int[] list = new int[cnt];
		for(int i=0; i<cnt; i++) {
			int y = (int)(Math.random() * 250) + 100;
			g2.draw(new Line2D.Double(150, y, 300, y));
			list[i] = y;
		}
		// y값 오름차순으로 정렬
		for(int i=0; i<list.length-1; i++) {
			int index = i;
			int min = list[i];
			for(int j=i+1; j<list.length; j++) {
				if(list[j] < min) {
					min = list[j];
					index = j;
				}
			}
			int temp = list[i];
			list[i] = list[index];
			list[index] = temp;
		}
		
//		g2.setColor(Color.RED);
//		g2.draw(new Line2D.Double(150, 50, 150, list[0]));
//		g2.setColor(Color.RED);
//		g2.draw(new Line2D.Double(150, list[0], 300, list[0]));
//		g2.setColor(Color.RED);
//		g2.draw(new Line2D.Double(300, list[0], 300, list[1]));
//		g2.setColor(Color.RED);
//		g2.draw(new Line2D.Double(150, list[1], 300, list[1]));
//		g2.setColor(Color.RED);
//		g2.draw(new Line2D.Double(150, list[1], 150, 400));
		
		for(int i=4; i<list[0]-42; i++) {
			g2.setColor(Color.RED);
			g2.fillOval(148, 42+i, 4, 4);			
		}
	}

}


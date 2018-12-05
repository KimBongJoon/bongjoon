package project1;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class RacingGame extends JFrame{

	MyThread snail1 = new MyThread("race1.png", 10, 25);		// 쓰레드를 사용해서 이미지 움직이기
	MyThread snail2 = new MyThread("race2.png", 10, 145);
	MyThread snail3 = new MyThread("race3.png", 10, 260);
	ArrayList<Integer> list = new ArrayList<>();
	int betMoney = 0;

	class MyThread extends Thread{

		int x,y;
		JLabel label;

		public MyThread(String img, int x, int y) {
			this.x=x;
			this.y=y;

			label = new JLabel();		// 달팽이 이미지 라벨에 집어넣기
			ImageIcon icon = new ImageIcon(img);
			label.setIcon(icon);
			label.setBounds(x, y+25, 50, 50);
			add(label);
		}

		@Override
		public void run() {

			for(x=10; x<690; x++) {		// 결승선까지
				x+=(Math.random()*5);
				label.setBounds(x, y, 100, 100);
				try {
					Thread.sleep(40);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			x = 690;
			if(y == snail1.y) {
				list.add(1);
			}
			else if(y == snail2.y) {
				list.add(2);
			}
			else if(y == snail3.y) {
				list.add(3);
			}
			if(list.size() == 3) {
				System.out.println("1등 : " + list.get(0) + "번 달팽이");
				System.out.println("2등 : " + list.get(1) + "번 달팽이");
				System.out.println("3등 : " + list.get(2) + "번 달팽이");				
			}
		}

	}

	public RacingGame() {

		getContentPane().setBackground(new Color(255, 255, 255));

		setTitle("달팽이 경주");
		setSize(800,800);
		getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Start");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(102, 51, 0));
		btnNewButton.setFont(new Font("HY목각파임B", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				snail1.start();		// 버튼 클릭시 달팽이경주 시작
				snail2.start();
				snail3.start();
			}
		});
		btnNewButton.setBounds(260, 390, 260, 50);
		getContentPane().add(btnNewButton);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 44, 784, 336);
		panel.setLayout(null);
		getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("area.jpg"));
		lblNewLabel.setBounds(0, 0, 784, 336);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setIcon(new ImageIcon("tree.PNG"));
		lblNewLabel_1.setBounds(0, 0, 94, 50);
		getContentPane().add(lblNewLabel_1);

		JLabel label = new JLabel();
		label.setIcon(new ImageIcon("tree.PNG"));
		label.setBounds(86, 0, 101, 50);
		getContentPane().add(label);

		JLabel label_1 = new JLabel();
		label_1.setIcon(new ImageIcon("tree.PNG"));
		label_1.setBounds(179, 0, 94, 50);
		getContentPane().add(label_1);

		JLabel label_2 = new JLabel();
		label_2.setIcon(new ImageIcon("tree.PNG"));
		label_2.setBounds(260, 0, 94, 50);
		getContentPane().add(label_2);

		JLabel label_3 = new JLabel();
		label_3.setIcon(new ImageIcon("tree.PNG"));
		label_3.setBounds(351, 0, 94, 50);
		getContentPane().add(label_3);

		JLabel label_4 = new JLabel();
		label_4.setIcon(new ImageIcon("tree.PNG"));
		label_4.setBounds(439, 0, 94, 50);
		getContentPane().add(label_4);

		JLabel label_5 = new JLabel();
		label_5.setIcon(new ImageIcon("tree.PNG"));
		label_5.setBounds(529, 0, 94, 50);
		getContentPane().add(label_5);

		JLabel label_6 = new JLabel();
		label_6.setIcon(new ImageIcon("tree.PNG"));
		label_6.setBounds(619, 0, 94, 50);
		getContentPane().add(label_6);

		JLabel label_7 = new JLabel();
		label_7.setIcon(new ImageIcon("tree.PNG"));
		label_7.setBounds(690, 0, 94, 50);
		getContentPane().add(label_7);
		
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\race1.png"));
		lblNewLabel_2.setBounds(0, 509, 205, 75);
		getContentPane().add(lblNewLabel_2);
		
		JLabel label_8 = new JLabel();
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\race2.png"));
		label_8.setBounds(293, 509, 205, 75);
		getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel();
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\race3.png"));
		label_9.setBounds(579, 509, 205, 75);
		getContentPane().add(label_9);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("1\uBC88 \uB2EC\uD33D\uC774");
		rdbtnNewRadioButton.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setFont(new Font("HY목각파임B", Font.PLAIN, 15));
		rdbtnNewRadioButton.setBounds(52, 590, 101, 23);
		getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton radioButton = new JRadioButton("2\uBC88 \uB2EC\uD33D\uC774");
		radioButton.setBackground(new Color(255, 255, 255));
		radioButton.setFont(new Font("HY목각파임B", Font.PLAIN, 15));
		radioButton.setBounds(344, 590, 101, 23);
		getContentPane().add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("3\uBC88 \uB2EC\uD33D\uC774");
		radioButton_1.setBackground(new Color(255, 255, 255));
		radioButton_1.setFont(new Font("HY목각파임B", Font.PLAIN, 15));
		radioButton_1.setBounds(632, 590, 101, 23);
		getContentPane().add(radioButton_1);
		
		ButtonGroup group = new ButtonGroup();	// 라디오버튼 그룹으로 묶어서 중복선택 불가.
		group.add(rdbtnNewRadioButton);
		group.add(radioButton);
		group.add(radioButton_1);
		
		rdbtnNewRadioButton.addItemListener(new ItemListener() {			
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					betMoney = Integer.parseInt(JOptionPane.showInputDialog("배팅하실 금액을 입력하세요"));
					System.out.println(betMoney);
				}
			}
		});
		
		radioButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					betMoney = Integer.parseInt(JOptionPane.showInputDialog("배팅하실 금액을 입력하세요"));
					System.out.println(betMoney);
				}
			}
		});
		
		radioButton_1.addItemListener(new ItemListener() {			
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					betMoney = Integer.parseInt(JOptionPane.showInputDialog("배팅하실 금액을 입력하세요"));
					System.out.println(betMoney);
				}
			}
		});
		
		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
		
		setVisible(true);

	}

	public static void main(String[] args) {
		new RacingGame();
	}
}
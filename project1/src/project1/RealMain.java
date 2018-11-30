package project1;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;

public class RealMain extends JFrame {
	
	Game game = new Game();
	Charge charge = new Charge();
	private JTextField textField;
	private JTextField textField_1;
	
	public RealMain() {
		setTitle("봉준희's 사설 토토방");
		getContentPane().setForeground(new Color(0, 0, 51));
		getContentPane().setBackground(new Color(51, 51, 51));
		setBackground(Color.WHITE);
		setSize(450, 700);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton();		// 충전 사진, 버튼클릭시 입금페이지로 이동
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				charge.deposit();
			}
		});
		btnNewButton.setIcon(new ImageIcon("1.gif"));
		btnNewButton.setBounds(12, 515, 406, 136);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton();		// 홀수짝수 사진
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.oddEven();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("2.gif"));
		btnNewButton_1.setBounds(12, 225, 190, 280);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton();		// 달팽이경주 사진
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.racing();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("1.PNG"));
		btnNewButton_2.setBounds(12, 135, 406, 80);
		getContentPane().add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(214, 225, 204, 280);
		panel.setLayout(null);
		getContentPane().add(panel);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setForeground(Color.RED);
		textField_1.setEditable(false);
		textField_1.setBackground(new Color(0, 0, 51));
		textField_1.setFont(new Font("휴먼모음T", Font.BOLD, 18));
		textField_1.setText("\uC2E4\uC2DC\uAC04 \uB2F9\uCCA8 \uD604\uD669");
		textField_1.setBounds(0, 0, 204, 40);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 80, 434, 38);
		panel_1.setLayout(new GridLayout());
		getContentPane().add(panel_1);
		
		JButton btnNewButton_3 = new JButton("\uC785\uAE08\uC2E0\uCCAD");	// 입금신청
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				charge.deposit();
			}
		});
		btnNewButton_3.setFont(new Font("HY엽서M", Font.PLAIN, 14));
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setBackground(new Color(204, 204, 102));
		panel_1.add(btnNewButton_3);
		
		JButton button = new JButton("\uCD9C\uAE08\uC2E0\uCCAD");	// 출금신청
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				charge.withdrawal();
			}
		});
		button.setFont(new Font("HY엽서M", Font.PLAIN, 14));
		button.setBackground(new Color(204, 204, 102));
		panel_1.add(button);
		
		JButton button_1 = new JButton("\uC785/\uCD9C\uAE08\uB0B4\uC5ED");	// 입/출급내역
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				charge.details();
			}
		});
		button_1.setFont(new Font("HY엽서M", Font.PLAIN, 14));
		button_1.setBackground(new Color(204, 204, 102));
		panel_1.add(button_1);
		
		setVisible(true);
		
		Dimension frameSize = this.getSize(); // 프레임 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2); // 화면 중앙
		
	}

	public static void main(String[] args) {
		new RealMain();
	}
	
}

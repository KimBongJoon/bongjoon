package project1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Fakelogin extends JFrame {
	
	private JLabel label_4;
	private JLabel lblNewLabel_5;
	private JLabel lblBType;
	private JLabel lblCType;
	private JLabel lblDType;
	private JLabel lblEType;
	private JLabel lblFType;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	
	public Fakelogin() {
		getContentPane().setBackground(Color.WHITE);
		setSize(655,700);
		getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Suit Shopping Mall");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 43));
		lblNewLabel_1.setBounds(22, 71, 581, 92);
		getContentPane().add(lblNewLabel_1);

		label_4 = new JLabel();
		label_4.setIcon(new ImageIcon("ssm.png"));
		label_4.setBounds(203, 42, 220, 57);
		getContentPane().add(label_4);

		lblNewLabel_5 = new JLabel("A type - 230 $");
		lblNewLabel_5.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(68, 361, 90, 15);
		getContentPane().add(lblNewLabel_5);

		lblBType = new JLabel("B type - 400 $");
		lblBType.setHorizontalAlignment(SwingConstants.CENTER);
		lblBType.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblBType.setBounds(272, 361, 90, 15);
		getContentPane().add(lblBType);

		lblCType = new JLabel("C type - 430 $");
		lblCType.setHorizontalAlignment(SwingConstants.CENTER);
		lblCType.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblCType.setBounds(475, 361, 90, 15);
		getContentPane().add(lblCType);

		lblDType = new JLabel("D type - 560 $");
		lblDType.setHorizontalAlignment(SwingConstants.CENTER);
		lblDType.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblDType.setBounds(68, 618, 90, 15);
		getContentPane().add(lblDType);

		lblEType = new JLabel("E type - 330 $");
		lblEType.setHorizontalAlignment(SwingConstants.CENTER);
		lblEType.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblEType.setBounds(272, 618, 90, 15);
		getContentPane().add(lblEType);

		lblFType = new JLabel("F type - 600 $");
		lblFType.setHorizontalAlignment(SwingConstants.CENTER);
		lblFType.setFont(new Font("굴림체", Font.PLAIN, 12));
		lblFType.setBounds(475, 618, 90, 15);
		getContentPane().add(lblFType);

		button_1 = new JButton("New button");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "상품 준비중입니다.");
			}
		});
		button_1.setIcon(new ImageIcon("suit1.jpg"));
		button_1.setBounds(42, 152, 137, 199);
		getContentPane().add(button_1);

		button_2 = new JButton("New button");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "상품 준비중입니다.");
			}
		});
		button_2.setIcon(new ImageIcon("suit2.gif"));
		button_2.setBounds(247, 152, 137, 199);
		getContentPane().add(button_2);

		button_3 = new JButton("New button");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "상품 준비중입니다.");
			}
		});
		button_3.setIcon(new ImageIcon("suit3.jpg"));
		button_3.setBounds(453, 151, 137, 199);
		getContentPane().add(button_3);

		button_4 = new JButton("New button");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "상품 준비중입니다.");
			}
		});
		button_4.setIcon(new ImageIcon("suit4.jpg"));
		button_4.setBounds(42, 409, 137, 199);
		getContentPane().add(button_4);

		button_5 = new JButton("New button");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "상품 준비중입니다.");
			}
		});
		button_5.setIcon(new ImageIcon("suit5.jpg"));
		button_5.setBounds(247, 409, 137, 199);
		getContentPane().add(button_5);

		button_6 = new JButton("New button");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "상품 준비중입니다.");
			}
		});
		button_6.setIcon(new ImageIcon("suit6.jpg"));
		button_6.setBounds(453, 409, 137, 199);
		getContentPane().add(button_6);

		setVisible(true);

		Dimension frameSize = this.getSize(); // 프레임 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2); // 화면 중앙
	}

	public static void main(String[] args) {
		new Fakelogin();
	}
	
}

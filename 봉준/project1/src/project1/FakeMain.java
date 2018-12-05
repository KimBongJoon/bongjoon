package project1;

import javax.swing.*;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPasswordField;

public class FakeMain extends JFrame implements ActionListener{
	JTextField textField;
	JButton button;
	JButton btnNewButton;
	JLabel label_4;
	JLabel lblNewLabel_5;
	JLabel lblBType;
	JLabel lblCType;
	JLabel lblDType;
	JLabel lblEType;
	JLabel lblFType;
	JButton button_1;
	JButton button_2;
	JButton button_3;
	JButton button_4;
	JButton button_5;
	JButton button_6;
	JPasswordField passwordField;
	static String memberId;	// �α��α�� ����
			
	public FakeMain() {
		getContentPane().setBackground(Color.WHITE);
		setSize(655,700);
		getContentPane().setLayout(null);

		btnNewButton = new JButton("\uB85C\uADF8\uC778");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(421, 11, 85, 23);
		getContentPane().add(btnNewButton);

		button = new JButton("\uD68C\uC6D0\uAC00\uC785");
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(518, 11, 98, 23);
		getContentPane().add(button);

		textField = new JTextField();
		textField.setBounds(68, 12, 119, 21);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setBounds(22, 15, 57, 15);
		getContentPane().add(lblNewLabel);

		JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label.setBounds(209, 15, 73, 15);
		getContentPane().add(label);

		JLabel lblNewLabel_1 = new JLabel("Suit Shopping Mall");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("������� ExtraBold", Font.PLAIN, 43));
		lblNewLabel_1.setBounds(22, 71, 581, 92);
		getContentPane().add(lblNewLabel_1);

		label_4 = new JLabel();
		label_4.setIcon(new ImageIcon("ssm.png"));
		label_4.setBounds(203, 42, 220, 57);
		getContentPane().add(label_4);

		lblNewLabel_5 = new JLabel("A type - 230 $");
		lblNewLabel_5.setFont(new Font("����ü", Font.PLAIN, 12));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(68, 361, 90, 15);
		getContentPane().add(lblNewLabel_5);

		lblBType = new JLabel("B type - 400 $");
		lblBType.setHorizontalAlignment(SwingConstants.CENTER);
		lblBType.setFont(new Font("����ü", Font.PLAIN, 12));
		lblBType.setBounds(272, 361, 90, 15);
		getContentPane().add(lblBType);

		lblCType = new JLabel("C type - 430 $");
		lblCType.setHorizontalAlignment(SwingConstants.CENTER);
		lblCType.setFont(new Font("����ü", Font.PLAIN, 12));
		lblCType.setBounds(475, 361, 90, 15);
		getContentPane().add(lblCType);

		lblDType = new JLabel("D type - 560 $");
		lblDType.setHorizontalAlignment(SwingConstants.CENTER);
		lblDType.setFont(new Font("����ü", Font.PLAIN, 12));
		lblDType.setBounds(68, 618, 90, 15);
		getContentPane().add(lblDType);

		lblEType = new JLabel("E type - 330 $");
		lblEType.setHorizontalAlignment(SwingConstants.CENTER);
		lblEType.setFont(new Font("����ü", Font.PLAIN, 12));
		lblEType.setBounds(272, 618, 90, 15);
		getContentPane().add(lblEType);

		lblFType = new JLabel("F type - 600 $");
		lblFType.setHorizontalAlignment(SwingConstants.CENTER);
		lblFType.setFont(new Font("����ü", Font.PLAIN, 12));
		lblFType.setBounds(475, 618, 90, 15);
		getContentPane().add(lblFType);

		button_1 = new JButton("New button");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "��ǰ �غ����Դϴ�.");
			}
		});
		button_1.setIcon(new ImageIcon("suit1.jpg"));
		button_1.setBounds(42, 152, 137, 199);
		getContentPane().add(button_1);

		button_2 = new JButton("New button");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "��ǰ �غ����Դϴ�.");
			}
		});
		button_2.setIcon(new ImageIcon("suit2.gif"));
		button_2.setBounds(247, 152, 137, 199);
		getContentPane().add(button_2);

		button_3 = new JButton("New button");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "��ǰ �غ����Դϴ�.");
			}
		});
		button_3.setIcon(new ImageIcon("suit3.jpg"));
		button_3.setBounds(453, 151, 137, 199);
		getContentPane().add(button_3);

		button_4 = new JButton("New button");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "��ǰ �غ����Դϴ�.");
			}
		});
		button_4.setIcon(new ImageIcon("suit4.jpg"));
		button_4.setBounds(42, 409, 137, 199);
		getContentPane().add(button_4);

		button_5 = new JButton("New button");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "��ǰ �غ����Դϴ�.");
			}
		});
		button_5.setIcon(new ImageIcon("suit5.jpg"));
		button_5.setBounds(247, 409, 137, 199);
		getContentPane().add(button_5);

		button_6 = new JButton("New button");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "��ǰ �غ����Դϴ�.");
			}
		});
		button_6.setIcon(new ImageIcon("suit6.jpg"));
		button_6.setBounds(453, 409, 137, 199);
		getContentPane().add(button_6);

		passwordField = new JPasswordField();
		passwordField.setBounds(272, 12, 137, 21);
		getContentPane().add(passwordField);

		btnNewButton.addActionListener(this);
		button.addActionListener(this);

		setVisible(true);

		Dimension frameSize = this.getSize(); // ������ ������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // ����� ������
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2); // ȭ�� �߾�
		
		String id = textField.getText();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(button == e.getSource()) {		// ȸ������ ��ư
			new JoinMembership();
		}

		if(btnNewButton == e.getSource()) {		// �α��� ��ư

			int login = 0;	// �ߺ��Ǵ� ���̵��� ����
			ArrayList userId = new ArrayList();
			ArrayList userPw = new ArrayList();
			ArrayList userNick = new ArrayList();
			String nick = null;
			memberId = textField.getText();
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BJH", "root", "1234");

				String id = "select * from member";
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(id); 
				while(rs.next()) { 
					userId.add(rs.getString(2)); 	// 2��° �� = id
					userPw.add(rs.getString(3));	// 3��° �� = pw
					userNick.add(rs.getObject(4));	// 4��° �� = nickname
				} 
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			for(int i=0; i<userId.size(); i++) {
				if(textField.getText().equals(userId.get(i)) && passwordField.getText().equals(userPw.get(i))) {	// ���� ���̵�� ��й�ȣ�� ���� �ִٸ�
					login++;																						// login 1����.
					nick = (String) userNick.get(i);																// �����г����� String���� ����
					
				}
			}
			if(login > 0) {	// login�� 0���� ũ�� ȸ��

				if(nick.length() > 5 && nick.substring(0, 6).equals("russia")) {	// �г��� ���̰� 5���� ũ�� russia�� ���۵ȴٸ�
					JOptionPane.showMessageDialog(null, nick + "�� ȯ���մϴ�.");		// RealMain�������� �̵�
					dispose();
					new RealMain();
				}
				else {
					JOptionPane.showMessageDialog(null, nick + "�� ȯ���մϴ�.");		// �Ϲ�ȸ���� FakeMain�������� �̵�
					dispose();
					new Fakelogin();
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��й�ȣ�� Ʋ���ϴ�.");
			}

		}
	}

	public static void main(String[] args) {
		new FakeMain();
	}


}
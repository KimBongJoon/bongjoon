package project1;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.*;

public class JoinMembership extends JFrame implements ItemListener {
	JTextField textField;
	JTextField textField_1;
	JTextField textField_2;
	JTextField textField_3;
	JComboBox comboBox;
	String select;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	public JoinMembership() {
		getContentPane().setBackground(Color.WHITE);	
		setSize(500, 500);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 77, 460, 324);
		getContentPane().add(panel);

		JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("굴림", Font.BOLD, 12));
		label.setBounds(12, 60, 73, 15);
		panel.add(label);

		JLabel label_1 = new JLabel("\uC774\uB984");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("굴림", Font.BOLD, 12));
		label_1.setBounds(12, 10, 73, 15);
		panel.add(label_1);

		JLabel label_2 = new JLabel("\uB2C9\uB124\uC784");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("굴림", Font.BOLD, 12));
		label_2.setBounds(12, 110, 73, 15);
		panel.add(label_2);

		JLabel label_3 = new JLabel("\uC544\uC774\uB514");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("굴림", Font.BOLD, 12));
		label_3.setBounds(12, 35, 73, 15);
		panel.add(label_3);

		JLabel label_5 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("굴림", Font.BOLD, 12));
		label_5.setBounds(12, 85, 110, 15);
		panel.add(label_5);

		JLabel label_6 = new JLabel("\uD734\uB300\uD3F0\uBC88\uD638");
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("굴림", Font.BOLD, 12));
		label_6.setBounds(12, 135, 73, 15);
		panel.add(label_6);

		JButton button_1 = new JButton("\uC911\uBCF5\uD655\uC778");
		button_1.addActionListener(new ActionListener() {		// id 중복확인
			public void actionPerformed(ActionEvent e) {

				int idCnt = 0;	// 중복되는 아이디의 갯수
				ArrayList userId = new ArrayList();	// DB에 저장되어있는 아이디를 ArrayList에 저장

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BJH", "root", "1234");

					String id = "select * from member";
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery(id); 
					while(rs.next()) { 
						userId.add(rs.getString(2)); 	// 2번째 값 = id
					} 
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				for(int i=0; i<userId.size(); i++) {	
					if(textField_1.getText().equals(userId.get(i))) {	// 만약 ArrayList에 id입력값과 일치하는 값이 들어있다면
						idCnt++;											// cnt 1증가
					}
				}
				if(idCnt > 0) {											// cnt가 0보다 크면 중복된 아이디가있기때문에 생성불가능.
					JOptionPane.showMessageDialog(null, "사용중인 아이디입니다.");
				}
				else {
					JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다.");
				}
			}
		});
		button_1.setFont(new Font("HY견고딕", Font.PLAIN, 12));
		button_1.setBackground(Color.DARK_GRAY);
		button_1.setForeground(Color.WHITE);
		button_1.setBounds(359, 31, 89, 23);
		panel.add(button_1);

		JButton button_2 = new JButton("\uC911\uBCF5\uD655\uC778");
		button_2.addActionListener(new ActionListener() {		// 닉네임 중복확인
			public void actionPerformed(ActionEvent e) {

				int nickCnt = 0;	// 중복되는 닉네임의 갯수
				ArrayList userNick = new ArrayList();	// DB에 저장되어있는 닉네임을 ArrayList에 저장

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BJH", "root", "1234");

					String nickname = "select * from member";
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery(nickname); 
					while(rs.next()) { 
						userNick.add(rs.getString(4)); 	// 4번째 값 = nickname
					} 
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				for(int i=0; i<userNick.size(); i++) {	
					if(textField_2.getText().equals(userNick.get(i))) {		// 만약 ArrayList에 닉네임 입력값과 일치하는 값이 들어있다면
						nickCnt++;											// cnt 1증가
					}
				}
				if(nickCnt > 0) {											// cnt가 0보다 크면 중복된 닉네임이있기때문에 생성불가능.
					JOptionPane.showMessageDialog(null, "사용중인 닉네임입니다.");
				} 
				else {
					JOptionPane.showMessageDialog(null, "사용 가능한 닉네임입니다.");
				}
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("HY견고딕", Font.PLAIN, 12));
		button_2.setBackground(Color.DARK_GRAY);
		button_2.setBounds(359, 106, 89, 23);
		panel.add(button_2);

		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setBackground(Color.WHITE);
		textField.setBounds(124, 7, 221, 21);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setForeground(Color.BLACK);
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(124, 32, 221, 21);
		panel.add(textField_1);

		String[] number = {"선택", "010", "011", "016", "017", "018", "019"};	// combobox에 들어갈 값

		comboBox = new JComboBox(number);
		comboBox.addItemListener(this);
		comboBox.setForeground(Color.BLACK);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(124, 132, 67, 21);
		panel.add(comboBox);

		textField_2 = new JTextField();
		textField_2.setForeground(Color.BLACK);
		textField_2.setColumns(10);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(124, 107, 221, 21);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setForeground(Color.BLACK);
		textField_3.setColumns(10);
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(197, 132, 148, 21);
		panel.add(textField_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(124, 58, 221, 18);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(124, 82, 221, 18);
		panel.add(passwordField_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("code.jpg"));
		lblNewLabel_1.setBounds(12, 174, 436, 150);
		panel.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("\uD68C\uC6D0\uAC00\uC785");		// 회원가입버튼
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("HY그래픽M", Font.BOLD, 18));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	// 회원가입버튼 클릭시

				// 만약 아이디와 닉네임 중복검사를 안하고 눌렀을 경우에도
				// 가입이 불가능하도록 회원가입버튼에서 한번더 확인
				int idCnt = 0;
				ArrayList userId = new ArrayList();
				int nickCnt = 0;	// 중복되는 닉네임의 갯수
				ArrayList userNick = new ArrayList();

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BJH", "root", "1234");

					String all = "select * from member";
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery(all); 
					while(rs.next()) { 
						userId.add(rs.getString(2));		// 아이디를 닉네임으로 체크할수도있기 때문에 따로 저장
						userNick.add(rs.getString(4));
					} 
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				for(int i=0; i<userId.size(); i++) {	
					if(textField_1.getText().equals(userId.get(i))) {
						idCnt++;
					}
				}
				for(int i=0; i<userNick.size(); i++) {	
					if(textField_2.getText().equals(userNick.get(i))) {		
						nickCnt++;											
					}
				}

				if(idCnt > 0) {
					JOptionPane.showMessageDialog(null, "사용중인 아이디입니다.");
				}
				if(nickCnt > 0) {										
					JOptionPane.showMessageDialog(null, "사용중인 닉네임입니다.");
				}
				
			

				String name = textField.getText();
				String id = textField_1.getText();
				String pw = passwordField.getText();
				String pw2 = passwordField_1.getText();		// 비밀번호 확인
				String nickname = textField_2.getText();
				String tel = select + textField_3.getText();

				if(!(pw.equals(pw2))) {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
				}
				else {
					if(idCnt == 0 && nickCnt == 0) {		// 아이디와 닉네임 중복된 수가 둘다 0일때 회원가입가능.

						try {
							Class.forName("com.mysql.jdbc.Driver");
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BJH", "root", "1234");

							String sql = "insert into member values (?, ?, ?, ?, ?)";
							PreparedStatement ps = con.prepareStatement(sql);
							ps.setString(1, name);
							ps.setString(2, id);
							ps.setString(3, pw);
							ps.setString(4, nickname);
							ps.setString(5, tel);
							
							String sql2 = "insert into charge values (?, 0)";
							PreparedStatement ps2 = con.prepareStatement(sql2);
							ps2.setString(1, id);

							ps.executeUpdate();
							ps2.executeUpdate();

							JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다");
							dispose();
						} catch (Exception e1) {
							e1.printStackTrace();
						}		
					}
				}
			}

		});
		btnNewButton.setBounds(100, 411, 128, 40);
		getContentPane().add(btnNewButton);

		JButton button = new JButton("\uCDE8\uC18C");		// 취소버튼
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int yesNo = JOptionPane.showConfirmDialog(null, "가입을 취소하시겠습니까?", null, JOptionPane.YES_NO_OPTION);
				if(yesNo == 0) {
					dispose();
				}
			}
		});
		button.setFont(new Font("HY그래픽M", Font.BOLD, 18));
		button.setForeground(Color.WHITE);
		button.setBackground(Color.DARK_GRAY);
		button.setBounds(240, 411, 128, 40);
		getContentPane().add(button);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("ssm.png"));
		lblNewLabel.setBounds(135, 10, 220, 57);
		getContentPane().add(lblNewLabel);

		setVisible(true);

		Dimension frameSize = this.getSize(); // 프레임 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2); // 화면 중앙

	}	

	public static void main(String[] args) {
		new JoinMembership();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		select = (String)comboBox.getSelectedItem();
	}
}

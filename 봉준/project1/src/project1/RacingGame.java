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
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

// 달팽이경주 페이지
public class RacingGame extends JFrame{
	
	Calendar now = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd(E) HH:mm:ss");
	String date = sdf.format(now.getTime());
	int cnt = 1;
	
	JRadioButton rdbtnNewRadioButton;
	JRadioButton radioButton;
	JRadioButton radioButton_1;
	
	FakeMain fake = null;
	ArrayList userMoney = new ArrayList<>();	// 사용자들 보유금액 리스트
	ArrayList userId = new ArrayList<>();
	int balance = 0;

	MyThread snail1 = new MyThread("race1.png", 10, 25);		
	MyThread snail2 = new MyThread("race2.png", 10, 145);
	MyThread snail3 = new MyThread("race3.png", 10, 260);
	ArrayList<Integer> list = new ArrayList<>();
	static int betMoney = 0;
	private JTextField textField;

	class MyThread extends Thread{		// Thread 사용해서 이미지 움직이기

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
			if(y == snail1.y) {		// 먼저 도착한 순서대로 list에 저장
				list.add(1);
			}
			else if(y == snail2.y) {
				list.add(2);
			}
			else if(y == snail3.y) {
				list.add(3);
			}
			if(list.size() == 3) {		// 마지막 달팽이까지 도착하면 1,2,3등 출력
				
				if(rdbtnNewRadioButton.isSelected() && list.get(0) == 1) {		// 선택한 달팽이가 1등했을때
					JOptionPane.showMessageDialog(null, "1등 : " + list.get(0) + "번 달팽이, 2등 : " + list.get(1) + "번 달팽이, 3등 : " + list.get(2) + "번 달팽이");
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BJH", "root", "1234");

						String id = "select * from charge";
						Statement stmt=con.createStatement();
						ResultSet rs=stmt.executeQuery(id); 
						while(rs.next()) {
							userId.add(rs.getString(1));
							userMoney.add(rs.getInt(2));	// charge테이블 deposit값
						}
						for(int i=0; i<userId.size(); i++) {
							if(userId.get(i).equals(fake.memberId)) {
								balance = (int)userMoney.get(i);
							}
						}

						String sql = "update charge set deposit = ? where member_id = ?";
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setInt(1, (int) (balance + betMoney * 2.5));	// 잔액 + 당첨금액을 저장
						ps.setString(2, fake.memberId);			
						ps.executeUpdate();
						balance = (int) (balance + betMoney * 2.5);
						textField.setText(String.valueOf(balance));
						
						if((betMoney * 2.5) >= 5000000) {
							try {	// 당첨금액을 파일로 저장
								FileWriter file = new FileWriter(cnt + "." + (int)(betMoney * 2.5) + "Point.txt");
								file.write(fake.memberId + "님 " + (int)(betMoney * 2.5) + "포인트 당첨!\r\n");
								file.write(date);
								file.flush();
								file.close();
								cnt++;
							} catch (IOException e) {
								e.printStackTrace();
							}
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				else if(radioButton.isSelected() && list.get(0) == 2){
					JOptionPane.showMessageDialog(null, "1등 : " + list.get(0) + "번 달팽이, 2등 : " + list.get(1) + "번 달팽이, 3등 : " + list.get(2) + "번 달팽이");
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BJH", "root", "1234");

						String id = "select * from charge";
						Statement stmt=con.createStatement();
						ResultSet rs=stmt.executeQuery(id); 
						while(rs.next()) {
							userId.add(rs.getString(1));
							userMoney.add(rs.getInt(2));	// charge테이블 deposit값
						}
						for(int i=0; i<userId.size(); i++) {
							if(userId.get(i).equals(fake.memberId)) {
								balance = (int)userMoney.get(i);
							}
						}

						String sql = "update charge set deposit = ? where member_id = ?";
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setInt(1, (int) (balance + betMoney * 2.5));	// 잔액 + 당첨금액을 저장
						ps.setString(2, fake.memberId);			
						ps.executeUpdate();
						balance = (int) (balance + betMoney * 2.5);
						textField.setText(String.valueOf(balance));
						
						if((betMoney * 2.5) >= 5000000) {
							try {	// 당첨금액을 파일로 저장
								FileWriter file = new FileWriter(cnt + "." + (int)(betMoney * 2.5) + "Point.txt");
								file.write(fake.memberId + "님 " + (int)(betMoney * 2.5) + "포인트 당첨!\r\n");
								file.write(date);
								file.flush();
								file.close();
								cnt++;
							} catch (IOException e) {
								e.printStackTrace();
							}
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				else if(radioButton_1.isSelected() && list.get(0) == 3) {
					JOptionPane.showMessageDialog(null, "1등 : " + list.get(0) + "번 달팽이, 2등 : " + list.get(1) + "번 달팽이, 3등 : " + list.get(2) + "번 달팽이");
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BJH", "root", "1234");

						String id = "select * from charge";
						Statement stmt=con.createStatement();
						ResultSet rs=stmt.executeQuery(id); 
						while(rs.next()) {
							userId.add(rs.getString(1));
							userMoney.add(rs.getInt(2));	// charge테이블 deposit값
						}
						for(int i=0; i<userId.size(); i++) {
							if(userId.get(i).equals(fake.memberId)) {
								balance = (int)userMoney.get(i);
							}
						}

						String sql = "update charge set deposit = ? where member_id = ?";
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setInt(1, (int) (balance + betMoney * 2.5));	// 잔액 + 당첨금액을 저장
						ps.setString(2, fake.memberId);			
						ps.executeUpdate();
						balance = (int) (balance + betMoney * 2.5);
						textField.setText(String.valueOf(balance));
						
						if((betMoney * 2.5) >= 5000000) {
							try {	// 당첨금액을 파일로 저장
								FileWriter file = new FileWriter(cnt + "." + (int)(betMoney * 2.5) + "Point.txt");
								file.write(fake.memberId + "님 " + (int)(betMoney * 2.5) + "포인트 당첨!\r\n");
								file.write(date);
								file.flush();
								file.close();
								cnt++;
							} catch (IOException e) {
								e.printStackTrace();
							}
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "1등 : " + list.get(0) + "번 달팽이, 2등 : " + list.get(1) + "번 달팽이, 3등 : " + list.get(2) + "번 달팽이");
				}
			}
		}

	}

	public RacingGame() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BJH", "root", "1234");

			String id = "select * from charge";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(id); 
			while(rs.next()) {
				userId.add(rs.getString(1));
				userMoney.add(rs.getInt(2));	
			}
			for(int i=0; i<userId.size(); i++) {
				if(userId.get(i).equals(fake.memberId)) {	// 로그인한 아이디의 DB에 저장된 포인트 꺼내기
					balance = (int)userMoney.get(i);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

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
				if(radioButton.isSelected() || radioButton_1.isSelected() || rdbtnNewRadioButton.isSelected()) {
					btnNewButton.setEnabled(false);
					snail1.start();		// 버튼 클릭시 달팽이경주 시작
					snail2.start();
					snail3.start();					
				}
				else {
					JOptionPane.showMessageDialog(null, "달팽이를 선택하세요");
				}
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
		lblNewLabel_2.setIcon(new ImageIcon("race1.png"));
		lblNewLabel_2.setBounds(0, 598, 205, 75);
		getContentPane().add(lblNewLabel_2);
		
		JLabel label_8 = new JLabel();
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setIcon(new ImageIcon("race2.png"));
		label_8.setBounds(294, 598, 205, 75);
		getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel();
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setIcon(new ImageIcon("race3.png"));
		label_9.setBounds(579, 598, 205, 75);
		getContentPane().add(label_9);
		
		rdbtnNewRadioButton = new JRadioButton("1\uBC88 \uB2EC\uD33D\uC774");
		rdbtnNewRadioButton.setBackground(new Color(255, 204, 153));
		rdbtnNewRadioButton.setFont(new Font("HY목각파임B", Font.PLAIN, 15));
		rdbtnNewRadioButton.setBounds(48, 679, 101, 23);
		getContentPane().add(rdbtnNewRadioButton);

		radioButton = new JRadioButton("2\uBC88 \uB2EC\uD33D\uC774");
		radioButton.setBackground(new Color(255, 204, 153));
		radioButton.setFont(new Font("HY목각파임B", Font.PLAIN, 15));
		radioButton.setBounds(344, 679, 101, 23);
		getContentPane().add(radioButton);

		radioButton_1 = new JRadioButton("3\uBC88 \uB2EC\uD33D\uC774");
		radioButton_1.setBackground(new Color(255, 204, 153));
		radioButton_1.setFont(new Font("HY목각파임B", Font.PLAIN, 15));
		radioButton_1.setBounds(631, 679, 101, 23);
		getContentPane().add(radioButton_1);
		
		ButtonGroup group = new ButtonGroup();	// 라디오버튼 그룹으로 묶어서 중복선택 불가.
		group.add(rdbtnNewRadioButton);
		group.add(radioButton);
		group.add(radioButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("\uBCF4\uC720\uC911\uC778 \uD3EC\uC778\uD2B8");
		lblNewLabel_3.setFont(new Font("HY목각파임B", Font.PLAIN, 17));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(222, 506, 175, 45);
		getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setText(String.valueOf(balance));
		textField.setBackground(new Color(255, 204, 102));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("HY목각파임B", Font.PLAIN, 17));
		textField.setEditable(false);
		textField.setBounds(393, 501, 175, 58);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel();
		lblNewLabel_4.setIcon(new ImageIcon("board.PNG"));
		lblNewLabel_4.setBounds(0, 447, 784, 314);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel();
		lblNewLabel_5.setIcon(new ImageIcon("tree2.PNG"));
		lblNewLabel_5.setBounds(0, 377, 150, 75);
		getContentPane().add(lblNewLabel_5);
		
		JLabel label_10 = new JLabel();
		label_10.setIcon(new ImageIcon("tree2.PNG"));
		label_10.setBounds(124, 377, 150, 75);
		getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel();
		label_11.setIcon(new ImageIcon("tree2.PNG"));
		label_11.setBounds(247, 377, 150, 75);
		getContentPane().add(label_11);
		
		JLabel label_12 = new JLabel();
		label_12.setIcon(new ImageIcon("tree2.PNG"));
		label_12.setBounds(371, 377, 150, 75);
		getContentPane().add(label_12);
		
		JLabel label_13 = new JLabel();
		label_13.setIcon(new ImageIcon("tree2.PNG"));
		label_13.setBounds(495, 377, 150, 75);
		getContentPane().add(label_13);
		
		JLabel label_14 = new JLabel();
		label_14.setIcon(new ImageIcon("tree2.PNG"));
		label_14.setBounds(619, 377, 150, 75);
		getContentPane().add(label_14);
		
		JLabel label_15 = new JLabel();
		label_15.setIcon(new ImageIcon("tree2.PNG"));
		label_15.setBounds(746, 378, 38, 75);
		getContentPane().add(label_15);
		
		rdbtnNewRadioButton.addItemListener(new ItemListener() {			
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					
					betMoney = Integer.parseInt(JOptionPane.showInputDialog("배팅하실 금액을 입력하세요"));
					
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BJH", "root", "1234");
						if(balance > betMoney) {
							String sql = "update charge set deposit = ? where member_id = ?";
							PreparedStatement ps = con.prepareStatement(sql);
							ps.setInt(1, balance - betMoney);	// 잔액 - 배팅금액 저장
							ps.setString(2, fake.memberId);			
							ps.executeUpdate();
							balance = balance - betMoney;
							textField.setText(String.valueOf(balance));		// 포인트 새로고침
							radioButton.setEnabled(false);
							radioButton_1.setEnabled(false);
						}
						else {
							JOptionPane.showMessageDialog(null, "포인트가 부족합니다");
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
				}
			}
		});
		
		radioButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					betMoney = Integer.parseInt(JOptionPane.showInputDialog("배팅하실 금액을 입력하세요"));
					
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BJH", "root", "1234");
						if(balance > betMoney) {
							String sql = "update charge set deposit = ? where member_id = ?";
							PreparedStatement ps = con.prepareStatement(sql);
							ps.setInt(1, balance - betMoney);	// 잔액 - 배팅금액 저장
							ps.setString(2, fake.memberId);			
							ps.executeUpdate();
							balance = balance - betMoney;
							textField.setText(String.valueOf(balance));		// 포인트 새로고침
							radioButton_1.setEnabled(false);
							rdbtnNewRadioButton.setEnabled(false);
						}
						else {
							JOptionPane.showMessageDialog(null, "포인트가 부족합니다");
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
				}
			}
		});
		
		radioButton_1.addItemListener(new ItemListener() {			
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					betMoney = Integer.parseInt(JOptionPane.showInputDialog("배팅하실 금액을 입력하세요"));
					
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BJH", "root", "1234");
						if(balance > betMoney) {
							String sql = "update charge set deposit = ? where member_id = ?";
							PreparedStatement ps = con.prepareStatement(sql);
							ps.setInt(1, balance - betMoney);	// 잔액 - 배팅금액 저장
							ps.setString(2, fake.memberId);			
							ps.executeUpdate();
							balance = balance - betMoney;
							textField.setText(String.valueOf(balance));		// 포인트 새로고침
							radioButton.setEnabled(false);
							rdbtnNewRadioButton.setEnabled(false);
						}
						else {
							JOptionPane.showMessageDialog(null, "포인트가 부족합니다");
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
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
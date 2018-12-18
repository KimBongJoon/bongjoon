package project1;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class LadderGame extends JFrame{
	
	static String result = null;
	static int betMoney = 0;
	
	FakeMain fake = null;
	ArrayList userMoney = new ArrayList<>();	// 사용자들 보유금액 리스트
	ArrayList userId = new ArrayList<>();
	int balance = 0;

	MyT red = new MyT("red.png", 257, 240);   // 내려오는 빨간점
	private JTextField textField;

	class MyT extends Thread {

		int x,y;
		JLabel lb;

		public MyT(String img, int x, int y) {   // 사진과 x축 y축

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
		public void run() {   // 쓰레드 메소드
			int random = r.nextInt(2);   // 0과 1 (왼쪽, 오른쪽)둘중하나 랜덤
			if(random == 0) {      // 0일경우 (왼쪽에서 시작)
				for (int a = 0; a < 7; a++) {
					if(a == 0) {   // (왼쪽)첫번째 칸이동
						for (y = 274; y <= 321; y++) {
							lb.setBounds(257,y,13,13);
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					if(a == 1) {   // (왼쪽)두번째 칸이동
						for (x = 257; x <= 425; x++) {
							lb.setBounds(x, 321, 13, 13);
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					if(a == 2) {   // (왼쪽)세번째 칸이동
						for (y = 321; y <= 341; y++) {
							lb.setBounds(425,y,13,13);
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					if(a == 3) {   // (왼쪽)네번째 칸이동
						for (x = 425; x >= 257; x--) {
							lb.setBounds(x, 341, 13, 13);
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					if(a == 4) {   // (왼쪽)다섯번째칸이동
						for (y = 341; y <= 361; y++) {
							lb.setBounds(257,y,13,13);
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					if(a == 5) {   // (왼쪽)여섯번째칸이동
						for (x = 257; x <= 425; x++) {
							lb.setBounds(x, 361, 13, 13);
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					if(a == 6) {   // (왼쪽)일곱번째칸이동
						for (y = 361; y <= 412; y++) {
							lb.setBounds(425, y, 13, 13);
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}
				JOptionPane.showMessageDialog(null, "결과는 [짝] 입니다");
				if(result.equals("짝")) {
					JOptionPane.showMessageDialog(null, "축하합니다! 당첨금액은 " + (int)(betMoney * 1.75) + "포인트입니다");
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
						ps.setInt(1, (int) (balance + betMoney * 1.75));	// 잔액 + 충전 금액을 저장
						ps.setString(2, fake.memberId);			
						ps.executeUpdate();
						balance = (int) (balance + betMoney * 1.75);
						textField.setText(String.valueOf(balance));

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

			else if(random == 1) {   // 1일경우 (오른쪽에서 시작)
				for (int b = 0;  b < 7; b++) {
					if(b == 0) {   // (오른쪽)첫번째 칸이동
						for (y = 274; y <= 321; y++) {
							lb.setBounds(425, y, 13, 13);
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					if(b == 1) {   // (오른쪽)두번째 칸이동
						for (x = 425;  x >= 257; x--) {
							lb.setBounds(x, 321, 13, 13);
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					if(b == 2) {   // (오른쪽)세번째 칸이동
						for (y = 321; y <= 341; y++) {
							lb.setBounds(257, y, 13, 13);
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					if(b == 3) {   // (오른쪽)네번째 칸이동
						for (x = 257;  x <= 425; x++) {
							lb.setBounds(x, 341, 13, 13);
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					if(b == 4) {   // (오른쪽)다섯번째 칸이동
						for (y = 341; y <= 361; y++) {
							lb.setBounds(425, y, 13, 13);
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					if(b == 5) {   // (오른쪽)여섯번째 칸이동
						for (x = 425;  x >= 257; x--) {
							lb.setBounds(x, 361, 13, 13);
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					if(b == 6) {   // (오른쪽)일곱번째 칸이동
						for (y = 361; y <= 412; y++) {
							lb.setBounds(257, y, 13, 13);
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}
				JOptionPane.showMessageDialog(null, "결과는 [홀] 입니다");
				if(result.equals("홀")) {
					JOptionPane.showMessageDialog(null, "축하합니다! 당첨금액은 " + (int)(betMoney * 1.75) + "포인트입니다");
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
						ps.setInt(1, (int) (balance + betMoney * 1.75));	// 잔액 + 충전 금액을 저장
						ps.setString(2, fake.memberId);			
						ps.executeUpdate();
						balance = (int) (balance + betMoney * 1.75);
						textField.setText(String.valueOf(balance));

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

	public LadderGame () {
		
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
		setTitle("사다리게임");
		setSize(730, 700);   // 화면사이즈
		getContentPane().setLayout(null);
		
		JLabel label_1 = new JLabel("\uBCF4\uC720\uC911\uC778 \uD3EC\uC778\uD2B8");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("HY목각파임B", Font.PLAIN, 17));
		label_1.setBounds(172, 600, 175, 45);
		getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setText(String.valueOf(balance));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("HY목각파임B", Font.PLAIN, 17));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(new Color(255, 204, 153));
		textField.setBounds(350, 593, 175, 58);
		getContentPane().add(textField);
		
		JButton button = new JButton("Start");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = JOptionPane.showInputDialog(null, "[홀/짝] 결과를 입력하세요");
				betMoney = Integer.parseInt(JOptionPane.showInputDialog(null, "배팅하실 금액을 입력하세요"));		
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
						button.setEnabled(false);
					}
					else {
						JOptionPane.showMessageDialog(null, "포인트가 부족합니다");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				textField.setText(String.valueOf(balance));		// 포인트 새로고침
				button.setEnabled(false);
				red.start();
			}
		});
		button.setForeground(new Color(0, 0, 0));
		button.setFont(new Font("HY목각파임B", Font.BOLD, 15));
		button.setBackground(new Color(230, 230, 250));
		button.setBounds(212, 215, 267, 50);
		getContentPane().add(button);
		
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\ladder.png"));
		label.setBounds(0, 0, 714, 567);
		getContentPane().add(label);

		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);

		setVisible(true);

	}

	public static void main(String[] args) {
		new LadderGame();
	}
}
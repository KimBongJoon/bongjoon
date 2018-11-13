package coinSing;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CoinSing implements ActionListener{

	static JButton[] btn = new JButton[15];
	static MainMachine main = new MainMachine();
	static Login log = new Login();
	static RoomMachine room = new RoomMachine();

	public static void main(String[] args) {
		
		
		System.out.println("아이디와 비밀번호를 입력하세요.");
		main.member("kbj0626", "1234");
		main.insert(10000);

		JFrame fr = new JFrame();
		fr.setTitle("코인노래방");
		fr.setSize(700, 700);
		GridLayout grid = new GridLayout(3, 5, 0, 100);
		fr.setLayout(grid);

		CoinSing c = new CoinSing();
		for(int i=0; i<btn.length; i++) {
			btn[i] = new JButton(i+1 + "번 방");
			fr.add(btn[i]);
			btn[i].addActionListener(c);
		}

		fr.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<btn.length; i++) {
			if(btn[i] == e.getSource()) {
				int yesNo = JOptionPane.showConfirmDialog(null, i+1 + "번 방을 선택하시겠습니까?", null, JOptionPane.YES_NO_OPTION);
				if(yesNo == 0) {
					room.roomCoin = Integer.parseInt(JOptionPane.showInputDialog("사용할 코인수를 입력하세요."));
					int remainCoin = main.coin - room.roomCoin;
					System.out.println("남은 코인 수 : " + remainCoin);
					btn[i].setEnabled(false);
				}
			}
		}

	}

}

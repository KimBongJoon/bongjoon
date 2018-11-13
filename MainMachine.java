package coinSing;

public class MainMachine {

	int coin = 0;
	
	public void member(String id, String pw) {
		if(id.equals("kbj0626") && pw.equals("1234")) {
			System.out.println("환영합니다!");
			System.out.println("현재 남은 코인 수 : " + coin);
		}
		else {
			System.out.println("아이디 또는 비밀번호가 다릅니다.");
			System.exit(0);
		}
	}
	
	public void insert(int money) {
		coin = money / 250;
		System.out.println("충전이 완료되었습니다.");
		System.out.println("현재 남은 코인 수 : " + coin);
	}
	
}

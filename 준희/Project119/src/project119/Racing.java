package project119;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Racing {

 public static void main(String[] args) {
  Race frame = new Race();
  
  frame.setLocation(300,100);
  frame.setSize(800,600);
  frame.setVisible(true);
  frame.addWindowListener(new WindowAdapter(){
   public void windowClosing (WindowEvent  e) {
    System.exit(1);
   }
  });
 }

}

@SuppressWarnings("serial")
class Race extends Frame implements ActionListener {
 RaceThreadx thread1;
 RaceThreadx thread2;
 RaceThreadx thread3;

 
 Button startButton = new Button("start");
// Button clearButton = new Button("초기화");
 Dimension d;
 
 int i[] = {0,0,0};
 boolean dal1=true,dal2=true,dal3=true;
 private Image img,img1,img2;
 
 public Race(){
  super("레이싱 게임");
  
  //버튼 만들어 이벤 처리
  setLayout(new BorderLayout());
  startButton.addActionListener(this);
  Panel p = new Panel();
  add("North",p);
  p.add(startButton);
  
  //쓰레드 생성
  thread1 = new RaceThreadx(this, 10, 150, 10, 50 );
  thread2 = new RaceThreadx(this, 10, 250, 10, 50 );
  thread3 = new RaceThreadx(this, 10, 350, 10, 50 );
  
  repaint();
  
  img = Toolkit.getDefaultToolkit().getImage("달팽이1.png");
  img1 = Toolkit.getDefaultToolkit().getImage("달팽이2.png");
  img2 = Toolkit.getDefaultToolkit().getImage("달팽이3.png");
  
 }
 
 public void actionPerformed(ActionEvent e){
  String str = e.getActionCommand();
  System.out.println(str);
  if(str.equals("start")){
   

   thread1.start();
   thread2.start();
   thread3.start();

  }

 }
 public void update(Graphics g){
  super.update(g);
 }
 
 public void paint(Graphics g){
  g.drawLine(750, 0, 750, 700);
  
  //1등~5등 을 판별해서 출력 처리
  for(int k=0;k<i.length;k++){
   if(thread1.x == 750 && i[k]==0&&dal1){i[k]=1;dal1=false;break;}
   else if(thread2.x == 750 && i[k]==0&&dal2){i[k]=2;dal2=false;break;}
   else if(thread3.x == 750 && i[k]==0&&dal3){i[k]=3;dal3=false;break;}
  }
  if(i[0]>0)  g.drawString("1등"+i[0]+"번 달팽이 우승",260,350);   
  if(i[1]>0) g.drawString("2등"+i[1]+"번 달팽이 준우승",260,350+20);
  if(i[2]>0) g.drawString("3등"+i[2]+"번 달팽이 ",260,350+40);
 

  //시간 출력 처리
  String date = new Date().toString();
  g.drawString(date, 20, 350);
  

  
  g.drawImage(img, thread1.x, 100, 38, 36, this);
  g.drawImage(img1, thread2.x, 150, 38, 36, this);
  g.drawImage(img2, thread3.x, 200, 38, 36, this);
  
 }
}
//쓰레드
class RaceThreadx extends Thread{
 Race frame;
 int x,y,w,h;
 
 public RaceThreadx(Race frame, int x, int y, int w, int h){
  this.frame = frame;
  this.x = x;
  this.y = y;
  this.w = w; //이 내용만 바뀐다.
  this.h = h;
 }
 
 public void run(){
  Random r = new Random(); //각 말마다 랜덤값에 의해 이동하는 거리를 다르게 주기 위해 사용
  Dimension d = frame.getSize();

  int widthLast = (int)(d.getWidth() - (2*x));
  for( ; x <= widthLast-10; x += 10){   
   frame.repaint();
   
   try{
    Thread.sleep(r.nextInt(300)+30);
   }catch(Exception e){}
  }
  frame.repaint();
 } 
}



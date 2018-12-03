package project119;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Hashtable;

import javax.swing.JPanel;


@SuppressWarnings("serial")
public class SadariPanel extends JPanel implements SadariInterFace{
	
	Sadari mainFrame;
	
	final int paddingX = 150;
	final int paddingY = 150;
	
	final int termX = 200;
	final int lengthY = 200;
	final int lineLength = 5;
	
	final int countBridge = 3; /* add Bridge Count */
	
	String nt[] = {"홀", "짝"};
	int currentDrawX;
	int currentDrawY;
	Hashtable<Integer,PointX> bridge;
	
	public SadariPanel(Sadari _mainFrame)
	{
		mainFrame = _mainFrame;
	}
	
	public void setStartPosition(int start)
	{
		currentDrawX = paddingX + (start-1)*termX;
		currentDrawY = paddingY;		
	}
	
	public void paintComponent(Graphics g)
	{
		
		if( mainFrame.mainStatus == STATUS.INIT)
		{			
			super.paintComponent(g);  /* 화면삭제 */
			/* 기본 사다리폼 */
			g.setColor(Color.BLACK);
			String[] loto = {"쌋네..쌋어!","쌋네..쌋어!"};
			loto[(int)(Math.random() * loto.length)] = "돈 땃다!!";
			for(int i=0;i<2;i++)
			{				
				g.drawString(nt[i], paddingX+i*termX, paddingY);
				g.drawLine(paddingX+i*termX, paddingY+lineLength, paddingX+i*termX, paddingY+lineLength+lengthY);
				g.drawString(loto[i], paddingX+i*termX, paddingY+lineLength+lengthY+lineLength*2);
			
				
			}
			
			bridge = new Hashtable<Integer,PointX>();
			for(int i=0;i<countBridge;i++)
			{
				int rdX = (int)(Math.random());
				int rdY = (int)(Math.random()*(lengthY-lineLength));
				
				g.drawLine(paddingX+rdX*termX, paddingY+rdY+lineLength, paddingX+rdX*termX+termX, paddingY+rdY+lineLength);
				/* 랜덤생성한 브릿지를 저장 */
				bridge.put(paddingY+rdY+lineLength, new PointX(paddingX+rdX*termX,paddingX+rdX*termX+termX));
			}

		}
		else if( mainFrame.mainStatus == STATUS.DRAWING)
		{
			g.setColor(Color.RED);
			while(currentDrawY < paddingY+lengthY+lineLength)
			{
				/* 생성된 브릿지 검색 */
				PointX value = bridge.get(currentDrawY);
				if( value != null )
				{
					/* 브릿지가 있으면 해당 X 라인인지 검색 */
					if( currentDrawX == value.startX)
					{
						g.drawLine(value.startX, currentDrawY, value.endX, currentDrawY);
						currentDrawX += termX;
					}
					else if( currentDrawX == value.endX )
					{
						g.drawLine(value.startX, currentDrawY, value.endX, currentDrawY);
						currentDrawX -= termX;
					}
				}
				g.drawLine(currentDrawX, currentDrawY, currentDrawX, ++currentDrawY);
				repaint();
			}
			
			mainFrame.mainStatus = STATUS.END;
		}
		else if( mainFrame.mainStatus == STATUS.END)
		{
			
		}
		else
		{
			
		}
		
	}
}

/* 사다리 랜덤 작대기 보관을 위한 클래스 */
class PointX
{
	public int startX;
	public int endX;
	
	public PointX(int _startX, int _endX )
	{
		startX = _startX;
		endX   = _endX;
	}
}


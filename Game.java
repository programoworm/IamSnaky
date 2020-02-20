import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.*;
public class Game extends JPanel implements KeyListener,ActionListener{
	private Timer timer;// new Timer(100, this);
	private int delay=50;
	private int inc=5;
	private int ix=26,iy=76;
	private int sx[]=new int[750];
	private int sy[]=new int[750];
	private boolean up=false;
	private boolean down=false;
	private boolean left=false;
	private boolean right=false;
	private int size=1;
	//private Graphics g;
	private void draw(int x,int y,Graphics g){
		g.setColor(Color.DARK_GRAY);
		//while(true){
		/*for(sx=sx,sy=sy;sx<(sx+4) && sy<(sy+4);sx++,sy++){
			System.out.println("Hi");
		}*/
		//timer.setInitialDelay(100);
		//timer.start();
		g.fillOval(x,y,30,30);
				//TimeUnit.SECONDS.sleep(1);	}
		
		//catch(Exception e){}
			//g.fillOval(sx+20,sy+20,30,30);
			//g.fillOval(sx+40,sy+40,30,30);
			//g.fillOval(sx+60,sy+60,30,30);
	}
	public Game(){
		sx[0]=ix;
		sy[0]=iy;
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
		timer=new Timer(delay,this);
		timer.start();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
		g.setColor(Color.BLUE);
		g.drawRect(24,10,851,55);
		g.setColor(Color.GREEN);
		g.drawRect(24,74,851,577);
		g.setColor(Color.WHITE);
		g.fillRect(25,75,850,576);
		g.setColor(Color.RED);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("SNAKE GAME by RB",270,50);
		for(int i=0;i<size;i++)
			this.draw(sx[i],sy[i],g);
		System.out.println("Running");
	}
	@Override
	public void actionPerformed(ActionEvent arg0){
		for(int i=0;i<size;i++){
			if(right)
				sx[i]=sx[i]+inc;
			else if(left)
				sx[i]=sx[i]-inc;
			else if(up)
				sy[i]=sy[i]-inc;
			else if(down)
				sy[i]=sy[i]+inc;
			if(sx[i]>840 || sy[i]>650){
				sx[0]=ix;
				sy[0]=iy;
			}
		}
		repaint();
	}
	@Override
	public void keyPressed(KeyEvent key){
		if(key.getKeyCode()==KeyEvent.VK_RIGHT){
			right=true;
			left=false;
			up=false;
			down=false;
		}
		if(key.getKeyCode()==KeyEvent.VK_LEFT){
			right=false;
			left=true;
			up=false;
			down=false;
		}
		if(key.getKeyCode()==KeyEvent.VK_UP){
			right=false;
			left=false;
			up=true;
			down=false;
		}
		if(key.getKeyCode()==KeyEvent.VK_DOWN){
			right=false;
			left=false;
			up=false;
			down=true;
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0){}
	@Override
	public void keyTyped(KeyEvent arg0){}
	 
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.*;
import java.util.Random;
public class Game extends JPanel implements KeyListener,ActionListener{
	private Timer timer;
	private int delay=200;
	private int inc=20;
	private int ix=20,iy=80;
	private int sx[]=new int[750];
	private int sy[]=new int[750];
	private boolean up=false;
	private boolean down=false;
	private boolean left=false;
	private boolean right=false;
	private int size=1;
	private int height=560,width=840;
	private Random rand=new Random();
	private int fx,fy;
	private Graphics g;
	private boolean pause=false;
	private boolean flag=false;
	private boolean ov=false;
	private void food(Graphics g){
		g.setColor(Color.RED);
		g.fillOval(fx,fy,20,20);
	}
	private void draw(int x,int y,Graphics g){
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x,y,20,20);
		//g.setColor(Color.RED);
		//g.fillOval(x+10,y+10,2,2);
	}
	private void pause(Graphics g){
		g.setColor(Color.BLACK);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("Game Paused",350,300);
	}
	private void over(Graphics g){
		//this.setBackground(Color.BLACK);
		/*g.setColor(Color.BLUE);
		g.drawRect(19,10,841,55);
		g.setColor(Color.GREEN);
		g.drawRect(19,79,841,561);
		g.setColor(Color.WHITE);
		g.fillRect(20,80,840,560);
		g.setColor(Color.RED);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("IamSnaky",350,50);*/
		g.setColor(Color.BLACK);
		g.setFont(new Font("TimesRoman", Font.BOLD, 30));
		g.drawString("Game Over",350,300);
		System.out.println("over() called");
	}
	public Game(){
		//height=576-75;
		//width=850-25;
		System.out.println("Height: "+height+" Width: "+width);
		fx=rand.nextInt((width-ix-inc)/20)*20+20;
		fy=rand.nextInt((height-iy-inc)/20)*20+80;
		sx[0]=ix;
		sy[0]=iy;
		System.out.println("fx: "+fx+" fy: "+fy);
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
		g.drawRect(19,10,841,55);
		g.setColor(Color.GREEN);
		g.drawRect(19,79,841,561);
		g.setColor(Color.WHITE);
		g.fillRect(20,80,840,560);
		g.setColor(Color.RED);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("IamSnaky",350,50);
		if(ov){
			System.out.println("Paint over");
			over(g);
		}
		if(pause){
			//System.out.println("Paused");
			pause(g);
		}
		this.food(g);
		for(int i=0;i<size;i++){
		//	System.out.println("sx["+i+"]"+sx[i]+"sy["+i+"]"+sy[i]);
			this.draw(sx[i],sy[i],g);
		}
		g.dispose();
	}
	@Override
	public void actionPerformed(ActionEvent arg0){
		//for(int i=0;i<size;i++){
			if(flag)
				size++;
			flag=false;
			int count=0;
			for(int i=1;i<size;i++){
				System.out.println("Running");
				if(sx[0]==sx[i] && sy[0]==sy[i]){
					System.out.println("Game over");
					right=false;
					left=false;
					up=false;
					down=false;
					ov=true;
					repaint();
				}
			}
			for(int i=size-1;i>0;i--){
					if(right){
			//			System.out.println("RIGHT");
						sy[i]=sy[i-1];
						sx[i]=sx[i-1]-1;
					}
					else if(left){
			//			System.out.println("LEFT");
						sy[i]=sy[i-1];
						sx[i]=sx[i-1]+1;
					}
					else if(up){
			//			System.out.println("UP");
						sx[i]=sx[i-1];
						sy[i]=sy[i-1]+1;
					}
					else if(down){
			//			System.out.println("DOWN");
						sx[i]=sx[i-1];
						sy[i]=sy[i-1]-1;
					}
					count++;
			
				//sx[i]=sx[i-1];//+20;
				//sy[i]=sy[i-1];//+20;
				}
			if(right){
				//flag=false;
				sx[0]=sx[0]+inc;
			}
			else if(left){
				//flag=false;
				sx[0]=sx[0]-inc;
			}
			else if(up){
				//flag=false;
				sy[0]=sy[0]-inc;
			}
			else if(down){
				//flag=false;
				sy[0]=sy[0]+inc;
			}
			if(sx[0]>840)
				sx[0]=ix;
			else if(sx[0]<20)
				sx[0]=840;
			else if(sy[0]>620)
				sy[0]=iy;
			else if(sy[0]<80)
				sy[0]=620;
			if(sx[0]==fx && sy[0]==fy){//sx[0]+10>=fx && sx[0]+10<=fx+10 && sy[0]+10>=fy && sy[0]+10<=fy+10){
				fx=rand.nextInt((width-ix-inc)/20)*20+20;
				fy=rand.nextInt((height-iy-inc)/20)*20+80;
				//sx[size++]=sx[size-1]+20;
				//System.out.println("sx[size-2]: "+sx[size-2]+" sx[size-1]: "+sx[size-1]);
				//sy[size++]=sy[size-1]+20;
				flag=true;
				//System.out.println("sy[size-2]: "+sy[size-2]+" sy[size-1]: "+sy[size-1]);
				System.out.println("Size: "+size);
				//System.out.println("Yes");
			}
			/*if(flag)
				for(int i=size-1;i>0;i--){
					if(right){
			//			System.out.println("RIGHT");
						sy[i]=sy[i-1];
						sx[i]=sx[i-1]-1;
					}
					else if(left){
			//			System.out.println("LEFT");
						sy[i]=sy[i-1];
						sx[i]=sx[i-1]+1;
					}
					else if(up){
			//			System.out.println("UP");
						sx[i]=sx[i-1];
						sy[i]=sy[i-1]+1;
					}
					else if(down){
			//			System.out.println("DOWN");
						sx[i]=sx[i-1];
						sy[i]=sy[i-1]-1;
					}
					count++;
			
				//sx[i]=sx[i-1];//+20;
				//sy[i]=sy[i-1];//+20;
				}*/
				System.out.println("Count: "+count);
		//}
		//System.out.println("Running");
		repaint();
	}
	@Override
	public void keyPressed(KeyEvent key){
		if(key.getKeyCode()==KeyEvent.VK_ENTER){
			//while(key.getKeyCode()==KeyEvent.VK_ENTER)
			//	continue;
			pause=true;
			right=false;
			left=false;
			up=false;
			down=false;
			System.out.println(sx[0]+" "+sy[0]);
		}
		if(key.getKeyCode()==KeyEvent.VK_RIGHT){
			if(!left||size==1){
				right=true;
				left=false;
				up=false;
				down=false;
				pause=false;
			}
			//flag=false;
		}
		if(key.getKeyCode()==KeyEvent.VK_LEFT){
			if(!right||size==1){
				right=false;
				left=true;
				up=false;
				down=false;
				pause=false;
			}
			//flag=false;
		}
		if(key.getKeyCode()==KeyEvent.VK_UP){
			if(!down||size==1){	
				right=false;
			//flag=false;
				left=false;
				up=true;
				down=false;
				pause=false;
			}
		}
		if(key.getKeyCode()==KeyEvent.VK_DOWN){
			if(!up||size==1){
				right=false;
				left=false;
			//flag=false;
				up=false;
				down=true;
				pause=false;
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0){}
	@Override
	public void keyTyped(KeyEvent arg0){}
}
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
class Main{
	public static void main(String[] args) {
		JFrame jf=new JFrame("Snake Game by RB");
		//jf.setTitle("Snake Game by RB");
		//jf.setResizable(false);
		//jf.setOpaque(true);
		//jf.setBackground(Color.BLACK);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Game game=new Game();
		jf.add(game);
		jf.setBounds(10,10,905,700);
		jf.setVisible(true);
		//Graphics g;
		//game.paintComponent(g);
	}
}
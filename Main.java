import javax.swing.JFrame;
class Main{
	public static void main(String[] args) {
		JFrame jf=new JFrame("Snake Game by RB");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Game game=new Game();
		jf.add(game);
		jf.setBounds(10,10,880,680);
		jf.setVisible(true);
	}
}
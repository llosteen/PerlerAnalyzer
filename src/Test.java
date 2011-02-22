import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Test extends Component {
	static private final String alucard = "C:\\Users\\Yuriko\\Desktop\\sprites\\alucard.gif";
	static private final String blackmage = "C:\\Users\\Yuriko\\Desktop\\sprites\\moosefftsingle.gif";
	static private JFrame frame = new JFrame("Title!");
	static private JButton button = new JButton("Change Image");
	static private BufferedImage buff;
	static private boolean isFirst = true;
	static private Test test = new Test();

	public void paint(Graphics g) {
		g.drawImage(buff, 0, 0, null);
	}
	
	

	public Dimension getPreferredSize() {
		return new Dimension(200, 200);
	}

	public Test() {
		try {
			buff = ImageIO.read(new File(alucard));
		} catch (IOException e) {
			System.out.println("You done goofed.");
		}

	}

	public static void main(final String[] args) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isFirst) {
					try {
						buff = ImageIO.read(new File(blackmage));
						isFirst = false;
						test.repaint();
					} catch (IOException ioe) {
						System.out.println("No black mage for you.");
					}
				} else {
					try {
						buff = ImageIO.read(new File(alucard));
						isFirst = true;
						test.repaint();
					} catch (IOException ioe) {
						System.out.println("No Alucard for you.");
					}
				}
			}
		});
		frame.getContentPane().add(button, BorderLayout.SOUTH);
		frame.getContentPane().add(test, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
}
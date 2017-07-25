import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class serves as a view in the MVC architecture, creating GUI components
 * for the main frame where the logic puzzle is presented to users. 
 */
public class AppFrame {

	private JFrame frame = new JFrame("Logic Puzzle");
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();

	private JLabel label1 = new JLabel();
	private JLabel label2 = new JLabel("The answer: ");

	private JTextField field = new JTextField(10);

	private JButton button = new JButton("Solve");

	private GridBagConstraints c = new GridBagConstraints();

	private PuzzleSolver solver = new PuzzleSolver();

	public void activate() {
		String text = "Three friends came first, second, and third in a prorgamming competition.\n"
				+ "Each of the three has a different first name, likes a different sport,\n"
				+ "and has a different nationality.\n"
				+ "Michale likes basketball and did better than the American in the programming\n"
				+ "competition. Simon, the Israeli, did better than the tennis player. The cricket\n"
				+ "player came first. The question is: Who is Australian?\n"
				+ "Source: <i>The Art of Prolog</i> by Ehud Shapiro and Leon Sterling";
		label1.setText("<html>" + text.replaceAll("\\n", "<br>") + "</html>");
		label1.setFont(new Font("Serif", Font.PLAIN, 20));

		frame.getContentPane().add(BorderLayout.NORTH, panel1);
		frame.getContentPane().add(BorderLayout.CENTER, panel2);

		panel1.setLayout(new GridBagLayout());
		panel2.setLayout(new GridBagLayout());

		addComponent(label1, panel1, 0, 0, 1);
		addComponent(button, panel1, 0, 1, 1);
		addComponent(label2, panel2, 0, 0, 1);
		addComponent(field, panel2, 1, 0, 1);

		button.addActionListener(new buttonListener());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 400);
		frame.setVisible(true);
	}

	// Adds an input component to a specified JPanel at a specified coordinate.
	private void addComponent(Component component, JPanel panel, int x, int y, int width) {
		c.fill = GridBagConstraints.BOTH;
		c.gridx = x;
		c.gridy = y;
		c.gridwidth = width;
		panel.add(component, c);
	}

	// Action listener for a button
	class buttonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			solver.solve();
			String result = solver.getAnswer();
			field.setText(result);
		}
	}
}

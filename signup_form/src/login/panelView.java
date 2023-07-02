package login;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;

public class panelView extends JPanel {

	/**
	 * Create the panel.
	 */
	public panelView() {
		setBackground(new Color(0, 128, 255));
		setBounds(0,0,538,396);
		setLayout(null);
		setVisible(true);
		JLabel lblNewLabel = new JLabel("View section");
		lblNewLabel.setBounds(137, 61, 177, 29);
		add(lblNewLabel);
	}

}

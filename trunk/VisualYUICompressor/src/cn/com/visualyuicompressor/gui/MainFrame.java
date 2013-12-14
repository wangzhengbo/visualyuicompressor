package cn.com.visualyuicompressor.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = -5525883509718511196L;

	public MainFrame() {
		init();

	}

	private void init() {
		setTitle("Visual YUICompressor for YUICompressor-2.4.8");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(800, 670));
		// setAlwaysOnTop(true);

		JLabel lblDescription = new JLabel();
		lblDescription
				.setText("<html><br/><font size='5'>&nbsp;&nbsp;&nbsp;<b>YUI Compressor</b> - The Yahoo! JavaScript and CSS Compressor"
						+ "<br/>&nbsp;&nbsp;&nbsp;<b>Visual YUI Compressor</b> - The Java GUI for YUI Compressor<br/></font></html>");

		getContentPane().add(lblDescription, BorderLayout.NORTH);
		getContentPane().add(new OptionPanel(), BorderLayout.WEST);
		getContentPane().add(SourcePanel.getInstance(), BorderLayout.CENTER);
		getContentPane().add(LogPanel.getInstance(), BorderLayout.SOUTH);
	}
}

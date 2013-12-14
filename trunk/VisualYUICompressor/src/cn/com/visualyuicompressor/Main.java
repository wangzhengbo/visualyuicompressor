package cn.com.visualyuicompressor;

import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.UIManager;

import cn.com.visualyuicompressor.gui.LogTextArea;
import cn.com.visualyuicompressor.gui.MainFrame;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			UIManager
					.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		} catch (Exception e1) {
			// Ignore exception
		}

		JFrame frame = new MainFrame();
		PrintStream printStream = new PrintStream(new JTextAreaOutputSteam(
				LogTextArea.getInstance()), true);
		System.setErr(printStream);
		System.setOut(printStream);
		frame.setVisible(true);
	}
}

package cn.com.visualyuicompressor.gui;

import javax.swing.JTextArea;

public class LogTextArea extends JTextArea {
	private static final long serialVersionUID = 9118390596337571024L;
	private static LogTextArea instance = null;

	private LogTextArea() {
		setCaretPosition(0);
		setRows(10);
	}

	public static LogTextArea getInstance() {
		if (instance == null) {
			instance = new LogTextArea();
		}

		return instance;
	}

	public void clear() {
		setText("");
	}
}

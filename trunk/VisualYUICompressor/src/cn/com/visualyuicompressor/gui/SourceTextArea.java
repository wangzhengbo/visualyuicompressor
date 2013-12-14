package cn.com.visualyuicompressor.gui;

import javax.swing.JTextArea;

public class SourceTextArea extends JTextArea {
	private static final long serialVersionUID = -6321740204116079597L;
	private static SourceTextArea instance = null;

	private SourceTextArea() {
		setCaretPosition(0);
		setRows(10);
	}

	public static SourceTextArea getInstance() {
		if (instance == null) {
			instance = new SourceTextArea();
		}

		return instance;
	}

	public void clear() {
		setText("");
	}
}

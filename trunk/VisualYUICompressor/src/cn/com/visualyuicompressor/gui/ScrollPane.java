package cn.com.visualyuicompressor.gui;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ScrollPane extends JScrollPane {
	private static final long serialVersionUID = -5708855185525995535L;

	public ScrollPane(final JTextArea textArea) {
		super(textArea);
		setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_ALWAYS);
		setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
		setAutoscrolls(true);
	}
}

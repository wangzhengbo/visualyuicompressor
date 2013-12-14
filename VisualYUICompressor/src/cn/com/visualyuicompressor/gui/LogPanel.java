package cn.com.visualyuicompressor.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Panel;

public class LogPanel extends Panel {
	private static final long serialVersionUID = -8954264162626787961L;
	private static LogPanel instance = null;

	private LogPanel() {
		this.setLayout(new BorderLayout());

		final Label logLabel = new Label("     Log:", LogTextArea.getInstance());
		logLabel.setFont(new Font(null, Font.BOLD, 14));
		logLabel.setVerticalAlignment(Label.BOTTOM);
		logLabel.setHeight(30);

		this.add(logLabel, BorderLayout.NORTH);
		add(LogScrollPane.getInstance(LogTextArea.getInstance()),
				BorderLayout.CENTER);
	}

	public static LogPanel getInstance() {
		if (instance == null) {
			instance = new LogPanel();
		}

		return instance;
	}
}

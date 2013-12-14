package cn.com.visualyuicompressor.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Panel;

public class SourcePanel extends Panel {
	private static final long serialVersionUID = -3941559491534224858L;
	private static SourcePanel instance = null;

	private SourcePanel() {
		setLayout(new BorderLayout());

		final Label sourceLabel = new Label(
				"     Source(Files and directories line by line):",
				SourceTextArea.getInstance());
		sourceLabel.setFont(new Font(null, Font.BOLD, 14));
		sourceLabel.setVerticalAlignment(Label.BOTTOM);
		sourceLabel.setHeight(30);

		// String tooltip = "File and directory line by line";
		// sourceLabel.setToolTipText(tooltip);
		add(sourceLabel, BorderLayout.NORTH);

		// SourceTextArea.getInstance().setToolTipText(tooltip);
		add(SourceScrollPane.getInstance(SourceTextArea.getInstance()),
				BorderLayout.CENTER);
	}

	public static SourcePanel getInstance() {
		if (instance == null) {
			instance = new SourcePanel();
		}

		return instance;
	}
}

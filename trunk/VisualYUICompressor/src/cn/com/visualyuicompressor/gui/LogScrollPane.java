package cn.com.visualyuicompressor.gui;

public class LogScrollPane extends ScrollPane {
	private static final long serialVersionUID = -4481721763280061642L;
	private static LogScrollPane instance = null;

	private LogScrollPane(final LogTextArea logTextArea) {
		super(logTextArea);
	}

	public static LogScrollPane getInstance(final LogTextArea logTextArea) {
		if (instance == null) {
			instance = new LogScrollPane(logTextArea);
		}

		return instance;
	}
}

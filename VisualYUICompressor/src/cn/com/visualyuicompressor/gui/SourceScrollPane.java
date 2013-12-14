package cn.com.visualyuicompressor.gui;

public class SourceScrollPane extends ScrollPane {
	private static final long serialVersionUID = -1817748050129102621L;
	private static SourceScrollPane instance = null;

	private SourceScrollPane(final SourceTextArea sourceTextArea) {
		super(sourceTextArea);
	}

	public static SourceScrollPane getInstance(
			final SourceTextArea sourceTextArea) {
		if (instance == null) {
			instance = new SourceScrollPane(sourceTextArea);
		}

		return instance;
	}
}

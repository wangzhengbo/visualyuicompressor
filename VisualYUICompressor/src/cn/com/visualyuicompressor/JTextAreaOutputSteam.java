package cn.com.visualyuicompressor;

import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

class JTextAreaOutputSteam extends OutputStream {
	private JTextArea textArea = null;

	public JTextAreaOutputSteam(final JTextArea textArea) {
		this.textArea = textArea;
	}

	@Override
	public void write(int b) throws IOException {
		write(new byte[] { (byte) b }, 0, 1);
	}

	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		final String text = new String(b, off, len);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				textArea.append(text);
			}
		});
	}
}

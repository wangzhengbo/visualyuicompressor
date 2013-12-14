package cn.com.visualyuicompressor.gui;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class Label extends JLabel {
	private static final long serialVersionUID = -4620889154458110127L;
	private JComponent forComponent = null;

	public Label() {
		super();
	}

	public Label(String text) {
		this("    " + text, null);
	}

	public Label(String text, final JComponent forComponent) {
		super(text);
		setForComponent(forComponent);

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				super.mouseClicked(me);

				if ((Label.this.forComponent != null)
						&& Label.this.forComponent.isFocusable()) {
					Label.this.forComponent.requestFocus();
				}
			}
		});
	}

	public void setPreferredSize(int width, int height) {
		super.setPreferredSize(new Dimension(width, height));
	}

	public void setWidth(int width) {
		this.setPreferredSize(width, (int) this.getPreferredSize().getHeight());
	}

	public void setHeight(int height) {
		this.setPreferredSize((int) this.getPreferredSize().getWidth(), height);
	}

	public JComponent getForComponent() {
		return forComponent;
	}

	public void setForComponent(JComponent forComponent) {
		this.forComponent = forComponent;
		if (forComponent != null) {
			this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		} else {
			this.setCursor(Cursor.getDefaultCursor());
		}
	}
}

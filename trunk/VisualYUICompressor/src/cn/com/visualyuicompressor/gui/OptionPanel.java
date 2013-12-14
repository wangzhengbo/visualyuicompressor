package cn.com.visualyuicompressor.gui;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import jp.co.tlt.Selfie3.guitools.TableLayout.TableLayout;
import cn.com.visualyuicompressor.gui.util.LogUtils;

public class OptionPanel extends JPanel {
	private static final long serialVersionUID = -1085894350158107763L;

	private static final int TABLE_LAYOUT_ROW_HEIGHT = 34;
	private static final int TABLE_LAYOUT_LEFT_COLUMN_WIDTH = 150;
	private static final int TABLE_LAYOUT_RIGHT_COLUMN_WIDTH = 240;

	private static final String TOOLTIP_FOR_TYPE = "Specifies the type of input file";
	private static final String TOOLTIP_FOR_CHARSET = "Read the input file using specified charset";
	private static final String TOOLTIP_FOR_LINE_BREAK = "Insert a line break after the specified column number";
	private static final String TOOLTIP_FOR_VERBOSE = "Display informational messages and warnings";
	private static final String TOOLTIP_FOR_NOMUNGE = "Minify only, do not obfuscate";
	private static final String TOOLTIP_FOR_PRESERVE_SEMI = "Preserve all semicolons";
	private static final String TOOLTIP_FOR_DISABLE_OPTIMIZATIONS = "Disable all micro optimizations";
	private static final String TOOLTIP_FOR_OUTPUT = "Place the output into specified file.";

	private static final String OUTPUT_FOR_JS = ".js$:-min.js";
	private static final String OUTPUT_FOR_CSS = ".css$:-min.css";

	public OptionPanel() {
		init();
	}

	private void init() {
		this.setSize(TABLE_LAYOUT_LEFT_COLUMN_WIDTH
				+ TABLE_LAYOUT_RIGHT_COLUMN_WIDTH + 10,
				TABLE_LAYOUT_ROW_HEIGHT * 8 + 10);

		// 使用Table布局
		final TableLayout tableLayout = new TableLayout(new Insets(5, 5, 5, 5));
		setLayout(tableLayout);

		tableLayout.addTR(TABLE_LAYOUT_ROW_HEIGHT)
				.addTD(TABLE_LAYOUT_LEFT_COLUMN_WIDTH)
				.addTD(TABLE_LAYOUT_RIGHT_COLUMN_WIDTH).repeat(9);

		final List<JComponent> javascriptOptions = new ArrayList<JComponent>();

		// type
		Label lblType = new Label("Type:");
		lblType.setToolTipText(TOOLTIP_FOR_TYPE);
		add(lblType);
		final JRadioButton radioJavaScript = new JRadioButton("javascript");
		radioJavaScript.setToolTipText(TOOLTIP_FOR_TYPE);
		radioJavaScript.setSelected(true);
		add(radioJavaScript);

		add(new JLabel());
		JRadioButton radioCss = new JRadioButton("css");
		radioCss.setToolTipText(TOOLTIP_FOR_TYPE);
		add(radioCss);

		ButtonGroup typeGroup = new ButtonGroup();
		typeGroup.add(radioJavaScript);
		typeGroup.add(radioCss);

		lblType.setForComponent(radioJavaScript);

		// charset
		Label lblCharset = new Label("Charset:");
		lblCharset.setToolTipText(TOOLTIP_FOR_CHARSET);
		add(lblCharset);

		final JComboBox cmbCharset = new JComboBox();
		cmbCharset.setToolTipText(TOOLTIP_FOR_CHARSET);
		SortedMap<String, Charset> charsets = Charset.availableCharsets();
		DefaultComboBoxModel charsetModel = new DefaultComboBoxModel();
		charsetModel.addElement("");
		for (Map.Entry<String, Charset> charsetEntry : charsets.entrySet()) {
			charsetModel.addElement(charsetEntry.getValue().displayName());
		}
		cmbCharset.setModel(charsetModel);
		cmbCharset.setSelectedItem(Charset.defaultCharset().displayName());
		add(cmbCharset);
		lblCharset.setForComponent(cmbCharset);

		// line break
		final Label lblLineBreak = new Label("Line Break:");
		lblLineBreak.setToolTipText(TOOLTIP_FOR_LINE_BREAK);
		add(lblLineBreak);

		final JTextField txtLineBreak = new JTextField();
		txtLineBreak.setToolTipText(TOOLTIP_FOR_LINE_BREAK);
		add(txtLineBreak);
		lblLineBreak.setForComponent(txtLineBreak);

		// JSpinner spinnerLineBreak = new JSpinner();
		// SpinnerNumberModel spinnerModel = new SpinnerNumberModel();
		// // spinnerModel.setValue(10);
		// // spinnerLineBreak.setModel(spinnerModel);
		// // spinnerLineBreak.setModel(model)
		// spinnerLineBreak.set
		// add(spinnerLineBreak);

		// verbose
		Label lblVerbose = new Label("Verbose:");
		lblVerbose.setToolTipText(TOOLTIP_FOR_VERBOSE);
		add(lblVerbose);

		final JCheckBox chkVerbose = new JCheckBox();
		chkVerbose.setToolTipText(TOOLTIP_FOR_VERBOSE);
		add(chkVerbose);
		lblVerbose.setForComponent(chkVerbose);

		// nomunge
		Label lblNomunge = new Label("No Obfuscate:");
		lblNomunge.setToolTipText(TOOLTIP_FOR_NOMUNGE);
		add(lblNomunge);
		javascriptOptions.add(lblNomunge);

		final JCheckBox chkNomunge = new JCheckBox();
		chkNomunge.setToolTipText(TOOLTIP_FOR_NOMUNGE);
		add(chkNomunge);
		lblNomunge.setForComponent(chkNomunge);
		javascriptOptions.add(chkNomunge);

		// preserve-semi
		Label lblPreserveSemi = new Label("Preserve Semicolons:");
		lblPreserveSemi.setToolTipText(TOOLTIP_FOR_PRESERVE_SEMI);
		add(lblPreserveSemi);
		javascriptOptions.add(lblPreserveSemi);

		final JCheckBox chkPreserveSemi = new JCheckBox();
		chkPreserveSemi.setToolTipText(TOOLTIP_FOR_PRESERVE_SEMI);
		add(chkPreserveSemi);
		lblPreserveSemi.setForComponent(chkPreserveSemi);
		javascriptOptions.add(chkPreserveSemi);

		// disable-optimizations
		Label lblDisableOptimizations = new Label("Disable Optimizations:");
		lblDisableOptimizations
				.setToolTipText(TOOLTIP_FOR_DISABLE_OPTIMIZATIONS);
		add(lblDisableOptimizations);
		javascriptOptions.add(lblDisableOptimizations);

		final JCheckBox chkDisableOptimizations = new JCheckBox();
		chkDisableOptimizations
				.setToolTipText(TOOLTIP_FOR_DISABLE_OPTIMIZATIONS);
		add(chkDisableOptimizations);
		lblDisableOptimizations.setForComponent(chkDisableOptimizations);
		javascriptOptions.add(chkDisableOptimizations);

		// o
		Label lblOutput = new Label("Output:");
		lblOutput.setToolTipText(TOOLTIP_FOR_OUTPUT);
		add(lblOutput);

		final JTextField txtOutput = new JTextField(OUTPUT_FOR_JS);
		txtOutput.setToolTipText(TOOLTIP_FOR_OUTPUT);
		add(txtOutput);
		lblOutput.setForComponent(txtOutput);

		radioJavaScript.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (JComponent component : javascriptOptions) {
					component.setVisible(true);
					// txtOutput.setText(OUTPUT_FOR_JS);
				}
			}
		});
		radioCss.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (JComponent component : javascriptOptions) {
					component.setVisible(false);
					// txtOutput.setText(OUTPUT_FOR_CSS);
				}
			}
		});

		// buttons
		add(new JLabel());

		final JButton btnCompress = new JButton("Compress");
		btnCompress.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				btnCompress.setEnabled(false);
				try {
					// btnCompress.setIcon(new
					// ImageIcon(getClass().getResource("/compressing.gif")));

					List<String> options = new ArrayList<String>();
					options.add("--type");
					if (radioJavaScript.isSelected()) {
						options.add("js");
					} else {
						options.add("css");
					}

					String charset = (String) cmbCharset.getSelectedItem();
					if ((charset != null) && !charset.isEmpty()) {
						options.add("--charset");
						options.add(charset);
					}

					String lineBreak = txtLineBreak.getText().trim();
					if (!lineBreak.isEmpty()) {
						options.add("--line-break");
						options.add(lineBreak);
					}

					if (chkVerbose.isSelected()) {
						options.add("-v");
					}

					if (radioJavaScript.isSelected()) {
						if (chkNomunge.isSelected()) {
							options.add("--nomunge");
						}

						if (chkPreserveSemi.isSelected()) {
							options.add("--preserve-semi");
						}

						if (chkDisableOptimizations.isSelected()) {
							options.add("--disable-optimizations");
						}
					}

					String output = txtOutput.getText().trim();
					if (output.isEmpty()) {
						output = radioJavaScript.isSelected() ? OUTPUT_FOR_JS
								: OUTPUT_FOR_CSS;
					}
					String[] outputPattern = output.split(":");
					if ((outputPattern.length != 2)
							|| outputPattern[0].trim().isEmpty()
							|| outputPattern[1].trim().isEmpty()) {
						LogUtils.log("Invalid Output.");
						return;
					}

					String source = SourceTextArea.getInstance().getText()
							.trim();
					if (!source.isEmpty()) {
						for (String filePath : source.split("\n")) {
							filePath = filePath.trim();
							if (!filePath.isEmpty()) {
								compress(radioJavaScript.isSelected(), options,
										outputPattern, filePath);
							}
						}
					}
				} finally {
					btnCompress.setEnabled(true);
				}
			}
		});
		add(btnCompress);
	}

	private static void compress(boolean compressJavascript,
			final List<String> options, final String[] outputPattern,
			final String filePath) {
		try {
			File file = new File(filePath);

			if (file.isDirectory()) {
				File[] files = file.listFiles();
				for (File f : files) {
					compress(compressJavascript, options, outputPattern,
							f.getAbsolutePath());
				}
			} else {
				if (!file.exists()) {
					LogUtils.log("File " + file.getAbsolutePath()
							+ " dose not exists.");
					return;
				}

				if (compressJavascript) {
					if (!file.getName().endsWith(".js")
							|| file.getName().endsWith("-min.js")) {
						return;
					}
				} else {
					if (!file.getName().endsWith(".css")
							|| file.getName().endsWith("-min.css")) {
						return;
					}
				}

				if (!file.canRead()) {
					LogUtils.log("File " + file.getAbsolutePath()
							+ " can not read.");
					return;
				}

				List<String> args = new ArrayList<String>(options);
				args.add("-o");
				// if (compressJavascript) {
				// args.add(file.getAbsolutePath().substring(0,
				// file.getAbsolutePath().length() - 3)
				// + "-min.js");
				// } else {
				// args.add(file.getAbsolutePath().substring(0,
				// file.getAbsolutePath().length() - 4)
				// + "-min.css");
				// }
				args.add(file.getAbsolutePath().replaceFirst(outputPattern[0],
						outputPattern[1]));
				args.add(file.getAbsolutePath());
				String[] argsArray = new String[args.size()];
				args.toArray(argsArray);

				LogUtils.log("Begin compress " + file.getAbsolutePath());
				com.yahoo.platform.yui.compressor.Bootstrap.main(argsArray);
			}
		} catch (Exception e) {
			// LogUtils.log(e);
		}
	}
}

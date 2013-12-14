package cn.com.visualyuicompressor.gui.util;

import cn.com.visualyuicompressor.gui.LogTextArea;

public final class LogUtils {
	private static LogTextArea logTextArea = LogTextArea.getInstance();

	private LogUtils() {
		// Empty
	}

	public static void log(String message) {
		log(message, false);
	}

	public static void log(final Exception e) {
		log(e, false);
	}

	public static void log(String message, boolean logToConsole) {
		if (message != null) {
			if (logToConsole) {
				System.out.println(message);
			} else {
				logTextArea.append(message);
				logTextArea.append("\n");
			}
		}
	}

	public static void log(final Exception e, boolean logToConsole) {
		if (e != null) {
			log(e.getMessage(), logToConsole);
		}
	}
}

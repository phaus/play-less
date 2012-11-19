package play.modules.less;

import java.io.File;
import java.io.FileFilter;

public class LessScanner {
	private final static String LESS_ASSETS_PATH = "app" + File.separator
			+ "assets" + File.separator + "stylesheets";

	public static File[] getFiles() {
		File rootDir = new File(LESS_ASSETS_PATH);
		if (rootDir.exists()) {
			return rootDir.listFiles(new LessFilter());
		}
		return new File[] {};
	}

	private static class LessFilter implements FileFilter {
		@Override
		public boolean accept(File pathname) {
			if (pathname.getName().endsWith("less")) {
				return true;
			}
			return false;
		}

	}
}

package play.modules.less;

import java.io.File;
import java.io.IOException;

import play.Logger;

import com.asual.lesscss.LessEngine;
import com.asual.lesscss.LessException;

public class LessCompiler {
	private final static String LESS_PUBLIC_PATH = "public" + File.separator
			+ "stylesheets";

	public static void compileCSS() {
		// Instantiates a new LessEngine
		LessEngine engine = new LessEngine();
		String cssName = "";
		try {
			for (File lessFile : LessScanner.getFiles()) {
				cssName = LESS_PUBLIC_PATH + File.separator
						+ lessFile.getName().replace(".less", ".css");
				Logger.debug("compiling " + lessFile.getAbsolutePath() + " to "
						+ cssName);
				engine.compile(lessFile, new File(cssName));

			}
		} catch (LessException ex) {
			Logger.error(ex, ex.getLocalizedMessage());
		} catch (IOException ex) {
			Logger.error(ex, ex.getLocalizedMessage());
		}
	}
}

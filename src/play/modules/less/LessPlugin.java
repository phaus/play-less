package play.modules.less;

import play.PlayPlugin;

public class LessPlugin extends PlayPlugin {
    public void onApplicationStart() {
		LessCompiler.compileCSS();
	}
    public void detectChange() {
		LessCompiler.compileCSS();    
    }	
}

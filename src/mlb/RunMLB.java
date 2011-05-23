package mlb;

import mlb.gui.MLBFrame;

public class RunMLB {

	MLBFrame guiFrame;
	
	public RunMLB() {
		guiFrame = new MLBFrame();
	}
	
	public static void main(String[] args) {
		new RunMLB();
	}

}

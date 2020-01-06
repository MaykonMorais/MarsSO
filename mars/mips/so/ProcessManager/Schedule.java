package mars.mips.so.ProcessManager;

import mars.mips.so.ProcessManager.*;
import mars.mips.so.ProcessManager.ProcessTable;

public class Schedule {
	
	public static boolean router() {
		if(ProcessTable.getRunning() != null) { // exists running process
			ProcessTable.getProcessListReady().add(ProcessTable.getRunning()); // get process runinnig and add on List Process ready 
		}
		if(ProcessTable.getProcessListReady().size() > 0) {
			ProcessTable.getProcessListReady().get(0).setStateProcess("running");
			ProcessTable.setRunning(ProcessTable.getProcessListReady().remove(0));
			return true;
		}
		return false;
	}
}

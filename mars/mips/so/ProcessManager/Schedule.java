package mars.mips.so.ProcessManager;

import mars.mips.so.ProcessManager.ProcessTable;

public class Schedule {
	
	public static boolean escalonar() {
		if(ProcessTable.getRunning() != null) { // exists running process
			ProcessTable.getProcessListReady().add(ProcessTable.getRunning()); // get process runnning and add on List Process ready 
		}
		if(ProcessTable.getProcessListReady().size() > 0) {
			ProcessTable.getProcessListReady().get(0).setStateProcess("running"); // mudando o estado do processo para excutando
			ProcessTable.setRunning(ProcessTable.getProcessListReady().remove(0)); // retirando da lista de processo de prontos
			return true;
		}
		return false;
	}
}

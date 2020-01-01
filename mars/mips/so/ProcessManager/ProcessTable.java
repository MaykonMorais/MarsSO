package mars.mips.so.ProcessManager;

import java.util.Queue;
import java.util.LinkedList;

public class ProcessTable {
	public ProcessControlBlock running; 
	
	public static LinkedList<ProcessControlBlock> readyProcesses = new LinkedList<ProcessControlBlock>();
	
	public ProcessControlBlock newPCB(int endInit, int pid, int stateProcess) {
		ProcessControlBlock pcb = new ProcessControlBlock(endInit, pid, stateProcess);
		
		return pcb;
	}
	
	public static void addProcess(ProcessControlBlock process) {
		readyProcesses.add(process);
	}
	
	public ProcessControlBlock getRunning() {
		return running;
	}

	public void setRunning(ProcessControlBlock running) {
		this.running = running;
	}
	
}

package mars.mips.so.ProcessManager;

import java.util.Queue;
import java.util.LinkedList;

public class ProcessTable {
	public static ProcessControlBlock running; 
	
	// lista de processos prontos
	public static LinkedList<ProcessControlBlock> readyProcesses = new LinkedList<ProcessControlBlock>();
	
	public static ProcessControlBlock newProcess(int id, int end, int priority) {
		ProcessControlBlock pcb = new ProcessControlBlock();
		
		pcb.setPriority(priority);
		pcb.setStateProcess(1);
		pcb.setSup(id);
		pcb.setInf(end);
		
		return pcb;
	}
	
	public static void addProcess(ProcessControlBlock process) {
		readyProcesses.add(process);
	}
	
	public ProcessControlBlock getRunning() {
		return running;
	}

	public static void setRunning(ProcessControlBlock running) {
		running = running;
	}
	
}

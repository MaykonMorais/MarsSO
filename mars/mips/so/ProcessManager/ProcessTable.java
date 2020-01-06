package mars.mips.so.ProcessManager;

import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import mars.mips.hardware.RegisterFile;
import mars.mips.so.ProcessManager.ProcessControlBlock;

public class ProcessTable {
	
	private static ProcessControlBlock running;
	private static List<ProcessControlBlock> processListReady = new ArrayList<ProcessControlBlock>();
	
	
	public ProcessTable(ProcessControlBlock process) {
		ProcessTable.running = process; 
	}
	
	public static ProcessControlBlock getRunning() {
		return running;
	}

	public static void setRunning(ProcessControlBlock running) {
		ProcessTable.running = running;
	}

	public static List<ProcessControlBlock> getProcessListReady() {
		return processListReady;
	}
	public static void setProcessListReady(List<ProcessControlBlock> processListReady) {
		ProcessTable.processListReady = processListReady;
	} 
	
	public static void newProcess(ProcessControlBlock process) {
		processListReady.add(process);
	}
	
	
	public static void processChange() {
		
		if(running != null) {
			running.setStateProcess("ready");
			running.setInitAdress(RegisterFile.getProgramCounter());
			running.getContexto().clear();
			for(int i = 0; i < RegisterFile.getRegisters().length; i++) {
				running.getContexto().add(RegisterFile.getValue(i));
			}
			running.getContexto().add(RegisterFile.getValue(33));
			running.getContexto().add(RegisterFile.getValue(34));
		}
		
		// adicionar switch se for  pedido outros tipos de prioridades
		if(Schedule.router()) {
			RegisterFile.setProgramCounter(running.getInitAdress());
			for(int i = 0;  i < running.getContexto().size(); i++) {
				RegisterFile.updateRegister(i, running.getContexto().get(i));
			}
		}
	}
	
	/*public static ProcessControlBlock running; 
	
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
	*/
}

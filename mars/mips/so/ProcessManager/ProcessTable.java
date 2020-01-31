package mars.mips.so.ProcessManager;

import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import mars.mips.hardware.RegisterFile;
import mars.mips.so.ProcessManager.ProcessControlBlock;

public class ProcessTable {
	
	private static ProcessControlBlock running; // processo em execucao
	// lista de processos prontos
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
			running.setStateProcess("ready"); // mudando meu estado
			running.setInitAdress(RegisterFile.getProgramCounter());
			running.getContexto().clear();
			running.copyRegistersToPCB(); // salvando meus registradores
			
		}
		
		// adicionar switch se for  pedido outros tipos de prioridades
		
		if(Schedule.escalonar()) {
			RegisterFile.setProgramCounter(running.getInitAdress());
			running.pcbToRegister();
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

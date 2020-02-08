package mars.mips.so.ProcessManager;

import java.util.ArrayList;
import java.util.List;

import mars.mips.hardware.RegisterFile;


// armazenar todas as informações de contexto de um processo:
public class ProcessControlBlock implements Comparable<ProcessControlBlock>{ 
	
	private static List<Integer> contexto = new ArrayList<Integer>();
	private int initAdress; // adress process running (pc)
	
	private int startAdress;  
	private int endAdress; 
	
	private int pid;
	private String stateProcess;
	private int priority;
	
	private int priorityMax;
	private int priorityMin;
	
	private int timeExec; 
	
	/* Construtores */
	public ProcessControlBlock() {
		
	}
	
	// usar este construtor (por enquanto)
	public ProcessControlBlock(int pc, int fim, int priority, List<Integer> context) {
		setInitAdress(pc);
		
		// registradores limite
		setStartAdress(pc);
		setEndAdress(fim);  
		
		setStateProcess("ready");
		
		//setPid(pid);
		setPriority(priority);
		setContexto(context);
		//this.timeExec = 0;		
	}
	
	public ProcessControlBlock(int initAdress, int pid, String stateProcess, int priority, List<Integer> context) {
		setInitAdress(initAdress);
		setPid(pid);
		setStateProcess(stateProcess);
		setPriority(priority);
		setContexto(context);		
	}
	
	public List<Integer> getContexto() {
		return contexto;
	}


	public void setContexto(List<Integer> contexto) {
		this.contexto = contexto;
	}


	public int getInitAdress() {
		return initAdress;
	}


	public void setInitAdress(int initAdress) {
		this.initAdress = initAdress;
	}


	public int getStartAdress() {
		return startAdress;
	}


	public void setStartAdress(int startAdress) {
		this.startAdress = startAdress;
	}


	public int getEndAdress() {
		return endAdress;
	}


	public void setEndAdress(int endAdress) {
		this.endAdress = endAdress;
	}


	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public String getStateProcess() {
		return stateProcess;
	}


	public void setStateProcess(String stateProcess) {
		this.stateProcess = stateProcess;
	}


	public int getPriority() {
		return priority;
	}


	public void setPriority(int priority) {
		this.priority = priority;
	}


	public int getPriorityMax() {
		return priorityMax;
	}


	public void setPriorityMax(int priorityMax) {
		this.priorityMax = priorityMax;
	}


	public int getPriorityMin() {
		return priorityMin;
	}


	public void setPriorityMin(int priorityMin) {
		this.priorityMin = priorityMin;
	}


	public int getTimeExec() {
		return timeExec;
	}


	public void setTimeExec(int timeExec) {
		this.timeExec = timeExec;
	}
	/*                                    */
	
	public void copyRegistersToPCB() { // Para copiar o conteúdo dos registradores físicos do hardware para a PCB
		for(int i = 0; i < 32; i++)  {
			contexto.add(RegisterFile.getValue(i));
		}
		// hi lo
		contexto.add(RegisterFile.getValue(33));
		contexto.add(RegisterFile.getValue(34));	
	}
	
	// para copiar da PCB para os registradores físicos
	public void pcbToRegister() {
		for (int i = 0; i < contexto.size(); i++) {
			RegisterFile.updateRegister(i, contexto.get(i));
		}
	}
	
	@Override
	public int compareTo(ProcessControlBlock arg0) {
		if(this.priority < arg0.getPriority()) {
			return 1;
		}
		else if(this.priority > arg0.getPriority()) {
			return -1;
		}
		else {
			return 0;
		}
	} 	
}

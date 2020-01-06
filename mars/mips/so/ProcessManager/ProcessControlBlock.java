package mars.mips.so.ProcessManager;

import java.util.List;

import javax.management.ConstructorParameters;

import mars.mips.hardware.RegisterFile;

public class ProcessControlBlock implements Comparable<ProcessControlBlock>{ 
	
	private List<Integer> contexto;
	private int initAdress; // adress process running (pc)
	
	private int startAdress; 
	private int endAdress; 
	private int pid;
	private String stateProcess;
	private int priority;
	
	private int priorityMax;
	private int priorityMin;
	
	
	private int timeExec;
	
	public ProcessControlBlock(int initAdress, int endAdress, int pid, String stateProcess, int priority, int priorityMax, int priorityMin, List<Integer> context) {
		
		setInitAdress(initAdress);
		setStartAdress(initAdress);
		setStateProcess(stateProcess);
		setEndAdress(endAdress);
		setPid(pid);
		setPriority(priority);
		setContexto(context);
		setPriorityMax(priorityMax);
		setPriorityMin(priorityMin);
		this.timeExec = 0;		
	}

	public ProcessControlBlock(int initAdress, int pid, String stateProcess, List<Integer> context) {
		
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

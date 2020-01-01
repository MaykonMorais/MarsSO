package mars.mips.so.ProcessManager;

import mars.mips.hardware.RegisterFile;

public class ProcessControlBlock {
	
	private int [] regs = new int[32]; // conteudo do registrador
	
	private int endInit; // endereco do inicio do programa
	private int pid; // indentificacao do processo
	private int stateProcess; 
	
	public ProcessControlBlock(int endInit, int pid, int stateProcess) {
		setEndInit(endInit);
		setPid(pid);
		setStateProcess(stateProcess);
	}
	
	// methods
	public void copyRegToPcb() {
		int sizeRegisters = 32;
		for(int i = 0; i < sizeRegisters; i++) {
			this.regs[i] = RegisterFile.getValue(i);
		}
	}
	
	public void copyPcbToReg() {
		int sizeRegisters = 32;
		for(int i = 0; i < sizeRegisters; i++) { 
			RegisterFile.updateRegister(i, this.regs[i]); 
		}
	}
	
	
	public int getEndInit() {
		return endInit;
	}
	public void setEndInit(int endInit) {
		this.endInit = endInit;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getStateProcess() {
		return stateProcess;
	}
	public void setStateProcess(int stateProcess) {
		this.stateProcess = stateProcess;
	} 
	
	
	
}

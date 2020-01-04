package mars.mips.so.ProcessManager;

import javax.management.ConstructorParameters;

import mars.mips.hardware.RegisterFile;

public class ProcessControlBlock {
	
	private int [] regs = new int[32]; // conteudo do registrador
	
	private int pid; // indentificacao do processo
	private int stateProcess; // 1 - running 2 - stopped 3 - blocked 
	private int priority;
	private static int pc;
	private int inf; // endereco do inicio do programa
	
	public int getInf() {
		return inf;
	}

	public void setInf(int inf) {
		this.inf = inf;
	}

	private int sup; 
	
	
	public static int getPc() {
		return pc;
	}

	public static void setPc(int pc) {
		pc = pc;
	}
	
	
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
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
	
	// methods
		
		//get
		public void copyRegToPcb() {
			int sizeRegisters = 32;
			for(int i = 0; i < sizeRegisters; i++) {
				this.regs[i] = RegisterFile.getValue(i);
			}
		}
		
		// set
		public void copyPcbToReg() {
			int sizeRegisters = 32;
			for(int i = 0; i < sizeRegisters; i++) { 
				RegisterFile.updateRegister(i, this.regs[i]); 
			}
			RegisterFile.setProgramCounter(getPc());
		}

		public int getSup() {
			return sup;
		}

		public void setSup(int sup) {
			this.sup = sup;
		}
	
}

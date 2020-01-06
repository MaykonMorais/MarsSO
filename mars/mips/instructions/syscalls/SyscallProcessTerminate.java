package mars.mips.instructions.syscalls;

import mars.ProcessingException;
import mars.ProgramStatement;
import mars.mips.so.ProcessManager.ProcessTable;
import mars.util.SystemIO;
import mars.mips.instructions.syscalls.SyscallProcessChange;

public class SyscallProcessTerminate extends AbstractSyscall {

	public SyscallProcessTerminate() {
		super(21, "SyscallProcessTerminate");
	}

	@Override
	public void simulate(ProgramStatement statement) throws ProcessingException {
		terminateProcess();
	}
	
	public void terminateProcess() {
		ProcessTable.setRunning(null);
		
		ProcessTable.processChange();
		SystemIO.printString("Processo Finalizado!!\n");
	}
}

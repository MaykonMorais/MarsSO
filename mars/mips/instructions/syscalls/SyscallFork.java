package mars.mips.instructions.syscalls;

import mars.ProcessingException;
import mars.ProgramStatement;
import mars.mips.so.ProcessManager.*;
import mars.mips.hardware.RegisterFile;

public class SyscallFork extends AbstractSyscall {

	public SyscallFork() {
		super(19, "SyscallFork");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void simulate(ProgramStatement statement) throws ProcessingException {
		// using $k0 and $k1 to save any details (end, priority)
		createProcess(RegisterFile.getValue(4), RegisterFile.getValue(26), RegisterFile.getValue(27));
	}
	
	public void createProcess(int id, int end, int priority) {
		ProcessTable.addProcess(ProcessTable.newProcess(id, end, priority));
	}
}

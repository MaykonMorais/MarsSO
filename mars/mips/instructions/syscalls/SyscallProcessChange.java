package mars.mips.instructions.syscalls;

import mars.ProcessingException;
import mars.ProgramStatement;
import mars.mips.hardware.RegisterFile;
import mars.mips.so.ProcessManager.ProcessTable;
import mars.mips.so.ProcessManager.Schedule;

/* swap process that running in the cpu */
public class SyscallProcessChange extends AbstractSyscall{

	public SyscallProcessChange() {
		super(20, "SyscallProcessChange");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void simulate(ProgramStatement statement) throws ProcessingException {
		ProcessTable.processChange();		
	}
}

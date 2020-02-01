package mars.mips.instructions.syscalls;

import mars.ProcessingException;
import mars.ProgramStatement;
import mars.mips.hardware.RegisterFile;
import mars.mips.so.ProcessManager.ProcessTable;
import mars.mips.so.ProcessManager.Schedule;
import mars.util.SystemIO;

/* swap process that running in the cpu */
public class SyscallProcessChange extends AbstractSyscall{

	public SyscallProcessChange() {
		super(20, "SyscallProcessChange");
	}

	@Override
	public void simulate(ProgramStatement statement) throws ProcessingException {
		System.out.println("Tipo de escalonamento: " + ProcessTable.getTypeScheduler());

		ProcessTable.processChange(ProcessTable.getTypeScheduler());
		
		SystemIO.printString("Processo Escalonado!\n");
	}
}

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
		swap();		
	}
	
	public static void swap() {
		
		if(ProcessTable.running != null) {
			// salvar contexto atual
			
			ProcessTable.running.copyRegToPcb();
			ProcessTable.running.setPc(RegisterFile.getProgramCounter());
			
			// adicionar novo processo 
			ProcessTable.addProcess(ProcessTable.running);
			ProcessTable.setRunning(Schedule.escalonar());
			
			if(ProcessTable.running == null) {
				return;
			}
			
			ProcessTable.running.setStateProcess(2); // state ready
			ProcessTable.running.copyPcbToReg();
			}
		
			else { 
				ProcessTable.setRunning(Schedule.escalonar());
				ProcessTable.running.setStateProcess(3); // 3 bloqueado
				
				ProcessTable.running.copyPcbToReg();
			}
		}
	}
	

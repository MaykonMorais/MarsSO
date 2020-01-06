package mars.mips.instructions.syscalls;

import java.util.ArrayList;
import java.util.List;

import mars.ProcessingException;
import mars.ProgramStatement;
import mars.mips.so.ProcessManager.*;
import mars.util.SystemIO;
import mars.mips.hardware.RegisterFile;

public class SyscallFork extends AbstractSyscall {

	public SyscallFork() {
		super(19, "SyscallFork");
	}

	@Override
	public void simulate(ProgramStatement statement) throws ProcessingException {
		createProcess();
	}
	
	public void createProcess() {
		List<Integer> registers = new ArrayList<Integer>();
		
		for(int i = 0; i < RegisterFile.getRegisters().length; i++) {
			registers.add(RegisterFile.getValue(i));
		}
		registers.add(RegisterFile.getValue(33));
		registers.add(RegisterFile.getValue(34));
		
		
		ProcessTable.newProcess(new ProcessControlBlock(RegisterFile.getUserRegister("$a0").getValue(), 
				RegisterFile.getUserRegister("$a1").getValue(), RegisterFile.getUserRegister("$a0").getValue(), "ready", RegisterFile.getUserRegister("$v1").getValue(), RegisterFile.getUserRegister("$a2").getValue(),
				RegisterFile.getUserRegister("$a3").getValue(), registers));
		
		SystemIO.printString("Processo adicionado com sucesso: " + RegisterFile.getUserRegister("$a0").getValue() + "\n");
	}
}

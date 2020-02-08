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
	
	public void createProcess() { // criando meu processo
		//List<Integer> context = new ArrayList<Integer>();
		
		ProcessControlBlock contexto = new ProcessControlBlock(); // criando pcb para o novo processo
		
		//contexto.copyRegistersToPCB(); // salvando contexto
		contexto.copyRegistersToPCB();
		
		/*ProcessTable.newProcess(new ProcessControlBlock(RegisterFile.getUserRegister("$a0").getValue(), 
				RegisterFile.getUserRegister("$a1").getValue(), RegisterFile.getUserRegister("$a0").getValue(), "ready", RegisterFile.getUserRegister("$v1").getValue(), RegisterFile.getUserRegister("$a2").getValue(),
				RegisterFile.getUserRegister("$a3").getValue(), registers));*/
		
		/*
		 Adicionando processo na tabela de processo
		 $a0 = label, $a1 = fim da funcao, $v1= prioridade
		*/
		
		
		ProcessTable.newProcess(new ProcessControlBlock(RegisterFile.getUserRegister("$a0").getValue(), RegisterFile.getUserRegister("$a1").getValue(), RegisterFile.getUserRegister("$v1").getValue(), contexto.getContexto()));
		
		// calculando endereço final 
		//ProcessTable.calculateEndAdress(ProcessTable.getProcessListReady());
		
		SystemIO.printString("Processo adicionado com sucesso: \n Endereco Inicio: " + RegisterFile.getUserRegister("$a0").getValue() + "\n Endereco Final: " + RegisterFile.getUserRegister("$v1").getValue()+"\n");
		
	}
}

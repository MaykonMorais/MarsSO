package mars.mips.instructions.syscalls;

import mars.ProcessingException;
import mars.ProgramStatement;

public class MySyscall extends AbstractSyscall{ // criando Syscall

	public MySyscall(int number, String name) {
		super(number, name);
		// TODO Auto-generated constructor stub
	}

@Override
public void simulate(ProgramStatement statement) throws ProcessingException {
	// TODO Auto-generated method stub
	
}
	
}

package mars.mips.instructions.syscalls;

import mars.util.*;
import mars.*;

import mars.ProgramStatement;

public class MySyscall extends AbstractSyscall{ // criando Syscall

	public MySyscall() {
		super(18, "MySyscall");
	}

@Override
public void simulate(ProgramStatement statement) throws ProcessingException {
	System.out.println("Hello Syscall!! \n");
}
}

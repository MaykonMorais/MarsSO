package mars.mips.so.ProcessManager;

import mars.mips.so.ProcessManager.*;
import mars.mips.so.ProcessManager.ProcessTable;

public class Schedule {
	public static ProcessControlBlock escalonar() { // fila
		ProcessControlBlock pcb = ProcessTable.readyProcesses.removeFirst();
		return pcb;
	}
}

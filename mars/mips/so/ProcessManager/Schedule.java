package mars.mips.so.ProcessManager;

import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import mars.mips.so.ProcessManager.ProcessTable;

public class Schedule {
	
	public static boolean fifo() {
		if(ProcessTable.getRunning() != null) { // exists running process
			ProcessTable.getProcessListReady().add(ProcessTable.getRunning()); // get process runnning and add on List Process ready 
		}
		if(ProcessTable.getProcessListReady().size() > 0) {
			ProcessTable.getProcessListReady().get(0).setStateProcess("running"); // mudando o estado do processo para excutando
			ProcessTable.setRunning(ProcessTable.getProcessListReady().remove(0)); // retirando da lista de processo de prontos
			return true;
		}
		return false;
	}
	
	/* Criar Funções para cada método do escalonador */
	
	public static boolean fixedPriority() {
		if(ProcessTable.getRunning() != null) {
			ProcessTable.getProcessListReady().add(ProcessTable.getRunning()); // adicionando processo
		}
		if(ProcessTable.getProcessListReady().size() > 0) {
			Collections.sort(ProcessTable.getProcessListReady()); // ordenando processo em ordem de prioridade alta na fila
			ProcessTable.getProcessListReady().get(0).setStateProcess("running"); // executando processo de mais alta prioridade
			ProcessTable.setRunning(ProcessTable.getProcessListReady().remove(0)); // retirando da lista de processo de prontos
			return true;
		}
		return false;
	}
	
	public static boolean lottery() {
		if(ProcessTable.getRunning() != null) {
			ProcessTable.getProcessListReady().add(ProcessTable.getRunning()); // adicionando processo
		}
		if(ProcessTable.getProcessListReady().size() > 0) {
			// fazer com que seja escolhido um processo entre os processos que estao na fila
			Random r = new Random();
			
			// escolhendo elemento aleatoriamente
			int element = r.nextInt(ProcessTable.getProcessListReady().size());
						
			ProcessTable.getProcessListReady().get(0).setStateProcess("running"); // mudando o estado do processo para excutando
			ProcessTable.setRunning(ProcessTable.getProcessListReady().remove(element)); // retirando elemento escolhido aleatoriamento da lista de pronto
			return true;
		}
		return false;
	}
}

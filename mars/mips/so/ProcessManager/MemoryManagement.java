package mars.mips.so.ProcessManager;

import javax.swing.JOptionPane;

import mars.mips.hardware.RegisterFile;
import mars.util.SystemIO;

public class MemoryManagement {
	// maximo valor da tabela
	public static int tamanhoTabela =  32;
	
	// tamanho da pagina 
	public static int tamanhoPagina = 2;
	
	public boolean verifyMemory() {
		
		// verificando se está entre o intervalo do processo
		if((RegisterFile.getProgramCounter() > ProcessTable.getRunning().getInitAdress()) || (RegisterFile.getProgramCounter() < ProcessTable.getRunning().getEndAdress())) {
   			SystemIO.printString("Acesso de Memoria Restrito:"+RegisterFile.getProgramCounter()+". Limite fora da área de acesso!");
   			JOptionPane.showMessageDialog(null,"Acesso de Memoria "+RegisterFile.getProgramCounter()+". Limite fora da área de acesso!\n");
   			
   			return true;

		}
		return false;
	}
	
}

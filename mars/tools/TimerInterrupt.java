package mars.tools;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;

import mars.ProgramStatement;
import mars.mips.hardware.AccessNotice;
import mars.mips.hardware.AddressErrorException;
import mars.mips.hardware.Memory;
import mars.mips.hardware.MemoryAccessNotice;
import mars.mips.instructions.BasicInstruction;
import mars.mips.instructions.BasicInstructionFormat;
import mars.mips.so.ProcessManager.ProcessTable;
import mars.mips.so.ProcessManager.Schedule;
import mars.util.SystemIO;

public class TimerInterrupt extends AbstractMarsToolAndApplication {
	private static String name    = "Timer to Interrupt";
    private static String version = "Version 1.0 (Maykon Morais)";
    private static String heading = "count time to interrupt and schedule process";
	
    
    private int counter = 0;
    private JTextField counterField;
    
    private JComboBox typePriority;
    String[] typeOfPriority = {"FIFO","Fixa", "Loteria"};
    
    protected int countTimer = 10;
    
    protected int countInter = 0; // counter interrupt
    private JTextField countInterField;
    
    protected int countInst = 3; 
    
    private JProgressBar progressBarInst;
    
    private JToggleButton timerActive; // active timer
    private JSpinner timerConfig; // input time
    
    private boolean execute;
    
    protected int lastAddress = -1;    
    
	protected TimerInterrupt(String title, String heading) {
		super(title, heading);
	}
	public TimerInterrupt() {
		super(name+", " + version, heading);
	}
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String[] args) {
		new TimerInterrupt(heading +", " + version, heading);
	}

	protected void addAsObserver() {
		addAsObserver(Memory.textBaseAddress, Memory.textLimitAddress);
	}
	
	@Override
	protected JComponent buildMainDisplayArea() {
		JPanel panel = new JPanel(new GridBagLayout());
		
		counterField = new JTextField("0", 10);
		counterField.setEditable(false);
		
		countInterField = new JTextField("0", 10);
		countInterField.setEditable(false);
		
		progressBarInst = new JProgressBar(JProgressBar.HORIZONTAL);
		progressBarInst.setStringPainted(true);
		
		
		timerActive = new JToggleButton("Turn ON/Turn OFF");
		timerActive.setToolTipText("select timer option");
		
		timerConfig = new JSpinner();
		timerConfig.setModel(new SpinnerNumberModel(10, 2, 100, 1));
		timerConfig.setToolTipText("input time to interrupt");
		
		
		typePriority = new JComboBox(typeOfPriority);
		
		// Add them to the panel
		
		// Fields
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.LINE_START;
		c.gridheight = c.gridwidth = 1;
		c.gridx = 3;
		c.gridy = 1;
		//c.insets = new Insets(0, 0, 17, 0);
		//panel.add(counterField, c);

		c.insets = new Insets(0, 0, 0, 0);
		c.gridy++;
		panel.add(countInterField, c);
				
		c.gridy++;
		panel.add(progressBarInst, c);
				
		c.gridy++;
		panel.add(timerConfig, c);
		
		c.gridy++;
		panel.add(typePriority, c);
		
		// Labels
		c.anchor = GridBagConstraints.LINE_END;
		c.gridx = 1;
		c.gridwidth = 2;
		c.gridy = 1;
		//c.insets = new Insets(0, 0, 17, 0);
		//panel.add(new JLabel("Qtd Instructions: "	), c);
				
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 2;
		c.gridwidth = 1;
		c.gridy++;
		panel.add(new JLabel("interruptions: "), c);
				
		c.gridy++;
		panel.add(new JLabel("Time: "), c);
				
		c.gridy++;
		panel.add(new JLabel("Timer: "), c);
				
		// Progress bars
		c.insets = new Insets(3, 3, 3, 3);
		c.gridx = 4;
		c.gridy = 2;
		panel.add(timerActive, c);
		
		c.gridx = 2;
		c.gridy = 5;
		panel.add(new JLabel("Priority: "), c);
				
		return panel;
				
	}
	
	protected void processMIPSUpdate(Observable resource, AccessNotice notice) {
		
		if(notice.getAccessType() != AccessNotice.READ) return;
		MemoryAccessNotice m = (MemoryAccessNotice) notice;
		
		int a = m.getAddress();
		if (a == lastAddress) return;
		if(ProcessTable.getRunning()  != null) { // if list are not empty
			lastAddress = a;
			counter++;
			ProcessTable.setTypeScheduler(typePriority.getSelectedItem().toString());
			System.out.println("Opcao" + ProcessTable.getTypeScheduler() + "\n");
			if(timerActive.isSelected()) {
				++countInst;
				
				if(countInst > (int)timerConfig.getValue()) {
					execute = false;
					++countInter; // interrupcoes
					countInst = 0;
					
					
					ProcessTable.processChange(typePriority.getSelectedItem().toString());
					SystemIO.printString("Change Process now \n");
				}
			}
			ProcessTable.setTypeScheduler(typePriority.getSelectedItem().toString());
			updateDisplay();	
		}
		
	}
//	@Override
	protected void initializePreGUI() {
		countInst = 0; // progress bar
		countInter = 0; 
		lastAddress = -1;
		countTimer = 10;
	}
	
// @Override
	protected void reset() {
		countInst = 0; // progress bar
		countInter = 0;
		lastAddress = -1;
		countTimer = 10;
		counter = 0;
		updateDisplay();
	}
	
	protected void updateDisplay() {
		progressBarInst.setValue(countInst);
		progressBarInst.setMaximum((int)timerConfig.getValue());
		counterField.setText(String.valueOf(counter));
		countInterField.setText(String.valueOf(countInter));
	}
}
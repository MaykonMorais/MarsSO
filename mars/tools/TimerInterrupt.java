package mars.tools;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;

public class TimerInterrupt extends AbstractMarsToolAndApplication {
	private static String name    = "Timer to Interrupt";
    private static String version = "Version 1.0 (Maykon Morais)";
    private static String heading = "count time to interrupt and schedule process";
	
    
    private int counter = 0;
    private JTextField counterField;
    
    protected int countTimer = 10;
    
    protected int countInter = 0; // counter interrupt
    private JTextField countInterField;
    
    protected int countInst = 3; 
    private JProgressBar progressBarInst;
    
    private JToggleButton timerActive; // active timer
    private JSpinner timerConfig; // input time
    
    
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

	@Override
	protected JComponent buildMainDisplayArea() {
		JPanel panel = new JPanel(new GridBagLayout());
		
		counterField = new JTextField("0", 10);
		counterField.setEditable(false);
		
		countInterField = new JTextField("0", 10);
		counterField.setEditable(false);
		
		progressBarInst = new JProgressBar(JProgressBar.HORIZONTAL);
		progressBarInst.setStringPainted(true);
		
		
		timerActive = new JToggleButton("Turn ON/Turn OFF");
		timerActive.setToolTipText("select timer option");
		
		timerConfig = new JSpinner();
		timerConfig.setModel(new SpinnerNumberModel(10, 2, 100, 1));
		timerConfig.setToolTipText("input time to interrupt");
		
		
		// Add them to the panel
		
				// Fields
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.LINE_START;
		c.gridheight = c.gridwidth = 1;
		c.gridx = 3;
		c.gridy = 1;
		c.insets = new Insets(0, 0, 17, 0);
		panel.add(counterField, c);

		c.insets = new Insets(0, 0, 0, 0);
		c.gridy++;
		panel.add(countInterField, c);
				
		c.gridy++;
		panel.add(progressBarInst, c);
				
		c.gridy++;
		panel.add(timerConfig, c);
				
		// Labels
		c.anchor = GridBagConstraints.LINE_END;
		c.gridx = 1;
		c.gridwidth = 2;
		c.gridy = 1;
		c.insets = new Insets(0, 0, 17, 0);
		panel.add(new JLabel("Qtd Instructions: "	), c);
				
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 2;
		c.gridwidth = 1;
		c.gridy++;
		panel.add(new JLabel("Qtd Instructions: "), c);
				
		c.gridy++;
		panel.add(new JLabel("Time: "), c);
				
		c.gridy++;
		panel.add(new JLabel("Timer: "), c);
				
		// Progress bars
		c.insets = new Insets(3, 3, 3, 3);
		c.gridx = 4;
		c.gridy = 2;
		panel.add(timerActive, c);
				
		return panel;
				
	}

}

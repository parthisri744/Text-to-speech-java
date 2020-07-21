package text_to_speak;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.awt.SystemColor;

public class Text_To_speak {

	private JFrame frmSpeakCommands;	
	private JFrame frame;
	private static final String  SayWhat = "kevin16";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Text_To_speak window = new Text_To_speak();
					window.frmSpeakCommands.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Text_To_speak() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSpeakCommands = new JFrame();
		frmSpeakCommands.setTitle("Speak Commands");
		frmSpeakCommands.setBounds(100, 100, 1300, 800);
		frmSpeakCommands.setResizable(false);
		frmSpeakCommands.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSpeakCommands.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(250, 128, 114), 12));
		panel.setBounds(35, 12, 1253, 170);
		frmSpeakCommands.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Convert Text To Speak");
		lblNewLabel.setBorder(new LineBorder(new Color(250, 128, 114), 4));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 68));
		lblNewLabel.setBounds(257, 24, 960, 92);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setIcon(new ImageIcon("/home/riya24/Downloads/Speaker.png"));
		label.setBounds(12, 12, 183, 133);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(250, 128, 114), 12));
		panel_1.setBounds(35, 171, 1253, 580);
		frmSpeakCommands.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		

		JTextArea txtSpeech = new JTextArea();
		txtSpeech.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		txtSpeech.setForeground(SystemColor.activeCaption);
		txtSpeech.setBounds(425, 34, 761, 448);
	    txtSpeech.setLineWrap(true);
	    txtSpeech.setWrapStyleWord(true);
		txtSpeech.setBorder(new LineBorder(new Color(250, 128, 114), 4));
		panel_1.add(txtSpeech);
		
		
        System.setProperty("FreeTTSSynthEngineCentral", "com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
		 System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		JButton btnNewButton = new JButton("Text Convert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VoiceManager vm = VoiceManager.getInstance();
				Voice iTalk = vm.getVoice(SayWhat);
				 if (iTalk == null) {
			            System.err.println(
			                "Cannot find a voice named "
			                + iTalk + ".  Please specify a different voice.");
			            System.exit(1);
			        }

				iTalk.allocate();
				try {
					iTalk.speak(txtSpeech.getText());
				}catch (Exception ex) {
					// TODO: handle exception
					JOptionPane.showConfirmDialog(null, "Can't Talk Me, Have Error!");
				}	
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 30));
		btnNewButton.setBounds(49, 232, 276, 49);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSpeech.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 34));
		btnNewButton_1.setBounds(49, 329, 276, 49);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame,"Confirm if you want to exit ","Text to Speech" ,
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 34));
		btnNewButton_2.setBounds(49, 433, 276, 49);
		panel_1.add(btnNewButton_2);
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Text To Speech");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSpeech.setText("");
				txtSpeech.append("\n\n I Love Parthiban");
			}
		});
		rdbtnNewRadioButton.setFont(new Font("Dialog", Font.BOLD, 24));
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnNewRadioButton.setBounds(49, 34, 276, 49);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Read Numbers");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSpeech.setText("");
				txtSpeech.append("\n\n0\t1\t2\t3\t4\n"
						+ "5\t6\t7\t8\t9");
			}
		});
		rdbtnNewRadioButton_1.setFont(new Font("Dialog", Font.BOLD, 24));
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnNewRadioButton_1.setBounds(49, 103, 259, 28);
		panel_1.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Alphabet To Speech");
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSpeech.setText("");
				txtSpeech.append("\n\nA\tB\tC\tD\tE\n"
						+ "F\tG\tH\tI\tJ\n"
						+ "K\tL\tM\tN\tO\n"
						+ "P\tQ\tR\tS\tT\n"
						+ "U\tV\tW\nX\tY\nZ");
			}
		});
		rdbtnNewRadioButton_2.setFont(new Font("Dialog", Font.BOLD, 24));
		rdbtnNewRadioButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnNewRadioButton_2.setBounds(50, 149, 327, 47);
		panel_1.add(rdbtnNewRadioButton_2);
		
		
		
	
	
	}
}

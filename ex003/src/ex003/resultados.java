package ex003;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class resultados {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					resultados window = new resultados();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public resultados() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().setForeground(SystemColor.textHighlight);
		frame.setBounds(100, 100, 589, 499);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setVisible(false);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setForeground(new Color(0, 102, 204));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(10, 140, 41, 49);
		frame.getContentPane().add(lblNewLabel);
		
		 JLabel lblNewLabel_1 = new JLabel("New label");
		 lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		 lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		 lblNewLabel_1.setForeground(new Color(102, 153, 204));
	     lblNewLabel_1.setBounds(214, 26, 113, 407);
	     frame.getContentPane().add(lblNewLabel_1);
		
		String txtFile = "c:/temp/score.txt";
		 BufferedReader file = null;
		 String line;
		 String txtSplitBy = ": ";
		     
		 try {
		    	 Map<String, String> highestScores = new TreeMap<String, String>();
	            file = new BufferedReader(new FileReader(txtFile));
		     while ((line = file.readLine()) != null) {
		       String[] nome = line.split(txtSplitBy);
		       String[] pontuacao = line.split(txtSplitBy);
		       highestScores.put(pontuacao[1], nome[0]);				       
	}
		     SortedMap<String,String> 
		     score = ((NavigableMap<String,String>) highestScores).descendingMap();		   
		     lblNewLabel.setText("<html>"+"<p>"+ score.toString() +"</p>"+"</html>");
		     String text=lblNewLabel.getText();
		     lblNewLabel_1.setText(text.replaceAll("[{},]", ""));
		     
		    
		   //JOptionPane.showMessageDialog(null,score);
	     }				     
	      
	  catch (IOException e) {
	     e.printStackTrace();
	 } finally {
	     if (file != null) {
	         try {
	             file.close();
	         } catch (IOException e) {
	             e.printStackTrace();
	         }
	     }
	 }
	}
}

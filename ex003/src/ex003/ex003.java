package ex003;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.TreeMap;

public class ex003 extends JApplet {

	/**
	 * Create the applet.
	 */
	public ex003() {
		getContentPane().setSize(new Dimension(800, 400));
		setSize(new Dimension(800, 400));
		getContentPane().setLayout(null);      		
		
		JLabel lbpontos = new JLabel("0");
		lbpontos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbpontos.setBounds(501, 29, 48, 17);
		getContentPane().add(lbpontos);
		
		JLabel lbpic2 = new JLabel("");
		lbpic2.setIcon(new ImageIcon("C:\\Users\\Ricardo\\eclipse-workspace\\ex003\\bin\\ex003\\pic2.jpg"));
		lbpic2.setBounds(227, 84, 169, 169);
		getContentPane().add(lbpic2);
		
		JLabel lbpic3 = new JLabel("");
		lbpic3.setIcon(new ImageIcon("C:\\Users\\Ricardo\\eclipse-workspace\\ex003\\bin\\ex003\\pic3.jpg"));
		lbpic3.setBounds(406, 84, 169, 169);
		getContentPane().add(lbpic3);
		
		JLabel lbpic4 = new JLabel("");
		lbpic4.setIcon(new ImageIcon("C:\\Users\\Ricardo\\eclipse-workspace\\ex003\\bin\\ex003\\pic4.jpg"));
		lbpic4.setBounds(585, 84, 169, 169);
		getContentPane().add(lbpic4);					
		
		JLabel lblPontos = new JLabel("Pontos:");
		lblPontos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPontos.setBounds(429, 29, 72, 17);
		getContentPane().add(lblPontos);
		
		JLabel lbbicho = new JLabel("venusaur");
		lbbicho.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbbicho.setForeground(Color.BLUE);
		lbbicho.setBounds(168, 23, 103, 23);
		getContentPane().add(lbbicho);
		
		JLabel lbpic1 = new JLabel("");
		lbpic1.setIcon(new ImageIcon("C:\\Users\\Ricardo\\eclipse-workspace\\ex003\\bin\\ex003\\pic1.jpg"));
		lbpic1.setBounds(48, 84, 169, 169);
		getContentPane().add(lbpic1);
									
	    JButton bt1 = new JButton("?");
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(bt1.getText()=="?") {
					if(lbbicho.getText()=="bulbasaur") {
						int pontos=Integer.parseInt(lbpontos.getText());
					pontos=pontos+10;
					lbpontos.setText(""+pontos);
					JOptionPane.showMessageDialog(null, "Já apanhou mais um!");
					lbbicho.setText("wartortle");
					bt1.setText("bulbasaur");
				
					try {
						AudioClip clip = Applet.newAudioClip(
						new URL("file:C:/Users/formando39/eclipse-workspace/ex003/bin/ex003/sucesso.wav"));
						clip.play();
						}catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();			
					    }	
					
				}
					else
					{
						int pontos=Integer.parseInt(lbpontos.getText());
						pontos=pontos-10;
						lbpontos.setText(""+pontos);
						JOptionPane.showMessageDialog(null, "Tente de novo!");
						try {
							AudioClip clip = Applet.newAudioClip(
							new URL("file:C:/Users/formando39/eclipse-workspace/ex003/bin/ex003/erro.wav"));
							clip.play();
							}catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();			
						    }	
					}
				}
					else {
						JOptionPane.showMessageDialog(null, "Já acertou esse!");
						try {
							AudioClip clip = Applet.newAudioClip(
							new URL("file:C:/Users/formando39/eclipse-workspace/ex003/bin/ex003/perdeu.wav"));
							clip.play();
							}catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();			
						    }	
					}
			}
		});
		bt1.setBounds(74, 297, 113, 23);
		getContentPane().add(bt1);
		
		JButton bt2 = new JButton("?");
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(bt2.getText()=="?") {
					if(lbbicho.getText()=="Victreebel") {
						int pontos=Integer.parseInt(lbpontos.getText());
					pontos=pontos+10;
					lbpontos.setText(""+pontos);
					JOptionPane.showMessageDialog(null, "Apanhou todos");
					lbbicho.setText("Parabens!");
					bt2.setText("Victreebel");
					try {
						AudioClip clip = Applet.newAudioClip(
						new URL("file:C:/Users/formando39/eclipse-workspace/ex003/bin/ex003/ganhou.wav"));
						clip.play();
						}catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();			
					    }
					try {
						FileWriter writer=new FileWriter("c:/temp/score.txt",true);
						String nome;
						nome=JOptionPane.showInputDialog(null,"Qual o seu nome?");					
						writer.write(nome+": "+pontos);
						writer.write("\r\n");
						writer.close();
					}
							catch(IOException e1) {
							e1.printStackTrace();	
							}
				}
					else
					{
						int pontos=Integer.parseInt(lbpontos.getText());
						pontos=pontos-10;
						lbpontos.setText(""+pontos);
						JOptionPane.showMessageDialog(null, "Tente de novo!");
					}
				}
					else {
						JOptionPane.showMessageDialog(null, "Já acertou esse!");
						try {
							AudioClip clip = Applet.newAudioClip(
							new URL("file:C:/Users/formando39/eclipse-workspace/ex003/bin/ex003/perdeu.wav"));
							clip.play();
							}catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();			
						    }	
					}
			}				
		});
		bt2.setBounds(267, 297, 103, 23);
		getContentPane().add(bt2);
		
		JButton bt3 = new JButton("?");
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(bt3.getText()=="?") {
					if(lbbicho.getText()=="venusaur") {
						int pontos=Integer.parseInt(lbpontos.getText());
					pontos=pontos+10;
					lbpontos.setText(""+pontos);
					JOptionPane.showMessageDialog(null, "Já apanhou mais um!");
					lbbicho.setText("bulbasaur");
					bt3.setText("venusaur");
					try {
						AudioClip clip = Applet.newAudioClip(
						new URL("file:C:/Users/formando39/eclipse-workspace/ex003/bin/ex003/sucesso.wav"));
						clip.play();
						}catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();			
					    }	
					
				}
					else
					{
						int pontos=Integer.parseInt(lbpontos.getText());
						pontos=pontos-10;
						lbpontos.setText(""+pontos);
						JOptionPane.showMessageDialog(null, "Tente de novo!");
						try {
							AudioClip clip = Applet.newAudioClip(
							new URL("file:C:/Users/formando39/eclipse-workspace/ex003/bin/ex003/erro.wav"));
							clip.play();
							}catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();			
						    }	
					}
				}
					else {
						JOptionPane.showMessageDialog(null, "Já acertou esse!");
						try {
							AudioClip clip = Applet.newAudioClip(
							new URL("file:C:/Users/formando39/eclipse-workspace/ex003/bin/ex003/perdeu.wav"));
							clip.play();
							}catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();			
						    }	
						
					}
			}					
						
		});
		bt3.setBounds(460, 297, 89, 23);
		getContentPane().add(bt3);
										
		JButton bt4 = new JButton("?");
		bt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(bt4.getText()=="?") {
					if(lbbicho.getText()=="wartortle") {
					int pontos=Integer.parseInt(lbpontos.getText());
					pontos=pontos+10;
					lbpontos.setText(""+pontos);
					JOptionPane.showMessageDialog(null, "Já apanhou mais um!");
					lbbicho.setText("Victreebel");
					bt4.setText("wartortle");
					try {
						AudioClip clip = Applet.newAudioClip(
						new URL("file:C:/Users/formando39/eclipse-workspace/ex003/bin/ex003/sucesso.wav"));
						clip.play();
						}catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();			
					    }
					
				}
					else
					{
						int pontos=Integer.parseInt(lbpontos.getText());
						pontos=pontos-10;
						lbpontos.setText(""+pontos);
						JOptionPane.showMessageDialog(null, "Tente de novo!");
						try {
							AudioClip clip = Applet.newAudioClip(
							new URL("file:C:/Users/formando39/eclipse-workspace/ex003/bin/ex003/erro.wav"));
							clip.play();
							}catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();			
						    }	
					}
				}
					else {
						JOptionPane.showMessageDialog(null, "Já acertou esse!");
						try {
							AudioClip clip = Applet.newAudioClip(
							new URL("file:C:/Users/formando39/eclipse-workspace/ex003/bin/ex003/perdeu.wav"));
							clip.play();
							}catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();			
						    }	
					}
			}					
			
		});
		bt4.setBounds(631, 297, 89, 23);
		getContentPane().add(bt4);
		
		JButton btpont = new JButton("Ver Pontua\u00E7\u00F5es");
		btpont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {								
				resultados info = new resultados();
				info.main(null);
			
				       //for(Integer score : ((TreeMap<Integer,String>) highestScores).descendingKeySet()) {
				    	   // JOptionPane.showMessageDialog(null,"Nome: " + nome[0] + "\n" + "Pontuacao: " + splitLine[1] + "\n") ; 	   
				      // };
				      	
	/*		Map<Integer, String> highestScores = new TreeMap<Integer, String>();
			BufferedReader reader;	
				try {			
	reader = new BufferedReader(new FileReader(new File("c:/temp/score.txt")));	
	String line = null;
	while ((line = reader.readLine()) != null) { // read your file line by line
	    String[] playerScores = line.split(": ");
	    // populate your collection with score-player mappings
	    highestScores.put(Integer.valueOf(playerScores[1]), playerScores[0]);
	}	
	// iterate in descending order
	for (Integer score : ((TreeMap<Integer, String>) highestScores).descendingKeySet()) {		 
		JOptionPane.showMessageDialog(null,highestScores.get(score) + ": " + score);
	}	*/
				/*try {
					FileReader reader=new FileReader("c:/temp/score.txt");
					int valor;
					String scores="";
					while((valor=reader.read())!=-1) {
						scores=scores+(char)valor;
					};
					reader.close();
					JOptionPane.showMessageDialog(null, scores);										
					
				}
						catch(IOException e1) {
						e1.printStackTrace();	
						}*/ 
	/*} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}	*/
			}
		});
		btpont.setBounds(619, 29, 149, 23);
		getContentPane().add(btpont);
		
		JLabel lbpic2_1 = new JLabel("");
		lbpic2_1.setBounds(37, 84, 169, 169);
		getContentPane().add(lbpic2_1);
		
		JButton btnNovoJogo = new JButton("Novo Jogo");
		btnNovoJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bt1.setText("?");
				bt2.setText("?");
				bt3.setText("?");
				bt4.setText("?");
				lbbicho.setText("venusaur");
				lbpontos.setText("0");
			}
		});
		btnNovoJogo.setBounds(289, 366, 195, 23);
		getContentPane().add(btnNovoJogo);
		
		
	}
}
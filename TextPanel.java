import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextPanel extends JPanel{
	private JTextArea textArea;
	
	public TextPanel(){
		textArea = new JTextArea();
		textArea.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		setLayout(new BorderLayout());
		textArea.setMargin(new Insets(10,10,10,10));
		add(new JScrollPane(textArea), BorderLayout.CENTER);
	}

	
	public void setFonts(String family, int weight, int size){
		textArea.setFont(new Font(family, weight, size));
	}
	
	
	public JTextArea getTextArea(){
		return textArea;
	}
	
	public void readFile(String fileName) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		textArea.setText(null);
		try {
			
			String str;
			
			while((str = br.readLine()) != null){
				//System.out.println(str + "\n");
				textArea.append(str + "\n");
			}
			
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error Occurred");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error Occurred");
		}
		
		finally{
			br.close();
		}
		
		
	}
	
	public void writeFile(String fileName) throws IOException{
		FileWriter fw = new FileWriter(fileName);
		
		try {
			
			textArea.write(fw);
		
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error Occurred");
		}
		
		finally{
			fw.close();
		}
		
	}
}

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

public class MainFrame extends JFrame {
	WordPanel wordPanel;
	public static TextPanel textPanel;
	JMenuBar menuBar;
	JFileChooser fileChooser;
	boolean saved = false;
	String fileName;
	String previousFile;
	
	String path = "E:/Code/Java Swing (GUI)/TextWizard/src/wizardIcon.png";
	ImageIcon icon = new ImageIcon(path);
	
	//============================================
	//Menus
	//============================================		
	JMenu file = new JMenu("File");
	JMenu edit = new JMenu("Edit");
	JMenu showHide = new JMenu("Show/Hide");
	JMenu showWordPanel = new JMenu("Show Word Analyzer");
	JMenu fonts = new JMenu("Font");
	JMenu size = new JMenu("Size");
			
			
	//============================================
	//MenuItems
	//============================================
	JMenuItem newFile = new JMenuItem("New");
	JMenuItem open = new JMenuItem("Open");
	JMenuItem saveFile = new JMenuItem("Save");
	JMenuItem exit = new JMenuItem("Exit");
	
	JCheckBoxMenuItem checkedShow = new JCheckBoxMenuItem("Show");
	

	public MainFrame() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		
		//============================================
		//Super & Construction
		//============================================				
		super("TextWizard 1.1");
		setIconImage(icon.getImage());
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		
		
		wordPanel = new WordPanel();
		textPanel = new TextPanel();
		menuBar = new JMenuBar();
	    fileChooser = new JFileChooser();
	    fileChooser.setFileFilter(new WordExtensionFilter());
		
	    
	    //============================================
		//MenuBar
		//============================================
		setJMenuBar(createMenuBar());
		
		//============================================
		//Border Layout
		//============================================
		setLayout(new BorderLayout());
		add(wordPanel, BorderLayout.WEST);
		add(new JScrollPane(textPanel), BorderLayout.CENTER);
		
		
		//==================================================================================
		Border innerBorder = BorderFactory.createTitledBorder("Word Analyzer");
		Border outterBorder = BorderFactory.createEmptyBorder(1,1,1,1);
		wordPanel.setBorder(BorderFactory.createCompoundBorder(outterBorder, innerBorder));
		
		
		
		//============================================
		//Frame
		//============================================				
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(500, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	
	public JMenuBar createMenuBar(){
		menuBar.add(file);
		menuBar.add(showHide);
		
		checkedShow.setSelected(true);
		
		file.setMnemonic(KeyEvent.VK_F);
		edit.setMnemonic(KeyEvent.VK_E);
		showHide.setMnemonic(KeyEvent.VK_H);
		
		
		//============================================
		//Add MenuItem
		//============================================
		
		file.add(newFile);
		file.add(open);
		file.add(saveFile);
		file.addSeparator();
		file.add(exit);
	
		
		
		
		showWordPanel.add(checkedShow);
		showHide.add(showWordPanel);
		
		
		
		//============================================
		//File Chooser Actions
		//============================================
		
		
		// OPEN===================================
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
					
					File file = fileChooser.getSelectedFile();
					fileName = file.getAbsolutePath();
					saved = true;
					
					
					if(textPanel.getTextArea().getText().length() != 0){
						int act = JOptionPane.showConfirmDialog(null, "Do you want to save existing file first?",
								"Confirm Open", JOptionPane.YES_NO_OPTION);
						if(act == JOptionPane.OK_OPTION){
							//saveFile	
							if(saved){
								try {
									textPanel.writeFile(previousFile);
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							
							else if(fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
								
								File tempFile = fileChooser.getSelectedFile();
								String tempFileName = tempFile.getAbsolutePath();
								saved = true;
								
								try {
									textPanel.writeFile(tempFileName);
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								
							}
						}
						
					}
					
					try {
						textPanel.readFile(fileName);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					previousFile = fileName;
					
				}
			}
		});
		
		
		// SAVE===================================
		saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		
		saveFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(saved){
					try {
						System.out.println(fileName);
						textPanel.writeFile(fileName);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
				else if(fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
					
					File file = fileChooser.getSelectedFile();
					String fileName = file.getAbsolutePath();
					saved = true;
					
					try {
						textPanel.writeFile(fileName);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				}
			}
		});
		
		
		// NEW===================================
		newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		
		newFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textPanel.getTextArea().getText().length() != 0){
					int act = JOptionPane.showConfirmDialog(null, "Do you want to save existing file first?",
							"Confirm New File", JOptionPane.YES_NO_OPTION);
					if(act == JOptionPane.OK_OPTION){
						//saveFile
						if(saved){
							try {
								textPanel.writeFile(previousFile);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
						
						else if(fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
							
							File file = fileChooser.getSelectedFile();
							String fileName = file.getAbsolutePath();
							saved = true;
							
							try {
								textPanel.writeFile(fileName);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							
						}
					}
				}
				
				saved = false;
				
				textPanel.getTextArea().setText(null);;
			}
		});
		
		
		// EXIT===================================
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textPanel.getTextArea().getText().length() != 0){
					int act = JOptionPane.showConfirmDialog(null, "Do you want to save existing file first?",
							"Confirm New File", JOptionPane.YES_NO_OPTION);
					if(act == JOptionPane.OK_OPTION){
						//saveFile
						if(saved){
							try {
								textPanel.writeFile(previousFile);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
						
						else if(fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
							
							File file = fileChooser.getSelectedFile();
							String fileName = file.getAbsolutePath();
							saved = true;
							
							try {
								textPanel.writeFile(fileName);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							
						}
					}
					
					System.exit(0);
				}
				
				else{
					System.exit(0);
				}
			}
		});
		
		
		
		// HIDE WORD PANEL===================================
		checkedShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wordPanel.setVisible(checkedShow.isSelected());
			}
		});
		
		
		return menuBar;
	}
	
	public TextPanel getTextPanel(){
		return textPanel;
	}
	
}

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

public class WordPanel extends JPanel {
	private int[] wordLengthCounter = new int[11]; 
    private double[] wordPercentages = new double[11]; 
    private double avgWordLength; 
    private int totalWords; 
	
	private JPanel wordPanel;
	
	private JLabel wordCountLabel;
	private JButton count;
	private JTextField wordCountField;
	
	
	private JLabel oneLetterLabel;
	private JTextField oneLetterField;
	private JLabel twoLetterLabel;
	private JTextField twoLetterField;
	private JLabel threeLetterLabel;
	private JTextField threeLetterField;
	private JLabel fourLetterLabel;
	private JTextField fourLetterField;
	private JLabel fiveLetterLabel;
	private JTextField fiveLetterField;
	private JLabel sixLetterLabel;
	private JTextField sixLetterField;
	private JLabel sevenLetterLabel;
	private JTextField sevenLetterField;
	private JLabel eightLetterLabel;
	private JTextField eightLetterField;
	private JLabel nineLetterLabel;
	private JTextField nineLetterField;
	private JLabel tenLetterLabel;
	private JTextField tenLetterField;
	private JButton percentageButton;
	
	private JLabel avgWordLengthLabel;
	private JButton avgWordLengthButton;
	private JTextField avgWordLengthField;
	
	private JLabel singleWordLabel1;
	private JLabel singleWordLabel2;
	private JButton singleWordButton;
	private JTextField singleWordField;
	private JTextField singleWordResultField;
	
	
	public WordPanel(){
		wordPanel = new JPanel();
		setPreferredSize(new Dimension(250, 100));
		
		
		// ============================================================
        // WORD COUNT
        // ============================================================
        
		wordCountLabel = new JLabel("Word Count");
		wordCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wordCountLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		wordCountField = new JTextField(10);
		wordCountField.setEnabled(false);
		wordCountField.setHorizontalAlignment(SwingConstants.CENTER);
		wordCountField.setFont(new Font("Arial", Font.BOLD, 15));
		wordCountField.setDisabledTextColor(Color.BLACK);
		
		count = new JButton("Count");
		
		avgWordLengthLabel = new JLabel("Average Length");
		avgWordLengthLabel.setHorizontalAlignment(SwingConstants.CENTER);
		avgWordLengthLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		avgWordLengthField = new JTextField(10);
		avgWordLengthField.setEnabled(false);
		avgWordLengthField.setHorizontalAlignment(SwingConstants.CENTER);
		avgWordLengthField.setFont(new Font("Arial", Font.BOLD, 15));
		avgWordLengthField.setDisabledTextColor(Color.BLACK);
		
		avgWordLengthButton = new JButton("Calculate");
		
		
		singleWordLabel1 = new JLabel("Type a Word");
		singleWordLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		singleWordLabel1.setFont(new Font("Arial", Font.BOLD, 15));
		
		singleWordLabel2 = new JLabel("# of Occurrence");
		singleWordLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		singleWordLabel2.setFont(new Font("Arial", Font.BOLD, 15));
		
		singleWordField = new JTextField(10);
		singleWordField.setEnabled(true);
		singleWordField.setHorizontalAlignment(SwingConstants.CENTER);
		singleWordField.setFont(new Font("Arial", Font.BOLD, 15));
		
		singleWordResultField = new JTextField(10);
		singleWordResultField.setEnabled(false);
		singleWordResultField.setHorizontalAlignment(SwingConstants.CENTER);
		singleWordResultField.setFont(new Font("Arial", Font.BOLD, 15));
		singleWordResultField.setDisabledTextColor(Color.BLACK);
		
		singleWordButton = new JButton("Count");
		
		
		
		// ============================================================
        // WORD PERCENTAGES
        // ============================================================
        
		
		// Labels
		
		oneLetterLabel = new JLabel("1-letter Word");
		oneLetterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		oneLetterLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		twoLetterLabel = new JLabel("2-letters Word");
		twoLetterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		twoLetterLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		threeLetterLabel = new JLabel("3-letters Word");
		threeLetterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		threeLetterLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		fourLetterLabel = new JLabel("4-letters Word");
		fourLetterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fourLetterLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		fiveLetterLabel = new JLabel("5-letters Word");
		fiveLetterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fiveLetterLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		sixLetterLabel = new JLabel("6-letters Word");
		sixLetterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sixLetterLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		sevenLetterLabel = new JLabel("7-letters Word");
		sevenLetterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sevenLetterLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		eightLetterLabel = new JLabel("8-letters Word");
		eightLetterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		eightLetterLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		nineLetterLabel = new JLabel("9-letters Word");
		nineLetterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nineLetterLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		tenLetterLabel = new JLabel("10+ letters Word");
		tenLetterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tenLetterLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		
		// Textfields
		
		oneLetterField = new JTextField(10);
		oneLetterField.setEnabled(false);
		oneLetterField.setHorizontalAlignment(SwingConstants.CENTER);
		oneLetterField.setFont(new Font("Arial", Font.BOLD, 15));
		oneLetterField.setDisabledTextColor(Color.BLACK);
		
		twoLetterField = new JTextField(10);
		twoLetterField.setEnabled(false);
		twoLetterField.setHorizontalAlignment(SwingConstants.CENTER);
		twoLetterField.setFont(new Font("Arial", Font.BOLD, 15));
		twoLetterField.setDisabledTextColor(Color.BLACK);
		
		threeLetterField = new JTextField(10);
		threeLetterField.setEnabled(false);
		threeLetterField.setHorizontalAlignment(SwingConstants.CENTER);
		threeLetterField.setFont(new Font("Arial", Font.BOLD, 15));
		threeLetterField.setDisabledTextColor(Color.BLACK);
		
		fourLetterField = new JTextField(10);
		fourLetterField.setEnabled(false);
		fourLetterField.setHorizontalAlignment(SwingConstants.CENTER);
		fourLetterField.setFont(new Font("Arial", Font.BOLD, 15));
		fourLetterField.setDisabledTextColor(Color.BLACK);
		
		fiveLetterField = new JTextField(10);
		fiveLetterField.setEnabled(false);
		fiveLetterField.setHorizontalAlignment(SwingConstants.CENTER);
		fiveLetterField.setFont(new Font("Arial", Font.BOLD, 15));
		fiveLetterField.setDisabledTextColor(Color.BLACK);
		
		sixLetterField = new JTextField(10);
		sixLetterField.setEnabled(false);
		sixLetterField.setHorizontalAlignment(SwingConstants.CENTER);
		sixLetterField.setFont(new Font("Arial", Font.BOLD, 15));
		sixLetterField.setDisabledTextColor(Color.BLACK);
		
		sevenLetterField = new JTextField(10);
		sevenLetterField.setEnabled(false);
		sevenLetterField.setHorizontalAlignment(SwingConstants.CENTER);
		sevenLetterField.setFont(new Font("Arial", Font.BOLD, 15));
		sevenLetterField.setDisabledTextColor(Color.BLACK);
		
		eightLetterField = new JTextField(10);
		eightLetterField.setEnabled(false);
		eightLetterField.setHorizontalAlignment(SwingConstants.CENTER);
		eightLetterField.setFont(new Font("Arial", Font.BOLD, 15));
		eightLetterField.setDisabledTextColor(Color.BLACK);
		
		nineLetterField = new JTextField(10);
		nineLetterField.setEnabled(false);
		nineLetterField.setHorizontalAlignment(SwingConstants.CENTER);
		nineLetterField.setFont(new Font("Arial", Font.BOLD, 15));
		nineLetterField.setDisabledTextColor(Color.BLACK);
		
		tenLetterField = new JTextField(10);
		tenLetterField.setEnabled(false);
		tenLetterField.setHorizontalAlignment(SwingConstants.CENTER);
		tenLetterField.setFont(new Font("Arial", Font.BOLD, 15));
		tenLetterField.setDisabledTextColor(Color.BLACK);
		
		// Percentage Button
		percentageButton = new JButton("Calculate");
		
		//===============================================================
		
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.fill = GridBagConstraints.BOTH;
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(5,5,0,5);
		gc.gridheight = 1;
		add(wordCountLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		add(wordCountField, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		gc.insets = new Insets(5,5,0,5);
		add(count, gc);
		
		
		//=====================================================
		
		gc.gridx = 0;
		gc.gridy = 2;
		gc.insets = new Insets(5,5,0,5);
		add(oneLetterLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		add(oneLetterField, gc);
		
		
		gc.gridx = 0;
		gc.gridy = 3;
		add(twoLetterLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 3;
		add(twoLetterField, gc);
		

		gc.gridx = 0;
		gc.gridy = 4;
		add(threeLetterLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 4;
		add(threeLetterField, gc);
		
		
		gc.gridx = 0;
		gc.gridy = 5;
		add(fourLetterLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 5;
		add(fourLetterField, gc);
		
		
		gc.gridx = 0;
		gc.gridy = 6;
		add(fiveLetterLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 6;
		add(fiveLetterField, gc);
		
		
		gc.gridx = 0;
		gc.gridy = 7;
		add(sixLetterLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 7;
		add(sixLetterField, gc);
		

		gc.gridx = 0;
		gc.gridy = 8;
		add(sevenLetterLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 8;
		add(sevenLetterField, gc);

		
		gc.gridx = 0;
		gc.gridy = 9;
		add(eightLetterLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 9;
		add(eightLetterField, gc);
		
		
		gc.gridx = 0;
		gc.gridy = 10;
		add(nineLetterLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 10;
		add(nineLetterField, gc);
		
		
		gc.gridx = 0;
		gc.gridy = 11;
		add(tenLetterLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 11;
		add(tenLetterField, gc);
		
		
		gc.gridx = 1;
		gc.gridy = 12;
		gc.insets = new Insets(5,5,0,5);
		add(percentageButton, gc);
		
		
		gc.gridx = 0;
		gc.gridy = 13;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(5,5,0,5);
		gc.gridheight = 1;
		add(avgWordLengthLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 13;
		add(avgWordLengthField, gc);
		
		gc.gridx = 1;
		gc.gridy = 14;
		gc.insets = new Insets(5,5,20,5);
		add(avgWordLengthButton, gc);
		
		
		gc.gridx = 0;
		gc.gridy = 15;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(5,5,0,5);
		gc.gridheight = 1;
		add(singleWordLabel1, gc);
		
		gc.gridx = 1;
		gc.gridy = 15;
		add(singleWordField, gc);
		
		gc.gridx = 1;
		gc.gridy = 17;
		add(singleWordButton, gc);
		
		gc.gridx = 0;
		gc.gridy = 18;
		add(singleWordLabel2, gc);
		
		gc.gridx = 1;
		gc.gridy = 18;
		add(singleWordResultField, gc);
		
		
		
		//==================================================================
		
		count.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wordCountField.setText(countWords() + "");
			}
		});
		
		
		percentageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(MainFrame.textPanel.getTextArea().getText().length() == 0){
					oneLetterField.setText("0.0%");
					twoLetterField.setText("0.0%");
					threeLetterField.setText("0.0%");
					fourLetterField.setText("0.0%");
					fiveLetterField.setText("0.0%");
					sixLetterField.setText("0.0%");
					sevenLetterField.setText("0.0%");
					eightLetterField.setText("0.0%");
					nineLetterField.setText("0.0%");
					tenLetterField.setText("0.0%");
				}
				else{
					processText(MainFrame.textPanel.getTextArea().getText());
					
					wordPercentages = getWordPercentages();
					
					oneLetterField.setText(String.format("%.2f", wordPercentages[1]) + "%");
					twoLetterField.setText(String.format("%.2f", wordPercentages[2]) + "%");
					threeLetterField.setText(String.format("%.2f", wordPercentages[3]) + "%");
					fourLetterField.setText(String.format("%.2f", wordPercentages[4]) + "%");
					fiveLetterField.setText(String.format("%.2f", wordPercentages[5]) + "%");
					sixLetterField.setText(String.format("%.2f", wordPercentages[6]) + "%");
					sevenLetterField.setText(String.format("%.2f", wordPercentages[7]) + "%");
					eightLetterField.setText(String.format("%.2f", wordPercentages[8]) + "%");
					nineLetterField.setText(String.format("%.2f", wordPercentages[9]) + "%");
					tenLetterField.setText(String.format("%.2f", wordPercentages[10]) + "%");
				}
			}
		});
		
		
		avgWordLengthButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(MainFrame.textPanel.getTextArea().getText().length() == 0){
					avgWordLengthField.setText("0");
				}
				else{
					processText(MainFrame.textPanel.getTextArea().getText());
					getWordPercentages();
					avgWordLengthField.setText(String.format("%.2f", getAvgWordLength()) + "");
				}
			}
		});
		
		
		singleWordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(MainFrame.textPanel.getTextArea().getText().length() == 0 || singleWordField.getText().length() == 0){
					singleWordResultField.setText("0");
				}
				else{
					int result = singleWordCount(MainFrame.textPanel.getTextArea().getText(), singleWordField.getText());
					singleWordResultField.setText(result + "");
				}
			}
		});
		
	}
	
	
	public int countWords(){
		processText(MainFrame.textPanel.getTextArea().getText());
		
		return totalWords;
	}
	
	
	
	public void processText(String text){
		totalWords = 0;
        // splitting words
        String[] words = text.split("[,.;:?!()\r\n|\r|\n ]");
        
        for(int i = 1; i < wordLengthCounter.length; i++){
        	wordLengthCounter[i] = 0;
        }
        
        for(String w: words){
            // checking if the word length is 0 and if any of the token is just other punctuation; 
            // if so, ignoring those words; otherwise analyzing 
            if(w.length() != 0 && w.charAt(0) != '\n' && w.charAt(0) != '[' && w.charAt(0) != ',' && w.charAt(0) != '.'
               && w.charAt(0) != ';' && w.charAt(0) != ':' && w.charAt(0) != '?' && w.charAt(0) != '!'
               && w.charAt(0) != '(' && w.charAt(0) != ')' && w.charAt(0) != ' ' && w.charAt(0) != ']'){
               
               if(w.length() < 10){
                    wordLengthCounter[w.length()]++; // for word length of less than 10, incrementing that length index
               }
               else wordLengthCounter[10]++; // for word length of 10 or greater, incrementing 10th index
               
               totalWords++; // incrementing for each "pure" word (not punctuation or space)
            }
        }
    }
    
    public double[] getWordPercentages(){
        //calculating word percentages
        wordPercentages = calculateWordPercentages(wordLengthCounter, totalWords);

        return wordPercentages;
    }
    
    public double getAvgWordLength(){
        // calculating average word length
        avgWordLength = calculateAvgWordLength(wordLengthCounter, totalWords);
        
        return avgWordLength;
    }
    
    public static double[] calculateWordPercentages(int[] wordCtr, int totalWords){
        double[] wordPerc = new double[11];
        for(int i = 1; i < wordPerc.length; i++){
            // calculating word percentages for each word length 
            wordPerc[i] = ((double)wordCtr[i] / totalWords) * 100;
        }
        
        return wordPerc;
    } 
    
    public static double calculateAvgWordLength(int[] wordCtr, int totalWords){
        int sum = 0;
        for(int i = 1; i < wordCtr.length; i++){
        	sum += i * wordCtr[i]; // calculating total length of words for each length
        }
        
        // returning the average length of words
        return (double)sum / totalWords;
    }
    
    public int singleWordCount(String text, String word){
		int count = 0;
    	totalWords = 0;
        // splitting words
        String[] words = text.split("[,.;:?!()\r\n|\r|\n ]");
        
        for(String w: words){
        	if(w.equals(word)) count++;
        }
        
        return count;
    }
}

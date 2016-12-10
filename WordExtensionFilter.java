import java.io.File;

import javax.swing.filechooser.FileFilter;

public class WordExtensionFilter extends FileFilter {
	
	public boolean accept(File f) {
		if(f.isDirectory()) return true;
		else if (getExtention(f.getName()) == null) return false;
		else if(getExtention(f.getName()).equals("txt")) return true;
		return false;
	}

	public String getDescription() {
		return "Text Document (*.txt)";
	}
	
	public String getExtention(String name){
		int pointIndex = name.lastIndexOf(".");
		
		if(pointIndex == -1) return null;
		else if(pointIndex == name.length() - 1) return null;
		else 
			return name.substring(pointIndex + 1);
	}

}

package org.stock.project;

import javax.swing.*;
import java.io.*;

/**
 * FileChooser is a Dialog box that interacts with the user
 * to select a file. 
 * @author U146576
 * @since jdk1.5
 */
public class FileChooser {
	private String dfile=null;

	
	String getDataFile(){
	
		File sfile;
		
		if (dfile == null){
			sfile = this.selectFile();
			dfile = sfile.getAbsolutePath();
			
		}
			return(dfile);
	}
	
	
	File selectFile(){
		JFileChooser jfc = new JFileChooser();
		File selectedFile = null;
		
		int returnVal = jfc.showOpenDialog(null);
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			selectedFile = jfc.getSelectedFile();
			
		}
		else {
			this.usageError("User Did Not Select a File AND File was not specified on the command line!");
			
		}
	  return(selectedFile);
	}
	
	void usageError (String err){
		System.out.println("Usage Error:");
		System.out.println(err);
		System.exit(1);
	}
	
}

package org.stock.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 
 * @author U146576
 *
 */
public class LoadDataStore {

	private int datasize=-1;
	private BufferedReader buff = null;
	private FileReader fileRd = null;
	private String line = "test";
	private String loadfile=null;
	private StringTokenizer tok = null;
	private String[][] stockData;		//Hold the data
	private MarketData[] mdata;
	
	/**
	 * Getter method for MarketData
	 * @return
	 */
	MarketData[] getMarketData(){
		return(mdata);
	}
	
	/**
	 * Getter method for Size of Data
	 * @return
	 */
	int getDataSize(){
		if (datasize < 0) {
			this.countLines();
		}
		return(datasize);
	}
	
	/**
	 * Setter method for Size of Data
	 */
	void setDataSize(int s){
		datasize = s;
	}
	
	
	/**
	 * A Integer that represents the size of the data file.
	 * Set the size using setter setDataSize.
	 */
	void countLines() {
		int counter = 0;
		
		try{ 
			BufferedReader br = new BufferedReader(new FileReader(loadfile));
			while ((line = br.readLine()) != null) {
				counter++;
			}
			br.close();
		}
		catch (IOException e) {
			e.printStackTrace();
			}
		
		this.setDataSize(counter);
	}
	
	
	/*
	 * @param Helper method to print the 2-Dimensional Array
	 * stockData[][] after assignments.
	 * 
	 * @deprecated Once we moved to Array of Objects and
	 * 			away from the 2-Dimensional Array.
	 */
	
	void printStockData(){
		//Frist loop through the rows
		for (int row=0; row < stockData.length; row++){
			System.out.print("Row " + row);
			//Now loop through each column
			for (int col=0; col < stockData[row].length; col++){
				System.out.print(" " +stockData[row][col]);
			}
		 //print a newline after each row
		  System.out.println();
		}
	}
	
	/**
	 * Helper method to print out the Array of Objects.
	 */
	
	void printArrayOfObjects(){
		for (int row=0; row < mdata.length; row++){
			System.out.print("Row "+ row + " ");
			System.out.print("Day: " + mdata[row].theday);
			System.out.print(" Open: "+ mdata[row].open);
			System.out.print(" High: "+ mdata[row].open);
			System.out.print(" Low: "+ mdata[row].open);
			System.out.print(" close: "+ mdata[row].open);
			System.out.print(" adjClose: "+ mdata[row].open);
			System.out.println(" Volumne: "+ mdata[row].open);
		
		}
	}
	
	
	/*
	 * Method will read the data from a file, will split the structured data
	 * based off commas that represent the columns, than 
	 * load the data into a 2-dimension array.(Depreciated)
	 * 
	 * @param iparams are command line arguments array "args" 
	 */
	void sourceData(String[] iparams) {
		
	 int arraySize=0;
	 int rowNum=0;
	 FileChooser dfc = new FileChooser();
	 
	 //Used for Testing without having to change Eclipse.
	 //iparams[1] = null;
	 
	 /*
	  * Command Line:  java StockAnalyer -df /usr/dan/data/DowDataFile.csv
	  */
	 
	 //if (iparams.length != 0 && iparams[0].equals("-df") && iparams[1] != null){
	 if (iparams.length != 0){
			System.out.println("Using Path: " + iparams[0]);
			loadfile=iparams[0];
		}
	 else {
		 loadfile = dfc.getDataFile();
	 }
	 
		
	 	arraySize = this.getDataSize();
		System.out.println("Size of the File is: "+ arraySize);
		mdata = new MarketData[arraySize];
		
		//Each element in the mdata references a MarketData class.
		//This loop is allocating storage to hold the variables.
		for(int x=0; x < mdata.length; x++){
			mdata[x] = new MarketData();
		}
		
	
	try{
		fileRd = new FileReader(loadfile);
		buff = new BufferedReader(fileRd);
	
		while ((line = buff.readLine()) != null) {
		
			//Need to separate the file based off commas. Using StringTokenizer
			tok = new StringTokenizer(line, ",");
			
				/* While Function has been Depreciated - Not using 2-Dimensional Array
				 * 
				 * while (tok.hasMoreElements()){
					for(int colNum=0;colNum<7;colNum++){
						stockData[rowNum][colNum] = tok.nextElement().toString();	
						}
						
					}
				 
				 */
				
				/*Double.parseDouble throws a NumberFormatException */
				mdata[rowNum].theday = tok.nextElement().toString();
				mdata[rowNum].open = Double.parseDouble(tok.nextElement().toString());
				mdata[rowNum].high = Double.parseDouble(tok.nextElement().toString());
				mdata[rowNum].low = Double.parseDouble(tok.nextElement().toString());
				mdata[rowNum].close = Double.parseDouble(tok.nextElement().toString());
				mdata[rowNum].adjClose = Double.parseDouble(tok.nextElement().toString());
				mdata[rowNum].volumne = Double.parseDouble(tok.nextElement().toString());
			    
				rowNum++;
				
			}//While End Readline
		
	} catch (NumberFormatException nfe){
		System.out.println("There was a problem converting the String to a Double");
		nfe.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
			try{
				if (buff != null){
					//System.out.println("Closing buffer reader");
					buff.close();
				}
				if (fileRd != null){
					//System.out.println("Closing File reader");
					fileRd.close();
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
  }
}

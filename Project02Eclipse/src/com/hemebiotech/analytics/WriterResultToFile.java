package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * This class integrates the tools to write the elements of a map in a file
 * @author Nabil Boudjellal
 */
public class WriterResultToFile {
	private String outPutFileName;
	private Map<String, Integer> map;
	/**
	 * This is the constructor of this class he takes in parameter
	 * @param map the map to write in to the result file
	 * @param outPutFileName the path of the output file
	 */
	public WriterResultToFile(Map<String, Integer> map, String outPutFileName)
	{
		this.outPutFileName = outPutFileName;
		this.map = map;
	}
	/**
	 * This method writes the contents of a map in a file, each item of the map in a new row
	 */
	public void writeToFile() 
	{
		FileWriter writer = null;
		if(outPutFileName != null)
		{
			try {
					writer = new FileWriter (outPutFileName);
	
				for (String key : map.keySet()) {
					writer.write(key + " : " + map.get(key) + '\n'); 
			    }

					writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

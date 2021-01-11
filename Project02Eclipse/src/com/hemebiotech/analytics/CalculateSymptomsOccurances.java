package com.hemebiotech.analytics;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 * This class allows us to calculate the number of appearances of symptoms and convert the list in a map with 
 * the symptom in key and number of appearances in value
 * @author Nabil Boudjellal
 */

public class CalculateSymptomsOccurances {
	
	private List<String> list;
	
	/**
	 * This is the constructor of this class he takes in parameter
	 * @param list the list of syndromes
	 */
	public CalculateSymptomsOccurances(List<String> list)
	{
		this.list = list;
	}
	
	/**
	 * This method returns a map of symptoms in key and their number of feedings in value
	 * @return map the map of symptoms with number of feedings
	 */
	public Map<String, Integer> calculateOccurances() {
		Map<String, Integer> map = new TreeMap<String, Integer>(); 
		
		
		for (String str : list) 
		{ 
			map.put(str, Collections.frequency(list,str));
		} 
		
		return map;
		
	}

}

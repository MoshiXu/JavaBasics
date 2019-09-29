package javaBasics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
 * 
 * For HW, unsure solution
 * 
 * 
 */


public class SplitstringDemo {

	public static void main(String[] args) throws IOException{

		int i; 
	    
		FileReader fr = new FileReader("C:\\Users\\banan\\Desktop\\test.txt"); 
	  
	    StringBuilder output=new StringBuilder();
	    while ((i=fr.read()) != -1) {
	      output.append((char)i);
	    } 

		String outputInString=output.toString();
		String[]values=outputInString.split("\\\\n");
		
		HashSet<String>result=new HashSet<>();
		Collections.addAll(result, values);
		System.out.println(result);
		
		
		FileWriter fw=new FileWriter("C:\\Users\\banan\\Desktop\\test.txt");    
        fw.append(result.toString());    
        fw.flush();
        fw.close();
		
	}

}

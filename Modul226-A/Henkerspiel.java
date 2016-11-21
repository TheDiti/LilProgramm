package ch.csbe.henkerspiel;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javafx.scene.control.Label;

public class Henkerspiel {
	
	private static List<Woerter> values = Arrays.asList(Woerter.values());
	private static int size = values.size();
	private static Random random = new Random();
	private static char[] erraten;
	public static String word;
	public static String test;
	
	public static String randomLetter(){
		String a = values.get(random.nextInt(size)).toString();
	    return a;
	    
	  }
	public static String getErraten(){
		String tostring = "";
		for(int i = 0;i<erraten.length;i++){
			tostring += erraten[i];
		}
		return tostring;
	}
	
	public static void setErraten(String er){
		erraten = new char[er.length()];
		for(int i =  0; i<er.length(); i++){
			if(er.charAt(i) == ' '){
				erraten[i] = ' ';
			}
			else{
				erraten[i] = '_';
			}
		}
	}
	
	public static void raten(String eingabe){
		boolean richtig = false;
		for(int j = 0; j < erraten.length; j++){
			if(word.charAt(j) == eingabe.charAt(0) || word.charAt(j) == eingabe.charAt(0)-32){
				erraten[j] = word.charAt(j);
				richtig = true;
			}
		}
		if(!richtig){
			System.out.println("FALSCH!!!");
		}
	}
	
}
package ch.csbe.henkerspiel;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Henkerspiel {
	
	private static List<Woerter> values = Arrays.asList(Woerter.values());
	private static int size = values.size();
	private static Random random = new Random();
	private static char[] erraten;
	public static String word;
	public static String test;
	private static int falsch = 0;
	private static int anzrichtig = 0;
	
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
	
	public static void raten(String eingabe) throws Exception{
		boolean richtig = false;
		for(int j = 0; j < erraten.length; j++){
			if(word.charAt(j) == eingabe.charAt(0) || word.charAt(j) == eingabe.charAt(0)-32){
				erraten[j] = word.charAt(j);
				richtig = true;
				anzrichtig++;
				if(word.length() == anzrichtig){
					gew();
				}
			}
		}
		if(!richtig){
			falsch++;
			HenkerApp.maenchen();
			if(falsch == 10){
				ver();
			}
		}
	}

	public static void setFalsch(int i){
		falsch = i;
	}
	public static int getFalsch(){
		return falsch;
	}

	public static void ver() throws Exception{
		HenkerApp.verloren(HenkerApp.stage);
	}
	public static void gew() throws Exception{
		HenkerApp.gewonnen(HenkerApp.stage);
}
}
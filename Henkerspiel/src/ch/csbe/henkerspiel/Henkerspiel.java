package ch.csbe.henkerspiel;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

<<<<<<< HEAD
/**
 * 
 * @author endrit.lena
 *
 */

public class Henkerspiel {
	
	private static List<Woerter> values = Arrays.asList(Woerter.values()); //verbindet sich mit den Enum Woerter
	private static int size = values.size();	//erstellt einen integer namens size welche die grösse des enums speichert
	private static Random random = new Random();	//erstellt ein Random welches benutzt wird um irgendetwas zurfällig zu wählen
	private static char[] erraten;	//erstellt einen character namens erraten
	public static String word;	//erstellt einen String namens word
	public static String test;	//erstellt einen String namens test
	private static int falsch = 0;	//erstellt einen integer namens falsch mit dem wert 0
	private static int anzrichtig = 0;	//erstellt einen integer namens anzrichtig mit dem wert 0
	
	//randomLetter wählt ein zufälliges Wort vom Enum Woerter
=======
public class Henkerspiel {
	
	private static List<Woerter> values = Arrays.asList(Woerter.values());
	private static int size = values.size();
	private static Random random = new Random();
	private static char[] erraten;
	public static String word;
	public static String test;
	private static int falsch = 0;
	private static int anzrichtig = 0;
	
>>>>>>> origin/master
	public static String randomLetter(){
		String a = values.get(random.nextInt(size)).toString();
	    return a;
	    
	  }
<<<<<<< HEAD
	
	//getErraten nimmt das zufällige wort
=======
>>>>>>> origin/master
	public static String getErraten(){
		String tostring = "";
		for(int i = 0;i<erraten.length;i++){
			tostring += erraten[i];
		}
		return tostring;
	}
	
<<<<<<< HEAD
	//setErraten setzt das zufällige Wort
=======
>>>>>>> origin/master
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
	
<<<<<<< HEAD
	//raten schaut ob der eingegebene Buchstabe mit einem buchstaben des Wortes identisch ist.
	public static void raten(String eingabe) throws Exception{
		boolean richtig = false;
		for(int j = 0; j < erraten.length; j++){
			if(word.charAt(j) == eingabe.charAt(0) || word.charAt(j) == eingabe.charAt(0)-32){ //wenn es identisch ist wird der buchstabe ausgegeben
=======
	public static void raten(String eingabe) throws Exception{
		boolean richtig = false;
		for(int j = 0; j < erraten.length; j++){
			if(word.charAt(j) == eingabe.charAt(0) || word.charAt(j) == eingabe.charAt(0)-32){
>>>>>>> origin/master
				erraten[j] = word.charAt(j);
				richtig = true;
				anzrichtig++;
				if(word.length() == anzrichtig){
					gew();
				}
			}
		}
<<<<<<< HEAD
		if(!richtig){	//wenn es nicht identisch ist wird eine Linie des Strichmänchen gezeichnet
=======
		if(!richtig){
>>>>>>> origin/master
			falsch++;
			HenkerApp.maenchen();
			if(falsch == 10){
				ver();
			}
		}
	}

<<<<<<< HEAD
	//setFalsch wird ausgeführt wenn ein Buchstabe falsch ist
	public static void setFalsch(int i){
		falsch = i;
	}
	
	//getFalsch gibt die anzahl der falsch eingegeben Buchstaben dem integer falsch zurück
=======
	public static void setFalsch(int i){
		falsch = i;
	}
>>>>>>> origin/master
	public static int getFalsch(){
		return falsch;
	}

<<<<<<< HEAD
	//setAnzrichtig wird ausgeführt wenn ein Buchstabe richtig ist
	public static void setAnzrichtig(int i){
		anzrichtig = i;
	}
	
	//ver verlinkt zu verloren() im HenkerApp wenn man verloren hat
	public static void ver() throws Exception{
		HenkerApp.verloren(HenkerApp.stage);
	}
	
	//gew verlinkt zu gewonnen() im HenkerApp wenn man gewonnen hat
=======
	public static void ver() throws Exception{
		HenkerApp.verloren(HenkerApp.stage);
	}
>>>>>>> origin/master
	public static void gew() throws Exception{
		HenkerApp.gewonnen(HenkerApp.stage);
}
}
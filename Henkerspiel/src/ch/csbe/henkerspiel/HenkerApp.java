package ch.csbe.henkerspiel;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * 
 * @author endrit.lena
 *
 */

public class HenkerApp extends Application{

	//Line & Circle dienen zur zeichnung des Mänchen
	static Line li1 = new Line(100, 100, 0, 100);	
	static Line li2 = new Line(0, 150, 0, 20);	
	static Line li3 = new Line(70, 100, 0, 100);	
	static Line li4 = new Line(0, 50, 0, 20);	
	static Circle c = new Circle(100, 100, 10);	
	static Line li6 = new Line(0, 50, 0, 20);	
	static Line li7 = new Line(20, 80, 0, 100);	
	static Line li8 = new Line(-20, 80, 0, 100);	
	static Line li9 = new Line(20, -80, 0, -100);	
	static Line li10 = new Line(-20, -80, 0, -100);
	public static Stage stage;
	
	//main startet die Anwendung
	public static void main(String[] args) {
		launch(args);
	}
	
	//Hier steht was geschehen soll wenn die Anwendung gestartet wird
	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		strt();	//führt zur strt Methode
	}
	
	//strt ist das GUI, welches man sieht wenn die Anwendung startet
	public static void strt(){
		Henkerspiel.setFalsch(0);	//setzt den Integer falsch auf 0
		Henkerspiel.setAnzrichtig(0);	//setzt den Integer anzrichtig auf 0
		Henkerspiel.word = Henkerspiel.randomLetter();	//Speichert das zufall gewählte Wort vom randomLetter im String word
		Henkerspiel.setErraten(Henkerspiel.word);	//setzt das ausgewählte wort vom String word zum Character erraten 
		Group gr = new Group();	//erstellt eine neue Gruppe
		Scene scene = new Scene(gr, 600, 450);	//erstellt eine neue Scene
		Pane pane = new Pane();	//erstellt eine neue Pane
		Pane pa = new Pane();	//erstellt eine andere neue Pane
		Label l = new Label("Henkerspiel");	//erstellt einen Label welches "Henkerspiel" heisst und wird als Titel im spiel benutzt
		Button b = new Button("Enter");	//erstellt einen neuen Button mit dem name "Enter"
		//erstellt ein neues Label welches das Gesuchte Wort ausgibt
		Label wort = new Label("Gesuchtes Wort: " + Henkerspiel.getErraten() + "  ["  + Henkerspiel.word.length() + " Buchstaben]");
			System.out.println(Henkerspiel.word);	//gibt das gesuchte Wort in der Konsole aus
		Label lb = new Label("Buchstabe eingeben:");	//ein neues Label welches über den TextField mit der beschriftung "Buchstabe eingeben:" steht
		TextField txt = new TextField();	//erstellt ein neues TextFiel in welchem man Buchstaben eingeben kann
		
		li1.setLayoutX(380); //setzt die X-Position auf die angegebene zahl
		li1.setLayoutY(200);	//setzt die Y-Position auf die angegeben zahl
		li1.setVisible(false);	//macht den Label unsichtbar
		
		li2.setLayoutX(420);
		li2.setLayoutY(150);
		li2.setVisible(false);
		
		li3.setLayoutX(420);
		li3.setLayoutY(70);
		li3.setVisible(false);
		
		li4.setLayoutX(490);
		li4.setLayoutY(150);
		li4.setVisible(false);
		
		c.setLayoutX(390);
		c.setLayoutY(110);
		c.setVisible(false);
		
		li6.setLayoutX(490);
		li6.setLayoutY(200);
		li6.setVisible(false);
		
		li7.setLayoutX(490);
		li7.setLayoutY(130);
		li7.setVisible(false);
		
		li8.setLayoutX(490);
		li8.setLayoutY(130);
		li8.setVisible(false);
		
		li9.setLayoutX(490);
		li9.setLayoutY(350);
		li9.setVisible(false);
		
		li10.setLayoutX(490);
		li10.setLayoutY(350);
		li10.setVisible(false);
		
		b.setLayoutX(275);
		b.setLayoutY(135);
		b.setFont(new Font("Arial", 15));	//setzt die Schriftart auf Arial und die Schriftgrösse auf 15
		b.setOnAction(new EventHandler<ActionEvent>() {	//dies macht, das der Button etwas macht wenn man drauf klickt
		    @Override public void handle(ActionEvent e) {
				try {
					Henkerspiel.raten(txt.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				wort.setText("Gesuchtes Wort: " + Henkerspiel.getErraten() + "  ["  + Henkerspiel.word.length() + " Buchstaben]");
				txt.clear();
		    }
		});
		
		lb.setLayoutX(10);
		lb.setLayoutY(115);
		lb.setFont(new Font("Arial", 15));
	
		txt.setLayoutX(10);
		txt.setLayoutY(135);
		txt.setPadding(new Insets(5, 120, 5, 5));
		
		wort.setLayoutX(10);
		wort.setLayoutY(65);
		wort.setFont(new Font("Arial", 15));
		
		l.setLayoutX(10);
		l.setLayoutY(10);
		l.setFont(new Font("Arial", 30));
		
		pa.setPadding(new Insets(0, 200, 350, 0)); //setzt die Grösse des Pane
		pa.setStyle("-fx-background-color: white;" 	//setzt Hintergrundfarbe, Rahmen und Rahmenfarbe der Pane
					+ "-fx-border-style: solid;" 
					+ "-fx-border-color: gray;");
		pa.setLayoutX(350);
		pa.setLayoutY(50);
		
		pane.setPadding(new Insets(0, 600, 450, 0)); 
		pane.setStyle("-fx-background-color: #e6e6e6;");
		
		//macht das die erstellten Sachen auf der scene ausgegeben werden (sozusage macht sie sichtbar)
		gr.getChildren().addAll(pane, pa, l, wort, txt, lb, b, li1, li2, li3, li4, c, li6, li7, li8, li9, li10);
		
		stage.setScene(scene);	//setzt die scene 
		stage.setTitle("Henkerspiel");	//gibt der scene einen Titel
		stage.show();	//zeigt die scene
		
	}

	//maenchen ist die methode die den Höngenen mänchen zeichnet
	public static void maenchen(){
		switch(Henkerspiel.getFalsch()){
		case 1: li1.setVisible(true);break;	//macht die Linien & Circle sichtbar
		case 2: li2.setVisible(true);break;
		case 3: li3.setVisible(true);break;
		case 4: li4.setVisible(true);break;
		case 5: c.setVisible(true);break;
		case 6: li6.setVisible(true);break;
		case 7: li7.setVisible(true);break;
		case 8: li8.setVisible(true);break;
		case 9: li9.setVisible(true);break;
		case 10: li10.setVisible(true);break;
		}

	}
	
	//gewonnen öffnet sich wenn man das gesuchte Wort gefunden hat
	public static void gewonnen(Stage stage){
		Group gr = new Group();
		Scene scene = new Scene(gr, 600, 450);
		Label l = new Label("Gewonnen");
		Button b = new Button("Neustart");
		
		b.setLayoutX(125);
		b.setLayoutY(135);
		b.setFont(new Font("Arial", 30));
		b.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
				strt();
		    }
		});

		l.setLayoutX(10);
		l.setLayoutY(10);
		l.setFont(new Font("Arial", 30));
		
		gr.getChildren().addAll(l,b);
		
		stage.setScene(scene);
		stage.setTitle("Gewonnen");
		stage.show();
	}
	
	//verloren öffnet sich wenn man das gesuchte wort nicht gefunden hat und das Strichmänchen gezeichnet wurde
	public static void verloren(Stage stage){
		Group gr = new Group();
		Scene scene = new Scene(gr, 600, 450);
		Label l = new Label("Verloren");
		Pane pa = new Pane();

		l.setLayoutX(10);
		l.setLayoutY(10);
		l.setFont(new Font("Arial", 30));
		Button b = new Button("Neustart");
		
		b.setLayoutX(125);
		b.setLayoutY(135);
		b.setFont(new Font("Arial", 30));
		b.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
				strt();
		    }
		});

		l.setLayoutX(10);
		l.setLayoutY(10);
		l.setFont(new Font("Arial", 30));
		
		gr.getChildren().addAll(l,b, pa,li1, li2, li3, li4, c, li6, li7, li8, li9, li10);
		
		stage.setScene(scene);
		stage.setTitle("Verloren");
		stage.show();
		
		li1.setLayoutX(380);
		li1.setLayoutY(200);
		
		li2.setLayoutX(420);
		li2.setLayoutY(150);
		
		li3.setLayoutX(420);
		li3.setLayoutY(70);
		
		li4.setLayoutX(490);
		li4.setLayoutY(150);
		
		c.setLayoutX(390);
		c.setLayoutY(110);
		
		li6.setLayoutX(490);
		li6.setLayoutY(200);
		
		li7.setLayoutX(490);
		li7.setLayoutY(130);
		
		li8.setLayoutX(490);
		li8.setLayoutY(130);
		
		li9.setLayoutX(490);
		li9.setLayoutY(350);
		
		li10.setLayoutX(490);
		li10.setLayoutY(350);
		
		pa.setPadding(new Insets(0, 200, 350, 0));
		pa.setStyle("-fx-background-color: white;" 
					+ "-fx-border-style: solid;" 
					+ "-fx-border-color: gray;");
		pa.setLayoutX(350);
		pa.setLayoutY(50);
	}
}

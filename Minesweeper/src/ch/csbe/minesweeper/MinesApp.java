package ch.csbe.minesweeper;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * 
 * @author endrit.lena
 *
 */

public class MinesApp extends Application{
	
	public static Stage stage;	//erstellt ein String mit dem namen stage
	public static GridPane gpbutton;	//erstellt ein GridPane mit dem namen gpbutton
	public static GridPane gplabel;		//erstellt ein GridPane mit dem namen gplabel
	
	//main startet die Anwendung
	public static void main(String[] args) {
		launch(args);
	}

	//Hier steht was geschehen soll wenn die Anwendung gestartet wird
	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		spiel();
	}

	//spiel ist das GUI, welches man sieht wenn die Anwendung startet
	public static void spiel(){
		gpbutton = Minesweeper.setField();
		gplabel = Minesweeper.setFieldLabel();
		Minesweeper.setBomb(gpbutton);
		
		Group g = new Group();
		Scene scene = new Scene(g,435,500);
		
		Label l = new Label("Minesweeper");
		l.setLayoutX(110);
		l.setLayoutY(30);
		l.setFont(new Font("Arial", 30));
		
		Button btn = new Button("Beenden");
		btn.getOnAction();
		
		gplabel.setStyle("-fx-border-style: solid;" + "-fx-border-color: gray;");
		gpbutton.setStyle("-fx-border-style: solid;" + "-fx-border-color: gray;");
		
		g.getChildren().addAll(gplabel,gpbutton ,l);
		
		stage.setScene(scene);
		stage.setTitle("Minesweeper");
		stage.show();
		
	}

}

package ch.csbe.minesweeper;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MinesApp extends Application{
	
	public static Stage stage;
	public static GridPane gpbutton;
	public static GridPane gplabel;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		gpbutton = Minesweeper.setField();
		gplabel = Minesweeper.setFieldlabel();
		Minesweeper.setBomb(gpbutton);
		spiel();
	}
	public static void spiel(){
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

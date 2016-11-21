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
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HenkerApp extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Henkerspiel.word = Henkerspiel.randomLetter();
		Henkerspiel.setErraten(Henkerspiel.word);
		Group gr = new Group();
		Scene scene = new Scene(gr, 600, 450);
		Pane pane = new Pane();
		Pane pa = new Pane();
		Label l = new Label("Henkerspiel");
		Button b = new Button("Enter");
		Label wort = new Label("Gesuchtes Wort: " + Henkerspiel.getErraten() + "  ["  + Henkerspiel.word.length() + " Buchstaben]");
			System.out.println(Henkerspiel.word);
		Label lb = new Label("Wort eingeben:");
		TextField txt = new TextField();	
		
		b.setLayoutX(275);
		b.setLayoutY(135);
		b.setFont(new Font("Arial", 15));
		b.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
				Henkerspiel.raten(txt.getText());
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
		
		pa.setPadding(new Insets(0, 200, 350, 0));
		pa.setStyle("-fx-background-color: white;" 
					+ "-fx-border-style: solid;" 
					+ "-fx-border-color: gray;");
		pa.setLayoutX(350);
		pa.setLayoutY(50);
		
		pane.setPadding(new Insets(0, 600, 450, 0)); 
		pane.setStyle("-fx-background-color: #e6e6e6;");
		
		gr.getChildren().addAll(pane, pa, l, wort, txt, lb, b);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Henkerspiel");
		primaryStage.show();
		
	}

}

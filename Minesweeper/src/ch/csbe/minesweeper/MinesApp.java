package ch.csbe.minesweeper;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MinesApp extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Group g = new Group();
		Scene scene = new Scene(g,400,500);
		
		GridPane gp = new GridPane();
		Label l = new Label("Minesweeper");
		l.setLayoutX(110);
		l.setLayoutY(30);
		l.setFont(new Font("Arial", 30));
		gp.setLayoutX(50);
		gp.setLayoutY(90);
		for(int i = 0;i < 10;i++){
			for(int j = 0;j < 10; j++){
				Button button = new Button(" ");
				button.setPadding(new Insets(0, 12, 12, 12));
				button.setStyle("-fx-background-color: #bfbfbf;" 
						+ "-fx-border-color: gray;"
		                + "-fx-border-style: solid;");
				button.setOnAction(new EventHandler<ActionEvent>() {
				    @Override public void handle(ActionEvent e) {
				    	button.setStyle("-fx-background-color: white;" 
								+ "-fx-border-color: gray;"
				                + "-fx-border-style: solid;");
				    }
				});
			    GridPane.setRowIndex(button, j);
			    GridPane.setColumnIndex(button, i);
				gp.getChildren().addAll(button);
			}
		}
		
		Button btn = new Button("Beenden");
		btn.getOnAction();
		
		g.getChildren().addAll(gp, l);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Minesweeper");
		primaryStage.show();
		
	}

}

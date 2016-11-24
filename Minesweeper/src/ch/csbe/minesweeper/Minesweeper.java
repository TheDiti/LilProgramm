package ch.csbe.minesweeper;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * 
 * @author endrit.lena
 *
 */

public class Minesweeper {
	
	//setBomb setzt ca. 20 Bombem an einem zufälligen platz in der GridPane
	public static void setBomb(GridPane gp){
		for(int i = 0;i<10;i++){
			for(int j = 0;j<10;j++){
				if(Math.random() < 0.2){
					Label l = (Label) getNode(MinesApp.gplabel,i,j);
					l.setText("X");
				}
			}
		}
	}
	
	//setField setzt felder in der GridPane
	public static GridPane setField(){
		GridPane gp = new GridPane();
		gp = new GridPane();
		gp.setLayoutX(50);
		gp.setLayoutY(90);
		for(int i = 0;i < 10;i++){
			for(int j = 0;j < 10; j++){
				Button button = new Button(" ");
				button.setPadding(new Insets(0, 14, 14, 14));
				button.setStyle("-fx-background-color: #bfbfbf;" 
						+ "-fx-border-color: gray;"
		                + "-fx-border-style: solid;");
				button.setOnAction(new EventHandler<ActionEvent>() {
				    @Override public void handle(ActionEvent e) {
				    	click(e);
				    }
				});
			    GridPane.setRowIndex(button, j);
			    GridPane.setColumnIndex(button, i);
			   
				gp.getChildren().addAll(button);
			}
		}
		return gp;
	}
	
	//setFieldLabel setzt Labels in der GridPane
	public static GridPane setFieldLabel(){
		GridPane gp = new GridPane();
		gp = new GridPane();
		
		gp.setLayoutX(50);
		gp.setLayoutY(90);
		for(int i = 0;i < 10;i++){
			for(int j = 0;j < 10; j++){
				Label l = new Label("O");
				l.setPadding(new Insets(4, 12, 12, 12));
				//l.setVisible(false);
				GridPane.setRowIndex(l, j);
			    GridPane.setColumnIndex(l, i);
			   
				gp.getChildren().addAll(l);
			}
		}
		return gp;
	}
	
	public static Node getNode(GridPane gridPane, int col, int row) {
	    for (Node node : gridPane.getChildren()) {
	        if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
	            return node;
	        }
	    }
	    return null;
	}
	
	//click führt das aus was geschieht wenn man auf einem Knopf klickt
	public static void click(ActionEvent e){
		Button button = (Button) e.getSource();
		int a = GridPane.getColumnIndex(button),b = GridPane.getRowIndex(button);
		Label l = (Label) getNode(MinesApp.gplabel,a,b);
    	
    	if(l.getText() == "X"){
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Game Over");
    		alert.setHeaderText("Game Over");

    		alert.showAndWait();
    		MinesApp.spiel();
    	}else{
    		button.setVisible(false);
    	}
	}


}

package ch.csbe.minesweeper;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Minesweeper {
	
	private Random random = new Random();
	
	public static void setBomb(GridPane gp){
		for(int i = 0;i<10;i++){
			for(int j = 0;j<10;j++){
				Button btn = (Button) getNode(gp,i,j);
				if(Math.random() < 0.2){
					Label l = (Label) getNode(MinesApp.gplabel,i,j);
					l.setText("X");
				}
			}
		}
	}
	
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
	
	public static GridPane setFieldlabel(){
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
	public static void click(ActionEvent e){
		Button button = (Button) e.getSource();
		int a = GridPane.getColumnIndex(button),b = GridPane.getRowIndex(button);
		Label l = (Label) getNode(MinesApp.gplabel,a,b);
//		l.setVisible(false);
    	
    	if(l.getText() == "X"){
    		//TODO set Alert window
    		System.out.println("Verloren!!!");
    	}else{
    		button.setVisible(false);
    	}
	}


}

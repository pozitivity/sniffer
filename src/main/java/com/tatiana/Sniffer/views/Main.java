package com.tatiana.Sniffer.views;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	MenuComponent menu = new MenuComponent();

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button btn = new Button();
		btn.setText("Start");
		Scene scene = new Scene(new VBox(), 800, 600);
		primaryStage.setTitle("Hello World");
		
		menu.initMenu();
		
		((VBox)scene.getRoot()).getChildren().addAll(menu.mainMenu, btn);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}

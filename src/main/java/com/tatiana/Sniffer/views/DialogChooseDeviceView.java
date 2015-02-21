package com.tatiana.Sniffer.views;

import com.tatiana.Sniffer.App;
import com.tatiana.Sniffer.controllers.DialogChooseDeviceController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class DialogChooseDeviceView extends Stage {
	
	final VBox layout;
	public static ListView<String> listViewDevs;
	public static final ObservableList<String> data = FXCollections.observableArrayList();
	public static final ObservableList<String> devs = FXCollections.observableArrayList();
	App app = new App();
	public static Button btnChoose;
	
	public DialogChooseDeviceView() {
		
		// adding list of all network device
		listViewDevs = new ListView<String>(data);
		listViewDevs.setEditable(false);
		devs.addAll(app.getListAllDevs());
		listViewDevs.setItems(devs);
		
		// adding button 
		btnChoose = new Button("OK");
		btnChoose.setStyle("-fx-border-radius: 0;");
		
		layout = new VBox(2);
		layout.setStyle("-fx-padding: 20");
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().add(listViewDevs);
		layout.setAlignment(Pos.BOTTOM_RIGHT);
		layout.getChildren().add(btnChoose);
		this.setScene(new Scene(layout, 600, 150));
		this.initModality(Modality.APPLICATION_MODAL);
		DialogChooseDeviceController.init();
		this.show();
	}
}

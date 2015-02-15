package com.tatiana.Sniffer.view;

import java.util.ArrayList;

import com.tatiana.Sniffer.App;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class DialogChooseDevice extends Stage {
	
	ListView<String> listViewDevs;
	public static final ObservableList<String> data = FXCollections.observableArrayList();
	public static final ObservableList<String> devs = FXCollections.observableArrayList();
	App app = new App();
	
	public DialogChooseDevice() {
		
		listViewDevs = new ListView<String>(data);
		listViewDevs.setEditable(false);
		
		devs.addAll(app.getListAllDevs());
		listViewDevs.setItems(devs);
		
		StackPane root = new StackPane();
		root.getChildren().add(listViewDevs);
		this.setScene(new Scene(root, 400, 150));
		this.show();
	}
}

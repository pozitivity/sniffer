package com.tatiana.Sniffer.controllers;

import com.tatiana.Sniffer.views.DialogChooseDeviceView;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class DialogChooseDeviceController {

	String selectedValue;
	
	public DialogChooseDeviceController() {
	
	}
	
	public static void init() {
		DialogChooseDeviceView.btnChoose.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println(DialogChooseDeviceView.listViewDevs.
						getSelectionModel().getSelectedItem());
				
			}
			
		});
	}
}

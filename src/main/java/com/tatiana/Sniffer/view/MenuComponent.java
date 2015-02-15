package com.tatiana.Sniffer.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuComponent {

	Menu options, about, help;
	MenuItem chooseDevice;
	public MenuBar mainMenu;
	
	public void initMenu() {
		options = new Menu("Options");
		chooseDevice = new MenuItem("Choose device...");
		options.getItems().add(chooseDevice);
		
		options.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				chooseDevice(event);
			}
		});
		
		about = new Menu("About");
		
		help = new Menu("Help");
		
		mainMenu = new MenuBar();
		
		mainMenu.getMenus().addAll(options, about, help);
	}
	
	public void chooseDevice(ActionEvent event) {
		System.out.println("Choose devices");
		DialogChooseDevice dialogChoose = new DialogChooseDevice();
		dialogChoose.show();
	}
}

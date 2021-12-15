/**
 * 
 */
package application;

import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.event.EventHandler;

/**
 * @author Moffatt
 *
 */
public class ImageLoader extends VBox {
	
	private static final String DEFAULT_IMG = "";
	private static final int DEF_HEIGHT = 500;
	private static final int DEF_WIDTH = 500;
	
	
	VBox vbox;
	HBox urlLayer;
	ImageView imgView;
	TextField urlField;
	Button button;

	public ImageLoader() {
		super();
		
		vbox = new VBox();
		urlLayer = new HBox(10);
		urlField = new TextField("https://");
		button = new Button("Load");
		
		Image img = new Image(DEFAULT_IMG, DEF_HEIGHT, DEF_WIDTH, false, false);
		imgView = new ImageView(img);
		
		this.getChildren().addAll(urlLayer, imgView);
		
		EventHandler<ActionEvent> buttonHandler = (ActionEvent event) -> {
			loadImage(event);
		};
		
		button.setOnAction(buttonHandler);
	}
	
	private void loadImage(ActionEvent e) {
		try {
			Image newImg = new Image(urlField.getText(), DEF_HEIGHT, DEF_WIDTH, false, false);
			imgView.setImage(newImg);
		} catch (IllegalArgumentException iae) {
			System.out.println("The supplied URL is invalid");
		} //try
		} //loadImage
	} //ImageLoader
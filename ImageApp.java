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
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Priority;
import javafx.geometry.Insets;

/**
 * @author Moffatt
 *
 */
public class ImageApp extends Application {

	Stage stage;
	Scene scene;
	
	VBox vbox;
	HBox hbox;
	
	HBox urlLayer;
	TextField urlField;
	Button loadImage;
	HBox container;
	
	ImageView imgView;
	
	private static final String DEFAULT_IMG = "";
	private static final int DEF_HEIGHT = 500;
	private static final int DEF_WIDTH = 500;
	
	public void start(Stage stage) {
		this.stage = stage;
		
		vbox = new VBox();
		urlLayer = new HBox(10);
		urlField = new TextField("https://");
		loadImage = new Button("Load");
		
		urlLayer.getChildren().addAll(urlField, loadImage);
		
		HBox.setHgrow(urlField, Priority.ALWAYS);
		hbox.setPadding(new Insets(10));
		
		Image img = new Image(DEFAULT_IMG, DEF_HEIGHT, DEF_WIDTH, false, false);
		
		imgView = new ImageView(img);
		imgView.setPreserveRatio(true);
		
		
		EventHandler<ActionEvent> loadImgHandler = this::loadImage;
		loadImage.setOnAction(this::loadImage);
		
		vbox.getChildren().addAll(urlLayer, imgView);
		
		ImageLoader ImageLoader1;
		ImageLoader ImageLoader2;
		
		ImageLoader1 = new ImageLoader();
		ImageLoader2 = new ImageLoader();
		
		container = new HBox(10);
		
		container.getChildren().addAll(ImageLoader1, ImageLoader2);
		
		scene = new Scene(container);
		stage.setScene(scene);
		stage.setTitle("Random Title");
		stage.sizeToScene();
		stage.show();
	} //start
	
	private void loadImage(ActionEvent e) {
		try {
			Image newImg = new Image(urlField.getText(), DEF_HEIGHT, DEF_WIDTH, false, false);
			imgView.setImage(newImg);
		} catch(IllegalArgumentException iae) {
			System.out.println("The supplied URL is invalied");
		} //catch
	} //loadImage

} //ImageApp

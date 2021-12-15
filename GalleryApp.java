package cs1302.gui;

import javafx.scene.control.ProgressBar;
import java.util.Random;
import javafx.stage.Modality;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;

import javafx.util.Duration;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.text.Text;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonArray;
import java.net.URL;
import java.net.URLEncoder;
import java.io.InputStreamReader;

import java.io.IOException;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;

//import java.lang.Runnable;

public class GalleryApp extends Application {
    String encodedString = null;
    URL url = null;
    InputStreamReader reader = null;
    String word = "rock";
    GridPane gridPane = new GridPane();
    int counter = 0;
    Timeline timeline = new Timeline();
    ProgressBar progress = new ProgressBar(0.0);
	String link = "https://www.facebook.com/photo?fbid=104110928650965&set=a.104110955317629";
    
	ToolBar toolbar = new ToolBar();
	Button pause = new Button("Pause");
	Text query = new Text("Search Query");
	TextField search = new TextField();
	Button update = new Button("Update Images");
	
    @Override
    public void start(Stage stage) {
    //ProgressBar progress = new ProgressBar)
	VBox vbox= new VBox();

	BorderPane borderPane = new BorderPane();
	HBox hbox = new HBox();
	
	final Menu file = new Menu("File");
	final Menu help = new Menu("Help");
 
	MenuBar menuBar = new MenuBar();
	menuBar.getMenus().addAll(file, help);

	MenuItem exitItem = new MenuItem("Exit");
	MenuItem aboutMe = new MenuItem("About");
	file.getItems().add(exitItem);
	help.getItems().add(aboutMe);

	aboutMe.setOnAction(e ->{
		FlowPane flowPane3 = new FlowPane();
		Text info  = new Text("About Name: Tony Robinson\n Email: par60406@uga.edu\n Version: 1.02 Alpha \nImage: ");
		Image me = new Image(link);
		flowPane3.getChildren().add(info);
		flowPane3.getChildren().add(new ImageView(me));

		Stage stage3 = new Stage();
		Scene scene3 = new Scene(flowPane3);
		stage3.setScene(scene3);
		stage3.initModality(Modality.APPLICATION_MODAL);
		stage3.setTitle("Aboout Me");
		stage3.sizeToScene();
		stage3.showAndWait();
	    });//creates the about me pop up window
	
        aboutMe.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));//allows hot keys for the help option
	
	
    exitItem.setOnAction(e ->{
		Platform.exit();
		System.exit(0);
	    });
    
    
	exitItem.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));//allows hot keys for the exit option


	
	toolbar.getItems().add(pause);
	toolbar.getItems().add(query);
	toolbar.getItems().add(search);
	toolbar.getItems().add(update);
	
	vbox.getChildren().add(menuBar);
	vbox.getChildren().add(toolbar);
	hbox.getChildren().add(progress);
	borderPane.setTop(vbox);
	borderPane.setBottom(hbox);
	borderPane.setCenter(gridPane);
	//borderPane.setBottom(progress);
	
    action();

	Scene scene = new Scene(borderPane);       	
	stage.setMaxWidth(640);
	stage.setMaxHeight(480);
        stage.setTitle("[XYZ] Gallery!");
        stage.setScene(scene);
	stage.sizeToScene();
        stage.show();
    } // start

public void action() {
    	EventHandler<ActionEvent> handler = event -> play();
    	KeyFrame keyFrame = new KeyFrame(Duration.seconds(2), handler);
    	timeline.setCycleCount(Timeline.INDEFINITE);
    	timeline.getKeyFrames().add(keyFrame);
    	timeline.play();
    	//decides how often the images will be swapped

    	pause.setOnAction(new EventHandler<ActionEvent>(){
    		public void handle(ActionEvent event){
    		    if(counter == 1)
    			{
    			    timeline.pause();
    			}
    		    
    		    if(pause.getText().equals("Play"))
    		       {
    			   pause.setText("Pause");
    			   timeline.play();
    		       }//sets play to pause and has images switch out
    		       
    		    else  if(pause.getText().equals("Pause"))
    			{
    			    pause.setText("Play");
    			    timeline.pause();
    			}//sets pause to play and stops images from moving
    		    }
    	    });
        
    	update.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(ActionEvent event){
                         word = search.getText();
                         
                        	 update(word);
                         /*
                         Platform.runLater(r);
                         Thread t = new Thread(r);
                         t.setDaemon(true);
                         t.start();
    		     */
    		    }	
    	    }); //adds the word in the search query to the url
    	update(word);	
}
    
    public static void main(String[] args) {
	try {
	    Application.launch(args);
	} catch (UnsupportedOperationException e) {
	    System.out.println(e);
	    System.err.println("If this is a DISPLAY problem, then your X server connection");
	    System.err.println("has likely timed out. This can generally be fixed by logging");
	    System.err.println("out and logging back in.");
	    System.exit(1);
	} // try
    } // main
    /**
     *swaps out all the current images with images relevant to the text entered in the search query
     *@param input the word entered into the search query
     *
     */
    
    
    public void update(String input){
	try{
            encodedString = URLEncoder.encode(input,"UTF-8");
        }catch(java.io.UnsupportedEncodingException e){
            // stuff                                                          
        } // try                                                                                   
        if(encodedString != null){
            try{
                url = new URL("http://itunes.apple.com/search?term=" + encodedString);
            }catch(java.net.MalformedURLException e){
                // stuff                                                       
            } // try                                                           
        } // if                                                                                     
        try{
            reader = new InputStreamReader(url.openStream());
        }catch(IOException e){
        }//try                                                                                      
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(reader);

	JsonObject root = je.getAsJsonObject(); 
        JsonArray results = root.getAsJsonArray("results"); // "results" array      
        int numResults = results.size();// "results" array size     
	
	if(numResults >= 20){
	    counter = 0;
	    int x = 0; 
	    int y = 0;
        //int progressBar = 0;
	    for (int i = 0; i < 20; i++) {
		JsonObject result = results.get(i).getAsJsonObject();
		JsonElement artworkUrl100 = result.get("artworkUrl100");
		if (artworkUrl100 != null) {
		    String artUrl = artworkUrl100.getAsString();
		    Image image = new Image(artUrl, 100, 100, false, false);
		    gridPane.add(new ImageView(image),y,x );
		    y++;
		    //progressBar++;
		    if(y == 5){
			y = 0;
			x++;
		    }
		    progress.setProgress(.05 * i);
		} // if
	    } // for
	}//uses the url to grab the image abojects and store them in the grid pane

	else{
	    timeline.pause();
	    FlowPane flowPane2 = new FlowPane();
	    Text info  = new Text("improper search, exit and try again");
	    flowPane2.getChildren().add(info);

	    Stage stage2 = new Stage();
	    Scene scene2 = new Scene(flowPane2, 300, 100);
	    stage2.setScene(scene2);
	    stage2.initModality(Modality.APPLICATION_MODAL);
	    stage2.setTitle("Ooops");
	    stage2.sizeToScene();
	    stage2.showAndWait();	
	} //creates a pop up window when the search has less than 20 results

    } //updates the images based on what's put in the search query 
    
    /**
     *swaps out the imgages with another image in sthe search query every 2 seconds
     */
    public void play(){
	Random rand = new Random();
	
	try{
            encodedString = URLEncoder.encode(word,"UTF-8");
        }catch(java.io.UnsupportedEncodingException e){
        } // try                                                               
        if(encodedString != null){
            try{
                url = new URL("http://itunes.apple.com/search?term=" + encodedString);
            }catch(java.net.MalformedURLException e){
                // stuff                                                       
            } // try                                                           
        } // if
	
	try {
            reader = new InputStreamReader(url.openStream());
        }catch(IOException e){
        }//try                                                                 

        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(reader);

        JsonObject root = je.getAsJsonObject();
        JsonArray results = root.getAsJsonArray("results");
	
	int y = rand.nextInt(4) + 0;
        int x = rand.nextInt(3) + 0;
        int imageNum = 21 + rand.nextInt((results.size()-22) + 1);
	
	JsonObject result = results.get(imageNum).getAsJsonObject();
	JsonElement artworkUrl100 = result.get("artworkUrl100");
	
	String artUrl = artworkUrl100.getAsString();
	Image image = new Image(artUrl, 100, 100, false, false);
	gridPane.add(new ImageView(image),y,x );
    }//executes the picture swap every two seconds
    
} // GalleryApp
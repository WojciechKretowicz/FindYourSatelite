/**
 * 
 * January 2019
 */
package kretowicz.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import kretowicz.map.Handles;
import kretowicz.map.MapFeatures;
import kretowicz.trace.Satelite;
import kretowicz.trace.Trace;

import com.esri.arcgisruntime.mapping.view.Graphic;

public class FindYourSatelite extends Application {
	
	Handles handles;
	Thread traceThread;
	
	@Override
	public void start(Stage stage) {

		// create stack pane and application scene
		StackPane stackPane = new StackPane();
		Scene scene = new Scene(stackPane);

		// set title, size, and add scene to stage
		stage.setTitle("Find your satelite");
		stage.setWidth(800);
		stage.setHeight(700);
		stage.setScene(scene);
		stage.show();

		// create handle for a position of the satelite
		handles = MapFeatures.createMap(stackPane);

		// create the Satelite object for ISS
		Satelite satelite = new Satelite("http://api.open-notify.org/iss-now.json");

		// create the Runnable for tracing satelite
		Trace trace = new Trace(satelite, 100, handles);
		traceThread = new Thread(trace);
		traceThread.start();

	}

	/**
	 * Stops and releases all resources used in application.
	 */
	@Override
	public void stop() {
		handles.getMapViewHandle().dispose();
		traceThread.stop();
	}

	/**
	 * Opens and runs application.
	 *
	 * @param args arguments passed to this application
	 */
	public static void main(String[] args) {

		Application.launch(args);
	}

}
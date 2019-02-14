/**
 * 
 * January 2019
 */
package kretowicz.map;

import com.esri.arcgisruntime.geometry.Polyline;
import com.esri.arcgisruntime.geometry.SpatialReference;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.Callout;
import com.esri.arcgisruntime.mapping.view.Graphic;
import com.esri.arcgisruntime.mapping.view.GraphicsOverlay;
import com.esri.arcgisruntime.mapping.view.MapView;
import com.esri.arcgisruntime.symbology.SimpleLineSymbol;
import com.esri.arcgisruntime.symbology.SimpleMarkerSymbol;
import com.esri.arcgisruntime.symbology.TextSymbol;

import javafx.scene.layout.StackPane;

/**
 * Class contain one static method that creates the map.
 *
 */
public class MapFeatures {

	/**
	 * 
	 * @param stackPane On this stackPane map will be displayed
	 * @return handle for changing the position of the point
	 */
	public static Handles createMap(StackPane stackPane) {

		// create a map with a web mercator basemap
		ArcGISMap map = new ArcGISMap(SpatialReference.create(3857));
		map.setBasemap(Basemap.createImagery());
		MapView mapViewHandle = new MapView();
		mapViewHandle.setMap(map);

		// create a graphics to show the input location
		GraphicsOverlay graphicsOverlay = new GraphicsOverlay();
		mapViewHandle.getGraphicsOverlays().add(graphicsOverlay);

		// create a red marker symbol for the input point
		final SimpleMarkerSymbol markerSymbol = new SimpleMarkerSymbol(SimpleMarkerSymbol.Style.CIRCLE, 0xFFFF0000, 8);
		Graphic pointHandle = new Graphic();
		pointHandle.setSymbol(markerSymbol);
		graphicsOverlay.getGraphics().add(pointHandle);

		Graphic textSymbolHandle = new Graphic();
		graphicsOverlay.getGraphics().add(textSymbolHandle);
		
		final SimpleLineSymbol lineSymbol = new SimpleLineSymbol(SimpleLineSymbol.Style.SOLID, 0xFFFFFFFF, 3);
		Graphic polylineHandle = new Graphic();
		polylineHandle.setSymbol(lineSymbol);
		graphicsOverlay.getGraphics().add(polylineHandle);
		
		stackPane.getChildren().add(mapViewHandle);

		Handles handles = new Handles(pointHandle, textSymbolHandle, polylineHandle, mapViewHandle);

		return handles;
	}
	
}

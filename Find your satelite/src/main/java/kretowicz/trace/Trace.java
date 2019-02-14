/**
 * 
 * January 2019
 */

package kretowicz.trace;

import java.util.ArrayList;
import java.util.List;

import com.esri.arcgisruntime.geometry.GeometryEngine;
import com.esri.arcgisruntime.geometry.Multipoint;
import com.esri.arcgisruntime.geometry.Part;
import com.esri.arcgisruntime.geometry.PartCollection;
import com.esri.arcgisruntime.geometry.Point;
import com.esri.arcgisruntime.geometry.PointCollection;
import com.esri.arcgisruntime.geometry.Polyline;
import com.esri.arcgisruntime.geometry.Segment;
import com.esri.arcgisruntime.geometry.SpatialReference;
import com.esri.arcgisruntime.mapping.view.Callout;
import com.esri.arcgisruntime.mapping.view.Graphic;
import com.esri.arcgisruntime.symbology.TextSymbol;
import com.esri.arcgisruntime.symbology.TextSymbol.HorizontalAlignment;
import com.esri.arcgisruntime.symbology.TextSymbol.VerticalAlignment;

import kretowicz.map.Handles;

/**
 * 
 * 
 *
 */
public class Trace implements Runnable {
	private Satelite satelite;
	private Integer window;
	private Handles handles;
	private PointCollection points;
	private List<Point> pointList;

	/**
	 * 
	 * @param satelite Satelite to trace
	 * @param window   Time after comes update, in ms
	 */
	public Trace(Satelite satelite, Integer window, Handles handles) {
		this.satelite = satelite;
		this.window = window;
		this.handles = handles;
	}

	@Override
	public void run() {
		Point point;
		Polyline polyline;
		TextSymbol textSymbol;
		
		pointList = new ArrayList<>();
		
		while (true) {
			
			// Updating satelite's position
			
			satelite.update();

			// Displaying the position
			
			point = new Point(satelite.getLongitude(), satelite.getLatitude(), SpatialReference.create(4326));

			point = (Point) GeometryEngine.project(point, SpatialReference.create(3857));

			handles.getPointHandle().setGeometry(point);

			// Displaying callout
			
			textSymbol = new TextSymbol(20, satelite.toString(), 0xFFFFFFFF, HorizontalAlignment.LEFT, VerticalAlignment.TOP);
			
			handles.getTextSymbolHandle().setGeometry(point);
			handles.getTextSymbolHandle().setSymbol(textSymbol);
			
			// Adding point to points
			
			pointList.add(point);
			
			points = new PointCollection(pointList);
			
			polyline = new Polyline(points);
			
			handles.getPolylineHandle().setGeometry(polyline);
			
			
			try {
				Thread.sleep(window);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}

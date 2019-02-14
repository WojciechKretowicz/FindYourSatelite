/**
 * 
 * January 2019
 */
package kretowicz.map;

import com.esri.arcgisruntime.geometry.Polyline;
import com.esri.arcgisruntime.mapping.view.Callout;
import com.esri.arcgisruntime.mapping.view.Graphic;
import com.esri.arcgisruntime.mapping.view.MapView;

public class Handles {
	private Graphic pointHandle;
	private Graphic textSymbolHandle;
	private Graphic polylineHandle;
	private MapView mapViewHandle;
	
	
	public Handles(Graphic pointHandle, Graphic textSymbolHandle, Graphic polylineHandle, MapView mapViewHandle) {
		this.pointHandle = pointHandle;
		this.textSymbolHandle = textSymbolHandle;
		this.polylineHandle = polylineHandle;
		this.mapViewHandle = mapViewHandle;
	}
	public Graphic getPointHandle() {
		return pointHandle;
	}
	public Graphic getTextSymbolHandle() {
		return textSymbolHandle;
	}
	
	public Graphic getPolylineHandle() {
		return polylineHandle;
	}
	
	public MapView getMapViewHandle() {
		return mapViewHandle;
	}
	
	
}

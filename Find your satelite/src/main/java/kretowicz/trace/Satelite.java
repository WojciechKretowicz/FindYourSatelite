/**
 * 
 * January 2019
 */
package kretowicz.trace;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import kretowicz.url.JsonReader;

/**
 * 
 * This class represents information about a the satelite
 *
 */
public class Satelite {
	private double longitude;
	private double latitude;
	private String url;
	
	/**
	 * 
	 * @param url url to json with information about satelite
	 */
	public Satelite(String url) {
		this.url = url;
		update();
	}
	
	/**
	 * Method updates the location of the satelite
	 */
	public void update() {
		try {
			JSONObject sateliteObject = JsonReader.readJsonFromUrl(url);
			
			sateliteObject = sateliteObject.getJSONObject("iss_position");
			longitude = sateliteObject.getDouble("longitude");
			latitude = sateliteObject.getDouble("latitude");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getLatitude() {
		return latitude;
	}
	
	@Override
	public String toString() {
		String str = "longitude: " + longitude + " latitude: " + latitude;
		return str;
	}
	
	
}

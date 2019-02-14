/**
 * Thanks to a friend Dariusz Komosinski
 * January 2019 
 */
package kretowicz.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Allows to read .json files.
 * 
 */
public class JsonReader {

	/**
	 * Reads all string lines.
	 * 
	 * @return	String value.
	 */
  private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

	/**
	 * Reads a .json file from url.
	 * 
	 * @param	url	An url where .json data is stored.
	 * @return		JSONObject.
	 */
  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONObject json = new JSONObject(jsonText);
      return json;
    } finally {
      is.close();
    }
  }

}

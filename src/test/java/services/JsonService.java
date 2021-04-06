package services;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonService {

	public String id;
	public String employee_name;
	public int employee_salary;
	public int employee_age;
	public String employee_email = "Firstname.Lastname@fake.com";

	public JsonService() {
	}

	/*
	 * In this particular method ig you run it several time you will get a 429 code,
	 * that is because to many request to the url.
	 */
	public String getDetails() {
		try {
			String stringJsonURL = "http://dummy.restapiexample.com/api/v1/employee/1";
			URL url = new URL(stringJsonURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request url: " + stringJsonURL);
			System.out.println("\nResponse Code: " + responseCode);
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println(response.toString());

			JSONObject myresponse = new JSONObject(response.toString());
			System.out.println(myresponse);

			System.out.println("status: " + myresponse.getString("status"));

			JSONObject dataDetails = new JSONObject(myresponse.getJSONObject("data").toString());
			System.out.println("data: " + dataDetails);
			System.out.println("Name: " + dataDetails.getString("employee_name"));
			this.employee_name = dataDetails.getString("employee_name");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.employee_name;

	}
}

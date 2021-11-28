package ticketviewer;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Base64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
* TicketClient authenticates and loads/save ticket data from Zendesk account.
*/
public class TicketsClient
{
	// TODO: Add methods to change subdomain, username and password during execution
	private String zendeskUrl = "https://zendeskcodingchallenge363.zendesk.com/api/v2/tickets.json";
	private String username = "dhapateashu.ad@gmail.com";
	private String password = "Ashu@8834";
	//private String username;

	//private String password;

	private TicketsViewer ui = new TicketsViewer();
	
	private ArrayList<TicketsDTO> ticketDatabase = new ArrayList<TicketsDTO>();
	
	public TicketsClient() {}

	private void getUserData(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter your username...");
		username=sc.nextLine();
		System.out.println("Please enter your password...");
		password=sc.nextLine();
		//sc.close();
	}

	private String encryptUserDetails()
	{
	//	getUserData();
		String toEncrypt = username + ":" + password;
		System.out.println(toEncrypt);
		return Base64.getEncoder().encodeToString(toEncrypt.getBytes());
	}
	
	public void loadTicketDatabase()
	{
		try
		{	
			JSONArray rawData = getJSONTicketData();	
			for (int i = 0; i < rawData.length(); i++)
			{
				JSONObject ticketData = rawData.getJSONObject(i);
				this.ticketDatabase.add(getTicket(ticketData));
			}
		}
		catch (IOException error)
		{
			ui.displayLoadError();
		}
		catch (JSONException error)
		{
			ui.displayLoadError();
		}
	}
	
	private TicketsDTO getTicket(JSONObject ticketData)
	{
		// TODO: Deserialize JSON ticket into ticket using GSON library
		TicketsDTO result = new TicketsDTO();
		result.setId(ticketData.optLong("id"));
		result.setSubject(ticketData.optString("subject"));
		result.setDescription(ticketData.optString("description"));
		result.setStatus(ticketData.optString("status"));
		result.setSubmitter_id(ticketData.optLong("submitter_id"));
		return result;
	}
	
	private JSONArray getJSONTicketData() throws JSONException, IOException
	{
		StringBuilder data = new StringBuilder();
		try
		{
			// Connect to Zendesk API using hardcoded details
			URL url = new URL(zendeskUrl);

			URLConnection uc = url.openConnection();
			String basicAuth = "Basic " + encryptUserDetails();
			uc.setRequestProperty("Authorization", basicAuth);
			
			int httpResult = ((HttpURLConnection) uc).getResponseCode();
			if (httpResult == HttpURLConnection.HTTP_OK)
			{
				BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
				String input;
				
				// Get all ticket data from the servers - UNSAFE if large amount of records is retrieved
				// save up to 100. 100 max. Then request more after the 4's page turn. Otherwise have a moving queue. Remove back 25 for more 25 and vice versa
				// TODO: Investigate API pagination
				while ((input = br.readLine()) != null)
				{
					data.append(input + "\n");
				}
				br.close();
			}
			else
			{
				ui.displayConnectError();
			}
		}
		catch (MalformedURLException error)
		{
			ui.displayConnectError();
		}
		JSONObject object = new JSONObject(data.toString());
		JSONArray result = object.getJSONArray("tickets");
		return result;
	}

	public ArrayList<TicketsDTO> getTicketDatabase() {
		return ticketDatabase;
	}
}

package ticketviewer;

import java.util.ArrayList;
import java.util.Base64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
* TicketsClient authenticates and loads/save ticket data from Zendesk account.
*/
public class TicketsClient
{

	public String zendeskUrl;

	public static String username;

	public static String password;

	public static String subdomain;

	private TicketsViewer ticketsViewer = new TicketsViewer();
	
	private ArrayList<TicketsDTO> ticketDatabase = new ArrayList<TicketsDTO>();

	InputProcessor inputProcessor;

	public TicketsClient() {}

	public String encryptUserLoginDetails()
	{
		String toEncrypt = username + ":" + password;
		return Base64.getEncoder().encodeToString(toEncrypt.getBytes());
	}
	
	public void loadTicketDatabase()
	{
		try
		{	
			JSONArray jsonArray = getJSONTicketsData();
			for (int i = 0; i < jsonArray.length(); i++)
			{
				JSONObject ticketsData = jsonArray.getJSONObject(i);
				this.ticketDatabase.add(getTickets(ticketsData));
			}
		}
		catch (IOException error)
		{
			ticketsViewer.displayLoadError();
		}
		catch (JSONException error)
		{
			ticketsViewer.displayLoadError();
		}
	}
	
	public TicketsDTO getTickets(JSONObject ticketData)
	{
		TicketsDTO ticketsDTO = new TicketsDTO();
		ticketsDTO.setId(ticketData.optLong("id"));
		ticketsDTO.setSubject(ticketData.optString("subject"));
		ticketsDTO.setDescription(ticketData.optString("description"));
		ticketsDTO.setStatus(ticketData.optString("status"));
		ticketsDTO.setSubmitterId(ticketData.optLong("submitter_id"));
		return ticketsDTO;
	}


	public JSONArray getJSONTicketsData() throws JSONException, IOException
	{
		StringBuilder data = new StringBuilder();
		try
		{
			InputProcessor inputProcessor=new InputProcessor();
			inputProcessor.getUserData();
			zendeskUrl = "https://"+subdomain+".zendesk.com/api/v2/incremental/tickets.json?start_time=1542953046";
			URL url = new URL(zendeskUrl);

			URLConnection urlConnection = url.openConnection();
			String basicAuth = "Basic " + encryptUserLoginDetails();
			urlConnection.setRequestProperty("Authorization", basicAuth);
			
			int httpResult = ((HttpURLConnection) urlConnection).getResponseCode();
			if (httpResult == HttpURLConnection.HTTP_OK)
			{
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				String input;
				
				//Here I am using API cursor request to fetch tickets if they are more than 100 as zendesk's api has
				//Pagination limit of 100 by default. The cursor request fetches all ticket data after the date 23rd Nov 2018(This epoch time is as mentioned in zendesk documentation for cursor request)
				while ((input = reader.readLine()) != null)
				{
					data.append(input + "\n");
				}
				reader.close();
			}
			else
			{
				ticketsViewer.displayConnectError();
			}
		}
		catch (MalformedURLException error)
		{
			ticketsViewer.displayConnectError();
		}
		JSONObject jsonObject = new JSONObject(data.toString());
		JSONArray jsonArray = jsonObject.getJSONArray("tickets");
		return jsonArray;
	}

	public ArrayList<TicketsDTO> getTicketsDatabase() {
		return ticketDatabase;
	}
}

package ticketviewertests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ticketviewer.TicketsClient;
import ticketviewer.TicketsDTO;

import org.junit.Test;

import java.util.ArrayList;

public class TicketsClientTest {

	@Mock
	ArrayList<TicketsDTO> ticketDatabase;

	@InjectMocks
	TicketsClient ticketsClient;

	@InjectMocks
	JSONObject jsonObject;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testEncryptUserDetails() throws Exception {
		String result = ticketsClient.encryptUserLoginDetails();
		boolean resultVal=!result.isEmpty();
		Assert.assertEquals(true, resultVal);
	}

	@Test
	public void testLoadTicketDatabase() throws Exception {
		ticketsClient.loadTicketDatabase();
	}

	@Test
	public void testGetTicket() throws Exception {
		TicketsDTO result = ticketsClient.getTickets(jsonObject);
		boolean resultVal= result!=null?true:false;
		Assert.assertEquals(true, resultVal);
	}

	@Test
	public void testGetJSONTicketData() throws Exception {
		JSONArray result = ticketsClient.getJSONTicketsData();
		boolean resultVal= result==null?true:false;
		Assert.assertEquals(false, resultVal);
	}

}

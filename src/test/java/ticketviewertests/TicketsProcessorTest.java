package ticketviewertests;

import org.junit.Assert;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ticketviewer.TicketsClient;
import ticketviewer.TicketsDTO;
import ticketviewer.TicketsProcessor;

import static org.junit.Assert.*;

import org.junit.Test;
import ticketviewer.TicketsViewer;

import java.util.ArrayList;
import java.util.Arrays;

public class TicketsProcessorTest<TickestClient> {

	@Mock
	TicketsClient ticketsClient;

	@Mock
	TicketsViewer ticketsViewer;

	@Mock
	TicketsProcessor ticketsProcessor;

	@Test
	public void testOverPageLimit() 
	{
		TicketsClient client = new TicketsClient();
		TicketsProcessor viewer = new TicketsProcessor();
		client.loadTicketDatabase();
		
		assertTrue(viewer.moreThanOnePage(client.getTicketsDatabase()));
	}

	@Test(expected = NullPointerException.class)
	public void testUnavailableSingleTicket()
	{
		ticketsClient.loadTicketDatabase();
		ticketsProcessor.viewTicket(ticketsClient.getTicketsDatabase(), -1);
	}

	@Test(expected = NullPointerException.class)
	public void testUnavailableTicketRange()
	{
		ticketsClient.loadTicketDatabase();
		ticketsProcessor.displayAllTickets(ticketsClient.getTicketsDatabase(), 789);
	}

	@Test
	public void testMoreThanOnePage() throws Exception {
		MockitoAnnotations.initMocks(this);
		boolean result = ticketsProcessor.moreThanOnePage(new ArrayList<TicketsDTO>(Arrays.asList(new TicketsDTO())));
		Assert.assertEquals(false, result);
	}

	@Test
	public void testDisplayAllTickets() throws Exception {
		MockitoAnnotations.initMocks(this);
		ticketsProcessor.displayAllTickets(new ArrayList<TicketsDTO>(Arrays.asList(new TicketsDTO())), 0);
	}

	@Test
	public void testViewTicket() throws Exception {
		MockitoAnnotations.initMocks(this);
		ticketsProcessor.viewTicket(new ArrayList<TicketsDTO>(Arrays.asList(new TicketsDTO())), 0);
	}

}

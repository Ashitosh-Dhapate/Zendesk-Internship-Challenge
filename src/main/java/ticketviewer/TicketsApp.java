package ticketviewer;

import java.io.IOException;

public class TicketsApp
{
	public static void main(String[] args) throws IOException
	{
		TicketsClient ticketsClient = new TicketsClient();
		InputProcessor inputProcessor = new InputProcessor();
		TicketsViewer ticketsViewer = new TicketsViewer();

		ticketsClient.loadTicketDatabase();

		ticketsViewer.displayWelcome();
		while (!inputProcessor.isQuitSelected())
		{
			ticketsViewer.displayMenu();
			inputProcessor.getMenuChoice(ticketsClient);
		}
		ticketsViewer.displayShutdownMessage();
	}
}

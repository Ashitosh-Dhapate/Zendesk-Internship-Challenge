package ticketviewer;

import java.io.IOException;

public class TicketsApp
{
	public static void main(String[] args) throws IOException
	{
		// TODO: handle exception here
		TicketsClient client = new TicketsClient();
		InputHandler input = new InputHandler();
		TicketsViewer ui = new TicketsViewer();
	
		client.loadTicketDatabase();
		
		ui.displayWelcome();
		while (!input.isQuit())
		{
			ui.displayMenu();
			input.getMenuChoice(client);
		}
		ui.displayShutdownMessage();
	}
}

package ticketviewer;

import java.util.ArrayList;

/**
* TicketViewer handles the core business logic of displaying single and multiple tickets as well as pagination.
*/
public class TicketsProcessor {
	private TicketsViewer ticketsViewer = new TicketsViewer();
	private static int PAGE_LIMIT = 25;

	public boolean moreThanOnePage(ArrayList<TicketsDTO> ticketDatabase)
	{
		if (ticketDatabase.size() > PAGE_LIMIT)
			return true;
		else
			return false;
	}

	public void displayAllTickets(ArrayList<TicketsDTO> ticketDatabase, int currentPage)
	{
		if (ticketDatabase.size() <= PAGE_LIMIT)
		{
			for (int i = 0; i < ticketDatabase.size(); i++)
			{
				ticketsViewer.printTicket(ticketDatabase.get(i), i+1);
			}
		}
		else
		{
			try
			{
				int currentIndex = (currentPage - 1) * PAGE_LIMIT;
				int currentIndexLimit = ticketDatabase.size() - currentIndex;
				if(currentIndexLimit>25){
					currentIndexLimit=25;
				}
				if (currentIndexLimit > PAGE_LIMIT)
					currentIndexLimit = currentIndex + PAGE_LIMIT;
				for (int i = currentIndex; i < currentIndex + currentIndexLimit; i++)
				{
					ticketsViewer.printTicket(ticketDatabase.get(i), i+1);
				}
			}
			catch (IndexOutOfBoundsException error)
			{
				ticketsViewer.displayInputError();
			}
		}
		
	}

	public void viewTicket(ArrayList<TicketsDTO> ticketDatabase, int index)
	{
		try
		{
			// As the user inputs a number that's not 0 based, index must be decremented
			ticketsViewer.printTicket(ticketDatabase.get(index-1), ticketDatabase.get(index-1).getDescription(), index);
		}
		catch (NullPointerException error)
		{
			ticketsViewer.displayNoTicketFoundError();
		}
		catch (IndexOutOfBoundsException error)
		{
			ticketsViewer.displayNoTicketFoundError();
		}
	}
}

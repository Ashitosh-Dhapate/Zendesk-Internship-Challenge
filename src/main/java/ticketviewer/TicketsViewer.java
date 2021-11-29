package ticketviewer;

/**
* TickerInterface is used as the view. Mostly displays messages/errors 
* and prints tickets.
*/
public class TicketsViewer
{
	public TicketsViewer() {}
	
	public void displayLoading()
	{
		System.out.println("\nLoading tickets...");
	}
	
	public void displayLoadError()
	{
		System.out.println("\nError: Problem in loading tickets...Please rerun again to test the app");
	}
	
	public void displayWelcome()
	{
		System.out.println("Welcome to Zendesk' Ticket Viewer");
	}

	public void displayMenu()
    	{
        	System.out.println("\nPlease insert a number from the following choices below and press Enter: ");
        	System.out.println("\n[1] - View all tickets");
        	System.out.println("\n[2] - View single ticket");
        	System.out.println("\n[3] - Quit");
        	System.out.print("Input:\n");
    	}
	
	public void displayTicketPageNumber(int currentPage, int maxPage)
	{
       		System.out.println("\nYou are on page " + currentPage + " of " + maxPage);
        	promptPageNumber();
	}
	
	public void displayTicketIDRequest()
    	{
        	System.out.println("\nPlease input a ticket number: \n");
    	}
	
	public void displayInputError()
    	{
        	System.out.println("\nError: Your input was invalid. Please rerun again to test the app");
    	}
	
	public void displayConnectError()
    	{
        	System.out.println("\nError: There is a connection issue or the API is currently unavailable. Please rerun again after some time to test the app");
    	}
	
	public void displayShutdownMessage()
    	{
        	System.out.println("\nGoodbye");
    	}
	
	public void printTicket(TicketsDTO ticket, int index)
	{
		System.out.println("\n[" + index + "] - Ticket " + Long.toString(ticket.getId()) + 
				" with subject '" + ticket.getSubject() +
				"' opened by " + ticket.getSubmitterId());
	}
	
	public void printTicket(TicketsDTO ticket, String ticketDescription, int index)
	{
		System.out.println("\n[" + index + "] - Ticket " + Long.toString(ticket.getId()) + 
				" with subject '" + ticket.getSubject() +
				"' opened by " + ticket.getSubmitterId());
		System.out.println("Content:\n" + ticketDescription);
	}

	public void displayNoTicketFoundError() 
	{
		System.out.println("\nError: No ticket found with that index...Please rerun again to test the app");
	}
	
	public void promptPageNumber() {
		System.out.println("\nPlease enter the page number you would like to view and press Enter (enter 0 to return to main menu):\n");
	}
}

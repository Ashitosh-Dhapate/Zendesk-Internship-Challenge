package ticketviewer;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
* InputHandler is the controller of the program, handling all the user input
*/

public class InputProcessor
{
	// Scanner is used for reading user input
	private Scanner scanner = new Scanner(System.in);
	// Used to exit the main loop
	private boolean quitSelected = false;
	
	private TicketsViewer ticketsViewer = new TicketsViewer();
	
	public InputProcessor() {}
	
	public boolean isQuitSelected() { return quitSelected; }
	public void setQuitOption(boolean quit) { this.quitSelected = quit; }
	
	private void scrollThroughPages(TicketsClient ticketsClient, TicketsProcessor ticketsProcessor)
	{
		int currentPageNumber = 1;
		int maxPageNumber = (int) Math.ceil(ticketsClient.getTicketsDatabase().size() / 25.0);
		while (currentPageNumber != 0)
		{
			try
			{
				if ((currentPageNumber <= maxPageNumber) && (currentPageNumber > 0))
				{
					ticketsProcessor.displayAllTickets(ticketsClient.getTicketsDatabase(), currentPageNumber);
					ticketsViewer.displayTicketPageNumber(currentPageNumber, maxPageNumber);
				}
				else
				{
					ticketsViewer.displayInputError();
					ticketsViewer.promptPageNumber();
				}
				currentPageNumber = scanner.nextInt();
			}
			catch (InputMismatchException error)
			{
				scanner.nextLine();
				ticketsViewer.displayInputError();
			}
		}
	}
	
	public void getMenuChoice(TicketsClient ticketsClient)
	{
		TicketsProcessor ticketsProcessor = new TicketsProcessor();
		
		try
		{
			switch(scanner.nextInt())
			{
			case 1:
				if (!ticketsProcessor.moreThanOnePage(ticketsClient.getTicketsDatabase()))
					ticketsProcessor.displayAllTickets(ticketsClient.getTicketsDatabase(), 0);
				else
				{
					scrollThroughPages(ticketsClient, ticketsProcessor);
				}
				break;
			case 2:
				getTicketFromID(ticketsClient);
				break;
			case 3:
				setQuitOption(true);
				break;
			default:
				ticketsViewer.displayInputError();
				break;
			}
		}
		catch (InputMismatchException error)
		{
			scanner.nextLine();
			ticketsViewer.displayInputError();
		}
	}

	private void getTicketFromID(TicketsClient ticketsClient)
	{
		TicketsProcessor ticketsProcessor = new TicketsProcessor();
		
		try
		{
			ticketsViewer.displayTicketIDRequest();
			ticketsProcessor.viewTicket(ticketsClient.getTicketsDatabase(), scanner.nextInt());
		}
		catch (InputMismatchException error)
		{
			scanner.nextLine();
			ticketsViewer.displayInputError();
		}
	}

	public void getUserData(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Please input the subdomain of your account...");
		TicketsClient.subdomain=sc.nextLine();
		System.out.println("Please enter your username...");
		TicketsClient.username=sc.nextLine();
		System.out.println("Please enter your password...");
		TicketsClient.password=sc.nextLine();
	}
	
}

package ticketviewertests;

import org.junit.Test;
import ticketviewer.TicketsDTO;
import ticketviewer.TicketsViewer;

public class TicketsViewerTest {
    TicketsViewer ticketsViewer = new TicketsViewer();

    @Test
    public void testDisplayLoading() throws Exception {
        ticketsViewer.displayLoading();
    }

    @Test
    public void testDisplayLoadError() throws Exception {
        ticketsViewer.displayLoadError();
    }

    @Test
    public void testDisplayWelcome() throws Exception {
        ticketsViewer.displayWelcome();
    }

    @Test
    public void testDisplayMenu() throws Exception {
        ticketsViewer.displayMenu();
    }

    @Test
    public void testDisplayTicketPageNumber() throws Exception {
        ticketsViewer.displayTicketPageNumber(0, 0);
    }

    @Test
    public void testDisplayTicketIDRequest() throws Exception {
        ticketsViewer.displayTicketIDRequest();
    }

    @Test
    public void testDisplayInputError() throws Exception {
        ticketsViewer.displayInputError();
    }

    @Test
    public void testDisplayConnectError() throws Exception {
        ticketsViewer.displayConnectError();
    }

    @Test
    public void testDisplayShutdownMessage() throws Exception {
        ticketsViewer.displayShutdownMessage();
    }

    @Test
    public void testPrintTicket() throws Exception {
        ticketsViewer.printTicket(new TicketsDTO(), 0);
    }

    @Test
    public void testPrintTicket2() throws Exception {
        ticketsViewer.printTicket(new TicketsDTO(), "ticketDescription", 0);
    }

    @Test
    public void testDisplayNoTicketFoundError() throws Exception {
        ticketsViewer.displayNoTicketFoundError();
    }

    @Test
    public void testPromptPageNumber() throws Exception {
        ticketsViewer.promptPageNumber();
    }
}

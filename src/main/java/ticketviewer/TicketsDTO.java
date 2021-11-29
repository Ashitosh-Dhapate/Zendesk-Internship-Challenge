package ticketviewer;

/**
* The main Tickets POJO class.
* Other fields were not added as these were the bare minimum needed to be displayed
*/
public class TicketsDTO
{
	private long id;
	private String subject;
	private String description;
	private String status;
	private long submitterId;
    
	public TicketsDTO() {}
    
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
    	}

		public String getSubject() {
        	return subject;
    	}
	
    	public void setSubject(String subject) {
        	this.subject = subject;
    	}
	
 	public String getDescription() {
		return description;
    	}
	
	public void setDescription(String description) {
       	 	this.description = description;
    	}
	
    	public String getStatus() {
        	return status;
    	}
	
    	public void setStatus(String status) {
        	this.status = status;
    	}
	
    	public long getSubmitterId() {
        	return submitterId;
    	}
	
    	public void setSubmitterId(long submitterId) {
        	this.submitterId = submitterId;
    	}
}

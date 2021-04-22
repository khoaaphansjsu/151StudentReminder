package studentReminder;

//Note: must deal with assignmentDB and Security

public class SRAccount {
	
	private String username;
	private String password;
	private AssignmentDB assignments;
	private Security accountSecurity;
	
	public SRAccount (String username, String password, 
			AssignmentDB assignments, Security accountSecurity) {
		this.username = username;
		this.password = password;
		this.assignments = assignments;
		this.accountSecurity = accountSecurity;
	}
	
	public String getUserName() {
		return username;
	}
	
	public void setPassword(String newPass) {
		password = newPass;
	}
}

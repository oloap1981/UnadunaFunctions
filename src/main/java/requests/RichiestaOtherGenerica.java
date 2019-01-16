package requests;

import java.util.List;

public class RichiestaOtherGenerica {
	
	private String functionName;
	
	//parte specifica per il servizio di email
	private String emailMessage;
	private List<String> toEmailAdresses;
	private List<String> ccEmailAdresses;
	private String emailSubject;
	private String base64Image; 
	private String filename;
	
	/**
	 * @return the emailMessage
	 */
	public String getEmailMessage() {
		return emailMessage;
	}
	/**
	 * @param emailMessage the emailMessage to set
	 */
	public void setEmailMessage(String emailMessage) {
		this.emailMessage = emailMessage;
	}
	/**
	 * @return the toEmailAdresses
	 */
	public List<String> getToEmailAdresses() {
		return toEmailAdresses;
	}
	/**
	 * @param toEmailAdresses the toEmailAdresses to set
	 */
	public void setToEmailAdresses(List<String> toEmailAdresses) {
		this.toEmailAdresses = toEmailAdresses;
	}
	/**
	 * @return the ccEmailAdresses
	 */
	public List<String> getCcEmailAdresses() {
		return ccEmailAdresses;
	}
	/**
	 * @param ccEmailAdresses the ccEmailAdresses to set
	 */
	public void setCcEmailAdresses(List<String> ccEmailAdresses) {
		this.ccEmailAdresses = ccEmailAdresses;
	}
	/**
	 * @return the emailSubject
	 */
	public String getEmailSubject() {
		return emailSubject;
	}
	/**
	 * @param emailSubject the emailSubject to set
	 */
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}
	/**
	 * @return the functionName
	 */
	public String getFunctionName() {
		return functionName;
	}
	/**
	 * @param functionName the functionName to set
	 */
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	/**
	 * @return the base64Image
	 */
	public String getBase64Image() {
		return base64Image;
	}
	/**
	 * @param base64Image the base64Image to set
	 */
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}
	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
	
}

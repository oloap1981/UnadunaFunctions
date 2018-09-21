package requests;

public class RichiestaGetGenerica {

	public static final String REQUEST_TYPE_MODELLI = "modelli";
	public static final String REQUEST_TYPE_ACCESSORI = "accessori";
	
	private String functionName;
	private String codiceModello;
	
	private String codiceConfigurazione;
	private String codiceOrdine;
	
	private String codiceUtente;
	private String emailUtente;
	
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
	 * @return the codiceModello
	 */
	public String getCodiceModello() {
		return codiceModello;
	}
	/**
	 * @param codiceModello the codiceModello to set
	 */
	public void setCodiceModello(String codiceModello) {
		this.codiceModello = codiceModello;
	}
	/**
	 * @return the codiceUtente
	 */
	public String getCodiceUtente() {
		return codiceUtente;
	}
	/**
	 * @param codiceUtente the codiceUtente to set
	 */
	public void setCodiceUtente(String codiceUtente) {
		this.codiceUtente = codiceUtente;
	}
	/**
	 * @return the emailUtente
	 */
	public String getEmailUtente() {
		return emailUtente;
	}
	/**
	 * @param emailUtente the emailUtente to set
	 */
	public void setEmailUtente(String emailUtente) {
		this.emailUtente = emailUtente;
	}
	/**
	 * @return the requestTypeModelli
	 */
	public static String getRequestTypeModelli() {
		return REQUEST_TYPE_MODELLI;
	}
	/**
	 * @return the requestTypeAccessori
	 */
	public static String getRequestTypeAccessori() {
		return REQUEST_TYPE_ACCESSORI;
	}
	/**
	 * @return the codiceConfigurazione
	 */
	public String getCodiceConfigurazione() {
		return codiceConfigurazione;
	}
	/**
	 * @param codiceConfigurazione the codiceConfigurazione to set
	 */
	public void setCodiceConfigurazione(String codiceConfigurazione) {
		this.codiceConfigurazione = codiceConfigurazione;
	}
	/**
	 * @return the codiceOrdine
	 */
	public String getCodiceOrdine() {
		return codiceOrdine;
	}
	/**
	 * @param codiceOrdine the codiceOrdine to set
	 */
	public void setCodiceOrdine(String codiceOrdine) {
		this.codiceOrdine = codiceOrdine;
	}
	
}

package requests;

public class RichiestaDeleteGenerica {
	private String functionName;
	
	private String codiceConfigurazione;
	private String codiceOrdine;
	
	private String codiceCodiceSconto;
	private String idCodiceSconto;
	
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
	public String getCodiceCodiceSconto() {
		return codiceCodiceSconto;
	}
	public void setCodiceCodiceSconto(String codiceCodiceSconto) {
		this.codiceCodiceSconto = codiceCodiceSconto;
	}
	public String getIdCodiceSconto() {
		return idCodiceSconto;
	}
	public void setIdCodiceSconto(String idCodiceSconto) {
		this.idCodiceSconto = idCodiceSconto;
	}
}

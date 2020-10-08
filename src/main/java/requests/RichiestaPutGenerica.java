package requests;

import java.util.List;

import com.marte5.unaduna.model.objects.CodiceSconto;
import com.marte5.unaduna.model.objects.Configurazione;
import com.marte5.unaduna.model.objects.Ordine;
import com.marte5.unaduna.model.objects.Utente;

public class RichiestaPutGenerica {

	private String functionName;
	private Configurazione configurazione;
	private Ordine ordine;
	private Utente utente;
	private List<String> codiciConfigurazioni;
	private CodiceSconto codiceSconto;
	private String codiceCodiceSconto;
	private String idCodiceSconto;
	private int percentualeCodiceSconto;
	private String idUtente;
	
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
	 * @return the configurazione
	 */
	public Configurazione getConfigurazione() {
		return configurazione;
	}
	/**
	 * @param configurazione the configurazione to set
	 */
	public void setConfigurazione(Configurazione configurazione) {
		this.configurazione = configurazione;
	}
	/**
	 * @return the ordine
	 */
	public Ordine getOrdine() {
		return ordine;
	}
	/**
	 * @param ordine the ordine to set
	 */
	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}
	
	/**
	 * @return the utente
	 */
	public Utente getUtente() {
		return utente;
	}
	/**
	 * @param ordine the ordine to set
	 */
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	/**
	 * @return the codiciConfigurazioni
	 */
	public List<String> getCodiciConfigurazioni() {
		return codiciConfigurazioni;
	}
	/**
	 * @param codiciConfigurazioni the codiciConfigurazioni to set
	 */
	public void setCodiciConfigurazioni(List<String> codiciConfigurazioni) {
		this.codiciConfigurazioni = codiciConfigurazioni;
	}
	public CodiceSconto getCodiceSconto() {
		return codiceSconto;
	}
	public void setCodiceSconto(CodiceSconto codiceSconto) {
		this.codiceSconto = codiceSconto;
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
	public int getPercentualeCodiceSconto() {
		return percentualeCodiceSconto;
	}
	public void setPercentualeCodiceSconto(int percentualeCodiceSconto) {
		this.percentualeCodiceSconto = percentualeCodiceSconto;
	}
	public String getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(String idUtente) {
		this.idUtente = idUtente;
	}
	
	
}

package requests;

import java.util.List;

import com.marte5.unaduna.model.objects.Configurazione;
import com.marte5.unaduna.model.objects.LogElement;
import com.marte5.unaduna.model.objects.Ordine;
import com.marte5.unaduna.model.objects.Utente;

public class RichiestaPutGenerica {

	private String functionName;
	private Configurazione configurazione;
	private Ordine ordine;
	private Utente utente;
	private List<String> codiciConfigurazioni;
	
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
	
	
}

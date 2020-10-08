package responses;

import java.util.List;

import com.marte5.unaduna.model.objects.Accessorio;
import com.marte5.unaduna.model.objects.Chiave;
import com.marte5.unaduna.model.objects.CodiceSconto;
import com.marte5.unaduna.model.objects.Configurazione;
import com.marte5.unaduna.model.objects.Esito;
import com.marte5.unaduna.model.objects.Modello;
import com.marte5.unaduna.model.objects.Ordine;
import com.marte5.unaduna.model.objects.Utente;

public class RispostaGetGenerica {
	
	private Esito esito;
	private List<Modello> modelli;
	private List<Accessorio> accessori;
	private List<Configurazione> configurazioni;
	private List<Ordine> ordini;
	private List<CodiceSconto> codiciSconto;
	private CodiceSconto codiceSconto;
	private Configurazione configurazione;
	private Ordine ordine;
	private Utente utente;
	private Chiave chiave;
	
	/**
	 * @return the esito
	 */
	public Esito getEsito() {
		return esito;
	}
	/**
	 * @param esito the esito to set
	 */
	public void setEsito(Esito esito) {
		this.esito = esito;
	}
	/**
	 * @return the utente
	 */
	public Utente getUtente() {
		return utente;
	}
	/**
	 * @param utente the utente to set
	 */
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	/**
	 * @return the modelli
	 */
	public List<Modello> getModelli() {
		return modelli;
	}
	/**
	 * @param modelli the modelli to set
	 */
	public void setModelli(List<Modello> modelli) {
		this.modelli = modelli;
	}
	/**
	 * @return the accessori
	 */
	public List<Accessorio> getAccessori() {
		return accessori;
	}
	/**
	 * @param accessori the accessori to set
	 */
	public void setAccessori(List<Accessorio> accessori) {
		this.accessori = accessori;
	}
	/**
	 * @return the configurazioni
	 */
	public List<Configurazione> getConfigurazioni() {
		return configurazioni;
	}
	/**
	 * @param configurazioni the configurazioni to set
	 */
	public void setConfigurazioni(List<Configurazione> configurazioni) {
		this.configurazioni = configurazioni;
	}
	/**
	 * @return the ordini
	 */
	public List<Ordine> getOrdini() {
		return ordini;
	}
	/**
	 * @param ordini the ordini to set
	 */
	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
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
	 * @return the chiave
	 */
	public Chiave getChiave() {
		return chiave;
	}
	/**
	 * @param chiave the chiave to set
	 */
	public void setChiave(Chiave chiave) {
		this.chiave = chiave;
	}
	public List<CodiceSconto> getCodiciSconto() {
		return codiciSconto;
	}
	public void setCodiciSconto(List<CodiceSconto> codiciSconto) {
		this.codiciSconto = codiciSconto;
	}
	public CodiceSconto getCodiceSconto() {
		return codiceSconto;
	}
	public void setCodiceSconto(CodiceSconto codiceSconto) {
		this.codiceSconto = codiceSconto;
	}
	
	
}

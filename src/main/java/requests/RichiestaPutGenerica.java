package requests;

import com.marte5.unaduna.model.objects.Configurazione;
import com.marte5.unaduna.model.objects.Ordine;

public class RichiestaPutGenerica {

	private Configurazione configurazione;
	private Ordine ordine;
	
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
	
}

package responses;

import com.marte5.unaduna.model.objects.Esito;

public class RispostaPutGenerica {
	
	private Esito esito;
	private String codiceConfigurazioneRisposta;
	private String codiceOrdineRisposta;
	private String codiceUtenteRisposta;
	private String codiceScontoRisposta;
	private String idCodiceScontoRisposta;
	private int percentualeCodiceSconto;
	
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
	 * @return the codiceOrdineRisposta
	 */
	public String getCodiceOrdineRisposta() {
		return codiceOrdineRisposta;
	}
	/**
	 * @param codiceOrdineRisposta the codiceOrdineRisposta to set
	 */
	public void setCodiceOrdineRisposta(String codiceOrdineRisposta) {
		this.codiceOrdineRisposta = codiceOrdineRisposta;
	}
	/**
	 * @return the codiceOrdineRisposta
	 */
	public String getCodiceConfigurazioneRisposta() {
		return codiceConfigurazioneRisposta;
	}
	/**
	 * @param codiceOrdineRisposta the codiceOrdineRisposta to set
	 */
	public void setCodiceConfigurazioneRisposta(String codiceConfigurazioneRisposta) {
		this.codiceConfigurazioneRisposta = codiceConfigurazioneRisposta;
	}
	/**
	 * @return the codiceUtenteRisposta
	 */
	public String getCodiceUtenteRisposta() {
		return codiceUtenteRisposta;
	}
	/**
	 * @param codiceUtenteRisposta the codiceUtenteRisposta to set
	 */
	public void setCodiceUtenteRisposta(String codiceUtenteRisposta) {
		this.codiceUtenteRisposta = codiceUtenteRisposta;
	}
	public String getCodiceScontoRisposta() {
		return codiceScontoRisposta;
	}
	public void setCodiceScontoRisposta(String codiceScontoRisposta) {
		this.codiceScontoRisposta = codiceScontoRisposta;
	}
	public String getIdCodiceScontoRisposta() {
		return idCodiceScontoRisposta;
	}
	public void setIdCodiceScontoRisposta(String idCodiceScontoRisposta) {
		this.idCodiceScontoRisposta = idCodiceScontoRisposta;
	}
	public int getPercentualeCodiceSconto() {
		return percentualeCodiceSconto;
	}
	public void setPercentualeCodiceSconto(int percentualeCodiceSconto) {
		this.percentualeCodiceSconto = percentualeCodiceSconto;
	}
	
}

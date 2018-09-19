package com.marte5.unaduna.model.objects;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="UNADUNA_Ordini")
public class Ordine {

	public static final int STATO_ORDINE_CREATO = 0;
	public static final int STATO_ORDINE_PAGATO = 1;
	public static final int STATO_ORDINE_PROCESSATO = 2;
	public static final int STATO_ORDINE_SPEDITO = 3;
	public static final int STATO_ORDINE_CHIUSO = 4;
	
	private String codice; 
	private int stato;
	private boolean pagato;
	private Utente utente;
	private Configurazione configurazione;
	
	/**
	 * @return the codice
	 */
	@DynamoDBHashKey(attributeName="codice")
	public String getCodice() {
		return codice;
	}
	/**
	 * @param codice the codice to set
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}
	/**
	 * @return the stato
	 */
	@DynamoDBAttribute(attributeName="stato")
	public int getStato() {
		return stato;
	}
	/**
	 * @param nome the stato to set
	 */
	public void setStato(int stato) {
		this.stato = stato;
	}
	/**
	 * @return the pagato
	 */
	@DynamoDBAttribute(attributeName="pagato")
	public boolean getPagato() {
		return pagato;
	}
	/**
	 * @param pagato the pagato to set
	 */
	public void setPagato(boolean pagato) {
		this.pagato = pagato;
	}
	/**
	 * @return the utente
	 */
	@DynamoDBAttribute(attributeName="utente")
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
	 * @return the configurazione
	 */
	@DynamoDBAttribute(attributeName="configurazione")
	public Configurazione getConfigurazione() {
		return configurazione;
	}
	/**
	 * @param configurazione the configurazione to set
	 */
	public void setConfigurazione(Configurazione configurazione) {
		this.configurazione = configurazione;
	}
	
}

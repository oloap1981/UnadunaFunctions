package com.marte5.unaduna.model.objects;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
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
	private float costo;
	private float costiSpedizione;
	private int stato;
	private boolean pagato;
	private String email; 
	private String codiceSconto;
	private UtenteOrdine utente;
	private List<Configurazione> configurazioni; 
	
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
	public UtenteOrdine getUtente() {
		return utente;
	}
	/**
	 * @param utente the utente to set
	 */
	public void setUtente(UtenteOrdine utente) {
		this.utente = utente;
	}
	/**
	 * @return the configurazione
	 */
	@DynamoDBAttribute(attributeName="configurazioni")
	public List<Configurazione> getConfigurazioni() {
		return configurazioni;
	}
	/**
	 * @param configurazione the configurazione to set
	 */
	public void setConfigurazioni(List<Configurazione> configurazioni) {
		this.configurazioni = configurazioni;
	}
	
	/**
	 * @return the costo
	 */
	@DynamoDBAttribute(attributeName="costo")
	public float getCosto() {
		return costo;
	}
	/**
	 * @param costo the costo to set
	 */
	public void setCosto(float costo) {
		this.costo = costo;
	}
	/**
	 * @return the costiSpedizione
	 */
	@DynamoDBAttribute(attributeName="costiSpedizione")
	public float getCostiSpedizione() {
		return costiSpedizione;
	}
	/**
	 * @param costiSpedizione the costiSpedizione to set
	 */
	public void setCostiSpedizione(float costiSpedizione) {
		this.costiSpedizione = costiSpedizione;
	}
	
	/**
	 * @return the email
	 */
	@DynamoDBAttribute(attributeName="email")
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	@DynamoDBDocument
	public static class UtenteOrdine {
			
			private String email;
			
			/**
			 * @return the email
			 */
			@DynamoDBAttribute(attributeName="email")
			public String getEmail() {
				return email;
			}
			/**
			 * @param email the email to set
			 */
			public void setEmail(String email) {
				this.email = email;
			}
			
		}

	/**
	 * @return the codiceSconto
	 */
	@DynamoDBAttribute(attributeName="codiceSconto")
	public String getCodiceSconto() {
		return codiceSconto;
	}
	/**
	 * @param codiceSconto the codiceSconto to set
	 */
	public void setCodiceSconto(String codiceSconto) {
		this.codiceSconto = codiceSconto;
	}



	

}

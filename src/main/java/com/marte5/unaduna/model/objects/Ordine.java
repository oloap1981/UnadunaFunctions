package com.marte5.unaduna.model.objects;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
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
	private UtenteOrdine utente;
	private ConfigurazioneOrdine configurazioneOrdine;
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
	@DynamoDBAttribute(attributeName="configurazione")
	public ConfigurazioneOrdine getConfigurazioneOrdine() {
		return configurazioneOrdine;
	}
	/**
	 * @param configurazione the configurazione to set
	 */
	public void setConfigurazioneOrdine(ConfigurazioneOrdine configurazioneOrdine) {
		this.configurazioneOrdine = configurazioneOrdine;
	}
	
	@DynamoDBIgnore
	public Configurazione getConfigurazione() {
		return configurazione;
	}
	/**
	 * @param configurazione the configurazione to set
	 */
	public void setConfigurazione(Configurazione configurazione) {
		this.configurazione = configurazione;
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
	
	@DynamoDBDocument
	public static class ConfigurazioneOrdine {
			
			private String codice;
			
			/**
			 * @return the email
			 */
			@DynamoDBAttribute(attributeName="codice")
			public String getCodice() {
				return codice;
			}
			/**
			 * @param email the email to set
			 */
			public void setCodice(String codice) {
				this.codice = codice;
			}
			
		}
}

package com.marte5.unaduna.model.objects;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="UNADUNA_Modelli")
public class Modello {
	
	private String nome;
	private String codice;
	private String urlStripe;
	private String urlStripeHD;
	private String urlThumbnail;
	private String urlThumbnailHD;
	private float prezzo;
	private float prezzoPieno;
	private boolean scontato;
	private List<String> accessori;
	private int ordine;
	private int ordineInterfaccia;
	private String accessorioInizialeSelezionato; 
	private boolean attivo;

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
	 * @return the nome
	 */
	@DynamoDBAttribute(attributeName="nome")
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the urlStripe
	 */
	@DynamoDBAttribute(attributeName="urlStripe")
	public String getUrlStripe() {
		return urlStripe;
	}
	/**
	 * @param urlStripe the urlStripe to set
	 */
	public void setUrlStripe(String urlStripe) {
		this.urlStripe = urlStripe;
	}
	/**
	 * @return the urlStripeHD
	 */
	@DynamoDBAttribute(attributeName="urlStripeHD")
	public String getUrlStripeHD() {
		return urlStripeHD;
	}
	/**
	 * @param urlStripeHD the urlStripeHD to set
	 */
	public void setUrlStripeHD(String urlStripeHD) {
		this.urlStripeHD = urlStripeHD;
	}
	/**
	 * @return the urlThumbnail
	 */
	@DynamoDBAttribute(attributeName="urlThumbnail")
	public String getUrlThumbnail() {
		return urlThumbnail;
	}
	/**
	 * @param urlThumbnail the urlThumbnail to set
	 */
	public void setUrlThumbnail(String urlThumbnail) {
		this.urlThumbnail = urlThumbnail;
	}
	/**
	 * @return the urlThumbnailHD
	 */
	@DynamoDBAttribute(attributeName="urlThumbnailHD")
	public String getUrlThumbnailHD() {
		return urlThumbnailHD;
	}
	/**
	 * @param urlThumbnailHD the urlThumbnailHD to set
	 */
	public void setUrlThumbnailHD(String urlThumbnailHD) {
		this.urlThumbnailHD = urlThumbnailHD;
	}
	/**
	 * @return the prezzo
	 */
	@DynamoDBAttribute(attributeName="prezzo")
	public float getPrezzo() {
		return prezzo;
	}
	/**
	 * @param prezzo the prezzo to set
	 */
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	/**
	 * @return the accessori
	 */
	@DynamoDBAttribute(attributeName="accessori")
	public List<String> getAccessori() {
		return accessori;
	}
	/**
	 * @param accessori the accessori to set
	 */
	public void setAccessori(List<String> accessori) {
		this.accessori = accessori;
	}
	/**
	 * @return the ordine
	 */
	@DynamoDBAttribute(attributeName="ordine")
	public int getOrdine() {
		return ordine;
	}
	/**
	 * @param ordine the ordine to set
	 */
	public void setOrdine(int ordine) {
		this.ordine = ordine;
	}
	/**
	 * @return the ordineInterfaccia
	 */
	@DynamoDBAttribute(attributeName="ordineInterfaccia")
	public int getOrdineInterfaccia() {
		return ordineInterfaccia;
	}
	/**
	 * @param ordineInterfaccia the ordineInterfaccia to set
	 */
	public void setOrdineInterfaccia(int ordineInterfaccia) {
		this.ordineInterfaccia = ordineInterfaccia;
	}
	
	@DynamoDBAttribute(attributeName="accessorioInizialeSelezionato")
	public String getAccessorioInizialeSelezionato() {
		return accessorioInizialeSelezionato;
	}
	public void setAccessorioInizialeSelezionato(String accessorioInizialeSelezionato) {
		this.accessorioInizialeSelezionato = accessorioInizialeSelezionato;
	}
	
	@DynamoDBAttribute(attributeName="attivo")
	public boolean getAttivo() {
		return attivo;
	}
	public void setAttivo(boolean attivo) {
		this.attivo = attivo;
	}
	/**
	 * @return the scontato
	 */
	@DynamoDBAttribute(attributeName="scontato")
	public boolean getScontato() {
		return scontato;
	}
	/**
	 * @param scontato the scontato to set
	 */
	public void setScontato(boolean scontato) {
		this.scontato = scontato;
	}
	/**
	 * @return the prezzoPieno
	 */
	@DynamoDBAttribute(attributeName="prezzoPieno")
	public float getPrezzoPieno() {
		return prezzoPieno;
	}
	/**
	 * @param prezzoPieno the prezzoPieno to set
	 */
	public void setPrezzoPieno(float prezzoPieno) {
		this.prezzoPieno = prezzoPieno;
	}
}

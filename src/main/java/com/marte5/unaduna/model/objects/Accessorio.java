package com.marte5.unaduna.model.objects;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="UNADUNA_Accessori")
public class Accessorio {

	private String nome;
	private String codice;
	private long prezzo;
	private String urlStripe;
	private String urlStripeHD;
	private String urlThumbnail;
	private String urlThumbnailHD;
	private String categoria;
	private String modello;
	private int ordine;
	private boolean vincoloColore;
	private String colore;
	private boolean vincoloMetallo;
	private String metallo;
	private String nomeStile;
	private String nomeBorchia;
	
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
	 * @return the prezzo
	 */
	@DynamoDBAttribute(attributeName="prezzo")
	public long getPrezzo() {
		return prezzo;
	}
	/**
	 * @param prezzo the prezzo to set
	 */
	public void setPrezzo(long prezzo) {
		this.prezzo = prezzo;
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
	 * @return the categoria
	 */
	@DynamoDBAttribute(attributeName="categoria")
	public String getCategoria() {
		return categoria;
	}
	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	/**
	 * @return the modello
	 */
	@DynamoDBAttribute(attributeName="modello")
	public String getModello() {
		return modello;
	}
	/**
	 * @param modello the modello to set
	 */
	public void setModello(String modello) {
		this.modello = modello;
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
	 * @return the vincoloColore
	 */
	public boolean isVincoloColore() {
		return vincoloColore;
	}
	/**
	 * @param vincoloColore the vincoloColore to set
	 */
	public void setVincoloColore(boolean vincoloColore) {
		this.vincoloColore = vincoloColore;
	}
	/**
	 * @return the colore
	 */
	public String getColore() {
		return colore;
	}
	/**
	 * @param colore the colore to set
	 */
	public void setColore(String colore) {
		this.colore = colore;
	}
	/**
	 * @return the vincoloMetallo
	 */
	public boolean isVincoloMetallo() {
		return vincoloMetallo;
	}
	/**
	 * @param vincoloMetallo the vincoloMetallo to set
	 */
	public void setVincoloMetallo(boolean vincoloMetallo) {
		this.vincoloMetallo = vincoloMetallo;
	}
	/**
	 * @return the metallo
	 */
	public String getMetallo() {
		return metallo;
	}
	/**
	 * @param metallo the metallo to set
	 */
	public void setMetallo(String metallo) {
		this.metallo = metallo;
	}
	/**
	 * @return the nomeStile
	 */
	@DynamoDBAttribute(attributeName="nomeStile")
	public String getNomeStile() {
		return nomeStile;
	}
	/**
	 * @param nomeStile the nomeStile to set
	 */
	public void setNomeStile(String nomeStile) {
		this.nomeStile = nomeStile;
	}
	/**
	 * @return the nomeBorchia
	 */
	@DynamoDBAttribute(attributeName="nomeBorchia")
	public String getNomeBorchia() {
		return nomeBorchia;
	}
	/**
	 * @param nomeBorchia the nomeBorchia to set
	 */
	public void setNomeBorchia(String nomeBorchia) {
		this.nomeBorchia = nomeBorchia;
	}
}

package com.marte5.unaduna.model.objects;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="UNADUNA_Configurazioni")
public class Configurazione {
	
	public static final String CONFIGURAZIONE_TIPO_NORMALE = "N";
	public static final String CONFIGURAZIONE_TIPO_PRECONFIG = "P";

	private String codice;
	private String nome;
	private String dedica;
	private boolean carrello;
	private List<Entita> elencoEntita;
	private UtenteConfigurazione utente;
	private String thumbnail;
	private String tipo;
	private int ordineInterfaccia; 
	private String urlImmagineInfluencer;
	
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
	 * @return the dedica
	 */
	@DynamoDBAttribute(attributeName="dedica")
	public String getDedica() {
		return dedica;
	}


	/**
	 * @param dedica the dedica to set
	 */
	public void setDedica(String dedica) {
		this.dedica = dedica;
	}
	
	/**
	 * @return the carrello
	 */
	@DynamoDBAttribute(attributeName="carrello")
	public boolean getCarrello() {
		return carrello;
	}

	/**
	 * @param carrello the carrello to set
	 */
	public void setCarrello(boolean carrello) {
		this.carrello = carrello;
	}

	/**
	 * @return the elencoEntita
	 */
	@DynamoDBAttribute(attributeName="elencoEntita")
	public List<Entita> getElencoEntita() {
		return elencoEntita;
	}


	/**
	 * @param elencoEntita the elencoEntita to set
	 */
	public void setElencoEntita(List<Entita> elencoEntita) {
		this.elencoEntita = elencoEntita;
	}
	
	/**
	 * @return the utente
	 */
	@DynamoDBAttribute(attributeName="utente")
	public UtenteConfigurazione getUtente() {
		return utente;
	}


	/**
	 * @param codice the utente to set
	 */
	public void setUtente(UtenteConfigurazione utente) {
		this.utente = utente;
	}
	
	/**
	 * @return the thumbnail
	 */
	@DynamoDBAttribute(attributeName="thumbnail")
	public String getThumbnail() {
		return thumbnail;
	}


	/**
	 * @param thumbnail the thumbnail to set
	 */
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	/**
	 * @return the tipo
	 */
	@DynamoDBAttribute(attributeName="tipo")
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@DynamoDBDocument
	public static class Entita {
		
		private String codice;
		private String nome; 
		private String descrizione;
		private String categoria;
		private String url;
		private long prezzo;
		private String tipoEntita;
		private int ordine;
		private String urlStripe;
		private String nomeStile;
		private String nomeBorchia;
		private String colore;
		private String metallo;
		private List<String> accessori;
		
		/**
		 * @return the codice
		 */
		@DynamoDBAttribute(attributeName="codice")
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
		 * @return the descrizione
		 */
		@DynamoDBAttribute(attributeName="descrizione")
		public String getDescrizione() {
			return descrizione;
		}
		/**
		 * @param descrizione the descrizione to set
		 */
		public void setDescrizione(String descrizione) {
			this.descrizione = descrizione;
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
		 * @return the url
		 */
		@DynamoDBAttribute(attributeName="url")
		public String getUrl() {
			return url;
		}
		/**
		 * @param url the url to set
		 */
		public void setUrl(String url) {
			this.url = url;
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
		 * @return the tipoEntita
		 */
		@DynamoDBAttribute(attributeName="tipoEntita")
		public String getTipoEntita() {
			return tipoEntita;
		}
		/**
		 * @param tipoEntita the tipoEntita to set
		 */
		public void setTipoEntita(String tipoEntita) {
			this.tipoEntita = tipoEntita;
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
		/**
		 * @return the colore
		 */
		@DynamoDBAttribute(attributeName="colore")
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
		 * @return the metallo
		 */
		@DynamoDBAttribute(attributeName="metallo")
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
	}

	@DynamoDBDocument
	public static class UtenteConfigurazione {
			
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


	/**
	 * @return the urlImmagineInfluencer
	 */
	@DynamoDBAttribute(attributeName="urlImmagineInfluencer")
	public String getUrlImmagineInfluencer() {
		return urlImmagineInfluencer;
	}


	/**
	 * @param urlImmagineInfluencer the urlImmagineInfluencer to set
	 */
	public void setUrlImmagineInfluencer(String urlImmagineInfluencer) {
		this.urlImmagineInfluencer = urlImmagineInfluencer;
	}
}

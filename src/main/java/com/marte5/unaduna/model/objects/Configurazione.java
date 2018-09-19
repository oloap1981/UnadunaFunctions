package com.marte5.unaduna.model.objects;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="UNADUNA_Configurazioni")
public class Configurazione {

	private String codice;
	private String nome;
	private String dedica;
	private List<Entita> elencoEntita;
	private Utente utente;
	
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
	@DynamoDBHashKey(attributeName="utente")
	public Utente getUtente() {
		return utente;
	}


	/**
	 * @param codice the utente to set
	 */
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
	
	class Entita {
		
		private String codice;
		private String nome; 
		private String descrizione;
		private String categoria;
		private String url;
		private long prezzo;
		private String tipoEntita;
		
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
		public String getTipoEntita() {
			return tipoEntita;
		}
		/**
		 * @param tipoEntita the tipoEntita to set
		 */
		public void setTipoEntita(String tipoEntita) {
			this.tipoEntita = tipoEntita;
		}
	}


}

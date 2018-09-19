package com.marte5.unaduna.handler.get;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.marte5.unaduna.model.objects.Configurazione;
import com.marte5.unaduna.model.objects.Esito;
import com.marte5.unaduna.utility.EsitoHelper;
import com.marte5.unaduna.utility.FunzioniUtils;

import requests.RichiestaGetGenerica;
import responses.RispostaGetGenerica;

public class UnaDunaGetConfigurazioniUtente implements RequestHandler<RichiestaGetGenerica, RispostaGetGenerica> {


    @Override
    public RispostaGetGenerica handleRequest(RichiestaGetGenerica request, Context context) {
    		String className = this.getClass().getName();
    		RispostaGetGenerica risposta = new RispostaGetGenerica();
    		Esito esito = FunzioniUtils.getEsitoPositivo(className);
    		List<Configurazione> configurazioniFiltrate = new ArrayList<Configurazione>();
    		String codiceUtente = request.getCodiceUtente();
    		
    		if(codiceUtente == null || codiceUtente == "") {
    			esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
    			esito.setMessage(className + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " UnaDunaGetConfigurazioniUtente - codice utente non valorizzato per la richiesta ");
    			risposta.setEsito(esito);
    			return risposta;
    		}
    		
    		AmazonDynamoDB client = null;
    		try {
    			client = AmazonDynamoDBClientBuilder.standard().build();
    		} catch (Exception e1) {
    			esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
    			esito.setMessage(className + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " getAziende ");
    			esito.setTrace(e1.getMessage());
    			risposta.setEsito(esito);
    			return risposta;
    		}
    		if(client != null) {
    			DynamoDBMapper mapper = new DynamoDBMapper(client);
    			DynamoDBScanExpression expr = new DynamoDBScanExpression();
    			List<Configurazione> configurazioni;
    			try {
    				configurazioni = mapper.scan(Configurazione.class, expr);
    			} catch (Exception e) {
    				esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
    				esito.setMessage(className + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " getAziende ");
    				esito.setTrace(e.getMessage());
    				risposta.setEsito(esito);
    				return risposta;
    			}
    			
    			for (Configurazione configurazione : configurazioni) {
				if(configurazione.getUtente().getCodice().equals(codiceUtente)) {
					configurazioniFiltrate.add(configurazione);
				}
			}
    			
    			risposta.setConfigurazioni(configurazioniFiltrate);
    		}	
    		
    		risposta.setEsito(esito);
    		return risposta;
    }
}
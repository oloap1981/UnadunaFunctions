package com.marte5.unaduna.handler.get;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.marte5.unaduna.model.objects.Configurazione;
import com.marte5.unaduna.model.objects.Esito;
import com.marte5.unaduna.utility.EsitoHelper;
import com.marte5.unaduna.utility.FunzioniUtils;

import requests.RichiestaGetGenerica;
import responses.RispostaGetGenerica;

public class UnaDunaGetConfigurazione implements RequestHandler<RichiestaGetGenerica, RispostaGetGenerica> {

    @Override
    public RispostaGetGenerica handleRequest(RichiestaGetGenerica request, Context context) {
    		String className = this.getClass().getName();
    		RispostaGetGenerica risposta = new RispostaGetGenerica();
    		Esito esito = FunzioniUtils.getEsitoPositivo(className);
    		
    		String codiceConfigurazione = request.getCodiceConfigurazione();
    		
    		if(codiceConfigurazione == null || codiceConfigurazione.equals("")) {
    			esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
    			esito.setMessage(className + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " getConfigurazione - codice configurazione non specificato ");
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
    			Configurazione configurazione;
    			try {
    				configurazione = mapper.load(Configurazione.class, codiceConfigurazione);
    			} catch (Exception e) {
    				esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
    				esito.setMessage(className + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " getAziende ");
    				esito.setTrace(e.getMessage());
    				risposta.setEsito(esito);
    				return risposta;
    			}
    			risposta.setConfigurazione(configurazione);
    		}	
    		
    		risposta.setEsito(esito);
    		return risposta;
    }
}
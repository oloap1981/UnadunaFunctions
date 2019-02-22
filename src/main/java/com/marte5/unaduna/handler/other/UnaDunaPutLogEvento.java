package com.marte5.unaduna.handler.other;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.marte5.unaduna.model.objects.Esito;
import com.marte5.unaduna.model.objects.LogElement;
import com.marte5.unaduna.utility.EsitoHelper;
import com.marte5.unaduna.utility.FunzioniUtils;

import requests.RichiestaOtherGenerica;
import responses.RispostaOtherGenerica;

public class UnaDunaPutLogEvento implements RequestHandler<RichiestaOtherGenerica, RispostaOtherGenerica> {

    @Override
    public RispostaOtherGenerica handleRequest(RichiestaOtherGenerica request, Context context) {
    	
    		String className = this.getClass().getName();
    		RispostaOtherGenerica risposta = new RispostaOtherGenerica();
    		Esito esito = FunzioniUtils.getEsitoPositivo(className);
    		
    		AmazonDynamoDB client = null;
    		try {
    			client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.EU_CENTRAL_1).build();
    		} catch (Exception e1) {
    			esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_SALVATAGGIO);
    			esito.setMessage(EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_PROCEDURA_LAMBDA + " putLogEventi ");
    			esito.setTrace(e1.getMessage());
    			risposta.setEsito(esito);
    			return risposta;
    		}
    		if(client != null) {
    			DynamoDBMapper mapper = new DynamoDBMapper(client);
    			LogElement logElement = request.getLogElement();
    			logElement.setId(FunzioniUtils.getEntitaIdLong());
    			try {
    				mapper.save(logElement);
    			} catch (Exception e) {
    				esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
    				esito.setMessage(className + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " putLogEventi ");
    				esito.setTrace(e.getMessage());
    				risposta.setEsito(esito);
    				return risposta;
    			}
    		}	
    		risposta.setEsito(esito);
    		return risposta;
    }
}
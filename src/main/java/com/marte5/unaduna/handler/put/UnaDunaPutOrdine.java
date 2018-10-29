package com.marte5.unaduna.handler.put;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.marte5.unaduna.model.objects.Configurazione;
import com.marte5.unaduna.model.objects.Esito;
import com.marte5.unaduna.model.objects.Ordine;
import com.marte5.unaduna.utility.EsitoHelper;
import com.marte5.unaduna.utility.FunzioniUtils;

import requests.RichiestaPutGenerica;
import responses.RispostaPutGenerica;

public class UnaDunaPutOrdine implements RequestHandler<RichiestaPutGenerica, RispostaPutGenerica> {


    @Override
    public RispostaPutGenerica handleRequest(RichiestaPutGenerica request, Context context) {
    		String className = this.getClass().getName();
    		RispostaPutGenerica risposta = new RispostaPutGenerica();
    		Esito esito = FunzioniUtils.getEsitoPositivo(className);
    		
    		String codiceOrdineRisposta = "";
    		
    		AmazonDynamoDB client = null;
    		try {
    			client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.EU_CENTRAL_1).build();
    		} catch (Exception e1) {
    			esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_SALVATAGGIO);
    			esito.setMessage(EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_PROCEDURA_LAMBDA + " putOrdine ");
    			esito.setTrace(e1.getMessage());
    			risposta.setEsito(esito);
    			return risposta;
    		}
    		if(client != null) {
    			DynamoDBMapper mapper = new DynamoDBMapper(client);
    			Ordine ordine = request.getOrdine();
    			
    			String codiceOrdine = ordine.getCodice();
    			if(codiceOrdine == null || codiceOrdine.equals("")) {
        			//insert
    				codiceOrdine = FunzioniUtils.getEntitaId();
	        } 
    			codiceOrdineRisposta = codiceOrdine;
	        	ordine.setCodice(codiceOrdine);
    			
    			try {
    				mapper.save(ordine);
    			} catch (Exception e) {
    				esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
    				esito.setMessage(className + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " putOrdine ");
    				esito.setTrace(e.getMessage());
    				risposta.setEsito(esito);
    				return risposta;
    			}
    			risposta.setCodiceConfigurazioneRisposta(codiceOrdineRisposta);
    		}	
    		risposta.setEsito(esito);
    		return risposta;
    }
}
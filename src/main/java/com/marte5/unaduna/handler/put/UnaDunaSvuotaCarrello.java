package com.marte5.unaduna.handler.put;

import java.util.List;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.marte5.unaduna.model.objects.Configurazione;
import com.marte5.unaduna.model.objects.Esito;
import com.marte5.unaduna.utility.EsitoHelper;
import com.marte5.unaduna.utility.FunzioniUtils;

import requests.RichiestaPutGenerica;
import responses.RispostaPutGenerica;

public class UnaDunaSvuotaCarrello implements RequestHandler<RichiestaPutGenerica, RispostaPutGenerica> {


    @Override
    public RispostaPutGenerica handleRequest(RichiestaPutGenerica request, Context context) {
    		String className = this.getClass().getName();
    		RispostaPutGenerica risposta = new RispostaPutGenerica();
    		Esito esito = FunzioniUtils.getEsitoPositivo(className);
    		
    		AmazonDynamoDB client = null;
    		try {
    			client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.EU_CENTRAL_1).build();
    		} catch (Exception e1) {
    			esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_SALVATAGGIO);
    			esito.setMessage(EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_PROCEDURA_LAMBDA + " putConfigurazione ");
    			esito.setTrace(e1.getMessage());
    			risposta.setEsito(esito);
    			return risposta;
    		}
    		if(client != null) {
    			DynamoDBMapper mapper = new DynamoDBMapper(client);

    			List<String> configurazioni = request.getCodiciConfigurazioni();
    			if(configurazioni == null) {
    				esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
    				esito.setMessage(className + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " putConfigurazione ");
    				esito.setTrace("non riesco a recuperare informazioni relative alla configurazione - " + request.toString());
    				risposta.setEsito(esito);
    				return risposta;
    			}
    			for(int i = 0; i < configurazioni.size(); i++) {
    				String codiceConfigurazione = configurazioni.get(i);
    				//carico la configurazione
    				Configurazione configurazione = mapper.load(Configurazione.class, codiceConfigurazione);
    				if(configurazione != null) {
    					//cambio lo stato
    					configurazione.setCarrello(false);
    					//salvo
    					try {
    						mapper.save(configurazione);
    	    			} catch (Exception e) {
    	    				esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
    	    				esito.setMessage(className + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " svuotaCarrello ");
    	    				esito.setTrace(e.getMessage());
    	    				risposta.setEsito(esito);
    	    				return risposta;
    	    			}
    				}
    			}
    		}	
    		risposta.setEsito(esito);
    		return risposta;
    }
}
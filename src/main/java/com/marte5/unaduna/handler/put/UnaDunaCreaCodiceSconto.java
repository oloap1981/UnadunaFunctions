package com.marte5.unaduna.handler.put;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.marte5.unaduna.model.objects.CodiceSconto;
import com.marte5.unaduna.model.objects.Configurazione;
import com.marte5.unaduna.model.objects.Esito;
import com.marte5.unaduna.utility.EsitoHelper;
import com.marte5.unaduna.utility.FunzioniUtils;

import requests.RichiestaPutGenerica;
import responses.RispostaPutGenerica;

public class UnaDunaCreaCodiceSconto implements RequestHandler<RichiestaPutGenerica, RispostaPutGenerica>{
	


    @Override
    public RispostaPutGenerica handleRequest(RichiestaPutGenerica request, Context context) {
    		String className = this.getClass().getName();
    		RispostaPutGenerica risposta = new RispostaPutGenerica();
    		Esito esito = FunzioniUtils.getEsitoPositivo(className);
    		
    		String idCodiceScontoRisposta = "";
    		
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

    			CodiceSconto codiceSconto = request.getCodiceSconto();
    			if(codiceSconto == null) {
    				esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
    				esito.setMessage(className + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " putCodiceSconto ");
    				esito.setTrace("non riesco a recuperare informazioni relative al codice sconto - " + request.toString());
    				risposta.setEsito(esito);
    				return risposta;
    			}
    			String idCodiceSconto = codiceSconto.getId();
    			if(idCodiceSconto == null || idCodiceSconto.equals("")) {
        			//insert
    				idCodiceSconto = FunzioniUtils.getEntitaId();
    			} 
    			idCodiceScontoRisposta = idCodiceSconto;
	        	codiceSconto.setId(idCodiceScontoRisposta);
    			
    			try {
    				mapper.save(codiceSconto);
    			} catch (Exception e) {
    				esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
    				esito.setMessage(className + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " putConfigurazione ");
    				esito.setTrace(e.getMessage());
    				risposta.setEsito(esito);
    				return risposta;
    			}
    			risposta.setCodiceScontoRisposta(codiceSconto.getCodice());
    			risposta.setIdCodiceScontoRisposta(idCodiceSconto);
    		}	
    		risposta.setEsito(esito);
    		return risposta;
    }
}

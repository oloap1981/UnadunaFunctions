package com.marte5.unaduna.handler.delete;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.marte5.unaduna.model.objects.CodiceSconto;
import com.marte5.unaduna.model.objects.Esito;
import com.marte5.unaduna.utility.EsitoHelper;
import com.marte5.unaduna.utility.FunzioniUtils;

import requests.RichiestaDeleteGenerica;
import responses.RispostaDeleteGenerica;

public class UnaDunaDeleteCodiceSconto  implements RequestHandler<RichiestaDeleteGenerica, RispostaDeleteGenerica>{
	 @Override
	    public RispostaDeleteGenerica handleRequest(RichiestaDeleteGenerica request, Context context) {
	    		String className = this.getClass().getName();
	    		RispostaDeleteGenerica risposta = new RispostaDeleteGenerica();
	    		Esito esito = FunzioniUtils.getEsitoPositivo(className);
	    		
	    		String idCodiceSconto = request.getIdCodiceSconto();
	    		
	    		AmazonDynamoDB client = null;
	    		try {
	    			client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.EU_CENTRAL_1).build();
	    		} catch (Exception e1) {
	    			esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_SALVATAGGIO);
	    			esito.setMessage(EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_PROCEDURA_LAMBDA + " deleteCodiceSconto ");
	    			esito.setTrace(e1.getMessage());
	    			risposta.setEsito(esito);
	    			return risposta;
	    		}
	    		if(client != null) {
	    			DynamoDBMapper mapper = new DynamoDBMapper(client);
	    			CodiceSconto codiceSconto = mapper.load(CodiceSconto.class, idCodiceSconto);
	    			
	    			try {
	    				mapper.delete(codiceSconto);
	    			} catch (Exception e) {
	    				esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
	    				esito.setMessage(className + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " deleteCodiceSconto ");
	    				esito.setTrace(e.getMessage());
	    				risposta.setEsito(esito);
	    				return risposta;
	    			}
	    		}	
	    		risposta.setEsito(esito);
	    		return risposta;
	    }
}

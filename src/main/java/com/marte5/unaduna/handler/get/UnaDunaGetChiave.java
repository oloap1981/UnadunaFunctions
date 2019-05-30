package com.marte5.unaduna.handler.get;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.marte5.unaduna.model.objects.Chiave;
import com.marte5.unaduna.model.objects.Esito;
import com.marte5.unaduna.utility.EsitoHelper;
import com.marte5.unaduna.utility.FunzioniUtils;

import requests.RichiestaGetGenerica;
import responses.RispostaGetGenerica;

public class UnaDunaGetChiave implements RequestHandler<RichiestaGetGenerica, RispostaGetGenerica> {

    @Override
    public RispostaGetGenerica handleRequest(RichiestaGetGenerica request, Context context) {
    		String className = this.getClass().getName();
    		RispostaGetGenerica risposta = new RispostaGetGenerica();
    		Esito esito = FunzioniUtils.getEsitoPositivo(className);
    		
    		String emailUtente = request.getEmailUtente();
    		
    		if(emailUtente == null || emailUtente.equals("")) {
    			esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
    			esito.setMessage(className + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " getChiave - email utente non specificato ");
    			risposta.setEsito(esito);
    			return risposta;
    		}
    		
    		AmazonDynamoDB client = null;
    		try {
    			client = AmazonDynamoDBClientBuilder.standard().build();
    		} catch (Exception e1) {
    			esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
    			esito.setMessage(className + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " getChiave ");
    			esito.setTrace(e1.getMessage());
    			risposta.setEsito(esito);
    			return risposta;
    		}
    		if(client != null) {
    			
    			DynamoDBMapper mapper = new DynamoDBMapper(client);
    			DynamoDBScanExpression expr = new DynamoDBScanExpression();
    			
				ArrayList<AttributeValue> attributi = new ArrayList<AttributeValue>();
    			AttributeValue attributo = new AttributeValue(emailUtente);
    			attributi.add(attributo);
    			expr.addFilterCondition("emailUtente", new Condition().withComparisonOperator(ComparisonOperator.EQ).withAttributeValueList(attributi));
    			
    			List<Chiave> chiavi;
    			try {
    				chiavi = mapper.scan(Chiave.class, expr);
    			} catch (Exception e) {
    				esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
    				esito.setMessage(className + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " getChiave ");
    				esito.setTrace(e.getMessage());
    				risposta.setEsito(esito);
    				return risposta;
    			}
    			
    			if(chiavi.size() == 0) {
    				esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
    				esito.setMessage(className + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " getChiave :  non esistono chiavi per l'utente specificato");
    				risposta.setEsito(esito);
    				return risposta;
    			} else if (chiavi.size() > 1) {
    				esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
    				esito.setMessage(className + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " getChiave :  esiste piu' di una chiave per l'utente selezionato, c'è una qualche anomalia");
    				risposta.setEsito(esito);
    				return risposta;
    			}
    			
    			risposta.setChiave(chiavi.get(0));
    		}	
    		
    		risposta.setEsito(esito);
    		return risposta;
    }
}
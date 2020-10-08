package com.marte5.unaduna.handler.put;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import com.marte5.unaduna.model.objects.CodiceSconto;
import com.marte5.unaduna.model.objects.Esito;
import com.marte5.unaduna.utility.EsitoHelper;
import com.marte5.unaduna.utility.FunzioniUtils;

import requests.RichiestaPutGenerica;
import responses.RispostaPutGenerica;

public class UnaDunaConsumaCodiceSconto implements RequestHandler<RichiestaPutGenerica, RispostaPutGenerica>{
	


    @Override
    public RispostaPutGenerica handleRequest(RichiestaPutGenerica request, Context context) {
    	
    		final String TIPO_CODICESCONTO_GENERICO = "G";
    		final String TIPO_CODICESCONTO_PERSONALIZZATO = "P";
    	
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

    			String codiceCodiceSconto = request.getCodiceCodiceSconto();
    			if(codiceCodiceSconto == null) {
    				esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
    				esito.setMessage(className + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " consumaCodiceSconto ");
    				esito.setTrace("non riesco a recuperare informazioni relative al codice sconto - " + request.toString());
    				risposta.setEsito(esito);
    				return risposta;
    			}
    			
				DynamoDBScanExpression expr = new DynamoDBScanExpression();			
				
				ArrayList<AttributeValue> attributi = new ArrayList<AttributeValue>();
				AttributeValue attributo = new AttributeValue(codiceCodiceSconto);
				attributi.add(attributo);
				expr.addFilterCondition("codice", new Condition().withComparisonOperator(ComparisonOperator.EQ).withAttributeValueList(attributi));				
				
		        List<CodiceSconto> codiciSconto;
				try {
					codiciSconto = mapper.scan(CodiceSconto.class, expr);
				} catch (Exception e1) {
					esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
					esito.setMessage(this.getClass().getName() + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " getEventiAzienda ");
					esito.setTrace(e1.getMessage());
					esito.setMessage(this.getClass().getName() + " - " + esito.getMessage());
					risposta.setEsito(esito);
					return risposta;
				}
    			if(codiciSconto.size() == 0) {
    				esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
    				esito.setMessage(className + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " consumaCodiceSconto ");
    				esito.setTrace("non esiste questo codice sconto");
    				risposta.setEsito(esito);
    				return risposta;
    			}
    			if(codiciSconto.size() > 1) {
    				esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
    				esito.setMessage(className + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " consumaCodiceSconto ");
    				esito.setTrace("si è verificato un problema nel recupero da DB del codice sconto");
    				risposta.setEsito(esito);
    				return risposta;
    			}
    			CodiceSconto codiceSconto = codiciSconto.get(0);
    			if(codiceSconto.getValido() == 0) {
					// codice sconto scaduto
					esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
    				esito.setMessage(className + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " consumaCodiceSconto ");
    				esito.setTrace("il codice sconto che si sta tentando di usare non è valido");
    				risposta.setEsito(esito);
    				return risposta;
				}
    			long dataScadenza = codiceSconto.getDataScadenza();
    			long dataInizio = codiceSconto.getDataInizio();
				Date dataCorrente = new Date();
				long dataCorrenteMillis = dataCorrente.getTime();
				if(dataScadenza < dataCorrenteMillis) {
					// codice sconto scaduto
					esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
    				esito.setMessage(className + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " consumaCodiceSconto ");
    				esito.setTrace("il codice sconto che si sta tentando di usare è scaduto");
    				risposta.setEsito(esito);
    				return risposta;
				}
				if(dataInizio > dataCorrenteMillis) {
					// codice sconto scaduto
					esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
    				esito.setMessage(className + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " consumaCodiceSconto ");
    				esito.setTrace("il codice sconto che si sta tentando di usare non è ancora attivo");
    				risposta.setEsito(esito);
    				return risposta;
				}
    			String tipo = codiceSconto.getTipoCodice();
    			if(tipo.equals(TIPO_CODICESCONTO_PERSONALIZZATO)) {
    				// controllo solo se è stato già usato
    				String idUtente = request.getIdUtente();
    				if(idUtente == null ||  idUtente.equals("")) {
    					esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
        				esito.setMessage(className + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " consumaCodiceSconto ");
        				esito.setTrace("non è stato fornito un idUtente valido");
        				risposta.setEsito(esito);
        				return risposta;	
    				}
    				if(!codiceSconto.getIdUtente().equals(idUtente)) {
    					esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
        				esito.setMessage(className + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " consumaCodiceSconto ");
        				esito.setTrace("il codice sconto fornito non è associato a questo utente");
        				risposta.setEsito(esito);
        				return risposta;
    				}
    				codiceSconto.setValido(0);
    			} 
    			
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
    			risposta.setPercentualeCodiceSconto(codiceSconto.getPercentuale());
    		}	
    		risposta.setEsito(esito);
    		return risposta;
    }
}

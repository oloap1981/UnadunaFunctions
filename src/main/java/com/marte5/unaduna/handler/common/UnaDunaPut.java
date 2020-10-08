package com.marte5.unaduna.handler.common;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.marte5.unaduna.model.objects.Esito;
import com.marte5.unaduna.utility.EsitoHelper;
import com.marte5.unaduna.utility.FunzioniUtils;

import requests.RichiestaPutGenerica;
import responses.RispostaPutGenerica;

public class UnaDunaPut implements RequestHandler<RichiestaPutGenerica, RispostaPutGenerica> {

	private final static String FUNCTION_NAME_PUT_CONFIGURAZIONE = "UnaDunaPutConfigurazione";
	private final static String FUNCTION_NAME_PUT_ORDINE = "UnaDunaPutOrdine";
	private final static String FUNCTION_NAME_PUT_UTENTE = "UnaDunaPutUtente";
	private final static String FUNCTION_NAME_SVUOTA_CARRELLO = "UnaDunaSvuotaCarrello";
	private final static String FUNCTION_NAME_CREACODICESCONTO = "UnaDunaCreaCodiceSconto";
	private final static String FUNCTION_NAME_CONSUMACODICESCONTO = "UnaDunaConsumaCodiceSconto";
	private static final String PACKAGE_NAME_PUT = "com.marte5.unaduna.handler.put.";
	
    @Override
    public RispostaPutGenerica handleRequest(RichiestaPutGenerica input, Context context) {
    	String className = this.getClass().getName();
        context.getLogger().log("Input: " + input);
        RispostaPutGenerica risposta = new RispostaPutGenerica();
        String functionName = input.getFunctionName();
        Esito esito = FunzioniUtils.getEsitoPositivo(className);
        
        if(!isFunctionNameValid(functionName)) {
        	esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
			esito.setMessage(EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " la funzione richiesta " + functionName + " non esiste ");
			risposta.setEsito(esito);
			return risposta;
        }
        
        try {
			@SuppressWarnings("unchecked")
			RequestHandler<RichiestaPutGenerica, RispostaPutGenerica> handler = (RequestHandler<RichiestaPutGenerica, RispostaPutGenerica>) Class.forName(PACKAGE_NAME_PUT + functionName).newInstance();
			risposta = handler.handleRequest(input, context);
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
			esito.setMessage(EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " PUT generica ");
			esito.setTrace(e.getMessage());
			risposta.setEsito(esito);
			return risposta;
		}
        
        return risposta;
    }
    
    private boolean isFunctionNameValid(String nomeFunzione) {
    		List<String> funzioni = new ArrayList<>();
    		
    		funzioni.add(FUNCTION_NAME_PUT_CONFIGURAZIONE);
    		funzioni.add(FUNCTION_NAME_PUT_ORDINE);
    		funzioni.add(FUNCTION_NAME_PUT_UTENTE);
    		funzioni.add(FUNCTION_NAME_SVUOTA_CARRELLO);
    		funzioni.add(FUNCTION_NAME_SVUOTA_CARRELLO);
    		funzioni.add(FUNCTION_NAME_CREACODICESCONTO);
    		funzioni.add(FUNCTION_NAME_CONSUMACODICESCONTO);
    		
    		return funzioni.contains(nomeFunzione);
    }
}

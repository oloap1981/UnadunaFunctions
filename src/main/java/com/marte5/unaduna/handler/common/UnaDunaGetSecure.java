package com.marte5.unaduna.handler.common;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.marte5.unaduna.model.objects.Esito;
import com.marte5.unaduna.utility.EsitoHelper;
import com.marte5.unaduna.utility.FunzioniUtils;

import requests.RichiestaGetGenerica;
import responses.RispostaGetGenerica;

public class UnaDunaGetSecure implements RequestHandler<RichiestaGetGenerica, RispostaGetGenerica> {

	private final static String FUNCTION_NAME_GET_ACCESSORI = "UnaDunaGetAccessori";
	private final static String FUNCTION_NAME_GET_MODELLI = "UnaDunaGetModelli";
	private final static String FUNCTION_NAME_GET_CONFIGURAZIONE = "UnaDunaGetConfigurazione";
	private final static String FUNCTION_NAME_GET_CONFIGURAZIONI = "UnaDunaGetConfigurazioni";
	private final static String FUNCTION_NAME_GET_CONFIGURAZIONI_UTENTE = "UnaDunaGetConfigurazioniUtente";
	private final static String FUNCTION_NAME_GET_ORDINE = "UnaDunaGetOrdine";
	private final static String FUNCTION_NAME_GET_ORDINI = "UnaDunaGetOrdini";
	private final static String FUNCTION_NAME_GET_ORDINI_UTENTE = "UnaDunaGetOrdiniUtente";
	private final static String FUNCTION_NAME_GET_CONFIGURAZIONI_PRECONFIGURATE = "UnaDunaGetConfigurazioniPreconfigurate";
	private final static String FUNCTION_NAME_GET_CONFIGURAZIONI_SHOPPING = "UnaDunaGetConfigurazioniShopping";
	private final static String FUNCTION_NAME_GET_CHIAVI = "UnaDunaGetChiave";
	private final static String FUNCTION_NAME_GET_CODICISCONTO = "UnaDunaGetCodiciSconto";
	private final static String FUNCTION_NAME_GET_CODICESCONTO = "UnaDunaGetCodiceSconto";
	
	private static final String PACKAGE_NAME_GET = "com.marte5.unaduna.handler.get.";
	
    @Override
    public RispostaGetGenerica handleRequest(RichiestaGetGenerica input, Context context) {
    	    String className = this.getClass().getName();
        context.getLogger().log("Input: " + input);
        RispostaGetGenerica risposta = new RispostaGetGenerica();

        String functionName = input.getFunctionName();
        Esito esito = FunzioniUtils.getEsitoPositivo(className);
        
        if(!isFunctionNameValid(functionName)) {
        	esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
			esito.setMessage(EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " la funzione richiesta non esiste ");
			risposta.setEsito(esito);
			return risposta;
        }
        
        try {
			@SuppressWarnings("unchecked")
			RequestHandler<RichiestaGetGenerica, RispostaGetGenerica> handler = (RequestHandler<RichiestaGetGenerica, RispostaGetGenerica>) Class.forName(PACKAGE_NAME_GET + functionName).newInstance();
			risposta = handler.handleRequest(input, context);
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
			esito.setMessage(EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " get generica ");
			esito.setTrace(e.getMessage());
			risposta.setEsito(esito);
			return risposta;
		}
        
        return risposta;
    }
    
    private boolean isFunctionNameValid(String nomeFunzione) {
    		List<String> funzioni = new ArrayList<>();
    		
    		funzioni.add(FUNCTION_NAME_GET_ACCESSORI);
    		funzioni.add(FUNCTION_NAME_GET_MODELLI);
    		funzioni.add(FUNCTION_NAME_GET_CONFIGURAZIONI);
    		funzioni.add(FUNCTION_NAME_GET_CONFIGURAZIONE);
    		funzioni.add(FUNCTION_NAME_GET_CONFIGURAZIONI_UTENTE);
    		funzioni.add(FUNCTION_NAME_GET_ORDINE);
    		funzioni.add(FUNCTION_NAME_GET_ORDINI);
    		funzioni.add(FUNCTION_NAME_GET_ORDINI_UTENTE);
    		funzioni.add(FUNCTION_NAME_GET_CONFIGURAZIONI_PRECONFIGURATE);
    		funzioni.add(FUNCTION_NAME_GET_CONFIGURAZIONI_SHOPPING);
    		funzioni.add(FUNCTION_NAME_GET_CHIAVI);
    		funzioni.add(FUNCTION_NAME_GET_CODICISCONTO);
    		funzioni.add(FUNCTION_NAME_GET_CODICESCONTO);
    		
    		return funzioni.contains(nomeFunzione);
    }
}

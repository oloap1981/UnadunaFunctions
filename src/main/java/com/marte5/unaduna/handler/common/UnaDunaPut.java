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

public class UnaDunaPut implements RequestHandler<RichiestaGetGenerica, RispostaGetGenerica> {

	private final static String FUNCTION_NAME_PUT_CONFIGURAZIONE = "UnaDunaPutConfigurazione";
	private final static String FUNCTION_NAME_PUT_ORDINE = "UnaDunaPutORDINE";
	
	private static final String PACKAGE_NAME_GET = "com.marte5.unaduna.handler.";
	
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
    		
    		return funzioni.contains(nomeFunzione);
    }
}

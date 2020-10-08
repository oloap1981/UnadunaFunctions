package com.marte5.unaduna.handler.common;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.marte5.unaduna.model.objects.Esito;
import com.marte5.unaduna.utility.EsitoHelper;
import com.marte5.unaduna.utility.FunzioniUtils;

import requests.RichiestaDeleteGenerica;
import responses.RispostaDeleteGenerica;

public class UnaDunaDelete implements RequestHandler<RichiestaDeleteGenerica, RispostaDeleteGenerica> {

	private final static String FUNCTION_NAME_DELETE_CONFIGURAZIONE = "UnaDunaDeleteConfigurazione";
	private final static String FUNCTION_NAME_DELETE_ORDINE = "UnaDunaDeleteOrdine";
	private final static String FUNCTION_NAME_DELETE_UTENTE = "UnaDunaDeleteUtente";
	private final static String FUNCTION_NAME_DELETE_CODICESCONTO = "UnaDunaDeleteCodiceSconto";
	private static final String PACKAGE_NAME_DELETE = "com.marte5.unaduna.handler.delete.";
	
    @Override
    public RispostaDeleteGenerica handleRequest(RichiestaDeleteGenerica input, Context context) {
    	    String className = this.getClass().getName();
        context.getLogger().log("Input: " + input);
        RispostaDeleteGenerica risposta = new RispostaDeleteGenerica();

        String functionName = input.getFunctionName();
        Esito esito = FunzioniUtils.getEsitoPositivo(className);
        
        if(!isFunctionNameValid(functionName)) {
        		esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_CANCELLAZIONE);
			esito.setMessage(EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_CANCELLAZIONE + " la funzione richiesta non esiste ");
			risposta.setEsito(esito);
			return risposta;
        }
        
        try {
			@SuppressWarnings("unchecked")
			RequestHandler<RichiestaDeleteGenerica, RispostaDeleteGenerica> handler = (RequestHandler<RichiestaDeleteGenerica, RispostaDeleteGenerica>) Class.forName(PACKAGE_NAME_DELETE + functionName).newInstance();
			risposta = handler.handleRequest(input, context);
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_CANCELLAZIONE);
			esito.setMessage(EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_CANCELLAZIONE + " DELETE generica ");
			esito.setTrace(e.getMessage());
			risposta.setEsito(esito);
			return risposta;
		}
        
        return risposta;
    }
    
    private boolean isFunctionNameValid(String nomeFunzione) {
    		List<String> funzioni = new ArrayList<>();
    		
    		funzioni.add(FUNCTION_NAME_DELETE_CONFIGURAZIONE);
    		funzioni.add(FUNCTION_NAME_DELETE_ORDINE);
    		funzioni.add(FUNCTION_NAME_DELETE_UTENTE);
    		funzioni.add(FUNCTION_NAME_DELETE_CODICESCONTO);
    		return funzioni.contains(nomeFunzione);
    }
}

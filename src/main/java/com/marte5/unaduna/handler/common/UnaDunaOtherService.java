package com.marte5.unaduna.handler.common;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.marte5.unaduna.model.objects.Esito;
import com.marte5.unaduna.utility.EsitoHelper;
import com.marte5.unaduna.utility.FunzioniUtils;

import requests.RichiestaOtherGenerica;
import responses.RispostaOtherGenerica;

public class UnaDunaOtherService implements RequestHandler<RichiestaOtherGenerica, RispostaOtherGenerica> {


	private final static String FUNCTION_NAME_SENDMAIL = "UnaDunaSendMail";
	private final static String FUNCTION_NAME_SAVEIMAGE = "UnaDunaSaveImage";
	
	private static final String PACKAGE_NAME_GET = "com.marte5.unaduna.handler.other.";
	
    @Override
    public RispostaOtherGenerica handleRequest(RichiestaOtherGenerica input, Context context) {
    	String className = this.getClass().getName();
        context.getLogger().log("Input: " + input);
        RispostaOtherGenerica risposta = new RispostaOtherGenerica();

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
			RequestHandler<RichiestaOtherGenerica, RispostaOtherGenerica> handler = (RequestHandler<RichiestaOtherGenerica, RispostaOtherGenerica>) Class.forName(PACKAGE_NAME_GET + functionName).newInstance();
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
    		
    		funzioni.add(FUNCTION_NAME_SENDMAIL);
    		funzioni.add(FUNCTION_NAME_SAVEIMAGE);
    		return funzioni.contains(nomeFunzione);
    }
}

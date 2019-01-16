package com.marte5.unaduna.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.marte5.unaduna.model.objects.Esito;

public class FunzioniUtils {
	
	public static final String AMAZON_S3_BASE_URL = "https://s3.eu-central-1.amazonaws.com/";
	
	/***
	 * 
	 * @return
	 */
	public static com.marte5.unaduna.model.objects.Esito getEsitoPositivo(String className) {
		Esito esito = new Esito();
        esito.setCodice(EsitoHelper.ESITO_OK_CODICE);
        esito.setMessage(className + " - " + EsitoHelper.ESITO_OK_MESSAGGIO);
        return esito;
	}
	
	public static final String DATE_FORMAT = "dd MMM yyyy";
	public static final Locale FUNCTIONS_LOCALE = Locale.ITALY;
	
	public static String getStringVersion(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, FUNCTIONS_LOCALE);
		return sdf.format(date);
	}
	
	public static String getEntitaId() {
		Date actualDate = new Date();
        return actualDate.getTime()  +"";
	}
}

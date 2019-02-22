package com.marte5.unaduna.handler.other;

import java.util.List;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.marte5.unaduna.model.objects.Esito;
import com.marte5.unaduna.model.objects.Proprieta;
import com.marte5.unaduna.utility.Constants;
import com.marte5.unaduna.utility.EsitoHelper;
import com.marte5.unaduna.utility.FunzioniUtils;
import com.marte5.unaduna.utility.SmtpAuthenticator;

import requests.RichiestaOtherGenerica;
import responses.RispostaOtherGenerica;

public class UnaDunaSendMailGmail implements RequestHandler<RichiestaOtherGenerica, RispostaOtherGenerica> {

	@Override
	public RispostaOtherGenerica handleRequest(RichiestaOtherGenerica request, Context context) {

		String className = this.getClass().getName();
		RispostaOtherGenerica risposta = new RispostaOtherGenerica();
		Esito esito = FunzioniUtils.getEsitoPositivo(className);

		//parametri di invio dalla richiesta
		String mailMessage = request.getEmailMessage();
		String subject = request.getEmailSubject();
		List<String> toAddressList = request.getToEmailAdresses();
		List<String> ccAddressList = request.getCcEmailAdresses();

		Proprieta hostProperty = null;
		//Proprieta fromProperty = null;
		
		//parametri di configurazione dal DB
		AmazonDynamoDB client = null;
		try {
			client = AmazonDynamoDBClientBuilder.standard().build();
		} catch (Exception e1) {
			esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
			esito.setMessage(className + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " SEND_EMAIL ");
			esito.setTrace(e1.getMessage());
			risposta.setEsito(esito);
			return risposta;
		}
		if(client != null) {
			DynamoDBMapper mapper = new DynamoDBMapper(client);

			try {
				hostProperty = mapper.load(Proprieta.class, Constants.MAIL_SMTP_SERVER);
				//fromProperty = mapper.load(Proprieta.class, Constants.MAIL_FROM_ADDRESS);
			} catch (Exception e) {
				esito.setCodice(EsitoHelper.ESITO_KO_CODICE_ERRORE_GET);
				esito.setMessage(className + " - " + EsitoHelper.ESITO_KO_MESSAGGIO_ERRORE_GET + " getConfigurazioni");
				esito.setTrace(e.getMessage());
				risposta.setEsito(esito);
				return risposta;
			}
		}	

		// Get system properties
		Properties properties = System.getProperties();

		properties.put("mail.smtp.host", "true");
		properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        
		try {
			// Create a default MimeMessage object.
			SmtpAuthenticator auth = new SmtpAuthenticator(Constants.MAIL_USER_GOOGLE, Constants.MAIL_PASSWORD_GOOGLE);
			Session session = Session.getInstance(properties, auth);
			
			MimeMessage message = new MimeMessage(session);

			for(int i = 0; i < toAddressList.size(); i++) {
				message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddressList.get(i)));
			}

			// Set Subject: header field
			message.setSubject(subject);

			// Send the actual HTML message, as big as you like
			message.setContent(mailMessage, "text/html");

			Transport transport = session.getTransport("smtp");
			
			transport.connect("smtp.gmail.com", Constants.MAIL_USER_GOOGLE, Constants.MAIL_PASSWORD_GOOGLE);

			message.setFrom("orders@annacloud.it");
			// Send message
			Transport.send(message);
			
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}

		risposta.setEsito(esito);
		return risposta;
	}
}
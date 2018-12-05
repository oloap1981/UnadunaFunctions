package com.marte5.unaduna.utility;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SmtpAuthenticator extends Authenticator {
	
	
	public SmtpAuthenticator() {
		super();
	}

	@Override
	public PasswordAuthentication getPasswordAuthentication() {
		String username = Constants.MAIL_USER;
		String password = Constants.MAIL_PASSWORD;
		if ((username != null) && (username.length() > 0) && (password != null) 
				&& (password.length   () > 0)) {

			return new PasswordAuthentication(username, password);
		}

		return null;
	}
}
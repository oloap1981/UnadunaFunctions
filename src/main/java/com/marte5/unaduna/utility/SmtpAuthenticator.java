package com.marte5.unaduna.utility;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SmtpAuthenticator extends Authenticator {
	
	private String userName;
	private String password;
	
	public SmtpAuthenticator(String username, String password) {
		this.userName = username;
		this.password = password;
	}

	@Override
	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(userName, password);
	}
}
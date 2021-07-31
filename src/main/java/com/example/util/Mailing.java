package com.example.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class Mailing {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	private String from = "mplqnp@gmail.com";
	
	private void sendSimpleMailMessage(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		
		javaMailSender.send(message);
	}
	
	public void sendWelcomeMessage(String to) {
		String subject = "Confirmación de registro";
		String text = "¡Enhorabuena, te has registrado correctamente!";
		
		this.sendSimpleMailMessage(to, subject, text);
	}
	
	public void sendDonationsMessage(String[] group) {
		String subject = "Donaciones";
		String text = "Cada granito de arena supone un soplo de esperanza.";

		for (String to : group)
			this.sendSimpleMailMessage(to, subject, text);
	}
	
	public void sendNewsletterMessage(String[] group) {
		String subject = "Revista";
		String text = "Nuevo artículo.";
		
		for (String to : group)
			this.sendSimpleMailMessage(to, subject, text);
	}
	
	public void sendNumberMessage(String to, int num) {
		String subject = "Dorsal";
		String text = "Número de dorsal: " + num;
		
		this.sendSimpleMailMessage(to, subject, text);
	}
	
	public void sendCertificateMessage(String[] group) {
		String subject = "Certificado de participación";
		String text = "¡Objetivo alcanzado!";
		
		for (String to : group)
			this.sendSimpleMailMessage(to, subject, text);
	}

}

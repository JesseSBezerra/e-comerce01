package br.com.ecomerce.email.teste;

import br.com.ecomerce.infra.email.EmailUtil;

public class TesteEmail {
public static void main(String[] args) {
	String remetente = "jesse.9001@gmail.com";
	String destinatarios = "jesse.9001@gmail.com, jesse.bezerra@mv.com.br, jessebezerra@hotmail.com.br,marxgentil@gmail.com";
	String assunto = "teste do envio de email";
	String texto = "Email enviado afins de teste";
	
	EmailUtil.mail(remetente, destinatarios, assunto, texto);
}
}

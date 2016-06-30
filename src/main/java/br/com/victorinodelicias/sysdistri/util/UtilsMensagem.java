package br.com.victorinodelicias.sysdistri.util;

import javax.inject.Named;

@Named(value = "mensagens")
public class UtilsMensagem {

	public static final String MENSAGEM_SUCESSO = "Ação executada com sucesso.";
	public static final String MENSAGEM_ERRO_INTERNO = "Erro interno. Contate o suporte.";
	public static final String MENSAGEM_ERRO_PERMISSAO = "Você não possui permissão para executar essa ação.";
	public static final String MENSAGEM_REQUIRED_TELEFONE = "Preencha o campo TELEFONE ou CELULAR.";

}

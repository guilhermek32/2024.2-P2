package br.ufal.ic.p2.jackut.Exceptions;

/**
 * Exce��o lan�ada quando um usu�rio tenta adicionar outro usu�rio como amigo,
 * mas j� existe um convite pendente.
 */
public class AmizadePendenteException extends RuntimeException {
    public AmizadePendenteException() {
        super("Usu�rio j� est� adicionado como amigo, esperando aceita��o do convite.");
    }
}

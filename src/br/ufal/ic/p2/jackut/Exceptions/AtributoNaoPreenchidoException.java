package br.ufal.ic.p2.jackut.Exceptions;

/**
 * Exce��o lan�ada quando um atributo obrigat�rio n�o � preenchido.
 */
public class AtributoNaoPreenchidoException extends RuntimeException {
    public AtributoNaoPreenchidoException() {
        super("Atributo n�o preenchido.");
    }
}

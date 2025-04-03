package br.ufal.ic.p2.jackut.Exceptions;

/**
 * Exceção lançada quando um atributo obrigatório não é preenchido.
 */
public class AtributoNaoPreenchidoException extends RuntimeException {
    public AtributoNaoPreenchidoException() {
        super("Atributo não preenchido.");
    }
}

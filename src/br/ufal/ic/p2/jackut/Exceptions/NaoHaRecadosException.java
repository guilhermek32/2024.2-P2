package br.ufal.ic.p2.jackut.Exceptions;

/**
 * Exce��o lan�ada quando n�o h� recados dispon�veis.
 */
public class NaoHaRecadosException extends RuntimeException {
    public NaoHaRecadosException() {
        super("N�o h� recados.");
    }
}

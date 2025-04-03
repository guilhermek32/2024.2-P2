package br.ufal.ic.p2.jackut.Exceptions;

/**
 * Exceção lançada quando não há recados disponíveis.
 */
public class NaoHaRecadosException extends RuntimeException {
    public NaoHaRecadosException() {
        super("Não há recados.");
    }
}

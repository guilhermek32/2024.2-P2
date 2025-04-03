package br.ufal.ic.p2.jackut.Exceptions;

/**
 * Exceção lançada quando a senha de um usuário é inválida.
 */
public class SenhaInvalidaException extends RuntimeException {
    public SenhaInvalidaException() {
        super("Senha inválida.");
    }
}

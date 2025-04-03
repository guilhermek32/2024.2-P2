package br.ufal.ic.p2.jackut.Exceptions;

/**
 * Exceção lançada quando um usuário tenta criar uma conta com um login que já existe.
 */
public class LoginJaExisteException extends RuntimeException {
    public LoginJaExisteException() {
        super("Login já existe.");
    }
}

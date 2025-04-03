package br.ufal.ic.p2.jackut.Exceptions;

/**
 * Exceção lançada quando o login de um usuário é inválido.
 */
public class LoginInvalidoException extends RuntimeException {
    public LoginInvalidoException() {
        super("Login inválido.");
    }
}

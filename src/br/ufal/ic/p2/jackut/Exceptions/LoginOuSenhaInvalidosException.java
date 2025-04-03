package br.ufal.ic.p2.jackut.Exceptions;

/**
 * Exceção lançada quando o login ou a senha de um usuário são inválidos.
 */
public class LoginOuSenhaInvalidosException extends RuntimeException {
    public LoginOuSenhaInvalidosException() {
        super("Login ou senha inválidos.");
    }
}

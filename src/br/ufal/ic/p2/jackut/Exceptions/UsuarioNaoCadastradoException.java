package br.ufal.ic.p2.jackut.Exceptions;

/**
 * Exceção lançada quando um usuário não está cadastrado.
 */
public class UsuarioNaoCadastradoException extends RuntimeException {
    public UsuarioNaoCadastradoException() {
        super("Usuário não cadastrado.");
    }
}

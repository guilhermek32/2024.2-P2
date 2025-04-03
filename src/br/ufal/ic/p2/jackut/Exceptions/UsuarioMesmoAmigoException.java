package br.ufal.ic.p2.jackut.Exceptions;

/**
 * Exceção lançada quando um usuário tenta adicionar a si mesmo como amigo.
 */
public class UsuarioMesmoAmigoException extends RuntimeException {
    public UsuarioMesmoAmigoException() {
        super("Usuário não pode adicionar a si mesmo como amigo.");
    }
}

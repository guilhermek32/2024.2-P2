package br.ufal.ic.p2.jackut.Exceptions;

/**
 * Exceção lançada quando um usuário tenta adicionar outro usuário como amigo, mas já são amigos.
 */
public class UsuarioJaAmigoException extends RuntimeException {
    public UsuarioJaAmigoException() {
        super("Usuário já está adicionado como amigo.");
    }
}

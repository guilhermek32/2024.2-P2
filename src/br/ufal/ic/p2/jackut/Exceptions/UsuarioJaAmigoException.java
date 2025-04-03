package br.ufal.ic.p2.jackut.Exceptions;

/**
 * Exce��o lan�ada quando um usu�rio tenta adicionar outro usu�rio como amigo, mas j� s�o amigos.
 */
public class UsuarioJaAmigoException extends RuntimeException {
    public UsuarioJaAmigoException() {
        super("Usu�rio j� est� adicionado como amigo.");
    }
}

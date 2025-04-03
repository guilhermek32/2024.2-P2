package br.ufal.ic.p2.jackut.Exceptions;

/**
 * Exce��o lan�ada quando um usu�rio tenta adicionar a si mesmo como amigo.
 */
public class UsuarioMesmoAmigoException extends RuntimeException {
    public UsuarioMesmoAmigoException() {
        super("Usu�rio n�o pode adicionar a si mesmo como amigo.");
    }
}

package br.ufal.ic.p2.jackut.Exceptions;

/**
 * Exce��o lan�ada quando um usu�rio n�o est� cadastrado.
 */
public class UsuarioNaoCadastradoException extends RuntimeException {
    public UsuarioNaoCadastradoException() {
        super("Usu�rio n�o cadastrado.");
    }
}

package br.ufal.ic.p2.jackut.Exceptions;

/**
 * Exce��o lan�ada quando um usu�rio tenta enviar um recado para si mesmo.
 */
public class UsuarioNaoEnviarRecadoParaSiMesmoException extends RuntimeException {
    public UsuarioNaoEnviarRecadoParaSiMesmoException() {
        super("Usu�rio n�o pode enviar recado para si mesmo.");
    }
}

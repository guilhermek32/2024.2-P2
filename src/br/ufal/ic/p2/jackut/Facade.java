package br.ufal.ic.p2.jackut;

import br.ufal.ic.p2.jackut.Exceptions.*;

import easyaccept.EasyAccept;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.*;


/**
 * Classe Facade que gerencia as operações do sistema.
 */
public class Facade {

    private Map<String, Usuario> usuarios;
    private Map<String, Usuario> sessoes;

    /**
     * Construtor da classe Facade.
     * Inicializa os mapas de usuários e sessões e carrega os dados do sistema.
     */
    public Facade() {
        this.usuarios = new HashMap<>();
        this.sessoes = new HashMap<>();
        carregarSistema();
    }

    /**
     * Método para zerar o sistema, limpando os mapas de usuários e sessões e deletando o arquivo JSON.
     */
    public void zerarSistema() {
        this.usuarios.clear();
        this.sessoes.clear();
        File arquivo = new File("usuarios.json");
        arquivo.delete();
    }


    /**
     * Método para carregar os dados do sistema a partir de um arquivo JSON.
     */
    public void carregarSistema() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File usuariosJson = new File("usuarios.json");
            if (usuariosJson.exists()) {
                List<Usuario> listaUsuarios = mapper.readValue(usuariosJson, new TypeReference<List<Usuario>>() {});
                for (Usuario usuario : listaUsuarios) {
                    criarUsuario(usuario.getLogin(), usuario.getSenha(), usuario.getNome());
                    Usuario userTemp = usuarios.get(usuario.getLogin());
                    userTemp.setFriends(new ArrayList<>(new LinkedHashSet<>(usuario.getFriends())));
                    userTemp.setSolicitacoesDeAmizade(new ArrayList<>(new HashSet<>(usuario.getSolicitacoesDeAmizade())));
                    userTemp.setCaixaMensagem(usuario.getCaixaMensagem());
                    for (Map.Entry<String, String> entry : usuario.getAtributos().entrySet()) {
                        userTemp.setAtributos(entry.getKey(), entry.getValue());
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar dados do JSON.");
            e.printStackTrace();
        }
    }


    /**
     * Método para salvar os dados do sistema em um arquivo JSON.
     */
    public void salvarSistema() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Usuario> listaUsuarios = new ArrayList<>(usuarios.values());
            for (Usuario usuario : listaUsuarios) {
                usuario.setFriends(new ArrayList<>(new LinkedHashSet<>(usuario.getFriends())));
                usuario.setSolicitacoesDeAmizade(new ArrayList<>(new HashSet<>(usuario.getSolicitacoesDeAmizade())));
            }
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("usuarios.json"), listaUsuarios);
        } catch (Exception e) {
            System.err.println("Erro ao salvar dados do JSON.");
            e.printStackTrace();
        }
    }


    /**
     * Método para criar um novo usuário.
     *
     * @param login Login do usuário.
     * @param senha Senha do usuário.
     * @param nome Nome do usuário.
     * @throws LoginInvalidoException Se o login for inválido.
     * @throws SenhaInvalidaException Se a senha for inválida.
     * @throws ContaJaExisteException Se a conta já existir.
     */
    public void criarUsuario(String login, String senha, String nome) {
        if (login == null || login.trim().isEmpty()) {
            throw new LoginInvalidoException();
        }
        if (senha == null || senha.trim().isEmpty()) {
            throw new SenhaInvalidaException();
        }
        if (usuarios.containsKey(login)) {
            throw new ContaJaExisteException();
        }
        Usuario novoUsuario = new Usuario(nome, login, senha);
        usuarios.put(login, novoUsuario);
    }


    /**
     * Método para obter um atributo de um usuário.
     *
     * @param login Login do usuário.
     * @param atributo Nome do atributo.
     * @return Valor do atributo.
     * @throws UsuarioNaoCadastradoException Se o usuário não estiver cadastrado.
     * @throws AtributoNaoPreenchidoException Se o atributo não estiver preenchido.
     */
    public String getAtributoUsuario(String login, String atributo) {
        if (!usuarios.containsKey(login)) {
            throw new UsuarioNaoCadastradoException();
        }
        Usuario usuario = usuarios.get(login);
        if ("nome".equals(atributo)) {
            return usuario.getNome();
        }
        String valor = usuario.getAtributos().get(atributo);
        if (valor == null) {
            throw new AtributoNaoPreenchidoException();
        } else {
            return valor;
        }
    }

    /**
     * Método para abrir uma sessão de usuário.
     *
     * @param login Login do usuário.
     * @param senha Senha do usuário.
     * @return ID da sessão.
     * @throws LoginOuSenhaInvalidosException Se o login ou a senha forem inválidos.
     */
    public String abrirSessao(String login, String senha) {
        if (login == null || login.trim().isEmpty() || senha == null || senha.trim().isEmpty()) {
            throw new LoginOuSenhaInvalidosException();
        }
        Usuario usuario = usuarios.get(login);
        if (usuario == null) {
            throw new LoginOuSenhaInvalidosException();
        }
        if (!usuario.getSenha().equals(senha)) {
            throw new LoginOuSenhaInvalidosException();
        }
        String sessionId = UUID.randomUUID().toString();
        sessoes.put(sessionId, usuario);
        return sessionId;
    }

    /**
     * Método para editar o perfil de um usuário.
     *
     * @param sessionId ID da sessão do usuário.
     * @param atributo Nome do atributo a ser editado.
     * @param conteudo Novo valor do atributo.
     * @throws UsuarioNaoCadastradoException Se o usuário não estiver cadastrado.
     * @throws LoginJaExisteException Se o novo login já existir.
     */
    public void editarPerfil(String sessionId, String atributo, String conteudo) {
        Usuario usuario = sessoes.get(sessionId);
        if (usuario == null) {
            throw new UsuarioNaoCadastradoException();
        }
        switch (atributo) {
            case "nome":
                usuario.setNome(conteudo);
                break;
            case "senha":
                usuario.setSenha(conteudo);
                break;
            case "login":
                if (usuarios.containsKey(conteudo)) {
                    throw new LoginJaExisteException();
                }
                usuario.setLogin(conteudo);
                break;
            default:
                usuario.setAtributos(atributo, conteudo);
        }
    }

    /**
     * Método para adicionar um amigo.
     *
     * @param idPessoa ID da sess??o do usuário.
     * @param amigo Login do amigo a ser adicionado.
     * @throws UsuarioNaoCadastradoException Se o usuário ou o amigo não estiverem cadastrados.
     * @throws UsuarioMesmoAmigoException Se o usuário tentar adicionar a si mesmo como amigo.
     * @throws UsuarioJaAmigoException Se o usuário já for amigo do amigo.
     * @throws AmizadePendenteException Se já houver uma solicitação de amizade pendente.
     */
    public void adicionarAmigo(String idPessoa, String amigo) {
        Usuario usuario = sessoes.get(idPessoa);
        if (usuario == null || !usuarios.containsKey(amigo)) {
            throw new UsuarioNaoCadastradoException();
        }
        if (usuario.getLogin().equals(amigo)) {
            throw new UsuarioMesmoAmigoException();
        }

        Usuario receptor = usuarios.get(amigo);
        if (usuario.getFriends().contains(amigo)) {
            throw new UsuarioJaAmigoException();
        }

        ArrayList<String> solicitacoesUsuarioAtual = usuario.getSolicitacoesDeAmizade();
        if (solicitacoesUsuarioAtual.contains(amigo)) {
            usuario.adicionarAmigos(amigo);
            receptor.adicionarAmigos(usuario.getLogin());
        } else {
            ArrayList<String> solicitacoes = receptor.getSolicitacoesDeAmizade();
                if (solicitacoes.contains(usuario.getLogin())) {
                    throw new AmizadePendenteException();
                }
            solicitacoes.add(usuario.getLogin());
            receptor.setSolicitacoesDeAmizade(solicitacoes);
        }
    }

    /**
     * Método para verificar se dois usuários são amigos.
     *
     * @param usuarioVerificador Login do usuário verificador.
     * @param usuarioVerificado Login do usuário verificado.
     * @return true se os usuários forem amigos, false caso contrário.
     * @throws UsuarioNaoCadastradoException Se algum dos usuários não estiver cadastrado.
     */
    public boolean ehAmigo(String usuarioVerificador, String usuarioVerificado) {
        if (!usuarios.containsKey(usuarioVerificador) || !usuarios.containsKey(usuarioVerificado)) {
            throw new UsuarioNaoCadastradoException();
        }
        Usuario usuario1 = usuarios.get(usuarioVerificador);
        Usuario usuario2 = usuarios.get(usuarioVerificado);
        List<String> amigos = usuario1.getFriends();
        List<String> amigos2 = usuario2.getFriends();
        return amigos.contains(usuario2.getLogin()) && amigos2.contains(usuario1.getLogin());
    }

    /**
     * Método para obter a lista de amigos de um usuário.
     *
     * @param login Login do usuário.
     * @return Lista de amigos do usuário.
     * @throws UsuarioNaoCadastradoException Se o usuário não estiver cadastrado.
     */
    public String getAmigos(String login) {
        if (!usuarios.containsKey(login)) {
            throw new UsuarioNaoCadastradoException();
        }
        Usuario usuario = usuarios.get(login);
        // Retorna os amigos na ordem de inserção
        return "{" + String.join(",", usuario.getFriends()) + "}";
    }

    /**
     * Método para enviar um recado para outro usuário.
     *
     * @param id ID da sessão do remetente.
     * @param destinatario Login do destinatário.
     * @param recado Conteúdo do recado.
     * @throws UsuarioNaoCadastradoException Se o remetente ou o destinatário não estiverem cadastrados.
     * @throws UsuarioNaoEnviarRecadoParaSiMesmoException Se o remetente tentar enviar um recado para si mesmo.
     */
    public void enviarRecado(String id, String destinatario, String recado) {
        Usuario remetente = sessoes.get(id);
        if (remetente == null) {
            throw new UsuarioNaoCadastradoException();
        }
        if (!usuarios.containsKey(destinatario)) {
            throw new UsuarioNaoCadastradoException();
        }
        if (remetente.getLogin().equals(destinatario)) {
            throw new UsuarioNaoEnviarRecadoParaSiMesmoException();
        }
        Recado novoRecado = new Recado(remetente.getLogin(), recado);
        Usuario receptor = usuarios.get(destinatario);
        receptor.receberMensagem(novoRecado);
    }

    /**
     * Método para ler um recado da caixa de mensagens do usuário.
     *
     * @param id ID da sessão do usuário.
     * @return Conteúdo do recado.
     * @throws UsuarioNaoCadastradoException Se o usuário não estiver cadastrado.
     * @throws NaoHaRecadosException Se não houver recados na caixa de mensagens.
     */
    public String lerRecado(String id) {
        Usuario usuario = sessoes.get(id);
        if (usuario == null) {
            throw new UsuarioNaoCadastradoException();
        }
        if (usuario.getCaixaMensagem().isEmpty()) {
            throw new NaoHaRecadosException();
        }
        Recado recado = usuario.getCaixaMensagem().poll();
        return recado.getMensagem();
    }

    /**
     * Método para encerrar o sistema, salvando os dados no arquivo JSON.
     */
    public void encerrarSistema() {
        salvarSistema();
    }
}

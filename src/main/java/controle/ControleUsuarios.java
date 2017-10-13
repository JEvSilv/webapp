package controle;
import java.util.ArrayList;
import entidades.*;
import dados.*;
public class ControleUsuarios {
IRepositorioUsuario repositorio;
	
	public ControleUsuarios(IRepositorioUsuario tipo){
		this.repositorio = tipo;
	}
	
	/**
	 * Retorna todos os usu�rios cadastrados na lista de usu�rios
	 * @return lista de usu�rios
	 */
	public ArrayList<Usuario> getUsuarios(){
		return repositorio.listar();
	}
	
	/**
	 * Dados login e senha de um usu�rio checa se ele existe
	 * @param login login do usu�rio
	 * @param senha senha do usu�rio
	 * @return um Usu�rio se existe e null se n�o existe
	 */
	public Usuario buscar(String login, String senha){
		return repositorio.buscar(login, senha);
	}
	
	/**
	 * Faz uma busca de usu�rio de acordo com o tipo de busca escolhida
	 * @param conteudo dado do usu�rio
	 * @param tipo tipo nome, email ou login
	 * @return lista contendo resultado da busca
	 */
	public ArrayList<Usuario> buscaPorConteudoETipo(String conteudo, String tipo){
		return repositorio.buscarPorConteudoETipo(conteudo, tipo);
	}
	
	/**
	 * Insere um novo usu�rio no reposit�rio
	 * @param u dados do Usuario
	 */
	public void inserir(Usuario u) {
		this.repositorio.inserir(u);
	}
}

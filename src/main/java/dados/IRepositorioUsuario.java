package dados;
import java.util.ArrayList;

import entidades.*;
public interface IRepositorioUsuario {
	public void inserir(Usuario u);
	public ArrayList<Usuario> listar();
	public Usuario buscar(String login, String senha);
	public void alterar(Usuario original, Usuario novo);
	public void remover(Usuario u);
	public ArrayList<Usuario> buscarPorConteudoETipo(String conteudo, String tipo);
}

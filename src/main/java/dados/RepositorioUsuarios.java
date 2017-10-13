package dados;
import java.util.ArrayList;

import entidades.Usuario;

public class RepositorioUsuarios implements IRepositorioUsuario{
	public ArrayList<Usuario> listaDeUsuarios;
	
	public RepositorioUsuarios() {
		this.listaDeUsuarios = new ArrayList<Usuario>();
	}
	
	public void inserir(Usuario u) {
		this.listaDeUsuarios.add(u);
	}
	
	public ArrayList<Usuario> listar() {
		return this.listaDeUsuarios;
	}

	@Override
	public Usuario buscar(String login, String senha) {
		Usuario usuario=null;
		//percorre toda a lista e checa se o usuário existe com o mesmo login e senha
		for(Usuario u: this.listaDeUsuarios){
			if (u.getLogin().equals(login) && u.getSenha().equals(senha)){
				usuario = u;
				return usuario;
			}
		}
		return usuario;
	}

	@Override
	public void alterar(Usuario original, Usuario novo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Usuario u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Usuario> buscarPorConteudoETipo(String conteudo, String tipo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void populaUsuarios(){
		Usuario u1 = new Usuario();
        u1.setId(1);
        u1.setNome("usuario");
        u1.setLogin("u");
        u1.setSenha("1234");
        u1.setEmail("u@ufpi.edu.br");
		
        Usuario u2 = new Usuario();
        u2.setId(2);
        u2.setNome("Maria Soares Sousa");
        u2.setLogin("maria");
        u2.setSenha("maria");
        u2.setEmail("maria@ufpi.edu.br");
		
        this.listaDeUsuarios.add(u1);
		this.listaDeUsuarios.add(u2);
		
        System.out.println(this.listaDeUsuarios);
   
	}
	
}

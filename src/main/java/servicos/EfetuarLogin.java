package servicos;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entidades.*;
import controle.*;
import dados.*;

/**
 * Servlet implementation class EfetuarLogin
 */
public class EfetuarLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RepositorioUsuarios repositorio;
	private ControleUsuarios controlador;
          
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EfetuarLogin() {
        super();
        // TODO Auto-generated constructor stub
        repositorio = new RepositorioUsuarios();
        this.repositorio.populaUsuarios();
        controlador = new ControleUsuarios(repositorio);
        /*
        controlador.inserir(u1);*/
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("ENTROU NO GET");
		 response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ENTROU NO POST");
		//doGet(request, response);
		
		String login;
		String senha;
		
		login = request.getParameter("login");
		senha = request.getParameter("senha");
		
		
		System.out.println(login +" "+senha);
		Usuario usuario = controlador.buscar(login, senha);
		
		if (usuario != null){
			System.out.println("USUARIO EXISTE");
				HttpSession session = request.getSession();
				session.setAttribute("email", usuario.getEmail());
				Date criacaoSessaoUsuario = new Date(session.getCreationTime());
				session.setAttribute("usuario", usuario);
				System.out.println("Usuario " + session.getAttribute("email") + " logado as" + criacaoSessaoUsuario);
				response.sendRedirect("principal");
		}else{
			System.out.println("USUARIO NAO EXISTE");
			response.sendRedirect("efetuarlogin");
		}
		
	}

}

package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public abstract class BaseDAO_IMP<E> implements BaseDAO<E> {
	private String url;
	private String usuario;
	private String senha;
	protected Connection con = null;
	
	
	public Connection getConnection() {
		url = "jdbc:postgresql://localhost:5432/STEPS";
		usuario = "postgres";
		senha = "BBbenBB30!";
		if (con == null) {
			try {
				con = DriverManager.getConnection(url, usuario, senha);
				System.out.println("Conexão bem sucedida!");
			} catch (SQLException e) {

				System.out.println("Falha na conexão!");
				e.printStackTrace();
			}
			return con;
		}else {
			return con;
		}
	}


	public void inserir(E objeto) {

		
	}


	public void listar(E objeto) {
		
		
	}


	@Override
	public E buscar(E objeto) {
		return objeto;
		
		
	}


	@Override
	public void alterar(E objeto) {
		
	}


	@Override
	public void remover(E objeto) {
		
	}

}

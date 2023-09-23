package connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Disciplina;
import entities.Prova;
import entities.Questao;

public class DisciplinaDAO extends BaseDAO_IMP<Disciplina> {

	@Override
	public void inserir(Disciplina disciplina) {
		String sql = "INSERT into Disciplina (nome, descricao) values (?,?)";
		con = getConnection();
		PreparedStatement ptst;
		try {
			ptst = con.prepareStatement(sql);
			ptst.setString(1, disciplina.getNome());
			ptst.setString(2, disciplina.getDescricao());
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void inserir(Disciplina disciplina, ArrayList<Prova> provas)
	{
	    con = getConnection();
	    PreparedStatement ptst;

	    try {
	        
	    	for (int i = 1; i <= provas.size(); i++) {
	    	    ptst = con.prepareStatement("INSERT INTO disciplina_prova(codigo_disciplina, codigo_prova) VALUES (?, ?)");
	    	    ptst.setInt(1, disciplina.getCodigo());
	    	    ptst.setInt(2, provas.get(i - 1).getCodigo());
	    	    ptst.execute();
	    	}
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
			//mesmo o arraylist sendo de tipo diferentes,etava dando erro ao sobrecarregar,por isso adicionei essa string
	public void inserir (Disciplina disciplina, ArrayList<Questao> questoes,String nada) {
	    con = getConnection();
	    PreparedStatement ptst;

	    try {
	        
	    	for (int i = 1; i <= questoes.size(); i++) {
	    	    ptst = con.prepareStatement("INSERT INTO disciplina_questao(codigo_disciplina,codigo_questao) VALUES (?, ?)");
	    	    ptst.setInt(1, disciplina.getCodigo());
	    	    ptst.setInt(2, questoes.get(i - 1).getCodigo());
	    	    ptst.execute();
	    	}
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	@Override
		public ArrayList<Disciplina> listar() {
		ArrayList<Disciplina> listaDeDisciplinas = new ArrayList<>();
		String sql = "Select * from Disciplina";
		ResultSet resultSet = null;
		try {
			con = getConnection();
			PreparedStatement ptst = con.prepareStatement(sql);
			resultSet = ptst.executeQuery();
			
			while (resultSet.next()) {		
				Disciplina disciplina = new Disciplina();
				disciplina.setNome(resultSet.getString("nome"));
				disciplina.setCodigo(resultSet.getInt("codigo"));
	        	disciplina.setDescricao(resultSet.getString("descricao"));
	        	listaDeDisciplinas.add(disciplina);
			}
			resultSet.close();
	        ptst.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaDeDisciplinas;		
	}

	@Override
	public Disciplina buscar (Disciplina disciplina) {
		Disciplina DisciplinaDeRetorno = new Disciplina(); 
		String sql = "Select * from disciplina where codigo = ?";
		con = getConnection();
		PreparedStatement ptst;
		ResultSet resultSet = null;
		try {
			ptst = con.prepareStatement(sql);
			ptst.setInt(1, disciplina.getCodigo());
			resultSet = ptst.executeQuery();
			while (resultSet.next()) {		
				DisciplinaDeRetorno.setNome(resultSet.getString("nome"));
	        	DisciplinaDeRetorno.setCodigo(resultSet.getInt("codigo"));
	        	DisciplinaDeRetorno.setDescricao(resultSet.getString("descrição"));
				DisciplinaDeRetorno.toString();

				
			}
	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  DisciplinaDeRetorno;
	}

	@Override
	public void alterar(Disciplina disciplina) {
		String sql = "UPDATE Disciplina SET nome= ?, descricao = ?  WHERE codigo = ? ";
		con = getConnection();
		PreparedStatement ptst;
		try {
			ptst = con.prepareStatement(sql);
			ptst.setInt(3, disciplina.getCodigo());
			ptst.setString(1, disciplina.getNome());
			ptst.setString(2, disciplina.getDescricao());
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remover(Disciplina disciplina) {
		con = getConnection();
		PreparedStatement ptst;
		try {
			ptst = con.prepareStatement("delete from disciplina_questao where codigo_disciplina = ?");
			ptst.setInt(1, disciplina.getCodigo());
			ptst.execute();

			ptst = con.prepareStatement("delete from disciplina_prova where codigo_disciplina = ?");
			ptst.setInt(1, disciplina.getCodigo());
			ptst.execute();


			ptst = con.prepareStatement("DELETE FROM disciplina WHERE codigo= ?");
	        ptst.setInt(1, disciplina.getCodigo());
	        ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
package connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Prova;
import entities.Questao; //precisa para funcionar

public class ProvaDAO extends BaseDAO_IMP<Prova> {

	@Override
	public void inserir(Prova prova) {
		
		String sql = "INSERT into Prova(disciplina, numerodequestoes, numerodequestoesfaceis, numerodequestoesmedias, numerodequestoesdificeis, datadecriacao) values (?,?,?,?,?,?)";
		con = getConnection();
		PreparedStatement ptst;
		try {
			ptst = con.prepareStatement(sql);
			ptst.setString(1, prova.getDisciplina());
			ptst.setInt(2, prova.getNumeroDeQuestoes());
			ptst.setInt(3, prova.getQuestoesFaceis());
			ptst.setInt(4, prova.getQuestoesMedias());
			ptst.setInt(5, prova.getQuestoesDificeis());
			ptst.setDate(6, java.sql.Date.valueOf(prova.getData()));
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//vai preencher com repetição a tabela que relaciona as provas com as questoes
	public void inserir(Prova prova, ArrayList<Questao> questoes) {
	    con = getConnection();
	    PreparedStatement ptst;

	    try {
	        // Inserir as questões associadas à prova
	    	for (int i = 1; i <= questoes.size(); i++) {
	    	    ptst = con.prepareStatement("INSERT INTO Prova_Questao (codigo_prova, codigo_questao) VALUES (?, ?)");
	    	    ptst.setInt(1, prova.getCodigo());
	    	    ptst.setInt(2, questoes.get(i - 1).getCodigo()); // Observe o índice corrigido aqui
	    	    ptst.execute();
	    	}
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	@Override
	public void alterar(Prova prova) {
	    String sql = "UPDATE Prova SET disciplina = ?, numerodequestoes = ?, numerodequestoesfaceis = ?, numerodequestoesmedias = ?, numerodequestoesdificeis = ?, datadecriacao = ? WHERE codigo = ?";
	    con = getConnection();
	    PreparedStatement ptst;
	    try {
	        ptst = con.prepareStatement(sql);
	        ptst.setString(1, prova.getDisciplina());
	        ptst.setInt(2, prova.getNumeroDeQuestoes());
	        ptst.setInt(3, prova.getQuestoesFaceis());
	        ptst.setInt(4, prova.getQuestoesMedias());
	        ptst.setInt(5, prova.getQuestoesDificeis());
	        ptst.setDate(6, java.sql.Date.valueOf(prova.getData()));
	        ptst.setInt(7, prova.getCodigo()); // Aqui definimos o código da prova como critério de busca
	        ptst.execute();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	@Override
	 //deleta primeira na prova_questao e depois deleta em prova, garantindo a algebra relacional
	public void remover(Prova prova) {
		con = getConnection();
		PreparedStatement ptst;
		try {
			// Remover os registros relacionados na tabela "prova_questao"
	        ptst = con.prepareStatement("DELETE FROM Prova_Questao WHERE codigo_prova = ?");
	        ptst.setInt(1, prova.getCodigo());
	        ptst.execute();

	        // Agora, remover o registro na tabela "prova"
	        ptst = con.prepareStatement("DELETE FROM Prova WHERE codigo = ?");
	        ptst.setInt(1, prova.getCodigo());
	        ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Prova> listar() {
		ArrayList<Prova> listaDeProvas = new ArrayList<>();
		String sql = "Select * from Prova";
		ResultSet resultSet = null;
		try {
			con = getConnection();
			PreparedStatement ptst = con.prepareStatement(sql);
			resultSet = ptst.executeQuery();
			
			while (resultSet.next()) {		
				Prova provaDeRetorno = new Prova();
				provaDeRetorno.setCodigo(resultSet.getInt("codigo"));
				provaDeRetorno.setDisciplina(resultSet.getString("disciplina"));
	        	provaDeRetorno.setNumeroDeQuestoes(resultSet.getInt("numerodequestoes"));
	        	provaDeRetorno.setQuestoesFaceis(resultSet.getInt("numerodequestoesfaceis"));
	        	provaDeRetorno.setQuestoesMedias(resultSet.getInt("numerodequestoesmedias"));
	        	provaDeRetorno.setQuestoesDificeis(resultSet.getInt("numerodequestoesdificeis"));
	        	provaDeRetorno.setData(resultSet.getDate("datadecriacao"));
	        	
	        	listaDeProvas.add(provaDeRetorno);
			}
			resultSet.close();
	        ptst.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaDeProvas;		
	}

	
	@Override
	public Prova buscar(Prova prova) {
		Prova provaDeRetorno = new Prova(); //esse objeto monitor é quem vai retornar
		String sql = "Select * from Prova where codigo = ?";
		con = getConnection();
		PreparedStatement ptst;
		ResultSet resultSet = null;
		try {
			ptst = con.prepareStatement(sql);
			ptst.setInt(1, prova.getCodigo());
			resultSet = ptst.executeQuery();
			while (resultSet.next()) {		
				provaDeRetorno.setCodigo(resultSet.getInt("codigo"));
	        	provaDeRetorno.setDisciplina(resultSet.getString("disciplina"));
	        	provaDeRetorno.setNumeroDeQuestoes(resultSet.getInt("numerodequestoes"));
	        	provaDeRetorno.setQuestoesFaceis(resultSet.getInt("numerodequestoesfaceis"));
	        	provaDeRetorno.setQuestoesMedias(resultSet.getInt("numerodequestoesmedias"));
	        	provaDeRetorno.setQuestoesDificeis(resultSet.getInt("numerodequestoesdificeis"));
	        	provaDeRetorno.setData(resultSet.getDate("datadecriacao"));
	        	provaDeRetorno.toString();
			}
	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return provaDeRetorno;
	}


}

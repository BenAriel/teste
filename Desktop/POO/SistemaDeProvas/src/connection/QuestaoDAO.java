package connection;
import java.util.ArrayList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Questao;
public class QuestaoDAO extends BaseDAO_IMP<Questao> {


	@Override
	public void inserir(Questao questao) {
		String sql = "INSERT into Questao (disciplina,enunciado,assunto, gabarito,nivelDeDificuldade) values (?,?,?,?,?)";
		con = getConnection();
		PreparedStatement ptst;
		try {
			ptst = con.prepareStatement(sql);
			ptst.setString(1, questao.getDisciplina());
			ptst.setString(2, questao.getEnunciado());
			ptst.setString(3, questao.getAssunto());
			ptst.setString(4, questao.getGabarito());
			ptst.setInt(5, questao.getNivelDeDificuldade());
			ptst.execute();
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Questao buscar(Questao questao) {
		Questao questaoDeRetorno = new Questao(); //esse objeto monitor é quem vai retornar
		String sql = "Select * from questao where codigo = ?";
		con = getConnection();
		PreparedStatement ptst;
		ResultSet resultSet = null;
		try {
			ptst = con.prepareStatement(sql);
			ptst.setInt(1, questao.getCodigo());
			resultSet = ptst.executeQuery();
			while (resultSet.next()) {		
				questaoDeRetorno.setCodigo(resultSet.getInt("codigo"));
				questaoDeRetorno.setDisciplina(resultSet.getString("disciplina"));
				questaoDeRetorno.setEnunciado(resultSet.getString("enunciado"));
				questaoDeRetorno.setGabarito(resultSet.getString("gabarito"));
				questaoDeRetorno.setAssunto(resultSet.getString("assunto"));
				questaoDeRetorno.setNivelDeDificuldade(resultSet.getInt("niveldedificuldade"));
				questaoDeRetorno.toString();
			}
	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return questaoDeRetorno;
	}

	@Override
	public void alterar(Questao questao) {
		String sql = "UPDATE Questao SET disciplina = ?, enunciado = ?, gabarito = ?,assunto = ?, NivelDeDificuldade = ?  WHERE codigo = ? ";
		con = getConnection();
		PreparedStatement ptst;
		try {
			ptst = con.prepareStatement(sql);
			ptst.setString(1, questao.getDisciplina());
			ptst.setString(2, questao.getEnunciado());			
			ptst.setString(3, questao.getGabarito());
			ptst.setString(4, questao.getAssunto());
			ptst.setInt(5, questao.getNivelDeDificuldade());
			ptst.setInt(6, questao.getCodigo());
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remover(Questao questao) {
		String sql = "delete from Questao where codigo = ?";
		con = getConnection();
		PreparedStatement ptst;
		try {
			ptst = con.prepareStatement(sql);
			ptst.setInt(1, questao.getCodigo());
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Questao> listar() {
		ArrayList<Questao> listaQuestoes = new ArrayList<>();
		String sql = "Select * from Questao";
		ResultSet resultSet = null;
		try {
			con = getConnection();
			PreparedStatement ptst = con.prepareStatement(sql);
			resultSet = ptst.executeQuery();
			
			while (resultSet.next()) {		
				Questao questao = new Questao();
				questao.setCodigo(resultSet.getInt("codigo"));
				questao.setDisciplina(resultSet.getString("disciplina"));
	        	questao.setEnunciado(resultSet.getString("enunciado"));
	        	questao.setGabarito(resultSet.getString("gabarito"));
	        	questao.setAssunto(resultSet.getString("assunto"));
	        	questao.setAssunto(resultSet.getString("niveldedificuldade"));
	        	listaQuestoes.add(questao);
			}
			resultSet.close();
	        ptst.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaQuestoes;		
	}
	

}
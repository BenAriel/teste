package connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Monitor;


public class MonitorDAO extends BaseDAO_IMP<Monitor> {
	@Override
	public void remover(Monitor monitor) {
		String sql = "delete from Monitor where matricula = ?";
		con = getConnection();
		PreparedStatement ptst;
		try {
			ptst = con.prepareStatement(sql);
			ptst.setString(1, monitor.getMatricula());
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Monitor buscar(Monitor monitor) {
		Monitor monitorDeRetorno = new Monitor(); //esse objeto monitor é quem vai retornar
		String sql = "Select * from Monitor where matricula = ?";
		con = getConnection();
		PreparedStatement ptst;
		ResultSet resultSet = null;
		try {
			ptst = con.prepareStatement(sql);
			ptst.setString(1, monitor.getMatricula());
			resultSet = ptst.executeQuery();
			while (resultSet.next()) {		
				monitorDeRetorno.setNomeMonitor(resultSet.getString("nome"));
	        	monitorDeRetorno.setLogin(resultSet.getString("login"));
	        	monitorDeRetorno.setSenha(resultSet.getString("senha"));
	        	monitorDeRetorno.setMatricula(resultSet.getString("matricula"));
	        	monitorDeRetorno.toString();
			}
	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return monitorDeRetorno;
	}

	@Override
	public void alterar(Monitor monitor) {
		String sql = "update monitor set nome = ?, login = ?, senha = ?  where matricula = ? ";
		con = getConnection();
		PreparedStatement ptst;
		try {
			ptst = con.prepareStatement(sql);
			ptst.setString(1, monitor.getNomeMonitor());
			ptst.setString(2, monitor.getLogin());
			ptst.setString(3, monitor.getSenha());
			ptst.setString(4, monitor.getMatricula());
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void inserir(Monitor monitor) {
		String sql = "INSERT into Monitor(nome, login, senha, matricula) values (?,?,?,?)";
		con = getConnection();
		PreparedStatement ptst;
		try {
			ptst = con.prepareStatement(sql);
			ptst.setString(1, monitor.getNomeMonitor());
			ptst.setString(2, monitor.getLogin());
			ptst.setString(3, monitor.getSenha());
			ptst.setString(4, monitor.getMatricula());
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        	
	}


	@Override
	public ArrayList<Monitor> listar() {
		ArrayList<Monitor> listaDeMonitores = new ArrayList<>();
		String sql = "Select * from Monitor";
		ResultSet resultSet = null;
		try {
			con = getConnection();
			PreparedStatement ptst = con.prepareStatement(sql);
			resultSet = ptst.executeQuery();
			
			while (resultSet.next()) {		
				Monitor monitor = new Monitor();
				monitor.setNomeMonitor(resultSet.getString("nome"));
				monitor.setMatricula(resultSet.getString("matricula"));
	        	monitor.setLogin(resultSet.getString("login"));
	        	monitor.setSenha(resultSet.getString("senha"));
	        	monitor.setMatricula(resultSet.getString("matricula"));
	        	listaDeMonitores.add(monitor);
			}
			resultSet.close();
	        ptst.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaDeMonitores;		
	}
}

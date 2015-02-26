package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.exception.DAOException;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDao {
	private Connection connection;
	
	public ContatoDao() {
		connection = new ConnectionFactory().getConnection();
	}
	
	public void adicionaContato(Contato contato){
		String sql = "insert into contatos " +
				"(nome,email,endereco,dataNascimento)" +
				" values (?,?,?,?)";
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			//seta os valores
			stmt.setString(1,contato.getNome());
			stmt.setString(2,contato.getEmail());
			stmt.setString(3,contato.getEndereco());
			stmt.setDate(4,new Date(contato.getDataNascimento().getTimeInMillis()));
			
			//executa
			stmt.execute();
			stmt.close();
		}catch(SQLException ex){
			throw new DAOException(ex);
		}
	}

	
	public List<Contato> getLista(){
		try{
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Contato contato = daoForContato(rs);
				
				//adicionando o objeto à lista
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			return contatos;
		}catch(SQLException ex){
			throw new DAOException(ex);
		}
	}
	
	public List<Contato> getLista(String pesquisa){
		try{
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos where nome like '"+pesquisa+"'");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Contato contato = daoForContato(rs);
				//adicionando o objeto à lista
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			return contatos;
		}catch(SQLException ex){
			throw new DAOException(ex);
		}
	}
	
	public Contato getContato(Long id){
		try{
		Contato contato = new Contato();
		PreparedStatement stmt = this.connection.prepareStatement("select * from contatos where id="+id);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			contato = daoForContato(rs);
		}
		rs.close();
		stmt.close();
		return contato;
		}catch(SQLException ex){
			throw new DAOException(ex);
		}
	}
	
	public void altera(Contato contato){
		String sql = "update contatos set nome=?, email=?,"+
				"endereco=?, dataNascimento=? where id=?";
		try{
			//prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			//seta os valores
			
			stmt.setString(1,contato.getNome());
			stmt.setString(2,contato.getEmail());
			stmt.setString(3,contato.getEndereco());
			stmt.setDate(4,new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
			
		}catch(SQLException ex){
			throw new DAOException(ex);
		}
	}
	
	public void remove(Contato contato){
		try{
			PreparedStatement stmt = connection.prepareStatement("delete from contatos where id=?");
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
		}catch(SQLException ex){
			throw new DAOException(ex);
		}
	}

	private Contato daoForContato(ResultSet rs) throws SQLException {
		//Criando o objeto contato
		Contato contato = new Contato();
		contato.setId(rs.getLong("id"));
		contato.setNome(rs.getString("nome"));
		contato.setEmail(rs.getString("email"));
		contato.setEndereco(rs.getString("endereco"));
		
		//Montando a data através de Calendar
		Calendar data = Calendar.getInstance();
		data.setTime(rs.getDate("dataNascimento"));
		contato.setDataNascimento(data);
		return contato;
	}
}

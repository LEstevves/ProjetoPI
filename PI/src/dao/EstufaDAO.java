package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Estufa;

public class EstufaDAO {
	
	
	public static void criar(Estufa estufa) {
		String sqlInsert = "INSERT INTO estufa(nome, tempMin, tempMax, umidArMin, umidArMax, umidSoloMin, umidSoloMax) VALUES (?, ?, ?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, estufa.getNome());
			stm.setString(2, estufa.getTempMin());
			stm.setString(3, estufa.getTempMax());
			stm.setString(4, estufa.getUmidArMax());
			stm.setString(5, estufa.getUmidArMin());
			stm.setString(6, estufa.getUmidSoloMin());
			stm.setString(7, estufa.getUmidSoloMax());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					estufa.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void atualizar(Estufa estufa) {
		String sqlUpdate = "UPDATE estufa SET nome=?,  tempMin=?, tempMax=?, umidArMin=?, umidArMax=?, umidSoloMin=?, umidSoloMax=? WHERE id=?";
		// usando o try with resources do Java 7, quefecha o queabriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, estufa.getNome());
			stm.setString(2, estufa.getTempMin());
			stm.setString(3, estufa.getTempMax());
			stm.setString(4, estufa.getUmidArMax());
			stm.setString(5, estufa.getUmidArMin());
			stm.setString(6, estufa.getUmidSoloMin());
			stm.setString(7, estufa.getUmidSoloMax());
			stm.setInt(8, estufa.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void excluir(int id) {
		String sqlDelete = "DELETE FROM pais WHERE id = ?";
		// usando o try with resources do Java 7, quefecha o queabriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Estufa carregar(int id) {
		Estufa estufa = new Estufa();
		estufa.setId(id);
		String sqlSelect = "SELECT nome, tempMin, tempMax, umidArMin, umidArMax, umidSoloMin, umidSoloMax FROM estufa WHERE id = ?";
		// usando o try with resources do Java 7, quefecha o queabriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					String nome = (rs.getString("nome"));
					String tempMin = (rs.getString("tempMin"));
					String tempMax = (rs.getString("tempMax"));
					String umidArMin = (rs.getString("umidArMin"));
					String umidArMax = (rs.getString("umidArMax"));
					String umidSoloMin = (rs.getString("umidSoloMin"));
					String umidSoloMax = (rs.getString("umidSoloMax"));
					estufa = new Estufa(id, nome, tempMin, tempMax, umidArMin, umidArMax, umidSoloMin, umidSoloMax);
				} else {
					estufa.setId(-1);
					estufa.setNome(null);
					estufa.setTempMin(null);
					estufa.setTempMax(null);
					estufa.setUmidArMin(null);
					estufa.setUmidArMax(null);
					estufa.setUmidSoloMin(null);
					estufa.setUmidSoloMax(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return estufa;
	}
	
	public List<Estufa> getLista() {
		try	{
			List<Estufa>	plantas	=	new	ArrayList<Estufa>();
			Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement("select * from estufa");
			ResultSet	rs	=	stm.executeQuery();
			
			while	(rs.next())	{

			Estufa	p	=	new	Estufa();
			p.setId(rs.getInt("id"));
			p.setNome(rs.getString("nome"));
			p.setTempMin(rs.getString("tempMin"));
			p.setTempMax(rs.getString("tempMax"));
			p.setUmidArMin(rs.getString("umidArMin"));
			p.setUmidArMax(rs.getString("umidArMax"));
			p.setUmidSoloMin(rs.getString("umidSoloMin"));
			p.setUmidSoloMax(rs.getString("umidSoloMax"));
			plantas.add(p);
			}
			rs.close();
			stm.close();
			return	plantas;
			}	
		catch	(SQLException	e)	{
			throw new	RuntimeException(e);
			}
		}

	
	
	 
}

		



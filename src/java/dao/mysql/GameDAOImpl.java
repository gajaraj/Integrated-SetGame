/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.GameDTO;
import model.GameSearchDTO;
import dao.DAOException;
import dao.GameDAO;
import model.PointDTO;

public class GameDAOImpl implements GameDAO {
    private static final String dbUrl = "jdbc:derby://localhost:1527/login";
    private static final String dbUserName = "sa";
    private static final String dbPassword = "password";

	/* (non-Javadoc)
	 * @see dao.mysql.HeroIFDemo#deleteHero(model.HeroDTO)
	 */
	public void deleteGame(GameDTO game) throws DAOException {
		String deleteSql = "DELETE FROM heros WHERE name='"
				+ game.getGameid().trim() + "';";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = conn.createStatement();
			Logger.getLogger(getClass().getName()).log(Level.INFO,
					"Executing delete: " + deleteSql);
			int rows = st.executeUpdate(deleteSql);
			st.close();
		} catch (Exception e) {
			String error = "Error deleting users. Nested Exception is: " + e;
			System.out.println("#$#$#@$#@#@$#@$#@$#$#@");
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
			throw new DAOException(error);
		} finally {
			try {
				conn.rollback();
				conn.close();
			} catch (Exception e) {
			}
		}
	}

	/* (non-Javadoc)
	 * @see dao.mysql.HeroIFDemo#findAllHero()
	 */
	public ArrayList<GameDTO> findAllGame() throws DAOException {
		ArrayList<GameDTO> items = new ArrayList<GameDTO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//String selectSql = "select gameid from points where userid = 'player1';";
                //String ss = "select gameid from game where Cast(users as integer) > 0 and gameid not in (select gameid from points where userid = 'player1');";
		String selectSql ="select gameid from game where Cast(users as integer) > 0 or gameid in (select gameid from points where userid = 'player2');";
                Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = conn.createStatement();
			Logger.getLogger(getClass().getName()).log(Level.INFO,
					"Executing select: " + selectSql);
			ResultSet rs = st.executeQuery(selectSql);
			while (rs.next()) {
				GameDTO oneGame = new GameDTO();
				oneGame.setGameid(rs.getString("gameid"));
				oneGame.setDescription(rs.getString("description"));
				oneGame.setFeature1(rs.getString("feature1"));
                                oneGame.setFeature1(rs.getString("feature2"));
                                oneGame.setUsers(rs.getString("users"));
				items.add(oneGame);
			}
			st.close();
		} catch (Exception e) {
			String error = "Error selecting users. Nested Exception is: " + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
			throw new DAOException(error);
		} finally {
			try {
				conn.rollback();
				conn.close();
			} catch (Exception e) {
			}
		}
		return items;
	}

        public ArrayList<GameDTO> findAvailGame(String userid) throws DAOException {
		ArrayList<GameDTO> items = new ArrayList<GameDTO>();
		try {
                        Class.forName("org.apache.derby.jdbc.ClientDriver");
			//Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//String selectSql = "select gameid from points where userid = 'player1';";
                //String ss = "select gameid from game where Cast(users as integer) > 0 and gameid not in (select gameid from points where userid = 'player1');";
		String selectSql ="select * from game where Cast(users as integer) > 0 or gameid in (select gameid from points where userid = '"+userid+"')";
                Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = conn.createStatement();
			Logger.getLogger(getClass().getName()).log(Level.INFO,
					"Executing select: " + selectSql);
			ResultSet rs = st.executeQuery(selectSql);
			while (rs.next()) {
				GameDTO oneGame = new GameDTO();
				oneGame.setGameid(rs.getString("gameid"));
				oneGame.setDescription(rs.getString("description"));
				oneGame.setFeature1(rs.getString("feature1"));
                                oneGame.setFeature1(rs.getString("feature2"));
                                oneGame.setUsers(rs.getString("users"));
				items.add(oneGame);
			}
			st.close();
		} catch (Exception e) {
			String error = "Error selecting users. Nested Exception is: " + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
			throw new DAOException(error);
		} finally {
			try {
				conn.rollback();
				conn.close();
			} catch (Exception e) {
			}
		}
		return items;
	}

	/* (non-Javadoc)
	 * @see dao.mysql.HeroIFDemo#findHero(java.lang.String)
	 */
	public ArrayList<GameDTO> findGame(String gameid) throws DAOException {
            ArrayList<GameDTO> itemss = new ArrayList<GameDTO>();
            String selectSql = "select * from game where gameid = '" + gameid + "');";
		//String selectSql = "SELECT * FROM heros WHERE name='" + heroName.trim()
		//		+ "';";
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		GameDTO oneGame = new GameDTO();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = conn.createStatement();
			Logger.getLogger(getClass().getName()).log(Level.INFO,
					"Executing select: " + selectSql);
			ResultSet rs = st.executeQuery(selectSql);
			while (rs.next()) {
				oneGame.setGameid(rs.getString("gameid"));
				oneGame.setDescription(rs.getString("description"));
				oneGame.setFeature1(rs.getString("feature1"));
                                oneGame.setFeature1(rs.getString("feature2"));
                                oneGame.setUsers(rs.getString("users"));
                                itemss.add(oneGame);
			}
			st.close();
		} catch (Exception e) {
			String error = "Error selecting users. Nested Exception is: " + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
			throw new DAOException(error);
		} finally {
			try {
				conn.rollback();
				conn.close();
			} catch (Exception e) {
			}
		}
		System.out.println(oneGame.toString());
		return itemss;
	}

	/* (non-Javadoc)
	 * @see dao.mysql.HeroIFDemo#insertHero(model.HeroDTO)
	 */
	public void insertGame(GameDTO game) throws DAOException {
		String insertSql = "INSERT INTO game VALUES('" + game.getGameid()
				+ "', '" + game.getDescription() + "', '" + game.getFeature1()
				+ "');";
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = conn.createStatement();
			Logger.getLogger(getClass().getName()).log(Level.INFO,
					"Executing insert: " + insertSql);
			int res = st.executeUpdate(insertSql);
			st.close();
		} catch (Exception e) {
			String error = "Error selecting users. Nested Exception is: " + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
			throw new DAOException(error);
		} finally {
			try {
				conn.rollback();
				conn.close();
			} catch (Exception e) {
			}
		}
	}

        public void insertPoint(PointDTO point) throws DAOException {
		String insertSql = "INSERT INTO points VALUES('" + point.getGameid()+ "', '" + point.getUserid() + "','" + point.getPoint() + "')";
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = conn.createStatement();
			Logger.getLogger(getClass().getName()).log(Level.INFO,
					"Executing insert: " + insertSql);
			int res = st.executeUpdate(insertSql);
			st.close();
		} catch (Exception e) {
			String error = "Error selecting users. Nested Exception is: " + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
			throw new DAOException(error);
		} finally {
			try {
				conn.rollback();
				conn.close();
			} catch (Exception e) {
			}
		}
	}
	/* (non-Javadoc)
	 * @see dao.mysql.HeroIFDemo#updateHero(model.HeroDTO)
	 */
	public void updateGame(GameDTO game) throws DAOException {
		String updateSql = "UPDATE game SET users = '"
				+ game.getUsers() + "' WHERE gameid='" + game.getGameid() + "';";
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = conn.createStatement();
			Logger.getLogger(getClass().getName()).log(Level.INFO,
					"Executing update: " + updateSql);
			int res = st.executeUpdate(updateSql);
			st.close();
		} catch (Exception e) {
			String error = "Error selecting users. Nested Exception is: " + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
			throw new DAOException(error);
		} finally {
			try {
				conn.rollback();
				conn.close();
			} catch (Exception e) {
			}
		}

	}

	/* (non-Javadoc)
	 * @see dao.mysql.HeroIFDemo#findHeroByCriteria(model.HeroSearchDTO)
	 */
	public ArrayList<PointDTO> findGameByCriteria(GameSearchDTO so)
			throws DAOException {
		ArrayList<PointDTO> list = new ArrayList<PointDTO>();
		String selectSql = null;
		
				selectSql = "SELECT * FROM points WHERE gameid = '" + so.getGameid() + "' AND userid = '" + so.getUserid() + "'";
			
		
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = conn.createStatement();
			Logger.getLogger(getClass().getName()).log(Level.INFO,
					"Executing select: " + selectSql);
			ResultSet rs = st.executeQuery(selectSql);
			while (rs.next()) {
				PointDTO oneHero = new PointDTO();
				oneHero.setGameid(rs.getString("gameid"));
				oneHero.setPoint(rs.getString("point"));
				oneHero.setGameid(rs.getString("userid"));
				System.out.println(oneHero.toString());
				list.add(oneHero);
			}
			st.close();
		} catch (Exception e) {
			String error = "Error selecting users. Nested Exception is: " + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
			throw new DAOException(error);
		} finally {
			try {
				conn.rollback();
				conn.close();
			} catch (Exception e) {
			}
		}
		return list;
	}
}



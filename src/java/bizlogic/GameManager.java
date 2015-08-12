package bizlogic;

import java.util.ArrayList;
import model.GameDTO;
import model.GameSearchDTO;
import dao.DAOException;
import dao.DAOFactory;
import dao.GameDAO;
import model.PointDTO;

public class GameManager {
    private GameDAO gameDAO;
	public GameManager() {
		gameDAO = DAOFactory.loadInstance().getGameDAO();
	}
        
        @SuppressWarnings("finally")
	public ArrayList<PointDTO> findGameByCriteria(GameSearchDTO gso){
		ArrayList<PointDTO> currentList = new ArrayList<PointDTO>();
		try {
			currentList = gameDAO.findGameByCriteria(gso);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			return currentList;
		}
		
	}
	@SuppressWarnings("finally")
	public ArrayList<GameDTO> findGame(String gameName){
		ArrayList<GameDTO> currentGame = new ArrayList<GameDTO>();
		try {
			currentGame = gameDAO.findGame(gameName);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			return currentGame;
		}
		
	}
        @SuppressWarnings("finally")
	public ArrayList<GameDTO> findAvailGame(String userid) {
    	ArrayList<GameDTO> currentList = new ArrayList<GameDTO>();
		try {
			currentList = gameDAO.findAvailGame(userid);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			return currentList;
		}
    }
    @SuppressWarnings("finally")
	public ArrayList<GameDTO> findAllGame() {
    	ArrayList<GameDTO> currentList = new ArrayList<GameDTO>();
		try {
			currentList = gameDAO.findAllGame();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			return currentList;
		}
    }
    public void insertGame(GameDTO game) {
    	try {
			gameDAO.insertGame(game);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void updateGame(GameDTO game) {
    	try {
			gameDAO.updateGame(game);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void deleteGame(GameDTO game) {
    	try {
			gameDAO.deleteGame(game);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    }
    public void insertPoint(PointDTO point) {
    	try {
			gameDAO.insertPoint(point);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}


package dao.mysql;

import dao.DAOFactory;
import dao.GameDAO;

public class DAOFactoryImpl extends DAOFactory {
	private GameDAO gameDAO = new GameDAOImpl();
	
    public GameDAO getGameDAO() {
        return gameDAO;
    }
    
    
}

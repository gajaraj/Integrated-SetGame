package dao;

import java.util.ArrayList;
import model.GameDTO;
import model.GameSearchDTO;
import model.PointDTO;

public interface GameDAO {
    public ArrayList<GameDTO> findGame(String gameName) throws DAOException;
    public ArrayList<GameDTO> findAllGame() throws DAOException;
    public ArrayList<GameDTO> findAvailGame(String userid) throws DAOException;
    public void insertGame(GameDTO game) throws DAOException;
    public void updateGame(GameDTO game) throws DAOException;
    public void deleteGame(GameDTO game) throws DAOException;
    public ArrayList<PointDTO> findGameByCriteria(GameSearchDTO gso) throws DAOException;
    public void insertPoint(PointDTO point) throws DAOException;
    
}

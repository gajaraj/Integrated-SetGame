package dao;

public abstract class DAOFactory {
	
	
	
	public abstract GameDAO getGameDAO();
	public static DAOFactory loadInstance(){
		 return new dao.mysql.DAOFactoryImpl();
	 }
	
}

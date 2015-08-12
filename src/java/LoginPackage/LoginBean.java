/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPackage;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class LoginBean {
    @PersistenceContext private EntityManager em;
    
    public List<LOGINUSER> validate(String username, String password) {
        Query query = em.createQuery("SELECT c FROM LOGINUSER c where c.userid = '"+username+"' and c.userpassword = '"+password+"'");
        List results = query.getResultList();
        return (results);//em.find(LoginUser.class, username));//.createQuery("select * From LOGINUSER where USERID ='"+username+"' and USERPASSWORD='"+password+"'").getResultList());       
        
    }
}

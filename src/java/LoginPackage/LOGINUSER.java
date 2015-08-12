/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPackage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity//(name = "LOGINUSER")
public class LOGINUSER {
    @Id @Column(name = "USERID") private String userid;
    private String userpassword;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    @Override
    public String toString() {
        return "LoginUser{" + "userid=" + userid + ", userpassword=" + userpassword + '}';
    }

   
}

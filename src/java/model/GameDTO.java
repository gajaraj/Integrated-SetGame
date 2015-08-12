/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

public class GameDTO implements Serializable {
    private String gameid;
    private String description;
    private String feature1;
    private String feature2;
    private String users;

    public String getGameid() {
        return gameid;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public void setGameid(String gameid) {
        this.gameid = gameid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFeature1() {
        return feature1;
    }

    public void setFeature1(String feature1) {
        this.feature1 = feature1;
    }

    public String getFeature2() {
        return feature2;
    }

    public void setFeature2(String feature2) {
        this.feature2 = feature2;
    }

    
    //@Override
   // public String toString() {
     //   return "GameDTO[" + "gameid=" + gameid + ", description=" + description + ", feature1=" + feature1 + ", feature2=" + feature2 + ']';
    //}

    @Override
    public String toString() {
        return "GameDTO[" + "gameid=" + gameid + ", description=" + description + ", feature1=" + feature1 + ", feature2=" + feature2 + ", users=" + users + ']';
    }
    
}

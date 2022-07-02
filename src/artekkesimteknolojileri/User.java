/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package artekkesimteknolojileri;

/**
 *
 * @author alims
 */
public class User {
    private String userName;
    private String password;
    private String nameOfUser;

    public User(String userName, String password, String nameOfUser) {
        this.userName = userName;
        this.password = password;
        this.nameOfUser = nameOfUser;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getNameOfUser() {
        return nameOfUser;
    }  
}

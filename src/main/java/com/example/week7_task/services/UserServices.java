package com.example.week7_task.services;

import com.example.week7_task.dao.UsersDAO;
import com.example.week7_task.dto.LoginDTO;
import com.example.week7_task.dto.UserDTO;
import com.example.week7_task.model.Users;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.JDBCType;
@Service
public class UserServices {
    @Autowired
    UsersDAO usersDAO;

    UserDTO userDTO;

    @Autowired
    PostServices postServices;

    public boolean save(Users users, HttpSession session){
       String password = BCrypt.hashpw(users.getPassword(),BCrypt.gensalt());
       users.setPassword(password);
       usersDAO.save(users);
       session.setAttribute("account_status","Account has been successfully created. please login");
       return true;
    }
    public Users getUser(String email,String password){
        Users users = usersDAO.findByEmail(email);
        return users;
    }
    public boolean auth(LoginDTO loginDTO, HttpSession session){
        Users users= usersDAO.findByEmail(loginDTO.getEmail());
        if(users!= null) {
            if(BCrypt.checkpw(loginDTO.getPassword(),users.getPassword())) {
                userDTO = new UserDTO();
                userDTO.setEmail(users.getEmail());
                userDTO.setFullName(users.getFullName());
                userDTO.setId(users.getId());
                postServices.fetchPost(session);
                session.setAttribute("userDTO",userDTO);
                session.setAttribute("loggedInUser",userDTO);
                return true;
            } else {
                return false;
            }
        } else {
                return false;
        }

    }

}

package com.ita.speakukrainian.utils.jdbc.services;

import com.ita.speakukrainian.utils.jdbc.dao.UsersDAO;
import com.ita.speakukrainian.utils.jdbc.entity.UsersEntity;

import java.util.List;

public class UsersService {

    private final UsersDAO usersDAO;

    public UsersService() {
        usersDAO = new UsersDAO();
    }

    public List<UsersEntity> getAllNameWhereEmail() {
        return usersDAO.selectAllWhereEmail();
    }
}

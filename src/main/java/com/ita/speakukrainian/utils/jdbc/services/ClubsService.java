package com.ita.speakukrainian.utils.jdbc.services;

import com.ita.speakukrainian.utils.jdbc.dao.ClubsDAO;
import com.ita.speakukrainian.utils.jdbc.entity.ClubsEntity;


import java.util.List;

public class ClubsService {
    private final ClubsDAO clubsDAO;
    public ClubsService() {
        clubsDAO = new ClubsDAO();
    }
    public List<ClubsEntity> getAll() {

        return clubsDAO.selectClubs();
    }
    public List<ClubsEntity> getByName(String name) {

        return clubsDAO.selectByName(name);
    }
}

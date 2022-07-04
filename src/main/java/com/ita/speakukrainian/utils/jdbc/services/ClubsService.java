package com.ita.speakukrainian.utils.jdbc.services;

import com.ita.speakukrainian.utils.jdbc.dao.ClubsDAO;
import com.ita.speakukrainian.utils.jdbc.entity.ClubsEntity;

import java.util.List;
import java.util.stream.Collectors;

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

    public ClubsEntity getById(Long id) {

        return clubsDAO.selectById(id);
    }
    public List<ClubsEntity> getByUserIDAndCenterNotNull(long id) {
        return clubsDAO.selectByUserID(id).stream().filter(club->club.getCenterId()!=null).collect(Collectors.toList());
    }

    public List<ClubsEntity> getAllNameClubs() {

        return clubsDAO.selectAllNameClubs();
    }
    public List<ClubsEntity> getAllNameClubsUseLike() {

        return clubsDAO.selectAllNameClubsUseLike();
    }


}

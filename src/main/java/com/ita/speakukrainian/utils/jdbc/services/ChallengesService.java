package com.ita.speakukrainian.utils.jdbc.services;

import com.ita.speakukrainian.utils.jdbc.dao.ChallengesDAO;
import com.ita.speakukrainian.utils.jdbc.dao.ClubsDAO;
import com.ita.speakukrainian.utils.jdbc.entity.ChallengesEntity;
import com.ita.speakukrainian.utils.jdbc.entity.ClubsEntity;

import java.util.List;

public class ChallengesService {
    private final ChallengesDAO challengesDAO;

    public ChallengesService() {

        challengesDAO = new ChallengesDAO();
    }
    public List<ChallengesEntity> getAll(String getsortnumber,int getsortnumberint) {

        return challengesDAO.selectByNamePictureSortNumberTitle(getsortnumber,getsortnumberint);
    }
}

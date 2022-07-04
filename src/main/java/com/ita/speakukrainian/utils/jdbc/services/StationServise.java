package com.ita.speakukrainian.utils.jdbc.services;

import com.ita.speakukrainian.utils.jdbc.dao.StationsDAO;
import com.ita.speakukrainian.utils.jdbc.entity.StationEntity;

import java.util.List;

public class StationServise {
    private final StationsDAO stationsDAO;
    public StationServise() {
        stationsDAO = new StationsDAO();
    }
    public List<StationEntity> getALLStations() {
        return stationsDAO.selectAll();
    }
}

package riho.project.sungjuk.dao;

import riho.project.sungjuk.model.SungjukVO;

import java.util.List;

public interface SungjukV3DAO {

    boolean saveSungjuk(SungjukVO sj);

    List<SungjukVO> loadSungjuk();
}

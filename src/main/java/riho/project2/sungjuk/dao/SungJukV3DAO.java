package riho.project2.sungjuk.dao;

import riho.project2.sungjuk.model.SungJukVO;

import java.util.List;

public interface SungJukV3DAO {

    boolean saveSungJuk(SungJukVO sj);

    List<SungJukVO> loadSungJuk();

    void writeSungJuk(List<SungJukVO> sjs);
}

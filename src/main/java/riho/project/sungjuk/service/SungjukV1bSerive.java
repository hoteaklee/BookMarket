package riho.project.sungjuk.service;

import riho.project.sungjuk.model.SungjukVO;

public interface SungjukV1bSerive {

    void newSungjuk();
    void readSungjuk();
    void readOneSungjuk();
    void modifySungjuk();
    void removeSungjuk();
    void computeSungjuk(SungjukVO sj);

    String displayMenu();

    void processMenu(String menu);

}

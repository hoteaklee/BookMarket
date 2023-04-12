package riho.project.sungjuk.service;

import riho.project.sungjuk.model.SungjukVO;

public interface SungjukV1cSerive {

    void newSungjuk();
    void readSungjuk();
    void readOneSungjuk();
    void modifySungjuk();
    void removeSungjuk();
    void computeSungjuk(SungjukVO sj);

    int displayMenu();

    void processMenu(int menu);

}

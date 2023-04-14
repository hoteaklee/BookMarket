package riho.project.sungjuk.dao;

import riho.project.sungjuk.model.SungjukVO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class SungjukV3DAOImpl implements SungjukV3DAO{

    private String fname = "c:/Java/sungjukv3.dat";
    private FileWriter fw = null;
    private FileReader fr = null;
    private BufferedWriter bw = null;
    private BufferedReader br = null;

    @Override
    public boolean saveSungjuk(SungjukVO sj) {

        // 생성된 성적데이터를 파일에 저장
        try {
            // 파일기록시 추가append 기능 활성화
            fw = new FileWriter(fname,true);
            bw = new BufferedWriter(fw);

            bw.write(sj.toString());    //파일에 기록
        } catch (Exception ex) {
            System.out.println("성적 데이터 저장중 오류 발생!");
            System.out.println(ex.getMessage());
            return false;
        } finally {
            // 파일쓰기가 끝나면 작업 종료
            if (bw != null) try {bw.close();} catch (Exception ex){}
            if (fw != null) try {fw.close();} catch (Exception ex){}
        }

        return true;
    }
}

package riho.project.sungjuk.dao;

import riho.project.sungjuk.model.SungjukVO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

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

    // 파일에 저장된 성적 데이터들을 모두 읽어서
    //ArrayList 객체에 저장하고 리턴
    @Override
    public List<SungjukVO> loadSungjuk() {
        List<SungjukVO> sjdata = new ArrayList<>();

        try {
            fr = new FileReader(fname);
            br = new BufferedReader(fr);

            while (br.ready()){
                // 파일에서 성적데이터 한줄을 읽어서
                String[] val = br.readLine().split("[ ]"); //파일에 한줄 읽어서 뛰어쓰기로 분류
                // Sungjuk 객체에 개별 값을 저장하고
                SungjukVO sj = new SungjukVO(
                        val[0],Integer.parseInt(val[1]),Integer.parseInt(val[2]),Integer.parseInt(val[3]));
                sj.setTot(Integer.parseInt(val[4]));
                sj.setAvg(Double.parseDouble(val[5]));
                sj.setGrd( val[6] );

                // ArrayList 객체에 저장
                sjdata.add(sj);
            }

        } catch (Exception ex) {
            System.out.println("성적 데이터 저장중 오류 발생!");
            System.out.println(ex.getMessage());
        } finally {
            // 파일쓰기가 끝나면 작업 종료
            if (br != null) try {br.close();} catch (Exception ex){}
            if (fr != null) try {fr.close();} catch (Exception ex){}
        }

        return sjdata;
    }
}

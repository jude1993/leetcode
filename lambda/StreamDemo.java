import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StreamDemo {
    @Test
    public void bufferedReader(){
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("C:\\Users\\jude.JUDEPC\\Desktop\\资料\\供应商接口文档\\19e\\test.txt"));
            String str = JSONObject.toJSONString(bufferedReader.lines().limit(10).toArray());
            System.out.println(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally{
            if(bufferedReader!=null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

package io;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author ：wupeng
 * @date ：Created in 17:26 2019/1/8
 * @description：
 */
@Getter
@Setter
@ToString
public class FileIo {
    private InputStream is;
    private OutputStream os;


    public FileIo(InputStream is,OutputStream os){
        this.is = is;
        this.os = os;
    }


}

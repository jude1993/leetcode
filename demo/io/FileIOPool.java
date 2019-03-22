package io;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：wupeng
 * @date ：Created in 17:11 2019/1/8
 * @description：
 */
@Getter
@Setter
@ToString
public class FileIOPool {

    public static List<FileIo> list = new ArrayList<>();

    public static List<FileIo> get(){
        return list;
    }

    public static void add(FileIo fileIo){
        list.add(fileIo);
    }

}

package io;

import java.io.*;

/**
 * @author ：wupeng
 * @date ：Created in 15:29 2019/1/8
 * @description：
 */
public class PointWriter {

  public static void main(String[] args) {
      String fileName = "E:\\BaiduNetdiskDownload\\oceans.mp4";
      String newFileName = "E:\\BaiduNetdiskDownload\\oceansCopy.mp4";
      PointWriter pointWriter = new PointWriter();
      try {
          pointWriter.writeByPoint(50L,fileName,newFileName);
      } catch (Exception e) {
          e.printStackTrace();
      }
  }

  public void writeByPoint(Long percent, String fileName, String newFileName)throws Exception{
      File file = new File(fileName);
      long length = file.length();
      Long skipCount = CountUtils.count(length, percent);

      System.out.println("fileName="+file.getName()+"/fileSize="+length+"/startPoint="+skipCount);
      BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
      BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFileName));
      FileIo fileIo = new FileIo(bis, bos);
      FileIOPool.add(fileIo);
      //bis.skip(skipCount);
      byte[] buff = new byte[1024 * 1024 * 2];
      //实际读取字节大小
      int readSize = -1;
      //while((readSize = bis.read(buff)) != -1){
          bos.write(buff,0,buff.length);
          bos.flush();
      //}
      bos.close();
      bis.close();
  }

}

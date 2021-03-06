package io;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * ByteBuffer
 *      allocate() 堆内内存
 *      allocateDirect() 堆外内存
 *
 * 包含头部位置，不包含尾部位置
 *
 *      position 内存可用起始位置
 *      limit   内存可用终止位置
 *      capacity 内存最大容量
 *
 * position和limit之间的数据是有效/可用数据
 *
 *  flip()  切换到读取模式
 *      read()/put()
 *      position和limit之间是可读数据位置
 *  compact() 切换到写入模式
 *      get()
 *      position和limit之间是可写数据位置
 *
 * */
public class ByteBufferTest {
    public static void main(String[] args) {

        byte[] barr = "123456789\n".getBytes();

        //堆内内存
        ByteBuffer by = ByteBuffer.allocate(1024);
        //堆外内存
        //ByteBuffer by2 = ByteBuffer.allocateDirect(1024);

        System.out.println("byte buffer init---------");
        System.out.println("position=" + by.position() + ",limit=" + by.limit() + ",capacity=" + by.capacity());

        by.put(barr);
        System.out.println("byte buffer put----------");
        System.out.println("position=" + by.position() + ",limit=" + by.limit() + ",capacity=" + by.capacity());

        //读出模式
        //flip 将limit值置为position之前的位置，将position值置为0
        Buffer flip = by.flip();
        System.out.println("byte buffer flip-----------------");
        System.out.println("position=" + flip.position() + ",limit=" + flip.limit() + ",capacity=" + flip.capacity());

        int anInt = by.getInt();
        System.out.println("getInt = " + anInt);
        System.out.println("position=" + flip.position() + ",limit=" + flip.limit() + ",capacity=" + flip.capacity());

        //写入模式
        ByteBuffer compact = by.compact();
        System.out.println("position=" + compact.position() + ",limit=" + compact.limit() + ",capacity=" + compact.capacity());
        System.out.println("byte buffer compact----------------");
        System.out.println("position=" + compact.position() + ",limit=" + compact.limit() + ",capacity=" + compact.capacity());
    }
}

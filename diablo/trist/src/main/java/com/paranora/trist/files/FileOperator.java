package com.paranora.trist.files;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by yangqun on 2016/12/08.
 */
public interface FileOperator {
    /**
     * 获得文件输入流
     * @param fileId 文件ID
     * @return
     */
    InputStream open(String fileId) ;

    /**
     * 获得文件输出流
     * @param fileId 文件ID
     * @return
     */
    OutputStream create(String fileId) ;


    /**
     * 删除文件
     * @param fileId 文件ID
     */
    boolean delete(String fileId);

    /**
     * 从文件系统中下载一份拷贝到本地目录
     * @param fileId
     * @param dir 本地目录
     * @return
     */
    File checkout(String fileId, File dir) ;

    /**
     * 保存本地的文件到文件系统
     * @param file
     * @return 返回文件ID
     * @
     */
    String checkIn(File file, String fileId);

    /**
     * 检查文件系统是否存在文件
     * @param fileId
     * @return
     */
    boolean fileExists(String fileId);
}

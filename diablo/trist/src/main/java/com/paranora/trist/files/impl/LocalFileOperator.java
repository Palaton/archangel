package com.paranora.trist.files.impl;

import com.paranora.trist.BusinessException;
import com.paranora.trist.SpringContextHolder;
import com.paranora.trist.SpringUtils;
import com.paranora.trist.SysHelperService;
import com.paranora.trist.files.FileOperator;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yangqun on 2016/12/08.
 */
public class LocalFileOperator implements FileOperator {

    public InputStream open(String fileId) throws BusinessException {
        try {
            return FileUtils.openInputStream(getLocalFile(fileId));
        } catch (IOException ex) {
            throw new BusinessException(ex.getMessage());
        }
    }

    public OutputStream create(String fileId) throws BusinessException {
        try {
            return FileUtils.openOutputStream(getLocalFile(fileId));
        } catch (IOException ex) {
            throw  new BusinessException(ex.getMessage());
        }
    }


    public boolean delete(String fileId) {
        File file = getLocalFile(fileId);
        return file.delete();
    }

    /**
     * 检出文件到本地temp文件夹
     */
    @Override
    public File checkout(String fileId, File dir) throws BusinessException {
        File srcFile = getLocalFile(fileId);
        if(!srcFile.exists()){
            return null;
        }
        File destFile = null;
        File temDir = null;
        if (dir != null && dir.mkdirs()) {
            temDir = dir;
        }
        if (dir == null) {
            String time = (new SimpleDateFormat("yyyyMMdd")).format(new Date());
            temDir = new File(SpringContextHolder.getSysHelperService().getUploadPath() + "temp" + File.separator + time);
        }
        try {
            FileUtils.copyFileToDirectory(srcFile, temDir);
            destFile = new File(temDir, srcFile.getName());
        } catch (IOException ex) {
            throw new BusinessException(ex.getMessage());
        }
        return destFile;
    }

    @Override
    public String checkIn(File file, String fileId) throws BusinessException {
        OutputStream out = null;
        FileInputStream in = null;
        try {
            out = create(fileId);
            in = FileUtils.openInputStream(file);
            IOUtils.copy(in, out);
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(out);
        } catch (IOException ex) {
            throw new BusinessException(ex.getMessage());
        } finally {
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(out);
        }
        return fileId;
    }

    private File getLocalFile(String fileId) {
        String baseDir = SpringUtils.getBean(SysHelperService.class).getUploadPath();
        return new File(baseDir + fileId);
    }
    public String getLocalFilePath(String fileId) {
        String baseDir = SpringUtils.getBean(SysHelperService.class).getUploadPath();
        return baseDir + fileId;
    }

    @Override
    public boolean fileExists(String fileId) {
        File srcFile = getLocalFile(fileId);
        return srcFile.exists();
    }
}
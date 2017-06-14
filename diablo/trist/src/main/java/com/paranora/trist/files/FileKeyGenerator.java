package com.paranora.trist.files;

import java.io.File;

/**
 * Created by yangqun on 2016/12/08.
 */
public interface FileKeyGenerator {
    String create(String name);
    String create(File file, String fileId, String relativePath);
    String getFilePath(String relativePath);
}
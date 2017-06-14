package com.paranora.trist;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * Created by yangqun on 2016/12/08.
 */
@Service
public class SysHelperService {
    private String uploadPath;
    private String imageServerUrl;

    public String getUploadPath() {
        return uploadPath;
    }

    @Value("${file.upload.dir}")
    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
        if(this.uploadPath.endsWith(File.separator) || this.uploadPath.endsWith("/")){
            return;
        }else {
            this.uploadPath = this.uploadPath+File.separator;
        }
    }

    public String getImageServerUrl() {
        return imageServerUrl;
    }

    @Value("${image.server.url}")
    public void setImageServerUrl(String imageServerUrl) {
        this.imageServerUrl = imageServerUrl;
        if(!this.imageServerUrl.endsWith("/")){
            this.imageServerUrl = this.imageServerUrl+"/";
        }
    }

}
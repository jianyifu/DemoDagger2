package com.fjy.gameboxmvp.data.pojo;

import com.google.gson.Gson;

import java.io.Serializable;

public class PkgInfo implements Serializable {

    /**
     * pkgName : null
     * version : null
     * downloadUrl : null
     * name : null
     * desp : null
     */

    private String pkgName;
    private String pkgSize;
    private String version;
    private String downloadUrl;
    private String name;
    private String desp;

    public String getPkgName() {
        return pkgName;
    }

    public void setPkgName(String pkgName) {
        this.pkgName = pkgName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesp() {
        return desp;
    }

    public void setDesp(String desp) {
        this.desp = desp;
    }

    public String getPkgSize() {
        return pkgSize;
    }

    public void setPkgSize(String pkgSize) {
        this.pkgSize = pkgSize;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
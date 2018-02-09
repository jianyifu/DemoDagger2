package com.fjy.gameboxmvp.data.pojo;

import android.text.TextUtils;

import com.google.gson.Gson;

import java.io.Serializable;

public class BigPicBean extends ObjBean implements Serializable {

    private String img;
    private String imgTitle;
    private int imgType;
    private String imgDetail;
    private String icon;
    private String iconTitle;
    private int btnType;
    private String btnDetail;
    private String activityStatus;
    private String gameName;
    private PkgInfo pkgInfo;

    private String played;//有played并且等于1的时候就显示继续玩
    private boolean isPlayed(){
        return "1".equals(played);
    }
    public String getPlayText(){
        if(isPlayed()){
            return "继续玩";
        }else{
            return "直接玩";
        }
    }
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImgTitle() {
        return imgTitle;
    }

    public void setImgTitle(String imgTitle) {
        this.imgTitle = imgTitle;
    }

    public int getImgType() {
        return imgType;
    }

    public void setImgType(int imgType) {
        this.imgType = imgType;
    }

    public String getImgDetail() {
        return imgDetail;
    }

    public void setImgDetail(String imgDetail) {
        this.imgDetail = imgDetail;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIconTitle() {
        return iconTitle;
    }

    public void setIconTitle(String iconTitle) {
        this.iconTitle = iconTitle;
    }

    public int getBtnType() {
        return btnType;
    }

    public void setBtnType(int btnType) {
        this.btnType = btnType;
    }

    public String getBtnDetail() {
        return btnDetail;
    }

    public void setBtnDetail(String btnDetail) {
        this.btnDetail = btnDetail;
    }

    public PkgInfo getPkgInfo() {
        return pkgInfo;
    }

    public void setPkgInfo(PkgInfo pkgInfo) {
        this.pkgInfo = pkgInfo;
    }

    public String getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(String activityStatus) {
        this.activityStatus = activityStatus;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getPlayed() {
        return played;
    }

    public void setPlayed(String played) {
        this.played = played;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    @Override
    public boolean isValid() {
        if(btnType == 4|| imgType == 4){
            if(pkgInfo == null || TextUtils.isEmpty(pkgInfo.getPkgName())|| TextUtils.isEmpty(pkgInfo.getDownloadUrl())){
                return false;
            }
        }
        return true;
    }

}
package com.fjy.gameboxmvp.data.pojo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by zhuhao on 2017/3/21.
 */

public class GameInfo implements Serializable  {
    private static final long serialVersionUID = 536871008L;


    private String id;
    private String name;
    private int classify;
    private String typeKey;
    private String description;
    private String shortDescription;
    private int hotNum;
    private int sortWeight;

    private ArrayList<String> gameImgs;
    private String iconImg;
    private String gameUrl;
    private String activityOn;

    private String activitySlogan;
    private String playFlag;
    private String screenStyle;// 0 竖屏   1 横屏
    private String browserStyle;// 0 crosswalk内核   1 系统浏览器内核

    private ArrayList<RemindData> activityList;
    public boolean isSelected;

    private String downloadUrl;
    private String pageName;
    private String downloadUrlVersion;
    private String gameSize;

    private boolean isCollect;  //有没有被收藏



    private ShareData shareData; //分享 相关



    private Long dbId;

    private String md5;

    private String gameFilePath;

    private String pagePath;

    private String directoryPath;

    private int status;// 1 正在下载  2，下载完成  3，解压完成    101 下载出错

    private String tag;



    private String pkgDetail;//apk packagename

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

    public String getGameSize() {
        return gameSize;
    }

    public void setGameSize(String gameSize) {
        this.gameSize = gameSize;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getScreenStyle() {
        return screenStyle;
    }

    public void setScreenStyle(String screenStyle) {
        this.screenStyle = screenStyle;
    }


    public ArrayList<RemindData> getActivityList() {
        return activityList;
    }

    public String getPlayFlag() {
        return playFlag;
    }

    public void setPlayFlag(String playFlag) {
        this.playFlag = playFlag;
    }

    public void setActivityList(ArrayList<RemindData> activityList) {
        this.activityList = activityList;
    }

    public String getActivityOn() {
        return activityOn;
    }

    public void setActivityOn(String activityOn) {
        this.activityOn = activityOn;
    }

    public String getActivitySlogan() {
        return activitySlogan;
    }

    public void setActivitySlogan(String activitySlogan) {
        this.activitySlogan = activitySlogan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassify() {
        return classify;
    }

    public void setClassify(int classify) {
        this.classify = classify;
    }

    public String getTypeKey() {
        return typeKey;
    }

    public void setTypeKey(String typeKey) {
        this.typeKey = typeKey;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHotNum() {
        return hotNum;
    }

    public void setHotNum(int hotNum) {
        this.hotNum = hotNum;
    }

    public int getSortWeight() {
        return sortWeight;
    }

    public void setSortWeight(int sortWeight) {
        this.sortWeight = sortWeight;
    }

    public ArrayList<String> getGameImgs() {
        return gameImgs;
    }

    public void setGameImgs(ArrayList<String> gameImgs) {
        this.gameImgs = gameImgs;
    }

    public String getIconImg() {
        return iconImg;
    }

    public void setIconImg(String iconImg) {
        this.iconImg = iconImg;
    }

    public String getGameUrl() {
        return gameUrl;
    }

    public void setGameUrl(String gameUrl) {
        this.gameUrl = gameUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getDownloadUrlVersion() {
        return downloadUrlVersion;
    }

    public void setDownloadUrlVersion(String downloadUrlVersion) {
        this.downloadUrlVersion = downloadUrlVersion;
    }

    public String getPkgDetail() {
        return pkgDetail;
    }

    public void setPkgDetail(String pkgDetail) {
        this.pkgDetail = pkgDetail;
    }

    public String getPlayed() {
        return played;
    }

    public void setPlayed(String played) {
        this.played = played;
    }

    public GameInfo(String name) {
        this.name = name;
    }

    public GameInfo() {
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        return gson.toJson(this);
    }

    public boolean isAndroidDefaultWebCore() {
        return "1".equalsIgnoreCase(browserStyle);
    }

    public void setBrowserStyle(String browserStyle) {
        this.browserStyle = browserStyle;
    }

    public String getBrowserStyle() {
        return this.browserStyle;
    }

    public boolean getIsSelected() {
        return this.isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public Long getDbId() {
        return this.dbId;
    }

    public void setDbId(Long dbId) {
        this.dbId = dbId;
    }

    public String getMd5() {
        return this.md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getGameFilePath() {
        return this.gameFilePath;
    }

    public void setGameFilePath(String gameFilePath) {
        this.gameFilePath = gameFilePath;
    }

    public String getPagePath() {
        return this.pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }

    public String getDirectoryPath() {
        return this.directoryPath;
    }

    public void setDirectoryPath(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public boolean isCollect() {
        return isCollect;
    }

    public void setCollect(boolean collect) {
        isCollect = collect;
    }

    public ShareData getShareData() {
        return shareData;
    }

    public void setShareData(ShareData shareData) {
        this.shareData = shareData;
    }



}

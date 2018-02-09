package com.fjy.gameboxmvp.data.pojo;

import java.io.Serializable;

/**
 * Created by zhuhao on 2017/7/27.
 */

public class ShareData implements Serializable {


    /**
     * id : 94a35a7494fd48f3719a746a63d0379a
     * title : null
     * content : null
     * imgUrl : null
     * defaultUrl : http://yx.sogou.com/h5game/wap/redirectgame.html?channel=1000&gameid=94a35a7494fd48f3719a746a63d0379a&gameurl=http%3A%2F%2Fapi.j115.com%2Fsdk%2Fplay%2F10134%2F25.html
     * qqUrl : null
     * wxUrl : null
     * wbUrl : null
     * qzoneUrl : null
     */

    private String id;
    private String title;
    private String content;
    private String imgUrl;
    private String defaultUrl;
    private String qqUrl;
    private String wxUrl;
    private String wbUrl;
    private String qzoneUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDefaultUrl() {
        return defaultUrl;
    }

    public void setDefaultUrl(String defaultUrl) {
        this.defaultUrl = defaultUrl;
    }

    public String getQqUrl() {
        return qqUrl;
    }

    public void setQqUrl(String qqUrl) {
        this.qqUrl = qqUrl;
    }

    public String getWxUrl() {
        return wxUrl;
    }

    public void setWxUrl(String wxUrl) {
        this.wxUrl = wxUrl;
    }

    public String getWbUrl() {
        return wbUrl;
    }

    public void setWbUrl(String wbUrl) {
        this.wbUrl = wbUrl;
    }

    public String getQzoneUrl() {
        return qzoneUrl;
    }

    public void setQzoneUrl(String qzoneUrl) {
        this.qzoneUrl = qzoneUrl;
    }
}

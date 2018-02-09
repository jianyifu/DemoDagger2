package com.fjy.gameboxmvp.data.pojo;

import java.io.Serializable;

/**
 * Created by zhuhao on 2017/3/27.
 */

public class RemindData implements Serializable{


    /**
     * title : 武神空间
     * description : 武神空间
     * startTime : 1490601196981
     * endTime : 1490603196981
     * remindWeek : 1111111
     * remindTime : 19:12
     */

    private String title;
    private String description;
    private long startTime;
    private long endTime;
    private String remindWeek;
    private String remindTime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getRemindWeek() {
        return remindWeek;
    }

    public void setRemindWeek(String remindWeek) {
        this.remindWeek = remindWeek;
    }

    public String getRemindTime() {
        return remindTime;
    }

    public void setRemindTime(String remindTime) {
        this.remindTime = remindTime;
    }
}

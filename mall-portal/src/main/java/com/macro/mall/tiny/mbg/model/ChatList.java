package com.macro.mall.tiny.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ChatList implements Serializable {
    private Long id;

    @ApiModelProperty(value = "我的id")
    private Long myid;

    @ApiModelProperty(value = "我的头像")
    private String myavator;

    @ApiModelProperty(value = "对方id")
    private Long targetid;

    @ApiModelProperty(value = "对方昵称")
    private String targetname;

    @ApiModelProperty(value = "对方头像")
    private String targetavator;

    @ApiModelProperty(value = "是否有未读信息，0没有，1有")
    private Byte havenew;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMyid() {
        return myid;
    }

    public void setMyid(Long myid) {
        this.myid = myid;
    }

    public String getMyavator() {
        return myavator;
    }

    public void setMyavator(String myavator) {
        this.myavator = myavator;
    }

    public Long getTargetid() {
        return targetid;
    }

    public void setTargetid(Long targetid) {
        this.targetid = targetid;
    }

    public String getTargetname() {
        return targetname;
    }

    public void setTargetname(String targetname) {
        this.targetname = targetname;
    }

    public String getTargetavator() {
        return targetavator;
    }

    public void setTargetavator(String targetavator) {
        this.targetavator = targetavator;
    }

    public Byte getHavenew() {
        return havenew;
    }

    public void setHavenew(Byte havenew) {
        this.havenew = havenew;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", myid=").append(myid);
        sb.append(", myavator=").append(myavator);
        sb.append(", targetid=").append(targetid);
        sb.append(", targetname=").append(targetname);
        sb.append(", targetavator=").append(targetavator);
        sb.append(", havenew=").append(havenew);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
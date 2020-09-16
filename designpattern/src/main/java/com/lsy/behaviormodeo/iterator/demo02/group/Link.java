package com.lsy.behaviormodeo.iterator.demo02.group;

/**
 * 树节点链路
 * @author TT
 */
public class Link {

    /**
     * 雇员ID
     */
    private String fromId;
    /**
     * 雇员ID
     */
    private String toId;

    public Link(String fromId, String toId) {
        this.fromId = fromId;
        this.toId = toId;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

}

package com.evo.sp.common.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Tree<T> {
    
    /**
     *
     * 节点ID
     */
    private String treeId;

    /**
     *  数据id
     */
    private String id;
    /**
     * 显示节点文本
     */
    private String text;
    /**
     * 节点状态
     */
    private Integer isOpen;
    /**
     * 节点是否被选中 true false
     */
    private boolean checked = false;
    /**
     * 节点属性
     */
    private List<Map<String, Object>> attributes;
    /**
     * 节点的子节点
     */
    private List<Tree<T>> children = new ArrayList<Tree<T>>();

    /**
     * 父ID
     */
    private String parentId;
    /**
     * 是否有父节点
     */
    private boolean isParent = false;
    /**
     * 是否有子节点
     */
    private boolean isChildren = false;
    /**
     *
     * 节点路径
     */
    private String path;
    
    /**
     *
     *  菜单icon
     */
    private String icon;
    
    /**
     *
     * 级别
     */
    private Integer level;
    
    /**
     *
     * 编码
     */
    private String code;
    
    /**
     *
     *  状态（1 启用   2禁用）
     */
    private Integer state;

    /**
     *
     * 类型
     */
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getTreeId() {
        return treeId;
    }

    public void setTreeId(String treeId) {
        this.treeId = treeId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }



    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public List<Map<String, Object>> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Map<String, Object>> attributes) {
        this.attributes = attributes;
    }

    public List<Tree<T>> getChildren() {
        return children;
    }

    public void setChildren(List<Tree<T>> children) {
        this.children = children;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public boolean isParent() {
        return isParent;
    }

    public void setParent(boolean parent) {
        isParent = parent;
    }

    public boolean isChildren() {
        return isChildren;
    }

    public void setChildren(boolean children) {
        isChildren = children;
    }
}

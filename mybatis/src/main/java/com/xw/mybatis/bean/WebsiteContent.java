package com.xw.mybatis.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;


import org.apache.ibatis.type.JdbcType;


public class WebsiteContent implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 导航id
     */
    private Long navId;

    /**
     * 标题
     */
    private String title;

    /**
     * 副标题
     */
    private String secondTitle;

    /**
     * 简述
     */
    private String description;

    /**
     * 内容详情
     */
    private String content;

    /**
     * 图片url
     */
    private String imgUrl;

    /**
     * 链接到站内其他文章详情id
     */
    private Long linkId;

    /**
     * 外部链接
     */
    private String linkUrl;

    /**
     * 权重
     */
    private Long sort;

    /**
     * 是否显示.(0-隐藏,1-显示)
     */
    private Integer isShow;

//    @Transient
    private String tags;// 前端传过来的标签

    /**
     * 页面显示时间
     */
    private Date showTime;

    /**
     * 创建人id
     */
    private Long createBy;

    /**
     * 创建人姓名
     */
    private String createByName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人id
     */
    private Long updateBy;

    /**
     * 更新人姓名
     */
    private String updateByName;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除.(0-不删除,1-删除)
     */
    private Integer isDel;
    
    private List<WebsiteTagContent> tagContents;
    

    public List<WebsiteTagContent> getTagContents() {
		return tagContents;
	}

	public void setTagContents(List<WebsiteTagContent> tagContents) {
		this.tagContents = tagContents;
	}

	private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNavId() {
        return navId;
    }

    public void setNavId(Long navId) {
        this.navId = navId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSecondTitle() {
        return secondTitle;
    }

    public void setSecondTitle(String secondTitle) {
        this.secondTitle = secondTitle == null ? null : secondTitle.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public Long getLinkId() {
        return linkId;
    }

    public void setLinkId(Long linkId) {
        this.linkId = linkId;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl == null ? null : linkUrl.trim();
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public String getCreateByName() {
        return createByName;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName == null ? null : createByName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateByName() {
        return updateByName;
    }

    public void setUpdateByName(String updateByName) {
        this.updateByName = updateByName == null ? null : updateByName.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

	@Override
	public String toString() {
		return "WebsiteContent [id=" + id + ", navId=" + navId + ", title=" + title + ", secondTitle=" + secondTitle
				+ ", description=" + description + ", content=" + content + ", imgUrl=" + imgUrl + ", linkId=" + linkId
				+ ", linkUrl=" + linkUrl + ", sort=" + sort + ", isShow=" + isShow + ", tags=" + tags + ", showTime="
				+ showTime + ", createBy=" + createBy + ", createByName=" + createByName + ", createTime=" + createTime
				+ ", updateBy=" + updateBy + ", updateByName=" + updateByName + ", updateTime=" + updateTime
				+ ", isDel=" + isDel + "]";
	}
    
}
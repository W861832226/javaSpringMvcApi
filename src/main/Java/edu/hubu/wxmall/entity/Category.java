package edu.hubu.wxmall.entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class Category {
    private Integer id;  //id
    private String name;  //名称
    private String keywords; //关键字
    private String frontDesc; //
    private Integer parentId; //父节点ID
    private Integer sortOrder; //排序
    private Integer showIndex;
    private Integer isShow; //是否显示（0 or 1）
    private String bannerUrl;
    private String iconUrl;
    private String imgUrl;
    private String wapBannerUrl;
    private String level; //层级
    private Integer type;
    private String frontName;
    private List<Category> children;//子分类


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getFrontDesc() {
        return frontDesc;
    }

    public void setFrontDesc(String frontDesc) {
        this.frontDesc = frontDesc;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getShowIndex() {
        return showIndex;
    }

    public void setShowIndex(Integer showIndex) {
        this.showIndex = showIndex;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getWapBannerUrl() {
        return wapBannerUrl;
    }

    public void setWapBannerUrl(String wapBannerUrl) {
        this.wapBannerUrl = wapBannerUrl;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getFrontName() {
        return frontName;
    }

    public void setFrontName(String frontName) {
        this.frontName = frontName;
    }

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Category)) {
            return false;
        }

        Category other = (Category) obj;
        if (other.getId() == null && getId() == null) {
            return true;
        }

        if (other.getId() != null && getId() != null) {
            return getId().equals(other.getId());
        }

        return false;
    }
}

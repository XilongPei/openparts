package com.openparts.base.entity;

import com.cnpc.framework.annotation.ForeignShow;
import com.cnpc.framework.annotation.Header;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.openparts.base.entity.OP_BaseEntity;

/*
-- ----------------------------
-- Table structure for `car_brand`
-- ----------------------------
DROP TABLE IF EXISTS `car_brand`;
CREATE TABLE `car_brand` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `level` tinyint(4) DEFAULT NULL COMMENT '品牌级别： 0-品牌   1-车系',
  `name` varchar(50) DEFAULT NULL COMMENT '汽车品牌名称',
  `parent_id` int(11) DEFAULT NULL COMMENT '上级品牌key值',
  `image` varchar(255) DEFAULT NULL COMMENT '汽车品牌logo图片地址',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
*/

@Entity
@Table(name="op_car_brand")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
public class Car_brand extends OP_BaseEntity {

    private static final long serialVersionUID = 5569761987303812150L;

    @Header(name = "品牌级别")
    @Column(name = "level", length = 4)
    private Integer level;

    @Header(name = "汽车品牌名称")
    @Column(name = "name", length = 50)
    private String name;

    @Header(name = "上级品牌key值")
    @Column(name = "parent_id", length = 11)
    private Integer parent_id;

    @Header(name = "汽车品牌logo图片地址")
    @Column(name = "image", length = 255)
    private String image;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

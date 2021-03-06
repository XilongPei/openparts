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
-- Table structure for `parts`
-- ----------------------------
DROP TABLE IF EXISTS `parts`;
CREATE TABLE `parts` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '配件类别key值',
  `name` varchar(100) DEFAULT NULL COMMENT '材料类别名称',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='配件类别表';
*/
@Entity
@Table(name="op_parts")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
public class Parts extends OP_BaseEntity {

    private static final long serialVersionUID = 5569761987303812150L;

    @Header(name = "类别名称")
    @Column(name = "name", length = 100)
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

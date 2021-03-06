package com.openparts.base.entity;

import com.cnpc.framework.annotation.ForeignShow;
import com.cnpc.framework.annotation.Header;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;

import com.openparts.base.entity.OP_BaseEntity;

/*
-- ----------------------------
-- Table structure for `parts_alias`
-- ----------------------------
DROP TABLE IF EXISTS `parts_alias`;
CREATE TABLE `parts_alias` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `parts_id` int(11) DEFAULT NULL COMMENT '配件类别名称的key值',
  `alias` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
*/
@Entity
@Table(name="op_parts_alias")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
public class Parts_alias extends OP_BaseEntity {

    private static final long serialVersionUID = 5569761987303812150L;

    @Header(name = "名称")
    @Column(name = "alias", length = 255)
    private String alias;

    private Parts parts;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "parts_id")
    public Parts getParts() {
        return parts;
    }

    public void setParts(Parts parts) {
        this.parts = parts;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }
}

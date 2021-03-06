package com.cnpc.framework.base.service;

import java.util.List;

import com.cnpc.framework.base.entity.Dict;
import com.cnpc.framework.base.pojo.TreeNode;

public interface DictService extends BaseService {

    List<TreeNode> getTreeData();

    List<Dict> getDictsByCode(String code);

    String getDictNameCC(String dictCode, String codeField, String code);
    String getDictCodeByID(String id);
    int updateChildrenDictCode(String dictCode, String parent_id);
}

package com.openparts.base.service.impl;

import com.alibaba.fastjson.JSON;
import com.cnpc.framework.base.entity.Dict;
import com.cnpc.framework.base.pojo.TreeNode;
import com.cnpc.framework.constant.RedisConstant;
import com.cnpc.framework.utils.StrUtil;
import com.cnpc.framework.utils.TreeUtil;
import org.springframework.stereotype.Service;
import com.openparts.base.service.UtilsService;
import com.cnpc.framework.base.service.impl.BaseServiceImpl;
import com.cnpc.framework.base.dao.BaseDao;
import com.cnpc.framework.base.dao.RedisDao;
import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.openparts.base.entity.Mobile_hints;
import org.hibernate.*;

@Service("utilsService")
public class UtilsServiceImpl extends BaseServiceImpl implements UtilsService {

    @Resource
    private BaseDao baseDao;

    @Resource
    public RedisDao redisDao;

    @Override
    public void saveVerifyString(String mobile, String strVerify) {
        int i;

        if (redisDao == null) {
            String hql = "update from Mobile_hints where mobile='" + mobile + "' set verify_str='" + strVerify + "'" ;

            i = baseDao.executeHql(hql);
            if (i < 1) {
                Session session = baseDao.getCurrentSession();
                Mobile_hints mobile_hints = new Mobile_hints();

                session.beginTransaction();
                mobile_hints.setMobile(mobile);
                mobile_hints.setVerify_str(strVerify);
                baseDao.save(mobile_hints);
                session.getTransaction().commit();
            }
            return;
        }

        boolean b;
        b = redisDao.add(RedisConstant.UTILS_MOBILE_VERIFY_STR_PRE+mobile, strVerify);
    }

    @Override
    public String getVerifyString(String mobile) {
        return "";
    }

/*
    public List<TreeNode> getTreeData() {

        // 获取数据
        String key = RedisConstant.DICT_PRE+"tree";
        List<TreeNode> tnlist = null;
        String tnStr = redisDao.get(key);
        if(!StrUtil.isEmpty(key)) {
            tnlist = JSON.parseArray(tnStr,TreeNode.class);
        }
        if (tnlist != null) {
            return tnlist;
        } else {
            String hql = "from Dict order by levelCode asc";
            List<Dict> dicts = this.find(hql);
            Map<String, TreeNode> nodelist = new LinkedHashMap<String, TreeNode>();
            for (Dict dict : dicts) {
                TreeNode node = new TreeNode();
                node.setText(dict.getName());
                node.setId(dict.getId());
                node.setParentId(dict.getParentId());
                node.setLevelCode(dict.getLevelCode());
                nodelist.put(node.getId(), node);
            }
            // 构造树形结构
            tnlist = TreeUtil.getNodeList(nodelist);
            redisDao.save(key, tnlist);
            return tnlist;
        }
    }

    public List<Dict> getDictsByCode(String code) {
        String key = RedisConstant.DICT_PRE+ code;
        List dicts = redisDao.get(key, List.class);
        if (dicts == null) {
            String hql = "from Dict where code='" + code + "'";
            Dict dict = this.get(hql);
            dicts = this.find("from Dict where parentId='" + dict.getId() + "' order by levelCode");
            redisDao.add(key, dicts);
            return dicts;
        } else {
            return dicts;
        }

    }
    */
}

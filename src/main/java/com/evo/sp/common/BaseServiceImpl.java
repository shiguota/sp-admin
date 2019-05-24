package com.evo.sp.common;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evo.sp.business.content.entity.CColumn;
import com.evo.sp.business.content.entity.RApp;
import com.evo.sp.business.system.entity.SysArea;
import com.evo.sp.business.system.entity.SysDictionary;
import com.evo.sp.business.system.entity.SysMenu;
import com.evo.sp.business.system.entity.SysOrganization;
import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.common.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author sgt
 * @since 2019-05-13 13:28Ω
 */
@SuppressWarnings("all")
public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {

    @Override
    public List<Tree<T>> queryTree(List<T> list, String treeId) {
        List<Tree<T>> trees = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Tree tree = new Tree();
            if (list.get(i) instanceof SysDictionary) {   //字典
                SysDictionary sysDictionary = (SysDictionary) list.get(i);
                tree.setText(sysDictionary.getDicName());
                tree.setId(sysDictionary.getId());
                tree.setParentId(sysDictionary.getPid());
                if (SpAssert.isNotNull(treeId)) {
                    tree.setTreeId(treeId + "-" + (i + 1));
                } else {
                    tree.setTreeId(0 + "-" + 0 + "-" + (i + 1));
                }
                tree.setCode(sysDictionary.getDicCode());
                tree.setLevel(sysDictionary.getLevel());
                trees.add(tree);
            } else if (list.get(i) instanceof SysMenu) {  //菜单
                SysMenu sysMenu = (SysMenu) list.get(i);
                tree.setText(sysMenu.getMenuName());
                tree.setPath(sysMenu.getMenuPath());
                tree.setIcon(sysMenu.getMenuIcon());
                tree.setId(sysMenu.getId());
                tree.setParentId(sysMenu.getPid());
                tree.setState(sysMenu.getState());
                tree.setLevel(sysMenu.getLevel());
                tree.setIsOpen(sysMenu.getIsOpen());
                tree.setCode(sysMenu.getMenuCode());
                trees.add(tree);
            } else if (list.get(i) instanceof SysOrganization) { //组织机构
                SysOrganization organization = (SysOrganization) list.get(i);
                tree.setText(organization.getOrgName());
                tree.setId(organization.getId());
                tree.setParentId(organization.getPid());
                if (SpAssert.isNotNull(treeId)) {
                    tree.setTreeId(treeId + "-" + (i + 1));
                } else {
                    tree.setTreeId(0 + "-" + 0 + "-" + (i + 1));
                }
                tree.setLevel(organization.getLevel());
                trees.add(tree);
            } else if (list.get(i) instanceof SysArea) {      //区域
                SysArea sysArea = (SysArea) list.get(i);
                tree.setText(sysArea.getAreaName());
                tree.setId(sysArea.getId());
                tree.setParentId(sysArea.getPid());
                if (SpAssert.isNotNull(treeId)) {
                    tree.setTreeId(treeId + "-" + (i + 1));
                } else {
                    tree.setTreeId(0 + "-" + 0 + "-" + (i + 1));
                }
                tree.setLevel(sysArea.getLevel());
                trees.add(tree);
            }else if (list.get(i) instanceof RApp) {      //应用
                RApp rApp = (RApp) list.get(i);
                tree.setText(rApp.getName());
                tree.setId(rApp.getId());
                if (SpAssert.isNotNull(treeId)) {
                    tree.setTreeId(treeId + "-" + (i + 1));
                } else {
                    tree.setTreeId(0 + "-" + 0 + "-" + (i + 1));
                }
                trees.add(tree);
            }else if (list.get(i) instanceof CColumn) {      //栏目
                CColumn cColumn = (CColumn) list.get(i);
                tree.setText(cColumn.getName());
                tree.setId(cColumn.getId());
                tree.setParentId(cColumn.getPid());
                tree.setType(cColumn.getType());
                if (SpAssert.isNotNull(treeId)) {
                    tree.setTreeId(treeId + "-" + (i + 1));
                } else {
                    tree.setTreeId(0 + "-" + 0 + "-" + (i + 1));
                }
                trees.add(tree);
            }
        }
        return trees;
    }
}

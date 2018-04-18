package org.sft.sample.web.user.service;

import javax.annotation.Resource;

import org.sft.sample.common.error.ApplicationErrorCode;
import org.sft.sample.common.error.AssertUtil;
import org.sft.sample.web.user.mapper.RoleMapper;
import org.sft.sample.web.user.model.Permission;
import org.sft.sample.web.user.model.Role;
import org.sft.sample.web.user.model.RolePermission;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public int addRole(Role role){
        Role role0 = roleMapper.getRoleByRoleName(role.getRoleName());
        AssertUtil.isNull(role0, ApplicationErrorCode.EXIST_DUPLICATION, "角色名=" + role.getRoleName());
        return roleMapper.addRole(role);
    }

    @Override
    public int updateRole(Role role){
        return roleMapper.updateRole(role);
    }

    @Override
    public Role findRoleById(String id){
        return roleMapper.findRoleById(id);
    }

    @Override
    public int deleteRole(String id){

        return roleMapper.deleteRole(id);
    }

    @Override
    @Transactional
    public int updateRolePermissions(Role role){
        int a = 0;
        for (Permission permission : role.getPermissions()) {
            RolePermission rolePermission = new RolePermission(role.getId(), permission.getId());
            a += roleMapper.addRolePermission(rolePermission);
        }
        return a;
    }

    @Override
    @Transactional
    public PageInfo<Role> findRoles(String roleName, Page<Role> page){
        /*
         * return PageHelper.startPage(page.getPageNum(), page.getPageSize()).doSelectPageInfo(new ISelect() {
         * @Override public void doSelect() { roleMapper.findRoles(roleName); } });
         */
        return PageHelper.startPage(page.getPageNum(), page.getPageSize()).doSelectPageInfo(() -> roleMapper.findRoles(roleName));
    }

}

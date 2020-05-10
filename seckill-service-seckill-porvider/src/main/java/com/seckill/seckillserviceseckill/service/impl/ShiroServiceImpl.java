package com.seckill.seckillserviceseckill.service.impl;

import com.seckill.seckillserviceseckill.dao.SysUserEntityMapper;
import com.seckill.seckillserviceseckill.service.ShiroService;
import com.seckill.seckillservicesystem.entity.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @ProjectName seckill
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 5/6/20 8:27 AM
 * @Version 1.0
 * @Title: ShiroServiceImpl
 * @Description:
 **/

@Service
public class ShiroServiceImpl implements ShiroService {

    @Autowired
    private SysUserEntityMapper sysUserEntityMapper;

    @Override
    public Set<String> getUserPermissions(long userId) {
//        List<String> permsList;
//
//        //系统管理员，拥有最高权限
//        if(userId == Constant.SUPER_ADMIN){
//            List<SysMenuEntity> menuList = sysMenuDao.selectList(null);
//            permsList = new ArrayList<>(menuList.size());
//            for(SysMenuEntity menu : menuList){
//                permsList.add(menu.getPerms());
//            }
//        }else{
//            permsList = sysUserDao.queryAllPerms(userId);
//        }
//        //用户权限列表
//        Set<String> permsSet = new HashSet<>();
//        for(String perms : permsList){
////            System.out.println("shiro" + perms);
//            if(StringUtils.isBlank(perms)){
//                continue;
//            }
//            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
//        }
//        return permsSet;
        return null;
    }

    @Override
    public SysUserEntity queryUser(Long userId) {
        return sysUserEntityMapper.selectByPrimaryKey(userId);
    }
}
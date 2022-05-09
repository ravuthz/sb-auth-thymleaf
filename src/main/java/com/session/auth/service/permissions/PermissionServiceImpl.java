package com.session.auth.service.permissions;

import com.session.auth.model.Permission;
import com.session.auth.model.Role;
import com.session.auth.repository.PermissionRepository;
import com.session.auth.repository.RoleRepository;
import com.session.auth.service.roles.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public List<Permission> list() {
        return (List<Permission>) permissionRepository.findAll();
    }

    @Override
    public Permission add() {
        return null;
    }

    @Override
    public Permission delete() {
        return null;
    }

}
package com.sinam.mybank.service.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("permissionService")
public class PermissionService {
    public boolean hasPermission(List<String> permissionKeys){
        var roles = AuthService.getUser().getAuthorities();
        System.out.println(roles);
        var rolesInText = roles.stream().map(GrantedAuthority::getAuthority).toList();

        return rolesInText.stream().anyMatch(permissionKeys::contains);
    }
}

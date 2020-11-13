package com.co.alaorden.service;

import com.co.alaorden.model.RoleEntity;
import com.co.alaorden.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public RoleEntity create (RoleEntity role){
        return roleRepository.save(role);
    }

    public RoleEntity read (Integer id){
        return roleRepository.findById(id).get();
    }

    public RoleEntity update (RoleEntity role, Integer id){
        RoleEntity tmpRole = roleRepository.findById(id).get();
        tmpRole.setDescription(role.getDescription());
        tmpRole.setName(role.getName());
        return roleRepository.save(tmpRole);
    }

    public String delete (Integer id){
        roleRepository.deleteById(id);
        return roleRepository.findById(id).get() == null ?
                "Eliminada el rol "+ id.toString() :
                "No se elimino el rol " + id.toString() ;
    }

}

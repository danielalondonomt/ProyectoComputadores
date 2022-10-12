package com.example.proyectopc.Servicios;


import com.example.proyectopc.modelo.Admin;
import com.example.proyectopc.repositorio.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServices {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll(){
        return adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin p){
        if(p.getIdAdmin()==null){
            return adminRepository.save(p);
        } else {
            Optional<Admin> e = adminRepository.getAdmin(p.getIdAdmin());
            if(e.isPresent()){
                return p;
            }else{
                return adminRepository.save(p);
            }
        }
    }

    public Admin update(Admin p){
        if(p.getIdAdmin()!=null){
            Optional<Admin> q = adminRepository.getAdmin(p.getIdAdmin());
            if(q.isPresent()){

                if(p.getEmail()!=null){
                    q.get().setEmail(p.getEmail());
                }
                if(p.getPassword()!=null){
                    q.get().setPassword(p.getPassword());
                }
                if(p.getName()!=null){
                    q.get().setName(p.getName());
                }
                adminRepository.save(q.get());
                return q.get();
            }else {
                return p;
            }
        }else{
            return p;
        }
    }
    public boolean delete(int id){

        boolean flag=false;
        Optional<Admin>p= adminRepository.getAdmin(id);
        if(p.isPresent()){
            adminRepository.delete(p.get());
            flag=true;
        }

        return flag;

    }


}

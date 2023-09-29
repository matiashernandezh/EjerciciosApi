package com.example.apiSGT.Implements;

import com.example.apiSGT.Entity.Usuario;
import com.example.apiSGT.Repository.UsuarioRepository;
import com.example.apiSGT.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    UsuarioRepository repository;

    @Override
    public List<Usuario> lista() {
        return repository.findAll();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        Boolean existe= repository.existsById(id);
        if(existe){
            Usuario seleccionado= repository.findById(id).get();
            return seleccionado;
        }else{
            System.out.println("El ID indicado no existe");
            return null;
        }
    }
    @Override
    public Usuario buscarPorCorreo(String correo) {
       return repository.findByCorreo(correo);

    }

    @Override
    public Usuario guardar(Usuario nuevo) {
        return repository.save((nuevo));
    }

    @Override
    public void borrarPorId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Usuario editarPorId(Long id, Usuario actualizado) {
        Boolean existe = repository.existsById(id);
        if (existe){
            Usuario seleccionado = repository.findById(id).get();
            seleccionado.setUsuarioNombre(actualizado.getUsuarioNombre());
            seleccionado.setCorreo(actualizado.getCorreo());
            System.out.println("El usuario ha sido actualizado");
            return repository.save(seleccionado);
        }else{
            System.out.println("El ID indicado no existe");
            return null;
        }
    }

}

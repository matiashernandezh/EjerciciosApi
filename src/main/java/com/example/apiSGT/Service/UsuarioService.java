package com.example.apiSGT.Service;

import com.example.apiSGT.Entity.Usuario;

import java.util.List;

public interface UsuarioService{
    List<Usuario> lista();
    Usuario buscarPorId(Long id);
    Usuario buscarPorCorreo(String email);
    Usuario guardar(Usuario nuevo);
    void borrarPorId(Long id);
    Usuario editarPorId(Long id,Usuario actualizado);
}

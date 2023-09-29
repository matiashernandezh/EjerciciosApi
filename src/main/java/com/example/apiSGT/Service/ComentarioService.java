package com.example.apiSGT.Service;

import com.example.apiSGT.Entity.Comentario;

import java.util.List;

public interface ComentarioService {
    List<Comentario> lista();
    Comentario buscarPorId(Long id);
    Comentario guardar(Comentario nuevo);
    void borrarPorId(Long id);
    Comentario editarPorId(Long id, Comentario actualizado);
}

package com.example.apiSGT.Service;

import com.example.apiSGT.Entity.Tarea;

import java.util.List;

public interface TareaService {
    List<Tarea> lista();
    Tarea buscarPorId(Long id);
    Tarea guardar(Tarea nuevo);
    void borrarPorId(Long id);
    Tarea editarPorId(Long id,Tarea actualizado);
}


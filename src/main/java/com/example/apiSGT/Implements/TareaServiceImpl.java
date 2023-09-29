package com.example.apiSGT.Implements;

import com.example.apiSGT.Entity.Tarea;
import com.example.apiSGT.Entity.Usuario;
import com.example.apiSGT.Repository.TareaRepository;
import com.example.apiSGT.Repository.UsuarioRepository;
import com.example.apiSGT.Service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServiceImpl implements TareaService {
    @Autowired
    TareaRepository repository;

    @Override
    public List<Tarea> lista() {
        return repository.findAll();
    }

    @Override
    public Tarea buscarPorId(Long id) {
        Boolean existe= repository.existsById(id);
        if(existe){
            Tarea seleccionado= repository.findById(id).get();
            return seleccionado;
        }else{
            System.out.println("El ID indicado no existe");
            return null;
        }
    }

    @Override
    public Tarea guardar(Tarea nuevo) {
        return repository.save((nuevo));
    }

    @Override
    public void borrarPorId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Tarea editarPorId(Long id, Tarea actualizado) {
        Boolean existe = repository.existsById(id);
        if (existe){
            Tarea seleccionado = repository.findById(id).get();
            seleccionado.setDescripcion(actualizado.getDescripcion());
            seleccionado.setTitulo(actualizado.getTitulo());
            seleccionado.setFechaVencimiento(actualizado.getFechaVencimiento());

            System.out.println("La tarea ha sido actualizada");
            return repository.save(seleccionado);
        }else{
            System.out.println("El ID indicado no existe");
            return null;
        }
    }
}

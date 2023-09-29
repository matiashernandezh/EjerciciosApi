package com.example.apiSGT.Implements;

import com.example.apiSGT.Entity.Comentario;
import com.example.apiSGT.Repository.ComentarioRepository;
import com.example.apiSGT.Service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioServiceImpl implements ComentarioService {
    @Autowired
    ComentarioRepository repository;

    @Override
    public List<Comentario> lista() {
        return repository.findAll();
    }

    @Override
    public Comentario buscarPorId(Long id) {
        Boolean existe= repository.existsById(id);
        if(existe){
            Comentario seleccionado= repository.findById(id).get();
            return seleccionado;
        }else{
            System.out.println("El ID indicado no existe");
            return null;
        }
    }

    @Override
    public Comentario guardar(Comentario nuevo) {
        return repository.save((nuevo));
    }

    @Override
    public void borrarPorId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Comentario editarPorId(Long id, Comentario actualizado) {
        Boolean existe = repository.existsById(id);
        if (existe){
            Comentario seleccionado = repository.findById(id).get();
            seleccionado.setTexto(actualizado.getTexto());
            seleccionado.setFechaCreacion(actualizado.getFechaCreacion());
            System.out.println("El comentario ha sido actualizado");
            return repository.save(seleccionado);
        }else{
            System.out.println("El ID indicado no existe");
            return null;
        }
    }

}

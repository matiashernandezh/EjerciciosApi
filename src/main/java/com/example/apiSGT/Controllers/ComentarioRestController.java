package com.example.apiSGT.Controllers;

import com.example.apiSGT.Entity.Comentario;
import com.example.apiSGT.Implements.ComentarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ComentarioRestController {
    @Autowired
    ComentarioServiceImpl service;

    @GetMapping("/comentario")
    public List<Comentario> lista(){
        List<Comentario> mostrar = service.lista();
        return mostrar;
    }
    @GetMapping("/comentario/{id}")
    public Comentario buscarPorId (@PathVariable Long id){
        Comentario mostrar = service.buscarPorId(id);
        return mostrar;
    }
    @PostMapping("/comentario")
    public Comentario guardar (@RequestBody Comentario nuevo){
        Comentario creado= service.guardar(nuevo);
        return creado;
    }
    @DeleteMapping("/comentario/{id}")
    public String borrarPorId (@PathVariable Long id){
        service.borrarPorId(id);
        return "El comentario ha sido borrrado";
    }
    @PutMapping("/comentario/{id}")
    public Comentario editarPorId (@PathVariable Long id, @RequestBody Comentario actualizado) {
        Comentario editado = service.editarPorId(id, actualizado);
        return editado;
    }

}

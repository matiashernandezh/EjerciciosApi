package com.example.apiSGT.Controllers;

import com.example.apiSGT.Entity.Tarea;
import com.example.apiSGT.Entity.Usuario;
import com.example.apiSGT.Implements.TareaServiceImpl;
import com.example.apiSGT.Implements.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TareaRestController {
    @Autowired
    TareaServiceImpl service;
    @Autowired
    UsuarioServiceImpl serviceUsuario;
    @GetMapping("/tarea")
    public List<Tarea> lista(){
        List<Tarea> mostrar = service.lista();
        return mostrar;
    }
    @GetMapping("/tarea/{id}")
    public Tarea buscarPorId (@PathVariable Long id){
        Tarea mostrar = service.buscarPorId(id);
        return mostrar;
    }
    @PostMapping("/tarea")
    public ResponseEntity<?> guardar (@RequestBody Tarea nuevo){

        Tarea creado= service.guardar(nuevo);
        return ResponseEntity.ok(creado);
    }
    @DeleteMapping("/tarea/{id}")
    public String borrarPorId (@PathVariable Long id){
        service.borrarPorId(id);
        return "La tarea ha sido borrrada";
    }
    @PutMapping("/tarea/{id}")
    public Tarea editarPorId (@PathVariable Long id, @RequestBody Tarea actualizado) {
        Tarea editado = service.editarPorId(id, actualizado);
        return editado;
    }

}

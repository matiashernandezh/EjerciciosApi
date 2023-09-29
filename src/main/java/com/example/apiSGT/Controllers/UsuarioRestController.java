package com.example.apiSGT.Controllers;

import com.example.apiSGT.Entity.Usuario;
import com.example.apiSGT.Implements.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioRestController {
    @Autowired
    UsuarioServiceImpl service;

    @GetMapping("/usuario")
    public List<Usuario> lista(){
        List<Usuario> mostrar = service.lista();
        return mostrar;
    }
    @GetMapping("/usuario/{id}")
    public Usuario buscarPorId (@PathVariable Long id){
        Usuario mostrar = service.buscarPorId(id);
        return mostrar;
    }
    @PostMapping("/usuario")
    public ResponseEntity<?> guardar (@RequestBody Usuario nuevo){

        Usuario existe = service.buscarPorCorreo(nuevo.getCorreo());
        if(existe != null){
            return ResponseEntity.badRequest().body("Ya existe un usuario con el correo " + nuevo.getCorreo());
        }
        Usuario creado= service.guardar(nuevo);

        return ResponseEntity.ok(creado);
    }
    @DeleteMapping("/usuario/{id}")
    public String borrarPorId (@PathVariable Long id){
        service.borrarPorId(id);
        return "El usuario ha sido borrrado";
    }
    @PutMapping("/usuario/{id}")
    public Usuario editarPorId (@PathVariable Long id, @RequestBody Usuario actualizado) {
        Usuario editado = service.editarPorId(id, actualizado);
        return editado;
    }
}

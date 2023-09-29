package com.example.apiSGT.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity//mapeo en base de datos
@Table(name="usuario")
@Getter //generar getter de forma automatica
@Setter //generar setter de forma automatica
@NoArgsConstructor //generar constructor vacío de forma automatica
@AllArgsConstructor //generar constructor completo de forma automatica

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//para que el id sea autoincremental
    private long usuarioId;

    @NotNull
    private String usuarioNombre;

    @NotNull
    private String correo;

    @JsonIgnore//Anotación para ignorar la información del curso en el JSON
    @OneToMany (mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Tarea> Tareas;



}

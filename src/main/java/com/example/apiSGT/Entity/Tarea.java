package com.example.apiSGT.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="tarea")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//para que el id sea autoincremental
    private long tareaId;

    @NotNull
    private String titulo;

    @NotNull
    private String descripcion;

    @NotNull
    @JsonFormat (pattern = "yyyy-MM-dd")
    private Date fechaVencimiento;


    @JoinColumn (name="usuarioid", nullable = false)
    @ManyToOne
    private Usuario usuario;


    @JsonIgnore//Anotación para ignorar la información del curso en el JSON
    @OneToMany (mappedBy = "tarea", cascade = CascadeType.ALL)
    private List<Comentario> tareaComentarios;


}

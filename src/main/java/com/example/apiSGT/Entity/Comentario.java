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

@Entity
@Table(name="comentario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long comentarioId;

    @NotNull
    private String texto;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaCreacion;

    @JoinColumn (name="tareaid", nullable = false)
    @ManyToOne
    private Tarea tarea;

}

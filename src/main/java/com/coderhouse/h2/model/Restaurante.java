package com.coderhouse.h2.model;

import lombok.*;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Table(name = "restaurante")
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy="id")
    private List<Category> categorias;
    private String descripcion;
    private String horaApertura;
    private String horaCierre;
    private String latitud;
    private String longitud;
    private String nombre;
    private String telefono;
    private Date fechaCreacion = Calendar.getInstance().getTime();
    @ManyToOne(cascade = CascadeType.ALL)
    private City ciudad;
    private String phone;

    @Override
    public String toString() {return String.format(
            "Restaurante[id=%d, nombre='%s']", id, nombre);
    }

}

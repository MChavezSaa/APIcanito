package model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data//lombock genera getters setters y toString automaticamente
@Entity
@Table(name="producto")
public class producto {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int idProducto;

     @NotNull
     @Column(name="nombre")
     private String nombre;

     @NotNull
     @Column(name= "detalle")
     private String detalle;

     @NotNull
     @Column(name="precio")
     private int precio;

}

package model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data//lombock genera getters setters y toString automaticamente
@Entity
@Table(name="cliente")
public class cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;

    @NotNull
    @Column(name="nombre")
    private String Nombre;

    @NotNull
    @Column(name="apellido")
    private String apellido;

    @NotNull
    @Column(name="usuario")
    private String usuario;

    @NotNull
    @Column(name="contraseña")
    private String contrasena;


}

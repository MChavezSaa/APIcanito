package DAO;

import model.producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productoDAO extends  JpaRepository <producto, Integer>{

}

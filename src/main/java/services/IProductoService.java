package services;

import model.producto;

import java.util.List;

public interface IProductoService {


    List<producto> findAll();

    producto save(producto producto);

    producto findOne(Integer id);

    void delete(Integer id);

    boolean exists(int id);

}

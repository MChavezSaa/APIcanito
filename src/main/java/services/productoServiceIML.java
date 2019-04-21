package services;

import DAO.productoDAO;
import model.producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class productoServiceIML implements IProductoService {

    @Autowired
    private productoDAO productoDAO;

    @Override
    @Transactional(readOnly = true)
    public List<producto> findAll() {
        return productoDAO.findAll();
    }

    @Override
    @Transactional
    public producto save(producto producto) {
        return productoDAO.save(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public producto findOne(Integer id) {
        return productoDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        productoDAO.deleteById(id);
    }

    @Override
    public boolean exists(int id) {
        return productoDAO.existsById(id);
    }

}

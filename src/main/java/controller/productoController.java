package controller;


import model.producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import services.productoServiceIML;

import java.util.List;

@RestController
@Controller
@RequestMapping(value = "/producto")
public class productoController {

    @Autowired
    private productoServiceIML productoService;

    //listar todos
    @GetMapping(value = "/listarproducto", produces = {"application/json"})
    public ResponseEntity<List<producto>> listar(){
        List<producto>lista = productoService.findAll();
        if (lista.isEmpty()) {
            return new ResponseEntity<List<producto>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<producto>>(lista, HttpStatus.OK);
    }

    //crear
    @PostMapping(value = "/producto/crear")
    public  ResponseEntity<producto> create(@RequestBody producto prod, BindingResult bindingResult) {

        if (bolsasangre.getFechaSalida() != null) {
            return new ResponseEntity<BolsaSangre>(HttpStatus.NOT_ACCEPTABLE);
        }
        Date nuevaFecha=bolsasangre.getFechaIngreso();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nuevaFecha);
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        bolsasangre.setFechaExpiracion(calendar.getTime());
        bolsaService.save(bolsasangre);
        return new ResponseEntity<BolsaSangre>(bolsasangre, HttpStatus.CREATED);
    }

}

/*
*

public class BolsaSangreController{

    @Autowired
    private BolsaSangreServiceIML bolsaService;
    @Autowired
    private SeccionServiceIML secc;



    //listar por ID
    @GetMapping(value="/bolsasangre/listarbolsa/{id}")
    //@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BolsaSangre> mostrar(@PathVariable int id) {
    	BolsaSangre bolsa = null;
		bolsa = bolsaService.findOne(id);
		if (bolsa == null) {
			return new ResponseEntity<BolsaSangre>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<BolsaSangre>(bolsa, HttpStatus.OK);
    }




    //update
    @PutMapping(value ="/bolsasangre/update/{id}")
   // @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BolsaSangre> update(@RequestBody BolsaSangre bolsasangre, @PathVariable int id) {
    	BolsaSangre bolsaActual = bolsaService.findOne(id);

		if (bolsaActual == null) {
			return new ResponseEntity<BolsaSangre>(HttpStatus.NOT_FOUND);
		}

    	bolsaActual.setFechaExpiracion(bolsasangre.getFechaExpiracion());
    	bolsaActual.setFechaIngreso(bolsasangre.getFechaIngreso());
    	bolsaActual.setFechaSalida(bolsasangre.getFechaSalida());
    	bolsaActual.setTipo(bolsasangre.getTipo());
    	//persiste el cliente actual(merge)
    	bolsaService.save(bolsaActual);
    	return new ResponseEntity<BolsaSangre>(bolsaActual, HttpStatus.ACCEPTED);

    }

    @DeleteMapping(value = "bolsasangre/delete/{id}")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable int id) {
    	BolsaSangre bolsaActual = bolsaService.findOne(id);
    	if (bolsaActual == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
    	bolsaService.delete(id);
    	return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/bolsasangre/numeroBolsas", method = RequestMethod.GET)
    public String obtenerNumeroDeBolsas(Model model) {
    	int numeroBolsas = secc.obtenerNumeroDeBolsas();
    	model.addAttribute("numeroBolsas", numeroBolsas);
    	return "reporte";
    }
}

* */
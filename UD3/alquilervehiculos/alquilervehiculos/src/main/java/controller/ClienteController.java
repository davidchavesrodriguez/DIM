package com.miempresa.alquilervehiculos.controller;

import com.miempresa.alquilervehiculos.model.Cliente;
import com.miempresa.alquilervehiculos.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Endpoint para obtener todos los clientes
    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.obtenerTodos();
    }

    // Endpoint para obtener un cliente por ID
    @GetMapping("/{id}")
    public Optional<Cliente> obtenerClientePorId(@PathVariable Integer id) {
        return clienteService.obtenerPorId(id);
    }

    // Endpoint para crear un nuevo cliente
    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return clienteService.guardarCliente(cliente);
    }

    // Endpoint para actualizar un cliente existente
    @PutMapping("/{id}")
    public Cliente actualizarCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
        cliente.setIdCliente(id);
        return clienteService.guardarCliente(cliente);
    }

    // Endpoint para eliminar un cliente
    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Integer id) {
        clienteService.eliminarCliente(id);
    }
}

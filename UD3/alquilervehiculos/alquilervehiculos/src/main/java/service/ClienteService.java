package com.miempresa.alquilervehiculos.service;

import com.miempresa.alquilervehiculos.model.Cliente;
import com.miempresa.alquilervehiculos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Método para obtener todos los clientes
    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }

    // Método para obtener un cliente por ID
    public Optional<Cliente> obtenerPorId(Integer id) {
        return clienteRepository.findById(id);
    }

    // Método para crear o actualizar un cliente
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Método para eliminar un cliente
    public void eliminarCliente(Integer id) {
        clienteRepository.deleteById(id);
    }
}

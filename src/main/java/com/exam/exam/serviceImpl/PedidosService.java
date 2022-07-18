/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exam.exam.serviceImpl;

import com.exam.exam.entity.Pedidos;
import com.exam.exam.repository.PedidosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Noodlexz.CD
 */
@Service
public class PedidosService implements Operaciones<Pedidos> {

    
    @Autowired
    private PedidosRepository pedidosRepository;
    @Override
    public Pedidos create(Pedidos t) {
        return pedidosRepository.save(t);
    }

    @Override
    public Pedidos update(Pedidos t) {
        return pedidosRepository.save(t);
    }

    @Override
    public void delete(int id) {
        pedidosRepository.deleteById(id);
    }

    @Override
    public Pedidos read(int id) {
        return pedidosRepository.findById(id).get();
    }

    @Override
    public List<Pedidos> readAll() {
       return pedidosRepository.findAll();
    }

}

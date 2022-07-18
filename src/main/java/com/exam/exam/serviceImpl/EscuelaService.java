/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exam.exam.serviceImpl;

import com.exam.exam.entity.Escuela;
import com.exam.exam.repository.EscuelaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Noodlexz.CD
 */
@Service
public class EscuelaService implements Operaciones<Escuela> {

    @Autowired
    private EscuelaRepository escuelaRepository;

    @Override
    public Escuela create(Escuela t) {

        return escuelaRepository.save(t);
    }

    @Override
    public Escuela update(Escuela t) {
        return escuelaRepository.save(t);
    }

    @Override
    public void delete(int id) {
        escuelaRepository.deleteById(id);
    }

    @Override
    public Escuela read(int id) {
        return escuelaRepository.findById(id).get();
    }

    @Override
    public List<Escuela> readAll() {

        return escuelaRepository.findAll();
    }

}

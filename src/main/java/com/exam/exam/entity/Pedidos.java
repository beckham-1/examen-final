/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exam.exam.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author Noodlexz.CD
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pedidos")
@Entity
public class Pedidos implements Serializable{
    
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idpedidos")
    @Id
    private int id;
    @Column(unique=true)
    private String cliente;
    private String fecha;
    private String reparto;
    private String producto;
    private int cantidad;
    private int precio;
}

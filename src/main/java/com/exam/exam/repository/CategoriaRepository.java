
package com.exam.exam.repository;

import com.exam.exam.entity.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
    
}

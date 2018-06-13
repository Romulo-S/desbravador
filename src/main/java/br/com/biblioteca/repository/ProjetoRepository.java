/**
 * 
 */
package br.com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.biblioteca.pojo.Projeto;

/**
 * @author romul
 *
 */
@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

}

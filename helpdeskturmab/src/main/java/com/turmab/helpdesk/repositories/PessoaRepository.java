package com.turmab.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.turmab.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
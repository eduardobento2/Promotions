package com.br.zup.Repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.zup.Models.Establishment;

@Repository

public interface EstablishmentRepository extends CrudRepository< Establishment,Integer>{

}

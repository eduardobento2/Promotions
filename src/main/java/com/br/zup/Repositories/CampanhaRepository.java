package com.br.zup.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.zup.Models.Campaign;

@Repository
public interface CampanhaRepository extends CrudRepository<Campaign,Integer>{

}

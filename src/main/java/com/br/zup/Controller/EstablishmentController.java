package com.br.zup.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.zup.Models.Establishment;
import com.br.zup.Service.EstablishmentService;

@RestController
@RequestMapping("/establishment")
public class EstablishmentController {

	@Autowired
	private EstablishmentService establishmentService;

	@GetMapping("/establishment")
	public ResponseEntity<?> getEstablishment(){
		if(establishmentService.quantityOfEstablishment()>0) {
			return ResponseEntity.ok(establishmentService.getEstablishment());
		}
		return ResponseEntity.noContent().build();
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getEstablishment(@PathVariable int id){
		try {
			Establishment establishment = establishmentService.getEstablishmentById(id);
			return ResponseEntity.ok(establishment);
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	

	@PostMapping
	public ResponseEntity<?> addEstablishment(@Valid @RequestBody Establishment establishment){
		try {
			establishmentService.saveEstablishment(establishment);
			return ResponseEntity.status(HttpStatus.CREATED).body(establishment);
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity<?>updateEstablishment(@PathVariable int id,@Valid @RequestBody Establishment establishment){

		establishmentService.updateEstablishment(id, establishment);
		return ResponseEntity.ok(establishment);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEstablishment(@PathVariable int id){
		establishmentService.deleteEstablishment(id);
		return ResponseEntity.ok().build();
	}
}


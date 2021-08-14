package com.elemaxelev.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.elemaxelev.domain.Fornecedor;
import com.elemaxelev.services.FornecedorService;

@RestController
@RequestMapping(value = "/fornecedores")
public class FornecedorResource {

	@Autowired
	private FornecedorService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Fornecedor>> findAll() {

		List<Fornecedor> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}
}

package com.example.springdeploy.dominio.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdeploy.dominio.dto.DtoLetraVenta;
import com.example.springdeploy.dominio.servicio.WorServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/reporte")
@CrossOrigin(origins = "*")
public class WordRest {
	
	private static Logger logger = LogManager.getLogger(WordRest.class);
	
	@Autowired
	private WorServiceImpl worService;
	
	@Transactional
	@PostMapping(value = "/exportarcontrato",  produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody byte[] exportarcontrato(@RequestBody DtoLetraVenta dto) throws Exception {
		return worService.generarRequerimientoPago(dto);
	}
	


}

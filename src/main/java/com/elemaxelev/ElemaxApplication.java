package com.elemaxelev;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.elemaxelev.domain.Cidade;
import com.elemaxelev.domain.Estado;
import com.elemaxelev.domain.Fornecedor;
import com.elemaxelev.domain.Insumo;
import com.elemaxelev.domain.InsumoFornecedor;
import com.elemaxelev.domain.enums.UnidadeMedida;
import com.elemaxelev.repositories.FornecedorRepository;
import com.elemaxelev.repositories.InsumoFornecedorRepository;
import com.elemaxelev.repositories.InsumoRepository;

@SpringBootApplication
public class ElemaxApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ElemaxApplication.class, args);
	}

	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Autowired
	private InsumoRepository insumoRepository;
	
	@Autowired
	private InsumoFornecedorRepository insumoFornecedorRepository;
	
	@Override
	public void run(String... args) throws Exception {


		Estado estado = new Estado(3l, "SP", "São Paulo");
		Cidade cidade = new Cidade(1l, "Praia Grande", estado);

		Fornecedor fornecedor1 = new Fornecedor(null, "Magazine Luiza", "Av. Brasil", 123l, "Indianapolis", "08:00 as 18:00", cidade.getEstado(), cidade);
		Fornecedor fornecedor2 = new Fornecedor(null, "Casas Bahia", "Rua bahia", 321l, "Monaco", "09:00 as 12:00", cidade.getEstado(), cidade);
		fornecedorRepository.saveAll(Arrays.asList(fornecedor1, fornecedor2));
		
		
		Insumo insumo1 = new Insumo(null, "Parafuso 3mm", new BigDecimal(150), UnidadeMedida.PECA, 200.0, new BigDecimal(20.5), LocalDate.now());
		Insumo insumo2 = new Insumo(null, "Solvente", new BigDecimal(75.4), UnidadeMedida.LITRO, 130.3, new BigDecimal(15), LocalDate.now());
		Insumo insumo3 = new Insumo(null, "Fita Isolante 10m", new BigDecimal(5.5), UnidadeMedida.METRO, 300.0, new BigDecimal(45.7), LocalDate.now());
		insumoRepository.saveAll(Arrays.asList(insumo1, insumo2, insumo3));
		
		InsumoFornecedor insumoFornecedor1 = new InsumoFornecedor(insumo1, fornecedor1, new BigDecimal(342), "Metais Ltda.", 1000.0);
		InsumoFornecedor insumoFornecedor2 = new InsumoFornecedor(insumo2, fornecedor1, new BigDecimal(412), "Liquidos Ltda.", 500.0);
		
		// simulacao proposital de instanciacao repetida, a classe auxiliar de chave composta ignora e não persiste no banco
		InsumoFornecedor insumoFornecedor3 = new InsumoFornecedor(insumo2, fornecedor1, new BigDecimal(412), "Liquidos Ltda.", 500.0);
		
		InsumoFornecedor insumoFornecedor4 = new InsumoFornecedor(insumo2, fornecedor2, new BigDecimal(204), "Aço Ltda.", 333.0);
		InsumoFornecedor insumoFornecedor5 = new InsumoFornecedor(insumo3, fornecedor1, new BigDecimal(150), "Fitas Ltda.", 142.0);
		insumoFornecedorRepository.saveAll(Arrays.asList(insumoFornecedor1, insumoFornecedor2, insumoFornecedor3, insumoFornecedor4, insumoFornecedor5));
		
	}

}

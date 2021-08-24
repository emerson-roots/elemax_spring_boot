package com.elemaxelev.services;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Service;

import com.elemaxelev.domain.Cidade;
import com.elemaxelev.domain.Estado;
import com.elemaxelev.domain.Fornecedor;
import com.elemaxelev.domain.Insumo;
import com.elemaxelev.domain.InsumoFornecedores;
import com.elemaxelev.domain.enums.UnidadeMedida;
import com.elemaxelev.repositories.CidadeRepository;
import com.elemaxelev.repositories.EstadoRepository;
import com.elemaxelev.repositories.FornecedorRepository;
import com.elemaxelev.repositories.InsumoFornecedorRepository;
import com.elemaxelev.repositories.InsumoRepository;

@Service
public class DBService {
	
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private FornecedorRepository fornecedorRepository;
	@Autowired
	private InsumoRepository insumoRepository;
	@Autowired
	private InsumoFornecedorRepository insumoFornecedorRepository;
	
    @Autowired
    private DataSource dataSource;

    // carrega no banco 27 estados brasileiros e 5564 cidades
    // de forma manual, foi tentado utilizar o comportamento padrão do Spring que pre-carrega
    // o arquivo nomeado "data.sql" mas de alguma forma, está gerando erro
    // então foi adotado este metodo
    public void loadCidadesEstados() {
            ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator(false, false, "UTF-8", new ClassPathResource("/_data.sql"));
        resourceDatabasePopulator.execute(dataSource);
    }
	
	public void instantiateTestDatabase() throws ParseException {
		
		//loadCidadesEstados();
		
		Estado estado1 = new Estado(null, "SP", "São Paulo");
		Estado estado2 = new Estado(null, "RJ", "Rio de Janeiro");
		estadoRepository.saveAll(Arrays.asList(estado1, estado2));
		
		Cidade cidade1 = new Cidade(null, "Praia Grande", estado1);
		Cidade cidade2 = new Cidade(null, "São Vicente", estado1);
		Cidade cidade3 = new Cidade(null, "Angra", estado2);
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));

		Fornecedor fornecedor1 = new Fornecedor(null, "Magazine Luiza", "Av. Brasil", 123l, "Indianapolis", "08:00 as 18:00", cidade1);
		Fornecedor fornecedor2 = new Fornecedor(null, "Casas Bahia", "Rua Bahia", 321l, "Monaco", "09:00 as 12:00", cidade3);
		Fornecedor fornecedor3 = new Fornecedor(null, "Ponto Frio", "Rua Guaiuba", 555l, "Jurandopolis", "07:00 as 15:00", cidade2);
		
		fornecedorRepository.saveAll(Arrays.asList(fornecedor1, fornecedor2, fornecedor3));
		
		
		Insumo insumo1 = new Insumo(null, "Parafuso 3mm", new BigDecimal(150), UnidadeMedida.PECA, 200.0, new BigDecimal(20.5), LocalDate.now());
		Insumo insumo2 = new Insumo(null, "Solvente", new BigDecimal(75.4), UnidadeMedida.LITRO, 130.3, new BigDecimal(15), LocalDate.now());
		Insumo insumo3 = new Insumo(null, "Fita Isolante 10m", new BigDecimal(5.5), UnidadeMedida.METRO, 300.0, new BigDecimal(45.7), LocalDate.now());
		insumoRepository.saveAll(Arrays.asList(insumo1, insumo2, insumo3));
		
		InsumoFornecedores insumoFornecedor1 = new InsumoFornecedores(insumo1, fornecedor1, new BigDecimal(342), "Metais Ltda.", 1000.0);
		InsumoFornecedores insumoFornecedor2 = new InsumoFornecedores(insumo2, fornecedor1, new BigDecimal(412), "Liquidos Ltda.", 500.0);
		
		// simulacao proposital de instanciacao repetida, a classe auxiliar de chave composta ignora e não persiste no banco
		InsumoFornecedores insumoFornecedor3 = new InsumoFornecedores(insumo2, fornecedor1, new BigDecimal(412), "Liquidos Ltda.", 500.0);
		
		InsumoFornecedores insumoFornecedor4 = new InsumoFornecedores(insumo2, fornecedor2, new BigDecimal(204), "Aço Ltda.", 333.0);
		InsumoFornecedores insumoFornecedor5 = new InsumoFornecedores(insumo3, fornecedor1, new BigDecimal(150), "Fitas Ltda.", 142.0);
		insumoFornecedorRepository.saveAll(Arrays.asList(insumoFornecedor1, insumoFornecedor2, insumoFornecedor3, insumoFornecedor4, insumoFornecedor5));
		
	}

}

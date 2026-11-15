package com.aula8.estadosmunicipios.service;

import com.aula8.estadosmunicipios.model.Estado;
import com.aula8.estadosmunicipios.model.Municipio;
import com.aula8.estadosmunicipios.repository.EstadoRepository;
import com.aula8.estadosmunicipios.repository.MunicipioRepository;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Importa estados.csv e municipios.csv (src/main/resources/csv) para o banco.
 * Ordem importante: primeiro estados, depois municipios (que dependem da FK).
 */
@Service
public class CsvImportService {

    private static final Logger log = LoggerFactory.getLogger(CsvImportService.class);

    private final EstadoRepository estadoRepository;
    private final MunicipioRepository municipioRepository;

    public CsvImportService(EstadoRepository estadoRepository, MunicipioRepository municipioRepository) {
        this.estadoRepository = estadoRepository;
        this.municipioRepository = municipioRepository;
    }

    @Transactional
    public void importar() throws IOException {
        if (estadoRepository.count() > 0 || municipioRepository.count() > 0) {
            log.info("Banco ja possui dados, importacao ignorada.");
            return;
        }
        Map<Long, Estado> estados = importarEstados();
        importarMunicipios(estados);
    }

    /** estados.csv: COD,NOME,SIGLA */
    private Map<Long, Estado> importarEstados() throws IOException {
        Map<Long, Estado> porCodigo = new HashMap<>();
        for (String[] c : lerCsv("csv/estados.csv", 3)) {
            Estado e = new Estado(Long.parseLong(c[0]), c[1], c[2]);
            porCodigo.put(e.getId(), e);
        }
        estadoRepository.saveAll(porCodigo.values());
        log.info("Estados importados: {}", porCodigo.size());
        return porCodigo;
    }

    /** municipios.csv: COD UF,COD,NOME  (COD UF e a chave do estado) */
    private void importarMunicipios(Map<Long, Estado> estados) throws IOException {
        List<Municipio> lista = new ArrayList<>();
        for (String[] c : lerCsv("csv/municipios.csv", 3)) {
            Long codUf = Long.parseLong(c[0]);
            Estado estado = estados.get(codUf);
            if (estado == null) {
                log.warn("Municipio {} ignorado: estado {} nao existe", c[2], codUf);
                continue;
            }
            lista.add(new Municipio(Long.parseLong(c[1]), c[2], estado));
        }
        municipioRepository.saveAll(lista);
        log.info("Municipios importados: {}", lista.size());
    }

    /** Le o CSV do classpath, ignora o cabecalho e linhas vazias e aplica trim em cada coluna. */
    private List<String[]> lerCsv(String caminho, int colunas) throws IOException {
        List<String[]> linhas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new ClassPathResource(caminho).getInputStream(), StandardCharsets.UTF_8))) {
            br.readLine(); // cabecalho
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = linha.replace("\uFEFF", "").trim();
                if (linha.isEmpty()) {
                    continue;
                }
                String[] partes = linha.split(",", colunas);
                for (int i = 0; i < partes.length; i++) {
                    partes[i] = partes[i].trim();
                }
                linhas.add(partes);
            }
        }
        return linhas;
    }
}

package com.aula8.estadosmunicipios.service;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/** Dispara a importacao dos CSVs assim que a aplicacao sobe. */
@Component
public class CsvImportRunner implements ApplicationRunner {

    private final CsvImportService importService;

    public CsvImportRunner(CsvImportService importService) {
        this.importService = importService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        importService.importar();
    }
}

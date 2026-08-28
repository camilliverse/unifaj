package br.edu.poo.exemplo.instrumentos_service.dbimage;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class ArquivoController {

    @Autowired ArquivoDao dao;

    @GetMapping("/dbimagens/{filename:.+}")
    @ResponseBody
    public ResponseEntity<byte[]> serveFile(@PathVariable String filename) throws Exception {
        Arquivo arquivo = dao.obterArquivoByName(filename);

        HttpHeaders headers = new HttpHeaders();
        headers.setCacheControl(CacheControl.noCache().getHeaderValue());
        headers.setContentDispositionFormData("resource", filename);
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(arquivo.getData(), headers, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/dbimagens/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) throws Exception {
        Arquivo a = new Arquivo();
        a.setArquivo(file.getOriginalFilename());
        a.setData(file.getBytes());
        dao.gravarImagem(a);

        return "OK";
    }

}

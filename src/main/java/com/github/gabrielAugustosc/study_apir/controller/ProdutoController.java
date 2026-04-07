package com.github.gabrielAugustosc.study_apir.controller;

import java.util.List;

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

import com.github.gabrielAugustosc.study_apir.model.Produto;
import com.github.gabrielAugustosc.study_apir.repository.RepositoryProdutoMockup;





@RestController
@RequestMapping("${api.version}/produtos")
public class ProdutoController {


    @Autowired
    private RepositoryProdutoMockup mockup;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Produto produto) {
        mockup.create(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto criado");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable long id){
       return mockup
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    } 

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(mockup.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Produto produto) {
        if (mockup.update(id, produto)) {
            return ResponseEntity.ok("Produto atualizado");
        }else{
        return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Produto excluído");

    }

}
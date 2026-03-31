package com.github.gabrielAugustosc.study_apir.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.github.gabrielAugustosc.study_apir.model.Produto;

public class RepositoryProdutoMockup {
    private List<Produto> produtos = new ArrayList<>();

    public RepositoryProdutoMockup() {

        produtos.add(new Produto(1L, "Maçã", BigDecimal.valueOf(10.50)));
        produtos.add(new Produto(3L, "Uva", BigDecimal.valueOf(15.23)));
    }

    public List<Produto> findAll() {
        return produtos;
    }

    public Optional<Produto> findById(Long id){
        return produtos.stream()
        .filter(p -> p.getId().equals(id))
        .findFirst();
    }

}
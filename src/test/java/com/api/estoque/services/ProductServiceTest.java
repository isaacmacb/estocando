package com.api.estoque.services;

import com.api.estoque.entity.Product;
import com.api.estoque.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // isso ativa o Mockito no test, permitindo usar inject e mock
class ProductServiceTest {

    @InjectMocks // Cria a classe real e injeta os mocks nela
    private ProductService productService;

    @Mock // Cria uma versão falsa da classe abaixo
    private ProductRepository productRepository;

    @Test // Marca o metodo abaixo como teste
    void deveCriarProduto() {
        Product product = new Product();
        product.setName("Teste");

        when(productRepository.save(any())).thenReturn(product); // when define o comportamento do mock
        // any permite aceitar qualquer valor
        // theReturn define o que será retornado

        Product result = productService.create(product);

        assertNotNull(result); // verifica se há nulos, não pode estar vazio
        assertEquals("Teste", result.getName()); // verificar se os valores são iguais

        verify(productRepository).save(product); // verify verifica se o metodo foi chamado corretamente
    }
}
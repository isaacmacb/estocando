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

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Test
    void deveCriarProduto() {
        Product product = new Product();
        product.setName("Teste");

        when(productRepository.save(any())).thenReturn(product);
        Product result = productService.create(product);

        assertNotNull(result);
        assertEquals("Teste", result.getName());

        verify(productRepository).save(product);
    }
}
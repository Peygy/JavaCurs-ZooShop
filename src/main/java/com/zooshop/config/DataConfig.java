package com.zooshop.config;

import com.zooshop.entity.Product;
import com.zooshop.entity.Workshop;
import com.zooshop.repository.ProductRepository;
import com.zooshop.repository.WorkshopRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class DataConfig
{
    // Данные для инициализации базы данных питомцев
    @Bean
    public CommandLineRunner loadData(ProductRepository productRepository, WorkshopRepository workshopRepository)
    {
        return (args) -> {
            if (productRepository.findAll().isEmpty())
            {
                var products = new ArrayList<Product>();
                // Для собак
                products.add(new Product("Корм для собак", 500, "dog"));
                products.add(new Product("Комбинезон", 2000, "dog"));
                products.add(new Product("Ошейник", 1500, "dog"));
                products.add(new Product("Капли", 300, "dog"));
                // Для кошек
                products.add(new Product("Корм для кошек", 400, "cat"));
                products.add(new Product("Дом-когтеточка", 5000, "cat"));
                products.add(new Product("Свитер", 1300, "cat"));
                products.add(new Product("Лежак", 2400, "cat"));
                // Для рыб
                products.add(new Product("Корм для рыб", 800, "fish"));
                products.add(new Product("Аквариум", 4500, "fish"));
                products.add(new Product("Декор", 3400, "fish"));
                products.add(new Product("Препараты", 1200, "fish"));
                // Для птиц
                products.add(new Product("Корм для птиц", 400, "bird"));
                products.add(new Product("Кормушка", 2100, "bird"));
                products.add(new Product("Жердочка", 1600, "bird"));
                products.add(new Product("Клетка", 6400, "bird"));
                productRepository.saveAll(products);

                for (var product : products)
                {
                    workshopRepository.save(new Workshop(product, 50));
                }
            }
        };
    }
}

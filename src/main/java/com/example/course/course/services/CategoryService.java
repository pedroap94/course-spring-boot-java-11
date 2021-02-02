package com.example.course.course.services;

import com.example.course.course.entities.Category;
import com.example.course.course.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    //gerando método para retornar tudo que há no banco de dados
    public List<Category> findAll(){ return categoryRepository.findAll(); }

    //gerando método para retornar por id. Não retornamos uma lista, já que será apenas um objeto
    public Category findById(Long id){
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.get();
    }

}

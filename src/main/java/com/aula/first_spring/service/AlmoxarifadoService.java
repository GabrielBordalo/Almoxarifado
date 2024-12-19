package com.aula.first_spring.service;

import com.aula.first_spring.model.AlmoxarifadoModel;
import com.aula.first_spring.repository.AlmoxarifadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlmoxarifadoService {
    @Autowired
    private AlmoxarifadoRepository almoxarifadoRepository;

    public List<AlmoxarifadoModel> listar() {
        return almoxarifadoRepository.findAll();
    }

    public AlmoxarifadoModel cadastrar(AlmoxarifadoModel almoxarifadoModel){
        return almoxarifadoRepository.save(almoxarifadoModel);
    }

    public AlmoxarifadoModel atualizar(Long id, AlmoxarifadoModel almoxarifadoModel){
        AlmoxarifadoModel verificarAluno = almoxarifadoRepository.findById(id).orElseThrow((() -> new RuntimeException("ID inexistente")));
        verificarAluno.setProduto(almoxarifadoModel.getProduto());
        verificarAluno.setQuantidade(almoxarifadoModel.getQuantidade());
        verificarAluno.setCategoria(almoxarifadoModel.getCategoria());
        return almoxarifadoRepository.save(verificarAluno);
    }

    public void delete(Long id){
        almoxarifadoRepository.deleteById(id);
    }

}

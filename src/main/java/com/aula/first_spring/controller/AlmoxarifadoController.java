package com.aula.first_spring.controller;

import com.aula.first_spring.model.AlmoxarifadoModel;
import com.aula.first_spring.service.AlmoxarifadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/almo-sys")
public class AlmoxarifadoController {
    @Autowired
    private AlmoxarifadoService almoxarifadoService;

    @GetMapping("/listar")
    public ResponseEntity<List<AlmoxarifadoModel>> listAlmoxarifado (){
        List<AlmoxarifadoModel> alunos = almoxarifadoService.listar();

        return ResponseEntity.ok(alunos);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<AlmoxarifadoModel>cadastrarProdutos (@RequestBody AlmoxarifadoModel almoxarifadoModel) {
        var aluno = almoxarifadoService.cadastrar(almoxarifadoModel);
        return ResponseEntity.ok().body(aluno);
    }

    @PutMapping ("atualizar/{id}")
    public AlmoxarifadoModel atualizarProduto (@PathVariable Long id, @RequestBody AlmoxarifadoModel almoxarifadoModel) {
        return almoxarifadoService.atualizar(id, almoxarifadoModel);
    }

    @DeleteMapping ("deletar/{id}")
    public void deletarProduto(@PathVariable Long id, AlmoxarifadoModel almoxarifadoModel){
        almoxarifadoService.delete(id);
    }
}

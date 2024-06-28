package com.imdb.filmes.controllers;

import com.imdb.filmes.models.Filmes;
import com.imdb.filmes.repositories.FilmesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Controladora Rest
// Uma controladora REST é uma classe que recebe requisições HTTP e retorna respostas HTTP
// Ela é responsável por receber as requisições, processar as informações e retornar uma resposta
// Ela é responsável por fazer a comunicação entre o cliente e o servidor

@CrossOrigin
@RestController // Diz ao SPRING que é uma controladora REST
@RequestMapping("/filmes") //URL base dessa controladora
public class FilmesController {

     /*
        CRUD          ->  Create, Read/Retrieve, Update and Delete
        PostMapping   ->  Enviar/criar dados para o banco
        GetMapping    ->  Trazer dados do banco
        RequestMapping->  Trazer dados do banco
        PutMapping    ->  Atualizar dados do banco
        DeleteMapping ->  Apaga dados do banco
     */
    // AutoWired significa que o SPRING vai injetar a dependência
    // Injetar dependência significa que o SPRING vai criar uma instância do objeto
    // e vai passar para a classe que está pedindo

    @Autowired
    FilmesRepository dbConnection;

    @CrossOrigin // Para evitar o erro de CORS
    @GetMapping("/")
    //Método que retorna todos os registros do banco
    public List<Filmes> findAllRecords(){
        return dbConnection.findAll();
    }

    @PostMapping(value = "/inserir", produces = "application/json") // Criar um novo registro
    public Filmes create(@RequestBody Filmes exemplo){
        dbConnection.save(exemplo);
        return exemplo;
    }

    // Encontrar um único elemento por id
    @RequestMapping(value = "/buscar/id/{id}", method = RequestMethod.GET)
    public Optional<Filmes> searchById(@PathVariable int id) {
        return dbConnection.findById(id);
    }

    // Encontrar elementos por nomes no elenco
    @RequestMapping(value = "/buscar/elenco/{name}", method = RequestMethod.GET)
    public List<Filmes> searchByCast(@PathVariable String name) {
        return dbConnection.findByelencoContaining(name);
    }

    @RequestMapping(value = "/buscar/diretor/{name}", method = RequestMethod.GET)
    public List<Filmes> searchByDirector(@PathVariable String name) {
        return dbConnection.findBydiretorContaining(name);
    }

    @RequestMapping(value = "/buscar/titulo/{name}", method = RequestMethod.GET)
    public List<Filmes> searchByTitle(@PathVariable String name) {
        return dbConnection.findBydiretorContaining(name);
    }

    @DeleteMapping(value = "/deletar/{id}", produces = "application/json") // Deletar um registro
    public String delete(@PathVariable int id) {
        Filmes filme = dbConnection.findById(id).get();
        dbConnection.delete(filme);
        // return "Registro deletado com sucesso!";
        return "{deleted:" + id + "}";
    }

    @PutMapping(value = "/atualizar/{id}", produces = "application/json") // Atualizar um registro
    public Filmes update(@PathVariable int id, @RequestBody Filmes exemplo) {
        Filmes filme = dbConnection.findById(id).get();
        filme.setTitulo(exemplo.getTitulo());
        filme.setAvaliacao(exemplo.getAvaliacao());
        filme.setAno(exemplo.getAno());
        filme.setFaixaEtaria(exemplo.getFaixaEtaria());
        filme.setGenero(exemplo.getGenero());
        filme.setDiretor(exemplo.getDiretor());
        filme.setElenco(exemplo.getElenco());
        filme.setMetaScore(exemplo.getMetaScore());
        filme.setPosterSrc(exemplo.getPosterSrc());
        filme.setDuracao(exemplo.getDuracao());
        dbConnection.save(filme);
        return filme;
    }

}

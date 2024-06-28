package com.imdb.filmes.repositories;

import com.imdb.filmes.models.Filmes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

    /*
        // Uma Repository é uma interface que estende a interface JpaRepository
        // JpaRepository é uma interface que possui métodos prontos para se comunicar com o banco de dados

        Classe responsavel por se comunicar com o banco de dados:
        SALVAR, LER, ATUALIZAR E DELETAR
    */

@Repository
public interface FilmesRepository extends JpaRepository<Filmes, Integer> {

    List<Filmes> findByelencoContaining(String name);

    List<Filmes> findBydiretorContaining(String name);

    List<Filmes> findBytituloContaining(String name);

    Optional<Filmes> findById(int id);

    // Lista Opcionional
    Optional<List<Filmes>> findFilmesBytitulo(String name);


}

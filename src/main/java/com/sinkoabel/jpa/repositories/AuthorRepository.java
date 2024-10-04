package com.sinkoabel.jpa.repositories;

import com.sinkoabel.jpa.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer>, JpaSpecificationExecutor<Author> {

    @Modifying
    @Transactional
    @Query("UPDATE Author a SET a.age = :age WHERE a.id = :id")
    int updateAuthor(int age, int id);

    @Transactional
    List<Author> findByNamedQuery(@Param("age") int age);

    // select * from authors where first_name = 'abel'; -> not case ignorant
    List<Author> findAllByFirstName(String firstName);

    // select * from authors where first_name = 'abel'; -> case ignorant!
    List<Author> findAllByFirstNameIgnoreCase(String firstName);

    // select * from authors where first_name like '%ab%';
    List<Author> findAllByFirstNameContainingIgnoreCase(String firstName);

    // select * from authors where first_name like 'ab%';
    List<Author> findAllByFirstNameStartsWithIgnoreCase(String firstName);

    // select * from authors where first_name in ('john', 'kimi', 'abel');
    List<Author> findAllByFirstNameInIgnoreCase(Collection<String> firstName);

    // and so on and on...
}

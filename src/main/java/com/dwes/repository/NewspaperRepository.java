package com.dwes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.dwes.entity.Newspaper;

public interface NewspaperRepository extends JpaRepository<Newspaper, Long>{

}

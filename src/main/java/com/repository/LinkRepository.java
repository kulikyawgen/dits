/*
@author Andrei Gorevoi
*/
package com.repository;

import com.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {
}
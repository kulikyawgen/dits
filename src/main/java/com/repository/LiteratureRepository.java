/*
@author Andrei Gorevoi
*/
package com.repository;

import com.model.Literature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LiteratureRepository extends JpaRepository<Literature, Long> {
}
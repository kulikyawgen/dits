/*
@author Andrei Gorevoi
*/
package com.repository.link;

import com.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinkRepository extends JpaRepository<Link,Integer> {
    @Query("delete from Link where linkId=?1")
    void deleteLinkById(int id);

    @Query("from Link where linkId=?1")
    Link findLinkById(int id);

    @Query("from Link l where l.literatureid.literatureId=?1")
    List<Link> findAllLinkByLiteratureId(int id);
}

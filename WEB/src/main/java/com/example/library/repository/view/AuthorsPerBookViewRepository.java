package com.example.library.repository.view;

import com.example.library.model.view.AuthorsPerBookView;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AuthorsPerBookViewRepository extends JpaRepository<AuthorsPerBookView,Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "REFRESH MATERIALIZED VIEW", nativeQuery = true)
    void refreshMaterializedView();
}

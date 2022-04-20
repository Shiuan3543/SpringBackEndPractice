package com.example.demo.Repository;
import com.example.demo.models.Shortcut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortcutRepository extends JpaRepository<Shortcut, Long> {

    public Shortcut getByShortUrl(String shortUrl);
}
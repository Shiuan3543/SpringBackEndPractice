package com.example.demo.Repository;

import com.example.demo.models.ShareQ;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShareQRepository extends JpaRepository<ShareQ, Long> {
    public ShareQ getByShortUrl(String shortUrl);
    public ShareQ getByIdno(String idno);
}

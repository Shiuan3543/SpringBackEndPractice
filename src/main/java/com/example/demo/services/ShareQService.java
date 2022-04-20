package com.example.demo.services;

import com.example.demo.models.ShareQ;

public interface ShareQService {
    public ShareQ create(ShareQ shareQ);
    public ShareQ add(ShareQ shareQ);
    public ShareQ getByIdno(String idno);
}

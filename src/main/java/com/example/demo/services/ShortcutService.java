package com.example.demo.services;
import com.example.demo.models.Shortcut;
import java.util.List;

public interface ShortcutService {
  public Shortcut createUrl(String longUrl);

  public Shortcut link(String shortUrl);

  public List<Shortcut> getAll();

  public Shortcut getByShortUrl(String shortUrl);

  //刪除
  public void delete(Long id);
}

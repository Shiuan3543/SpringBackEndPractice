package com.example.demo.services.imp;

import com.example.demo.models.Shortcut;
import com.example.demo.Repository.ShortcutRepository;

import java.util.List;

import com.example.demo.services.ShortcutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortcutServiceImp implements ShortcutService {

  @Autowired
  ShortcutRepository shortcutRepository;

  char[] chars = new char[36]; // 建一個空字元陣列備用

  public ShortcutServiceImp() { // 利用ascii code 65~90 把A~Z存入陣列
    for (int i = 0; i < 26; i++) {
      this.chars[i] = (char) (65 + i);
    }
    for (int i = 26; i < 36; i++) { // 再繼續存0~9(ascii 48~57)
      this.chars[i] = (char) (22 + i);
    }
  }

  // 傳入長，產生短，並回傳
  @Override
  public Shortcut createUrl(String longUrl) {
    List<Shortcut> shortcutList = shortcutRepository.findAll();
    for (int i = 0; i < shortcutList.size(); i++) { // 已產生過短網址，就直接回傳
      if (shortcutList.get(i).getLongUrl().equals(longUrl)) {
        return shortcutList.get(i); // 記得跟大家講
      }
    }
    String url = ""; // 預設短網址為空字串
    while (url == "") {
      int random;
      for (int i = 0; i < 8; i++) { // 8個字元組成字串
        random = (int) (Math.random() * 36); // 0~35間隨機int
        url = url + chars[random];
      }
      for (int i = 0; i < shortcutList.size(); i++) {
        if (shortcutList.get(i).getShortUrl().equals(url)) { // 找到相同短網址
          System.out.println("相同:" + url);
          url = ""; // 就清空
          break;
        }
      }
    }
    Shortcut shortcut = new Shortcut(longUrl, url);
    shortcutRepository.save(shortcut);
    return shortcut;
  }

  @Override
  public List<Shortcut> getAll() {
    return shortcutRepository.findAll();
  }

  @Override
  public Shortcut getByShortUrl(String shortUrl) {
    return shortcutRepository.getByShortUrl(shortUrl);
  }

  //刪除
  public void delete(Long id) {
    this.shortcutRepository.deleteById(id);
  }

  @Override
  public Shortcut link(String shortUrl){
    System.out.println("ser收到" + shortUrl);
    Shortcut shortcut = shortcutRepository.getByShortUrl(shortUrl);
    System.out.println(shortcut);
    return shortcut;
  }
}

package java56.controller;

import java.util.Map;
import java56.dao.ScoreDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component("/score/step01/delete.do")
public class ScoreDelete {
  @Autowired
  ScoreDao scoreDao;
  
  @RequestMapping
  public String execute(Map<String, String[]> params, Map<String, Object> model)
      throws Exception {
    int no = Integer.parseInt(params.get("no")[0]);
    scoreDao.delete(no);
    
    return "redirect:list.do";
  }
}















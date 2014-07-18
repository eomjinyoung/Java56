package java56.controller;

import java.util.Map;
import java56.dao.ScoreDao;
import java56.vo.Score;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component("/score/step01/update.do")
public class ScoreUpdate {
  @Autowired
  ScoreDao scoreDao;
  
  @RequestMapping
  public String execute(Map<String, String[]> params, Map<String, Object> model)
      throws Exception {
    if (params.get("name") == null) { // 변경폼에서 값이 넘어오는 것이 아니다.
      model.put("score", scoreDao.selectOne(
          Integer.parseInt(params.get("no")[0])));
      return "/score/step01/scoreupdateform.jsp";
      
    } else {
      scoreDao.update(new Score()
        .setNo(Integer.parseInt(params.get("no")[0]))
        .setName(params.get("name")[0])
        .setKor(Integer.parseInt(params.get("kor")[0]))
        .setEng(Integer.parseInt(params.get("eng")[0]))
        .setMath(Integer.parseInt(params.get("math")[0])));
      return "redirect:list.do";
    }
  }
}















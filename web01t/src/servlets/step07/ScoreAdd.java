package servlets.step07;

import java.util.Map;

public class ScoreAdd implements PageController {
  ScoreDao scoreDao;
  
  public void setScoreDao(ScoreDao scoreDao) {
    this.scoreDao = scoreDao;
  }
  
  @Override
  public String execute(Map<String, String[]> params, Map<String, Object> model)
      throws Exception {
    Score score = new Score();
    score.setName(params.get("name")[0]);
    score.setKor(Integer.parseInt(params.get("kor")[0]));
    score.setEng(Integer.parseInt(params.get("eng")[0]));
    score.setMath(Integer.parseInt(params.get("math")[0]));
    
    scoreDao.insert(score);
    return "redirect:list.do";
  }
}















package servlets.step07;

import java.util.Map;

public class ScoreDelete  implements PageController {
  ScoreDao scoreDao;
  
  public void setScoreDao(ScoreDao scoreDao) {
    this.scoreDao = scoreDao;
  }
  
  @Override
  public String execute(Map<String, String[]> params, Map<String, Object> model)
      throws Exception {
    int no = Integer.parseInt(params.get("no")[0]);
    scoreDao.delete(no);
    
    return "redirect:list.do";
  }
}















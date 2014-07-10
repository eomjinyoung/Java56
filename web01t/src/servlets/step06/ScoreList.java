package servlets.step06;

import java.util.Map;

// 출력을 JSP에게 위임하기

public class ScoreList implements PageController {
  ScoreDao scoreDao;
  
  public void setScoreDao(ScoreDao scoreDao) {
    this.scoreDao = scoreDao;
  }
  
  @Override
  public String execute(Map<String, String[]> params, Map<String, Object> model)
      throws Exception {
      model.put("scores", scoreDao.list());
      
      return "/score/step06/ScoreList.jsp";
  }

}











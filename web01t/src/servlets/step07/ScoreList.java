package servlets.step07;

import java.util.Map;

import org.apache.log4j.Logger;

// 출력을 JSP에게 위임하기

public class ScoreList implements PageController {
  static Logger logger = Logger.getLogger(ScoreList.class);
  ScoreDao scoreDao;
  
  public void setScoreDao(ScoreDao scoreDao) {
    this.scoreDao = scoreDao;
  }
  
  @Override
  public String execute(Map<String, String[]> params, Map<String, Object> model)
      throws Exception {
    logger.info("성적 목록 가져오기.....");
    model.put("scores", scoreDao.list());
    
    return "/score/step07/ScoreList.jsp";
  }

}











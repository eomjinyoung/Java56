package java56.controller.json;

import java.util.HashMap;
import java56.dao.ScoreDao;
import java56.vo.Score;

import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/score")
public class ScoreControl {
  static Logger logger = Logger.getLogger(ScoreControl.class);
  
  @Autowired
  ScoreDao scoreDao;
  
  @RequestMapping("/list") 
  public Object list(
      @RequestParam(defaultValue="1") int pageNo, 
      @RequestParam(defaultValue="3") int pageSize, 
      String order,
      String columnName,
      String orderType,
      ServletResponse response)
      throws Exception {
    logger.info("성적 목록 가져오기.....");
    
    int countAll = scoreDao.countAll();
    int totalPage = countAll / pageSize;
    if ((countAll % pageSize) > 0) {
      totalPage++;
    }
    
    HashMap<String,Object> result = new HashMap<String,Object>();
    
    if (order != null) {
      //result.put("order", order);
      result.put("scores", scoreDao.list(pageNo, pageSize, order));
    } else if (columnName != null) {
      result.put("scores", 
          scoreDao.list(pageNo, pageSize, columnName, orderType));
    } else {
      result.put("scores", scoreDao.list(pageNo, pageSize, null));
    } 
    //result.put("totalPage", totalPage);
    //result.put("pageNo", pageNo);
    //result.put("pageSize", pageSize);
    
    return result;
  }
  
  @RequestMapping(value="/add", method=RequestMethod.POST)
  public Object add(Score score)
      throws Exception {
    scoreDao.insert(score);
    HashMap<String,Object> result = new HashMap<String,Object>();
    result.put("status", "success");
    return result;
  }
  
  @RequestMapping(value="/delete", method=RequestMethod.GET)
  public Object delete(int no)
      throws Exception {
    int count = scoreDao.delete(no);
    
    HashMap<String,Object> result = new HashMap<String,Object>();
    
    if (count > 0) {
      result.put("status", "success");
    } else {
      result.put("status", "failure");
    }
    
    return result;
  }
  
  @RequestMapping(value="/update", method=RequestMethod.GET)
  public Object detail(int no, Model model)
      throws Exception {
    HashMap<String,Object> result = new HashMap<String,Object>();
    result.put("score", scoreDao.selectOne(no));
    return result;
  }
  
  @RequestMapping(value="/update", method=RequestMethod.POST)
  public Object update(Score score)
      throws Exception {
    scoreDao.update(score);
    HashMap<String,Object> result = new HashMap<String,Object>();
    result.put("status", "success");
    return result;
  }
}








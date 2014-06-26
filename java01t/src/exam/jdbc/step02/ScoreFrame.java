package exam.jdbc.step02;

/* [<], [>] 버튼 추가 및 이벤트 처리
 * - Frame 클래스가 ActionListener 역할을 겸한다.
 * - OOP입장에서는 바람직하지 않다.
 *   => Low coupling, High cohesion(하나의 클래스는 하나의 역할을 수행한다)
 *   
 * ActionListener 규칙
 * - 버튼을 클릭 이벤트를 처리하는 규칙
 * - TextField의 엔터 키 이벤트를 처리하는 규칙 
 * 
 * 버튼에 Action 이름을 설정한 후 이벤트 처리 시에 사용한다.
 */

import java.awt.Button;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ScoreFrame  extends Frame implements ActionListener {
  private TextField tfName = new TextField(20);
  private TextField tfKor = new TextField(5);
  private TextField tfEng = new TextField(5);
  private TextField tfMath = new TextField(5);

  public void actionPerformed(ActionEvent e) {
    // 추가 버튼, < 버튼, > 버튼
    if (e.getActionCommand().equals("scoreAdd")) {
      Score score = new Score();
      score.setName(tfName.getText());
      score.setKor(Integer.parseInt(tfKor.getText()));
      score.setEng(Integer.parseInt(tfEng.getText()));
      score.setMath(Integer.parseInt(tfMath.getText()));

      scoreDao.insert(score);

      clearForm();
    } else if (e.getActionCommand().equals("scorePrevious")) {
      Score currScore = null;
      if (tfName.getText().equals("")) {
        currScore = scoreDao.getCurrentScore();
      } else {
        currScore = scoreDao.previous();
      }
      if (currScore == null) {
        System.out.println("가져올 데이터가 없습니다!");
      } else {
        setForm(currScore);
      }
      
    } else if (e.getActionCommand().equals("scoreNext")) {
      Score currScore = scoreDao.next();
      if (currScore == null) {
        System.out.println("가져올 데이터가 없습니다!");
      } else {
        setForm(currScore);
      }
    } else if (e.getActionCommand().equals("formClear")) {
      clearForm();
    } else if (e.getActionCommand().equals("scoreDelete")) {
      scoreDao.delete();
      Score currScore = scoreDao.getCurrentScore();
      if (currScore == null) {
        clearForm();
      } else {
        setForm(currScore);
      }
    }
  }

  private ScoreDao scoreDao;

  public ScoreFrame() {
    this.setTitle("BIT SMS");
    this.setSize(400, 300);
    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    this.setLayout(new FlowLayout(FlowLayout.LEFT));

    this.add( createRowPanel("Name", tfName) );
    this.add( createRowPanel("Korea", tfKor) );
    this.add( createRowPanel("English", tfEng) );
    this.add( createRowPanel("Mathmatics", tfMath) );

    Panel toolbar = new Panel(new FlowLayout(FlowLayout.LEFT));

    Button btn = createToolbarButton("Add");
    btn.setActionCommand("scoreAdd"); 
    btn.addActionListener(this);
    toolbar.add(btn);

    btn = createToolbarButton("Clear");
    btn.setActionCommand("formClear"); 
    btn.addActionListener(this);
    toolbar.add(btn);
    
    btn = createToolbarButton("Delete");
    btn.setActionCommand("scoreDelete"); 
    btn.addActionListener(this);
    toolbar.add(btn);
    
    btn = createToolbarButton("<");
    btn.setActionCommand("scorePrevious"); 
    btn.addActionListener(this);
    toolbar.add(btn);

    btn = createToolbarButton(">");
    btn.setActionCommand("scoreNext");
    btn.addActionListener(this);
    toolbar.add(btn);

    this.add(toolbar);
  }

  private Button createToolbarButton(String title) {
    Button btn = new Button(title);
    btn.setPreferredSize(new Dimension(80,  30));
    return btn;
  }

  private Panel createRowPanel(String title, Component comp) {
    Panel panel = new Panel(new FlowLayout(FlowLayout.LEFT)); 
    panel.setPreferredSize(new Dimension(300, 25));

    Label label = new Label(title);
    label.setPreferredSize(new Dimension(50, 25));
    panel.add(label);

    panel.add(comp);

    return panel;
  }

  public void setScoreDao(ScoreDao scoreDao) {
    this.scoreDao = scoreDao;
    Score score = scoreDao.getCurrentScore();
    if (score != null) {
      setForm(score);
    }
  }

  private void clearForm() {
    tfName.setText("");
    tfKor.setText("");
    tfEng.setText("");
    tfMath.setText("");
  }

  private void setForm(Score score) {
    tfName.setText(score.getName());
    tfKor.setText(Integer.toString(score.getKor()));
    tfEng.setText(Integer.toString(score.getEng()));
    tfMath.setText(Integer.toString(score.getMath()));
  }

}




















//Eric Thornton's Paint Program
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import java.util.Hashtable;
import javax.swing.border.*;

public class Assignment10 extends JFrame implements ActionListener, MouseListener, MouseMotionListener, ChangeListener, ItemListener
{
  float thickness = 20.0f;
  Font myFont = new Font("Arial", Font.BOLD, 20);
  int current_x = -10; 
  int current_y = -10;
  int begin_x = -10;
  int begin_y = -10;
  int last_x=-10;
  int last_y=-10;
  int xpos=-10;
  int ypos=-10;
  Container con = null;
  Color drawColor = (Color.red);
  JMenu myMenu = new JMenu("File");
  JMenuItem m;
  JMenu myMenu1 = new JMenu("Help");
  JMenuItem c;
  JMenuItem r;
  JMenuItem t;
  JButton erase = new JButton("", new ImageIcon("Eraser.png"));
  boolean eraseOn = false;
  JButton pencil = new JButton("", new ImageIcon("pencil.png"));
  boolean pencilOn = false;
  JButton brush = new JButton("", new ImageIcon("brush.png"));
  boolean brushOn = false;
  JButton font = new JButton("", new ImageIcon("text.png"));
  boolean fontOn = false;
  JButton line = new JButton("", new ImageIcon("line.png"));
  boolean lineOn = false;
  JButton red = new JButton("", new ImageIcon("red.gif"));
  boolean redOn = true;
  JButton yellow = new JButton("", new ImageIcon("yellow.gif"));
  boolean yellowOn = false;
  JButton green = new JButton("", new ImageIcon("green.gif"));
  boolean greenOn = false;
  JButton blue = new JButton("", new ImageIcon("blue.gif"));
  boolean blueOn = false;
  JLabel text = new JLabel("Enter text, then click location:");
  JTextField text1 = new JTextField("",5);
  JLabel thick = new JLabel("          Brush:");
  JPanel layout = new JPanel(new GridLayout(1,7));
  JPanel layout2 = new JPanel(new GridLayout(3,2));
  JPanel layout3 = new JPanel(new GridLayout(3,0));
  JPanel layout4 = new JPanel(new GridLayout(2,0));
  JSlider slider = new JSlider(JSlider.HORIZONTAL, 1,3,3);
  JMenuBar mBar = new JMenuBar();
  ButtonGroup fontGrp = new ButtonGroup();
  JRadioButton arial = new JRadioButton("Arial");
  boolean arialOn = true;
  JRadioButton tahoma = new JRadioButton("Tahoma");
  boolean tahomaOn = false;
  JRadioButton courier = new JRadioButton("Courier New");
  boolean courierOn = false;
  
  JPanel centerPanel = new JPanel();

  public Assignment10() //constructor
  {
    fontGrp.add(arial);
    arial.addItemListener(this);
    fontGrp.add(tahoma);
    tahoma.addItemListener(this);
    fontGrp.add(courier);
    courier.addItemListener(this);
    layout.add(erase);
    erase.addActionListener(this);
    erase.setToolTipText("Eraser");
    layout.add(pencil);
    pencil.addActionListener(this);
    pencil.setToolTipText("Pencil");
    layout.add(brush);
    brush.addActionListener(this);
    brush.setToolTipText("Brush");
    layout.add(font);
    font.addActionListener(this);
    font.setToolTipText("Text");
    layout.add(line);
    line.addActionListener(this);
    line.setToolTipText("Line");
    layout.add(layout3);
    fontGrp.add(arial);
    layout3.add(arial);
    fontGrp.add(tahoma);
    layout3.add(tahoma);
    fontGrp.add(courier);
    layout3.add(courier);
    layout.add(layout4);
    layout4.add(thick);
    layout4.add(slider);
    slider.setMinorTickSpacing(1);
    slider.setMajorTickSpacing(1);
    slider.addChangeListener(this);
    slider.setPaintTicks(true);
    slider.setPaintLabels(true);
    slider.setSnapToTicks(true);
    mBar = new JMenuBar();
    mBar.add(myMenu);
    mBar.add(myMenu1);
    setJMenuBar(mBar);
    t= new JMenuItem("New");
    t.addActionListener(this);
    m = new JMenuItem("Exit");
    myMenu.setMnemonic('F');
    m.addActionListener(this);
    myMenu.add(t);
    myMenu.add(m);
    myMenu1.setMnemonic('H');
    c= new JMenu("About");
    c.addActionListener(this);
    myMenu1.add(c);
    r = new JMenuItem("Created by: Eric");
    c.add(r);
    Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
    labelTable.put(new Integer( 1 ), new JLabel("Thin") );
    labelTable.put(new Integer(3), new JLabel("Thick") );
    slider.setLabelTable( labelTable );
    layout.add(layout4);
    layout2.add(red);
    red.addActionListener(this);
    layout2.add(yellow);
    yellow.addActionListener(this);
    layout2.add(green);
    green.addActionListener(this);
    layout2.add(blue);
    blue.addActionListener(this);
    layout2.add(text);
    text.setVisible(false);
    layout2.add(text1);
    text1.setVisible(false);
    setTitle("My Paint Program");
    setBackground(Color.white);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    con = this.getContentPane(); 
    con.setBackground(Color.white);
    addMouseListener(this);
    addMouseMotionListener(this);
    con.add(layout, BorderLayout.NORTH);
    con.add(centerPanel, BorderLayout.CENTER);
    centerPanel.setBackground(Color.white);
    con.add(layout2, BorderLayout.SOUTH);
    layout.setBorder(new BevelBorder(BevelBorder.RAISED));
    erase.setBorder(new BevelBorder(BevelBorder.RAISED));
    pencil.setBorder(new BevelBorder(BevelBorder.RAISED));
    brush.setBorder(new BevelBorder(BevelBorder.RAISED));
    font.setBorder(new BevelBorder(BevelBorder.RAISED));
    line.setBorder(new BevelBorder(BevelBorder.RAISED));
    red.setBorder(new BevelBorder(BevelBorder.RAISED));
    green.setBorder(new BevelBorder(BevelBorder.RAISED));
    yellow.setBorder(new BevelBorder(BevelBorder.RAISED));
    blue.setBorder(new BevelBorder(BevelBorder.RAISED));


  }
 public void itemStateChanged(ItemEvent e) 
 { 
 Object source = e.getItem();
   if(source == arial)
    { 
     myFont = new Font("Arial", Font.BOLD, 20);
    } 
   else if(source == tahoma)
    {
     myFont = new Font("Tahoma", Font.BOLD, 20);
    }
   else if(source == courier)
    {
     myFont = new Font("Courier New", Font.BOLD,20);
    }

 }
 public void actionPerformed(ActionEvent e)
{  
  Object source = e.getSource();
  String actionCommand = e.getActionCommand();
  if(source == erase)
  {
    erase.setBorder(new BevelBorder(BevelBorder.LOWERED));
    pencil.setBorder(new BevelBorder(BevelBorder.RAISED));
    brush.setBorder(new BevelBorder(BevelBorder.RAISED));
    font.setBorder(new BevelBorder(BevelBorder.RAISED));
    line.setBorder(new BevelBorder(BevelBorder.RAISED));
   
    eraseOn = true;
    pencilOn = false;
    brushOn = false;
    fontOn = false;
    lineOn = false;
  }
  else if(source == pencil)
  {
    erase.setBorder(new BevelBorder(BevelBorder.RAISED));
    pencil.setBorder(new BevelBorder(BevelBorder.LOWERED));
    brush.setBorder(new BevelBorder(BevelBorder.RAISED));
    font.setBorder(new BevelBorder(BevelBorder.RAISED));
    line.setBorder(new BevelBorder(BevelBorder.RAISED));
   
    eraseOn = false;
    pencilOn = true;
    brushOn = false;
    fontOn = false;
    lineOn = false;
}
else if(source == brush)
  {
    erase.setBorder(new BevelBorder(BevelBorder.RAISED));
    pencil.setBorder(new BevelBorder(BevelBorder.RAISED));
    brush.setBorder(new BevelBorder(BevelBorder.LOWERED));
    font.setBorder(new BevelBorder(BevelBorder.RAISED));
    line.setBorder(new BevelBorder(BevelBorder.RAISED));
   
    eraseOn = false;
    pencilOn = false;
    brushOn = true;
    fontOn = false;
    lineOn = false;
  }
else if(source == font)
  {
    erase.setBorder(new BevelBorder(BevelBorder.RAISED));
    pencil.setBorder(new BevelBorder(BevelBorder.RAISED));
    brush.setBorder(new BevelBorder(BevelBorder.RAISED));
    font.setBorder(new BevelBorder(BevelBorder.LOWERED));
    line.setBorder(new BevelBorder(BevelBorder.RAISED));
   
    eraseOn = false;
    pencilOn = false;
    brushOn = false;
    fontOn = true;
    lineOn = false;

text.setVisible(true);
text1.setVisible(true);
  }
else if(source == line)
  {
    erase.setBorder(new BevelBorder(BevelBorder.RAISED));
    pencil.setBorder(new BevelBorder(BevelBorder.RAISED));
    brush.setBorder(new BevelBorder(BevelBorder.RAISED));
    font.setBorder(new BevelBorder(BevelBorder.RAISED));
    line.setBorder(new BevelBorder(BevelBorder.LOWERED));
   
    eraseOn = false;
    pencilOn = false;
    brushOn = false;
    fontOn = false;
    lineOn = true;
  }
else if(source == red)
   {
    red.setBorder(new BevelBorder(BevelBorder.LOWERED));
    green.setBorder(new BevelBorder(BevelBorder.RAISED));
    yellow.setBorder(new BevelBorder(BevelBorder.RAISED));
    blue.setBorder(new BevelBorder(BevelBorder.RAISED));
    drawColor = (Color.red);
   }
else if(source == yellow)
   {
    red.setBorder(new BevelBorder(BevelBorder.RAISED));
    green.setBorder(new BevelBorder(BevelBorder.RAISED));
    yellow.setBorder(new BevelBorder(BevelBorder.LOWERED));
    blue.setBorder(new BevelBorder(BevelBorder.RAISED));
    drawColor = (Color.yellow);
   }
else if(source == green)
   {
    red.setBorder(new BevelBorder(BevelBorder.RAISED));
    green.setBorder(new BevelBorder(BevelBorder.LOWERED));
    yellow.setBorder(new BevelBorder(BevelBorder.RAISED));
    blue.setBorder(new BevelBorder(BevelBorder.RAISED));
    drawColor = (Color.green);
   }
else if(source == blue)
   {
    red.setBorder(new BevelBorder(BevelBorder.RAISED));
    green.setBorder(new BevelBorder(BevelBorder.RAISED));
    yellow.setBorder(new BevelBorder(BevelBorder.RAISED));
    blue.setBorder(new BevelBorder(BevelBorder.LOWERED));
    drawColor = (Color.blue);
   }
else if(actionCommand.equals("Exit"))
      {
      System.exit(0);
      }
else if(actionCommand.equals("New"))
      {
      centerPanel.repaint();
      }
}
 public void stateChanged(ChangeEvent evt)
  {
    JSlider source = (JSlider)evt.getSource();
    if(source.getValue() == 1)
    {
 	thickness = 5.0f;	
    }
   else if(source.getValue() == 2)
    {
        thickness = 10.0f;
    }
   else if(source.getValue() == 3)
    {
        thickness = 20.0f;
    }
  }

  public void mouseDragged(MouseEvent evt)
  {
    xpos=evt.getX();
    ypos=evt.getY();
    if(pencilOn)
    {
    Graphics gr = getGraphics();
    gr.setColor(drawColor);
    gr.drawLine(last_x,last_y,xpos,ypos);
    }
    if(brushOn) 
    {
     Graphics gr = getGraphics();
     Graphics2D gr2D = (Graphics2D)gr;
     BasicStroke aStroke = new BasicStroke((thickness), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
     gr2D.setStroke(aStroke);
     gr.setColor(drawColor);
     gr.drawLine(last_x,last_y,xpos,ypos);
    }
    if(eraseOn)
    {
     Graphics gr = getGraphics();
     Graphics2D gr2D = (Graphics2D)gr;
     BasicStroke aStroke = new BasicStroke((thickness), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
     gr2D.setStroke(aStroke);
     gr.setColor(Color.white);
     gr.drawLine(last_x,last_y,xpos,ypos);
    }
    layout.repaint();
    layout2.repaint();
    mBar.repaint();
    last_x = xpos;
    last_y = ypos;
  }

  public void mousePressed(MouseEvent evt)
  {
    last_x = evt.getX();
    last_y = evt.getY();
    begin_x = evt.getX();
    begin_y = evt.getY();
    
    if(fontOn)
    {
     Graphics gr = getGraphics();
     Graphics2D gr2D = (Graphics2D)gr;
     text1.getText();
     gr.setFont(myFont);
     gr.setColor(drawColor);
     gr.drawString(text1.getText(),last_x,last_y);
    }
  }

  //following methods need to be included even if not used
  public void mouseMoved(MouseEvent evt) {}
  public void mouseClicked(MouseEvent evt) {}
  public void mouseReleased(MouseEvent evt) 
{
     current_x = evt.getX(); 
     current_y = evt.getY();
 if(lineOn)
    {
     Graphics gr = getGraphics();
     Graphics2D gr2D = (Graphics2D)gr;
     BasicStroke aStroke = new BasicStroke((thickness), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
     gr2D.setStroke(aStroke);
     gr.setColor(drawColor);
     gr.drawLine(begin_x,begin_y,current_x,current_y);   
    }
}
  public void mouseEntered(MouseEvent evt) {}
  public void mouseExited(MouseEvent evt) {}


  public static void main(String[] args)
  {
    Assignment10 myDD = new Assignment10();
    myDD.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myDD.setSize(750,700);
    myDD.setResizable(false); 
    myDD.setVisible(true);
    myDD.setLocationRelativeTo(null);
  }
}
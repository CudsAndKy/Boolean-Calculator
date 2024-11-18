import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UIHandler extends JFrame implements MouseListener {

    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    ImageIcon calcButton = new ImageIcon("CalcButton.png");
    ImageIcon passImg = new ImageIcon("pass.png");
    ImageIcon exitImg = new ImageIcon("exitButton.png");
    Image image;
    Image frameIcon = Toolkit.getDefaultToolkit().getImage("calculator icon.jpg");
    JLabel Homelabel = new JLabel();
    JLabel homeDesc = new JLabel();
    JLabel calcLabel = new JLabel();
    JLabel exitLabel = new JLabel(); 
    JLabel passlabel = new JLabel();
    JLabel about = new JLabel();
    JLabel members = new JLabel();


    public UIHandler() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Boolean Product Calculator");
        this.setLayout(null);  
        this.setSize(screensize.width, screensize.height);
        this.setIconImage(frameIcon);   

        //Description for home
        homeDesc.setBounds(815, 410, 500, 200);
        homeDesc.setFont(new Font("Calibri", Font.PLAIN, 18));
        homeDesc.setText("<html>The Boolean Matrix Product Calculator multiplies two boolean<br>matrices using logical operations— AND for multiplication and<br>OR for addition. It's a useful tool for application in<br>computer science, digital circuits, ang graph theory.</html>");
        homeDesc.setForeground(Color.gray);
        this.add(homeDesc);

        //Exit Button
        resizeExitImg();
        exitLabel.setText("Exit");
        exitLabel.setFont(new Font("Calibri", Font.BOLD, 23));
        exitLabel.setForeground(Color.gray);
        exitLabel.setHorizontalTextPosition(JLabel.CENTER);
        exitLabel.addMouseListener(this);
        this.add(exitLabel);

        //Home Visuals
        resizePassImg();
        //this.add(passlabel);

        //About
        about.setText("ABOUT");
        about.setFont(new Font("Calibri", Font.PLAIN, 15));
        about.setBounds(300, 10, 50,50);
        about.setForeground(Color.gray);
        about.addMouseListener(this);
        this.add(about);

        //Members
        members.setText("MEMBERS");
        members.setFont(new Font("Calibri", Font.PLAIN, 15));
        members.setBounds(500, 10, 100,50);
        members.setForeground(Color.gray);
        members.addMouseListener(this);
        this.add(members);
        

        //Calculate Button
        resize();
        calcLabel.setText("Calculate");
        calcLabel.setFont(new Font("Calibri", Font.BOLD, 28));
        calcLabel.setForeground(Color.black);
        calcLabel.setHorizontalTextPosition(JLabel.CENTER);
        calcLabel.addMouseListener(this);
        this.add(calcLabel);

        //Title text
        titlepanel.setOpaque(false);
        titlepanel.setBounds(800, 300, 500, 200); 
        this.add(titlepanel);



        Homelabel.setBackground(Color.BLACK);
        Homelabel.setBounds(0, 0, screensize.width, screensize.height);
        Homelabel.setOpaque(true);
        this.add(Homelabel);

        this.addMouseListener(this);

        this.setVisible(true);
    }

    public void resize() {

        image = calcButton.getImage();
        int width = 200;
        int height = (int) ((double)image.getHeight(null)/image.getWidth(null) * width);
        image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        
        ImageIcon resizedIcon = new ImageIcon(image);
        calcLabel.setIcon(resizedIcon);

        calcLabel.setBounds(810, 580, width, height);
    }

    public void resizeExitImg() {
        image = exitImg.getImage();
        int width = 150;
        int height = (int) ((double)image.getHeight(null)/image.getWidth(null) * width);
        image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        
        ImageIcon resizedIcon = new ImageIcon(image);
        exitLabel.setIcon(resizedIcon);
        exitLabel.setBounds(1030, 600, width, height);
    }

    public void resizePassImg() {
        image = passImg.getImage();
        int width = 300;
        int height = (int) ((double)image.getHeight(null)/image.getWidth(null) * width);
        image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        ImageIcon resizedIcon = new ImageIcon(image);
        passlabel.setIcon(resizedIcon);
        passlabel.setBounds(90, 200, width, height);
    }

    public void hover() {

        image = calcButton.getImage();
        int width = 240;
        int height = (int) ((double)image.getHeight(null)/image.getWidth(null) * width);
        image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        
        ImageIcon resizedIcon = new ImageIcon(image);
        calcLabel.setIcon(resizedIcon);

        calcLabel.setBounds(810, 580, width, height);
    }

    public void hoverexit() {
        image = exitImg.getImage();
        int width = 170;
        int height = (int) ((double)image.getHeight(null)/image.getWidth(null)*width);
        image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        ImageIcon resizedIcon = new ImageIcon(image);
        exitLabel.setIcon(resizedIcon);
        exitLabel.setBounds(1030, 600, width, height);
    }



    JPanel titlepanel = new JPanel() {  
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); 
            Graphics2D g2d = (Graphics2D) g; 

        
            GradientPaint gradient = new GradientPaint(0, 0, new Color(76, 193, 55), getWidth(), getHeight(), new Color(251, 197, 49));
            g2d.setPaint(gradient);

        
            Font font = new Font("Sans-serif", Font.BOLD, 65);
            g2d.setFont(font);
            String title1 = "Boolean Matrix";
            String title2 = "Product";

            FontMetrics fm = g2d.getFontMetrics();
            int x1 = (getWidth() - fm.stringWidth(title1)) / 2;
            int x2 = x1;

            int y1 = (getHeight() - fm.getAscent()) / 2 - 10;
            int y2 = y1 + fm.getAscent() + 10;

           
            g2d.drawString(title1, x1, y1);
            g2d.drawString(title2, x2, y2);
        }
    };

    

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==calcLabel) {
            hover();
            calcLabel.revalidate();
            calcLabel.repaint();
        }
        if (e.getSource()==exitLabel) {
            hoverexit();
            exitLabel.revalidate();
            exitLabel.repaint();
        }
        }


    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==calcLabel) {
            resize();
            calcLabel.revalidate();
            calcLabel.repaint();
        }
        if(e.getSource()==exitLabel) {
            resizeExitImg();;
            exitLabel.revalidate();
            exitLabel.repaint();
        }
    }


}

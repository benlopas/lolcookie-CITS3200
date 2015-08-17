import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.UIManager;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.Input;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.AWTEvent;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.ImageProducer;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Scrollbar;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class SimpleOpticsTwoPointZero {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	public String mouse = "No Input Yet";
	boolean SomethingIsSelected = false;
	JLabel lblNewLabel;
	int coX = 33;
	int coY = 91;
	int x_pressed = 0;
    int y_pressed = 0;
    int x_released = 0;
    int y_released = 0;
    private JTable table;
    Icon Number1;
    JLabel newLabel;
    private JTextField textField_2;
    
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleOpticsTwoPointZero window = new SimpleOpticsTwoPointZero();
					window.frame.setVisible(true);
					} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	
	/**
	 * Create the application.
	 */
	public SimpleOpticsTwoPointZero() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBackground(Color.WHITE);
		frame.setBounds(0,0,1600,850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		

		/*class graphers extends JFrame {

			public void paint(Graphics g){
				g.setColor(Color.RED);
				g.drawLine(0, 0, 500, 500);
			}
		}
		graphers gr = new graphers();
        frame.add(gr);*/
		

		String[] filename = {"Laser.png","Modulator.png","Fibre_link.png","Link.png","Mirror.png","aom.png","mix.png","pd.png","fs.png"};
        Icon[] pics = {new ImageIcon(getClass().getResource(filename[0])),
                           new ImageIcon(getClass().getResource(filename[1])),
                           new ImageIcon(getClass().getResource(filename[2])),
                           new ImageIcon(getClass().getResource(filename[3])),
                           new ImageIcon(getClass().getResource(filename[4])),
        				   new ImageIcon(getClass().getResource(filename[5])),
        				   new ImageIcon(getClass().getResource(filename[6])),
        				   new ImageIcon(getClass().getResource(filename[7])),
        				   new ImageIcon(getClass().getResource(filename[8]))};
		
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(31, 28, 297, 39);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("Laser");
		comboBox.addItem("Modulator");
		comboBox.addItem("Fibre_link");
		comboBox.addItem("Link");
		comboBox.addItem("Mirror");
		comboBox.addItem("aom");
		comboBox.addItem("mix");
		comboBox.addItem("photo_detector");
		comboBox.addItem("frequency_selector");
		
	 
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(coX, coY, 225, 75);
		frame.getContentPane().add(lblNewLabel);
		
		
		Scrollbar scrollbar = new Scrollbar();
		scrollbar.setBounds(1569, 10, 17, 853);
		frame.getContentPane().add(scrollbar);
		
		JLabel lblFrequency = new JLabel("Frequency:");
		lblFrequency.setForeground(Color.WHITE);
		lblFrequency.setBounds(31, 195, 65, 14);
		frame.getContentPane().add(lblFrequency);
		
		JLabel lblPower = new JLabel("Power:");
		lblPower.setForeground(Color.WHITE);
		lblPower.setBounds(31, 231, 46, 14);
		frame.getContentPane().add(lblPower);
		
		textField = new JTextField();
		textField.setBounds(113, 189, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(113, 225, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		
		
		
		
        
        newLabel = new JLabel("");
		newLabel.setForeground(Color.BLACK);
		newLabel.setBackground(Color.WHITE);
		newLabel.setBounds(coX, coY, 225, 75);
		frame.getContentPane().add(newLabel);
		
		lblNewLabel.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e) {
                //catching the current values for x,y coordinates on screen
                x_pressed = e.getX();
                y_pressed = e.getY();
             
            }
        });
		
		JLabel linkcomp = new JLabel("");
		linkcomp.setForeground(Color.WHITE);
		linkcomp.setBackground(Color.BLACK);
		linkcomp.setBounds(113, 299, 75, 75);
		frame.getContentPane().add(linkcomp);
		linkcomp.setIcon(pics[3]);
		
		JLabel newlink = new JLabel("New Link");
		newlink.setForeground(Color.WHITE);
		newlink.setBounds(31, 305, 65, 20);
		frame.getContentPane().add(newlink);
		
		
		
		
		
		
		
		if(Mouse.getEventButton() != -1 && (113 < x_pressed && 188 < x_pressed) && (299 < y_pressed && 374 < y_pressed))
			if(Mouse.isButtonDown(0))
				
				
				
				
		
		
        
        
        comboBox.addItemListener(
                new ItemListener(){
                    public void itemStateChanged(ItemEvent event){
                        if(event.getStateChange()==ItemEvent.SELECTED){
                            lblNewLabel.setIcon(pics[comboBox.getSelectedIndex()]);
                        }
                           
                            
                       }
                  }
                );
        
        comboBox.addItemListener(
                new ItemListener(){
                    public void itemStateChanged(ItemEvent event){
                        if(event.getStateChange()==ItemEvent.SELECTED)
                            newLabel.setIcon(pics[comboBox.getSelectedIndex()]);
                           
                            
                       }
                  }
                );
        
		
        
        
        
        lblNewLabel.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e) {
                //catching the current values for x,y coordinates on screen
                x_pressed = e.getX();
                y_pressed = e.getY();
             
            }
        });
        
        newLabel.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e) {
                //catching the current values for x,y coordinates on screen
                x_pressed = e.getX();
                y_pressed = e.getY();
             
            }
        });

        lblNewLabel.addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseDragged(MouseEvent e){
                //and when lblNewLabel is dragged
                lblNewLabel.setLocation(e.getXOnScreen() - x_pressed, e.getYOnScreen() - y_pressed);
               
            }
          }
        );
        
        newLabel.addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseDragged(MouseEvent e){
                //and when lblNewLabel is dragged
                newLabel.setLocation(e.getXOnScreen() - x_pressed, e.getYOnScreen() - y_pressed);
               
            }
          }
        );
        
        lblNewLabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseReleased(MouseEvent r){
            	x_released = r.getX();
            	y_released = r.getY();
                //and when lblNewLabel is released
            	lblNewLabel.setLocation(r.getXOnScreen() - x_pressed, r.getYOnScreen() - y_pressed);
               
            }
          }
        );
        String[] names = new String[501];
        for(int i = 1; i<=500; i++){
        	names[i] = "label"+i+"s";
        	JLabel newerlabel = new JLabel(names[i]);
    		newerlabel.setForeground(Color.BLACK);
    		newerlabel.setBackground(Color.WHITE);
    		newerlabel.setBounds(coX, coY, 225, 75);
    		frame.getContentPane().add(newerlabel);
    		
    		comboBox.addItemListener(
                    new ItemListener(){
                        public void itemStateChanged(ItemEvent event){
                            if(event.getStateChange()==ItemEvent.SELECTED)
                                newerlabel.setIcon(pics[comboBox.getSelectedIndex()]);
                               
                                
                           }
                      }
                    );
    		
    		newerlabel.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mousePressed(MouseEvent e) {
                    //catching the current values for x,y coordinates on screen
                    x_pressed = e.getX();
                    y_pressed = e.getY();
                 
                }
            });
    		
    		newerlabel.addMouseMotionListener(new MouseMotionAdapter(){
                @Override
                public void mouseDragged(MouseEvent e){
                    //and when lblNewLabel is dragged
                    newerlabel.setLocation(e.getXOnScreen() - x_pressed, e.getYOnScreen() - y_pressed);
                   
                }
              }
            );
    		
    		newerlabel.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseReleased(MouseEvent r){
                	x_released = r.getX();
                	y_released = r.getY();
                    //and when lblNewLabel is released
                	newerlabel.setLocation(r.getXOnScreen() - x_pressed, r.getYOnScreen() - y_pressed);
                   
                }
              }
            );

    		
        }
        
        
        
        newLabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseReleased(MouseEvent r){
            	x_released = r.getX();
            	y_released = r.getY();
                //and when lblNewLabel is released
            	newLabel.setLocation(r.getXOnScreen() - x_pressed, r.getYOnScreen() - y_pressed);
               
            }
          }
        );
        
        for(int i = 1; i <=16 ; i++)
	           for(int j = 1; j<=11; j++)
	           {
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBorder(new LineBorder(Color.GREEN, 2));
		panel.setBounds(338, 28, 75*i, 75*j);
		frame.getContentPane().add(panel);
	           }
        
        
        
        
			
       

			}
	}


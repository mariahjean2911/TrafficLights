package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {

        public static void main(String[] args) {
            TrafficLight m1 = new TrafficLight();
            m1.setTitle("Traffic Light Operator");
            m1.setSize(300, 500);
            m1.setVisible(true);
            m1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }

        static class TrafficLight extends JFrame implements ActionListener {

            int  action = 0;
            JButton click;
            Container light;

            TrafficLight() {
                light = getContentPane();
                light.setLayout(new FlowLayout());
                click = new JButton("Click Here to Change The Color Of The Light");
                click.addActionListener(this);
                light.add(click);
            }
            public void paint (Graphics g) {

                super.paint(g);
                final int WIDTH = 175, HEIGHT = 350;

                g.setColor(Color.BLACK);
                g.fill3DRect(40, 80, WIDTH, HEIGHT, true);

                if(action == 0) {
                    Graphics2D redLight = (Graphics2D) g;
                    redLight.drawOval(87, 100, 80, 80);
                    redLight.setPaint(Color.red);
                    redLight.fillOval(87, 100, 80, 80);
                    action = 1; }
                else if (action == 1) {
                    Graphics2D yellowLight = (Graphics2D) g;
                    yellowLight.drawOval(87, 200, 80, 80);
                    yellowLight.setPaint(Color.yellow);
                    yellowLight.fillOval(87, 200, 80, 80);
                    action = 2;
                }
                else if (action == 2) {
                    Graphics2D greenLight = (Graphics2D) g;
                    greenLight.drawOval(87, 320, 80, 80);
                    greenLight.setPaint(Color.green);
                    greenLight.fillOval(87, 320, 80, 80);
                    action = 0;
                }
            }
            public void actionPerformed(ActionEvent e) {
                repaint(87, 80, 80, 80);
                repaint(87, 200, 80, 80);
                repaint(87,320, 80, 80);
            }
        }
    }

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucaskarwal
 */
public class Controller extends View implements ActionListener{
    
    
    public Controller() {
        addActionListeners();
        setBombs();
        calculateScores();
    }
    
    private void addActionListeners() {
        for(Cell c : cells)
            c.addActionListener(this);
    }
    
    private void setBombs() {
        for(int i = 0; i < 40; i++) {
            Random r = new Random();
            int num = r.nextInt(255);
            System.out.println(num);
            Cell c = cells.get(num);
            c.setBomb(true);
        }
    }
    
    private void calculateScores() {
        for(Cell c : cells) {
            if(c.getNum() == 15 || c.getNum() == 31 || c.getNum() == 47 || c.getNum() == 63 || c.getNum() == 79 || c.getNum() == 95 || c.getNum() == 111 || c.getNum() == 127 || c.getNum() == 143 || c.getNum() == 159 
                    || c.getNum() == 175 || c.getNum() == 191 || c.getNum() == 207 || c.getNum() == 223 || c.getNum() == 239 || c.getNum() == 255) {
                try {
                    if(cells.get(c.getNum() - 17).isBomb())
                        c.setScore(c.getScore() + 1);
                } catch(Exception e){}
                try {
                    if(cells.get(c.getNum() - 16).isBomb())
                        c.setScore(c.getScore() + 1);
                } catch(Exception e){}
                try {
                    if(cells.get(c.getNum() - 1).isBomb())
                        c.setScore(c.getScore() + 1);
                } catch(Exception e){}
                try {
                    if(cells.get(c.getNum() + 16).isBomb())
                        c.setScore(c.getScore() + 1);
                } catch(Exception e){}
                try {
                    if(cells.get(c.getNum() + 15).isBomb())
                        c.setScore(c.getScore() + 1);
                } catch(Exception e){}
            }
            
            else if(c.getNum() == 0 || c.getNum() == 16 || c.getNum() == 32 || c.getNum() == 48 || c.getNum() == 64 || c.getNum() == 80 || c.getNum() == 112 || c.getNum() == 128 || c.getNum() == 144 || c.getNum() == 160 
                    || c.getNum() == 176 || c.getNum() == 192 || c.getNum() == 208 || c.getNum() == 224 || c.getNum() == 240 || c.getNum() == 256) {
                try {
                    if(cells.get(c.getNum() - 16).isBomb())
                        c.setScore(c.getScore() + 1);
                } catch(Exception e){}
                try {
                    if(cells.get(c.getNum() - 15).isBomb())
                        c.setScore(c.getScore() + 1);
                } catch(Exception e){}
                try {
                    if(cells.get(c.getNum() + 1).isBomb())
                        c.setScore(c.getScore() + 1);
                } catch(Exception e){}
                try {
                    if(cells.get(c.getNum() + 17).isBomb())
                        c.setScore(c.getScore() + 1);
                } catch(Exception e){}
                try {
                    if(cells.get(c.getNum() + 16).isBomb())
                        c.setScore(c.getScore() + 1);
                } catch(Exception e){}
            }
                
            else {
                try {
                    if(cells.get(c.getNum() - 17).isBomb())
                        c.setScore(c.getScore() + 1);
                } catch(Exception e){}
                try {
                    if(cells.get(c.getNum() - 16).isBomb())
                        c.setScore(c.getScore() + 1);
                } catch(Exception e){}
                try {
                    if(cells.get(c.getNum() - 15).isBomb())
                        c.setScore(c.getScore() + 1);
                } catch(Exception e){}
                try {
                    if(cells.get(c.getNum() - 1).isBomb())
                        c.setScore(c.getScore() + 1);
                } catch(Exception e){}
                try {
                    if(cells.get(c.getNum() + 1).isBomb())
                        c.setScore(c.getScore() + 1);
                } catch(Exception e){}
                try {
                    if(cells.get(c.getNum() + 17).isBomb())
                        c.setScore(c.getScore() + 1);
                } catch(Exception e){}
                try {
                    if(cells.get(c.getNum() + 16).isBomb())
                        c.setScore(c.getScore() + 1);
                } catch(Exception e){}
                try {
                    if(cells.get(c.getNum() + 15).isBomb())
                        c.setScore(c.getScore() + 1);
                } catch(Exception e){}
            }
        }
    }
    
    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button " + e.getSource());
        int type = e.getModifiers();
        if(type != 20) {
            Cell c = (Cell) e.getSource();
            if(c.isBomb()) {
                System.out.println("BOMB");
                for(Cell cell : cells)
                    cell.setEnabled(false);
            }
            else {
                c.setText(""+c.getScore());
                c.setEnabled(false);
            }
        }
        if(type == 20) {
            Cell c = (Cell) e.getSource();
            c.setEnabled(false);
            c.setText("B");
        }
        
        //after every click check to see if there are any enabled buttons left to check to see if the game is over
        //if the game is over check to see if all of the bombs are correct

    }
    
    
    
    public static void main(String[] args) {
        new Controller();
    }
}

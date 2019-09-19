import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.sound.sampled.LineEvent.Type;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.Timer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

@SuppressWarnings({ "unused", "serial" })
public class PuzzleRunner extends JPanel
	{
		public int xPos;
		public String[][] grid = new String[3][3];

		public static void main(String[] args)
			{
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				JFrame frame = new JFrame("BlockPuzzle");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(1000, 880);
				PuzzleRunner game = new PuzzleRunner();
				frame.add(game);
				frame.setVisible(true);
				frame.setResizable(false);
				game.setFocusable(true);
				frame.setLocation((int)(screenSize.getWidth() / 2) - 300, (int)(screenSize.getHeight() / 2) - 380);
			}
		
		public PuzzleRunner()
		{
			generateGrid();
			setBackground(Color.BLACK);
			Timer timer = new Timer(10, new ActionListener(){
				public void actionPerformed(ActionEvent arg0)
				{
					repaint();
//					xPos +=1;
					
				}
			});
			timer.start();
		}
		
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.setColor(Color.GREEN);
			int x = 200;
			int y = 100;
			for(int r = 0; r < 3; r++)
				{
					for(int c = 0; c < 3; c++)
						{
							if(!grid[r][c].equals(""))
								{
									g.fillRect(x, y, 200, 200);
									g.setColor(Color.BLACK);
									g.drawString(grid[r][c], x + 100, y + 100);
									g.setColor(Color.GREEN);
								}
							x += 201;
						}
					x = 200;
					y += 201;
				}
		}
		
		public void generateGrid()
		{
			grid = new String[3][3];
			for(int i = 0; i < 3; i++)
				for(int j = 0; j < 3; j++)
					grid[i][j] = "";
			String[] vals = {"a","b","c","d","e","f","g","h"};
			for(String s: vals)
				{
					boolean placed = false;
					while(!placed)
						{
							int r = (int) (Math.random() * 3);
							int c = (int) (Math.random() * 3);
							if(grid[r][c].isEmpty())
								{
									grid[r][c] = s;
									placed = true;
								}
						}
				}
		}
		public void printGrid()
		{
			for(String[] g: grid)
				{
					for(String s: g)
						{
							System.out.print(s + " ");
						}
					System.out.println("\n");
				}
		}

	}

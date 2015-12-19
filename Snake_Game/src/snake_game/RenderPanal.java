package snake_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class RenderPanal extends JPanel{
    
    public static final Color GREEN = new Color(0);

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Snake_Game snake = Snake_Game.snake;

		g.setColor(GREEN); 
		
		g.fillRect(0, 0, 800, 700);

		g.setColor(Color.BLUE);

		for (Point point : snake.snakeParts)
		{
			g.fillRect(point.x * Snake_Game.SCALE, point.y * Snake_Game.SCALE, Snake_Game.SCALE, Snake_Game.SCALE);
		}
		
		g.fillRect(snake.head.x * Snake_Game.SCALE, snake.head.y * Snake_Game.SCALE, Snake_Game.SCALE, Snake_Game.SCALE);
		
		g.setColor(Color.RED);
		
		g.fillRect(snake.cherry.x * Snake_Game.SCALE, snake.cherry.y * Snake_Game.SCALE, Snake_Game.SCALE, Snake_Game.SCALE);
		
		String string = "Score: " + snake.score + ", Length: " + snake.tailLength + ", Time: " + snake.time / 20;
		
		g.setColor(Color.white);
		
		g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), 10);

		string = "Game Over!";

		if (snake.over)
		{
			g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), (int) snake.dim.getHeight() / 4);
		}

		string = "Paused!";

		if (snake.paused && !snake.over)
		{
			g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), (int) snake.dim.getHeight() / 4);
		}
	}
    
}

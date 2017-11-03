package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject {
	
	private Handler handler;

	public BasicEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;

		velX = 5;
		velY = 5;
		
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 16, 16);
	}

	public void tick() {
		x += velX;
		y += velY;

		if(y <= 0 || y >= Game.HEIGHT - 44) velY *= -1;
		if(y <= 0 || x >= Game.WIDTH - 32) velX *= -1;
		
	}
	

	public void render(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(x, y, 16, 16); 
	}

}

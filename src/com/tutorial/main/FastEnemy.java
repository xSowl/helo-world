package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FastEnemy extends GameObject {
	
	private Handler handler;

	public FastEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;

		velX = 2;
		velY = 9;
		
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, 16, 16);
	}

	public void tick() {
		x += velX;
		y += velY;

		if(y <= 0 || y >= Game.HEIGHT - 44) velY *= -1;
		if(y <= 0 || x >= Game.WIDTH - 32) velX *= -1;
		
	}
	

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 15, 15);
	}

}

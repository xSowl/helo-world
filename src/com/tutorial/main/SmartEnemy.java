package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject {
	
	private Handler handler;
	private GameObject player;

	public SmartEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		for(int i = 0; i < handler.object.size(); i++){
			if(handler.object.get(i).getid() == ID.Player) player = handler.object.get(i);
		}
		
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x,(int) y, 16, 16);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		int diffX = x - player.getX() - 5;
		int diffy = y - player.getY() - 5;
		int distance = (int) Math.sqrt((x-player.getX())*(x-player.getX()) + (y-player.getY())*(y-player.getY()));
		
		velX = (int) ((-1.0/distance) * diffX);
		velY = (int) ((-1.0/distance) * diffy);

		//if(y <= 0 || y >= Game.HEIGHT - 44) velY *= -1;
		//if(x <= 0 || x >= Game.WIDTH - 32) velX *= -1;
		
	}
	

	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect((int)x, (int)y, 15, 15);
	}

}

package com.onauj.entities;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.image.BufferedImage;

import com.onauj.main.Game;
import com.onauj.world.Camera;
import com.onauj.world.World;


public class Player extends Entity{

	
	public boolean right,left;
	

	

	
	public int dir = 1;
	private double gravity = 2*speed;
	
	public boolean jump = false;
	
	public boolean isJumping = false;
	public int jumpHeight = 48;
	public int jumpFrames = 0;
	
	private int framesAnimation = 0;
	private int maxFrames = 15;
	
	private int maxSprite = 2;
	private int curSprite = 0;
	
	public Player(int x, int y, int width, int height,double speed,BufferedImage sprite) {
		super(x, y, width, height,speed,sprite);
		
	}
	
	public void tick(){
		depth = 2;
		if(World.isFree((int)x,(int)(y+(gravity+height/2))) && isJumping == false) {
			y+=gravity;
		}
		if(right && World.isFree((int)(x+speed), (int)y)) {
			x+=speed;
			dir = 1;
		}
		else if(left && World.isFree((int)(x-speed), (int)y)) {
			x-=speed;
			dir = -1;
		}
		
		if(jump) {
			if(!World.isFree(this.getX(),this.getY()+1)) {
				isJumping = true;
			}else {
				jump = false;
			}
		}
		
		if(isJumping) {
			if(World.isFree(this.getX(), this.getY()-2)) {
				y-=2;
				jumpFrames+=2;
				if(jumpFrames == jumpHeight) {
					isJumping = false;
					jump = false;
					jumpFrames = 0;
				}
			}else {
				isJumping = false;
				jump = false;
				jumpFrames = 0;
			}
		}
		
		
		Camera.x = Camera.clamp((int)x - Game.WIDTH / 2, 0, World.WIDTH * 16 - Game.WIDTH);
		Camera.y = Camera.clamp((int)y - Game.HEIGHT / 2, 0, World.HEIGHT * 16 - Game.HEIGHT);
		
		
	}
	
	public void render(Graphics g){
		framesAnimation++;
		if(framesAnimation == maxFrames) {
			curSprite++;
			framesAnimation = 0;
			if(curSprite == maxSprite) {
				curSprite = 0;
			}
		}
		
		if(Game.debug_mode) {
			g.setColor(Color.DARK_GRAY);
			g.setFont(new Font("arial",Font.ITALIC,16));
			g.drawString("X:"+this.getX()+"\n Y:"+this.getY(), this.getX() + Camera.x,this.getY() + Camera.y-64 );
			g.setColor(Color.red);
			g.drawRect(this.getX() + Camera.x,this.getY() + Camera.y, width, height);
			
			g.drawLine((int)(x), (int)y, (int)(x), (int)(y+(100*gravity)));
		}
		super.render(g);
	}
	

	


}

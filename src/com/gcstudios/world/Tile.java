package com.gcstudios.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;

public class Tile {
	
	private static int size = 80;
	public static BufferedImage TILE_FLOOR = Game.spritesheet.getSprite(0,0,size,size);
	public static BufferedImage TILE_GRASS = Game.spritesheet.getSprite(80,0,size, size);
	public static BufferedImage TILE_DIRT = Game.spritesheet.getSprite(80,0,size, size);
	public static BufferedImage TILE_WOOD = Game.spritesheet.getSprite(0,160,size,size);
	public static BufferedImage TILE_DIAMOND = Game.spritesheet.getSprite(320,size,size,size);
	public static BufferedImage TILE_STONE = Game.spritesheet.getSprite(160,0,size,size);

	private BufferedImage sprite;
	private int x,y;
	
	public Tile(int x,int y,BufferedImage sprite){
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		
		System.out.println(x+"/"+y);
	}
	
	public void render(Graphics g){
		g.drawImage(sprite, x - Camera.x, y - Camera.y, null);
	}

}

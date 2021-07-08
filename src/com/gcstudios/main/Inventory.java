package com.gcstudios.main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gcstudios.world.Tile;

public class Inventory {
	
	
	public String[] items = {"wood", "dirt", "stone", "diamond", "",""};
	public int initialPosition = (Game.WIDTH/2) - (Game.pxSize*items.length)/2;
	
	public int selected = -1;
	public boolean isPressed = false;
	public int mx,my; 
	
	public int offset = 36;
	public int offsetY = Game.HEIGHT-(Game.pxSize+offset);
	public boolean isPlaceItem = false;
	
	public void itemsRender(BufferedImage sprite, int offsetX, int offsetY, int offsetSize, Graphics g, int selected) {
		
		int offsetSize2 = offsetSize/10;
		if(this.selected == selected) {
			
			offsetSize2 = offsetSize/-30;
			g.setColor(new Color(10,10,10,100));
			g.fillRect(offsetX + offsetSize2+6, offsetY + offsetSize2+3, offsetSize-1, offsetSize-1);
			
			g.setColor(new Color(255,255,255,36));
			g.drawImage(sprite, offsetX + offsetSize2, offsetY + offsetSize2, offsetSize, offsetSize, null);
			g.fillRect(offsetX + offsetSize2, offsetY + offsetSize2, offsetSize, offsetSize);
			
			g.setColor(Color.red);
			g.drawRect(offsetX + offsetSize2, offsetY + offsetSize2, offsetSize, offsetSize);

		} else {
			g.setColor(new Color(10,10,10,100));
			g.fillRect(offsetX + offsetSize2+6, offsetY + offsetSize2+3, offsetSize-1, offsetSize-1);
			g.setColor(new Color(10,10,10,66));
			
			g.drawImage(sprite, offsetX + offsetSize2, offsetY + offsetSize2, offsetSize, offsetSize, null);
			g.drawRect(offsetX + offsetSize2, offsetY + offsetSize2, offsetSize, offsetSize);
		}
	}
	
	public void tick() {
		if(isPressed) {
			isPressed = false;
			System.out.println(!(mx >= initialPosition) && !(mx <initialPosition+ (Game.pxSize*items.length)));
			if(mx >= initialPosition && mx <initialPosition+ (Game.pxSize*items.length) && my >= offsetY && my < Game.HEIGHT-Game.pxSize/2-1) {
				selected = (mx-initialPosition)/Game.pxSize;
				isPressed = false;
			}else {
				isPressed = false;
				selected = -1;
			}
		}
	}
	
	
	public void render(Graphics g) {
		for(int i = 0; i < items.length; i++) {
			int offsetX = initialPosition + (i*Game.pxSize)+5;
			int offsetSize =  Game.pxSize-10;
			
			g.setColor(new Color(10,10,10,30));
			g.fillRect(initialPosition + (i*Game.pxSize)+5, Game.HEIGHT-(Game.pxSize+offset), Game.pxSize, Game.pxSize);
			
			if(i == items.length-1) {
				
				g.setColor(Color.black);
				g.drawRect(initialPosition+5, offsetY, Game.pxSize*(i+1), Game.pxSize);	
			}
			if(items[i] == "dirt") {
				itemsRender(Tile.TILE_DIRT, offsetX, offsetY, offsetSize, g, i);      				
			
			}
			if(items[i] == "wood") {
				
				itemsRender(Tile.TILE_WOOD, offsetX, offsetY, offsetSize, g, i);
			}
			
			if(items[i] == "stone") {
				itemsRender(Tile.TILE_STONE, offsetX, offsetY, offsetSize, g, i);
			}
			if(items[i] == "diamond") {
				itemsRender(Tile.TILE_DIAMOND, offsetX, offsetY, offsetSize, g, i);
			}
			

		}
		
		if(Game.debug_mode) {
			g.setColor(Color.red);
			
			g.drawLine(0,Game.HEIGHT - (Game.pxSize+offset+10), Game.WIDTH/2,Game.HEIGHT - (Game.pxSize+offset+10));
			g.drawLine(0,Game.HEIGHT - (Game.pxSize/2)+5, Game.WIDTH/2,Game.HEIGHT - (Game.pxSize/2)+5);
			
			g.fillOval( Game.WIDTH/2,Game.HEIGHT - (Game.pxSize+offset/6+10)-offset, offset/4, offset/4);
			g.fillOval( Game.WIDTH/2,Game.HEIGHT - (Game.pxSize/2+offset/6)+5, offset/4, offset/4);
		}
	}
}

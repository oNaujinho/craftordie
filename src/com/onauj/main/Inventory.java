package com.onauj.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


import com.onauj.world.Tile;

public class Inventory {
	
	
	public String[] items = {"wood", "dirt", "stone", "diamond", "",""};
	public int initialPosition = (Game.WIDTH/2) - (Game.pxSize*items.length)/2;
	
	public static int selected = -1;
	public boolean isPressed = false;
	public int mx,my; 
	
	public boolean isPlaceItem = false;
	
	private int offset = 36;
	private int offsetY = Game.HEIGHT-(Game.pxSize+offset);
	private int offsetX;
	private int offsetSize;
	
	public void tick() {
		if(isPressed) {
			isPressed = false;
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
			
			offsetX = initialPosition + (i*Game.pxSize)+5;
			offsetSize = Game.pxSize-10;
			
			hotbarRender(i, g);
			
			if(items[i] == "dirt") {
				itemsRender(Tile.TILE_DIRT, offsetX, i, g);      				
			}
			if(items[i] == "wood") {	
				itemsRender(Tile.TILE_WOOD, offsetX, i, g);
			}
			if(items[i] == "stone") {
				itemsRender(Tile.TILE_STONE, offsetX, i, g);
			}
			if(items[i] == "diamond") {
				itemsRender(Tile.TILE_DIAMOND, offsetX, i, g);
			}
		}
	}
	
	public void itemsRender(BufferedImage sprite, int offsetX, int selected, Graphics g) {
		
		int offsetSize2 = offsetSize/10;
		if(Inventory.selected == selected) {
			
			//Quando o item é selecionado
			offsetSize2 = offsetSize/-30;
			g.setColor(new Color(10,10,10,100));
			g.fillRect(offsetX + offsetSize2+6, offsetY + offsetSize2+3, offsetSize-1, offsetSize-1);
			
			g.setColor(new Color(255,255,255,36));
			g.drawImage(sprite, offsetX + offsetSize2, offsetY + offsetSize2, offsetSize, offsetSize, null);
			g.fillRect(offsetX + offsetSize2, offsetY + offsetSize2, offsetSize, offsetSize);
			
			g.setColor(Color.red);
			g.drawRect(offsetX + offsetSize2, offsetY + offsetSize2, offsetSize, offsetSize);

		} else {
			//Quando o item não é selecionado
			g.setColor(new Color(10,10,10,100));
			g.fillRect(offsetX + offsetSize2+6, offsetY + offsetSize2+3, offsetSize-1, offsetSize-1);
			g.setColor(new Color(10,10,10,66));
			
			g.drawImage(sprite, offsetX + offsetSize2, offsetY + offsetSize2, offsetSize, offsetSize, null);
			g.drawRect(offsetX + offsetSize2, offsetY + offsetSize2, offsetSize, offsetSize);
		}
	}
	
	public void hotbarRender (int i, Graphics g) {
		g.setColor(new Color(10,10,10,30));
		g.fillRect(offsetX, offsetY, Game.pxSize, Game.pxSize);
			
		if(i == items.length-1) {
			
			g.setColor(Color.black);
			g.drawRect(initialPosition+5, offsetY, Game.pxSize*(i+1), Game.pxSize);	
		}
	}
		
}

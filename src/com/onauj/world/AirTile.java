package com.onauj.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class AirTile extends Tile{
	
	@SuppressWarnings("unused")
	private BufferedImage sprite;

	public AirTile(int x, int y, BufferedImage sprite) {
		super(x, y, sprite);
		this.sprite = sprite;
	}
	
	public void render(Graphics g) {
		this.sprite = null;
	}

}

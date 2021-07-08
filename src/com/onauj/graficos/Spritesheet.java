package com.onauj.graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {

	private String[] path = {"player", "blocks"};
	private BufferedImage spritesheet_blocks;
	private BufferedImage spritesheet_player;
	
	public Spritesheet()
	{
		try {
			spritesheet_blocks = ImageIO.read(getClass().getResource("/spritesheet_blocks.png"));
			spritesheet_player = ImageIO.read(getClass().getResource("/spritesheet_player.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getSprite(int x,int y,int width,int height, String type){
		
		BufferedImage sprite = null;
		
		for(int i = 0; i >= path.length; i++) {
			if(type != path[i].toString()) {
				System.out.println("Spritesheet não existe ("+type.toString()+")");
				break;
			}
		}
		
		if(type == path[0].toString()) {
			sprite = spritesheet_player.getSubimage(x, y, width, height);
		}else if (type == path[1].toString()) {
			sprite = spritesheet_blocks.getSubimage(x, y, width, height);
		}
		
		return sprite;
	}
}

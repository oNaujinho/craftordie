	package com.onauj.world;

import java.awt.Graphics;
import com.onauj.main.Game;

public class World {

	public static Tile[] tiles;
	public static int WIDTH,HEIGHT;
	public static final int TILE_SIZE = 64;
	
	
	public World(){
		WIDTH = Game.WIDTH/16;
		HEIGHT = Game.HEIGHT/16;
		
		
		tiles = new Tile[WIDTH*HEIGHT];
		for(int xx = 0; xx < WIDTH; xx++) {
			for(int yy = 0; yy < HEIGHT; yy++) {
				if(yy >= (Game.HEIGHT/TILE_SIZE) - 3) {
					
					tiles[xx+yy*WIDTH] = new GrassTile((xx*TILE_SIZE),yy*TILE_SIZE,Tile.TILE_GRASS);
				}else {
					tiles[xx+yy*WIDTH] = new AirTile(xx*TILE_SIZE,yy*TILE_SIZE,Tile.TILE_WOOD);
				}
			}
		}
	}
	
	public static boolean isFree(int xnext,int ynext){
		
		int x1 = xnext / TILE_SIZE;
		int y1 = ynext / TILE_SIZE;
		
		int x2 = (xnext+TILE_SIZE-1) / TILE_SIZE;
		int y2 = ynext / TILE_SIZE;
		
		int x3 = xnext / TILE_SIZE;
		int y3 = (ynext+TILE_SIZE-1) / TILE_SIZE;
		
		int x4 = (xnext+TILE_SIZE-1) / TILE_SIZE;
		int y4 = (ynext+TILE_SIZE-1) / TILE_SIZE;
		
		return !((tiles[x1 + (y1*World.WIDTH)] instanceof GrassTile) ||
				(tiles[x2 + (y2*World.WIDTH)] instanceof GrassTile) ||
				(tiles[x3 + (y3*World.WIDTH)] instanceof GrassTile) ||
				(tiles[x4 + (y4*World.WIDTH)] instanceof GrassTile));
	}
	
	public static void restartGame(){
		//TODO: Aplicar método para reiniciar o jogo corretamente.
		return;
	}
	
	public void render(Graphics g){

		
		int xstart = Camera.x >> 4;
		int ystart = Camera.y >> 4;
		
		int xfinal = xstart + (Game.WIDTH >> 4);
		int yfinal = ystart + (Game.HEIGHT >> 4);
		
		for(int xx = xstart; xx <= xfinal; xx++) {
			for(int yy = ystart; yy <= yfinal; yy++) {
				if(xx < 0 || yy < 0 || xx >= WIDTH || yy >= HEIGHT)
					continue;
				Tile tile = tiles[xx + (yy*WIDTH)];
				tile.render(g);
			}
		}
	}
	
}

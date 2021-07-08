package com.onauj.graficos;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.onauj.main.Game;
import com.onauj.main.Inventory;

public class UI {

	public void render(Graphics g) {
		if(Game.debug_mode) {
			
			//Debugando para observar se inventario está no centro e seleção atual;
			int offset = 36;
			g.drawString("Bloco selecionado: "+Inventory.selected,20 ,(Game.HEIGHT-23-offset));
			g.setColor(Color.red);
			
			g.drawLine(0,Game.HEIGHT - (Game.pxSize+offset+10), Game.WIDTH/2,Game.HEIGHT - (Game.pxSize+offset+10));
			g.drawLine(0,Game.HEIGHT - (Game.pxSize/2)+5, Game.WIDTH/2,Game.HEIGHT - (Game.pxSize/2)+5);
			
			g.fillOval( Game.WIDTH/2,Game.HEIGHT - (Game.pxSize+offset/6+10)-offset, offset/4, offset/4);
			g.fillOval( Game.WIDTH/2,Game.HEIGHT - (Game.pxSize/2+offset/6)+5, offset/4, offset/4);
			
			//FPS
			g.setColor(Color.GREEN);
			g.setFont(new Font("arial",Font.ITALIC,32));
			g.drawString(""+Game.FPS,16/2,32);
			
			//QUANTIDADE DE ENTIDADES
			int entities = 0;
			for(int i = 0; i <= Game.entities.size(); i++) entities = i;
			
			g.setColor(Color.DARK_GRAY);
			g.setFont(new Font("arial",Font.BOLD,19));
			g.drawString("Entidades: "+entities,20 ,Game.HEIGHT-23);

		}
	}
	
}

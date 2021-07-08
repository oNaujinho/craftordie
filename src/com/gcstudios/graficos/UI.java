package com.gcstudios.graficos;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.gcstudios.entities.Player;
import com.gcstudios.main.Game;

public class UI {

	public void render(Graphics g) {
		if(Game.debug_mode) {
			g.setColor(Color.GREEN);
			g.setFont(new Font("arial",Font.ITALIC,32));
			g.drawString(""+Game.FPS,16/2,32);
			int atualTubos = 0;
			for(int i = 0; i < Game.entities.size(); i++) atualTubos = i+1;
			
			g.setColor(Color.DARK_GRAY);
			g.setFont(new Font("arial",Font.BOLD,19));
			g.drawString("Entidades: "+atualTubos,20 ,Game.HEIGHT-23);

		}
	}
	
}

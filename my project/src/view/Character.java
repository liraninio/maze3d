package view;

import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;

import algorithmes.mazeGenerators.Position;

public class Character {
	private Position pos;
	private Image img;
	
	public Character() {
		img = new Image(null, getClass().getClassLoader().getResourceAsStream("resources/images/character.jpg"));
	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}
	
	public void draw(int x, int y, GC gc) {
		gc.drawImage(img, 0, 0, img.getBounds().width, img.getBounds().height, x * pos.getZ(), y * pos.getY(), x, y);
	}

}
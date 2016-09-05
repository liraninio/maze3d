package io;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import algorithmes.mazeGenerators.Maze3d;
import algorithmes.mazeGenerators.Position;
import algorithmes.mazeGenerators.randomCellTree;

public class Run {

//	private static Maze3d maze;

	public static void main(String[] args) throws IOException {
		
		Position p= new Position(5,5,5);
		Maze3d maze=new Maze3d(p);
		 maze=new randomCellTree().generate(p);
		
		// save it to a file
		OutputStream out=new MyCompressorOutputStream(
		new FileOutputStream("1.maz"));
		out.write(maze.toByteArray());
		out.flush();
		out.close();
		InputStream in=new MyDecompressorInputStream(new FileInputStream("1.maz"));
		byte b[]=new byte[maze.toByteArray().length];
		in.read(b);
		in.close();
		Maze3d loaded=new Maze3d(b);
		System.out.println(loaded.equals(maze));

		
		
		
	}

}
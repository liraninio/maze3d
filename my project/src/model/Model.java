package model;

import java.io.IOException;

public interface Model {
	public void m_generate(String nameMaze,int x,int y,int z,String alg);
	public void m_display(String name);
	public void m_display_cross_section(int num,String index,String name);
	public void m_save_maze(String mazeName,String fileName);
	public void m_load_maze(String fileName,String mazeName) throws IOException;
	public void m_solve(String mazeName,String alg);
	public void m_display_solution(String mazeName);
	public void m_exit();
}

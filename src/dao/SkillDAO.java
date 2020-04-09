package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Skill;
import utility.ConnectionManager;
public class SkillDAO{
	static List<Skill> skillList = new ArrayList<Skill>();
	 String insert_skills = "insert into skill values (?,?)";
	 String select_skills = "select * from skill order by name asc";
	
	public void insertSkills(Skill skill) throws SQLException, Exception {
		PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(insert_skills);
		ps.setLong(1, skill.getSkillid());
		ps.setString(2, skill.getSkillname());
		ps.executeUpdate();
		
	}
	
	public List<Skill> listAllSkills () throws SQLException, Exception {
		
		Skill skill;
		
		PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(select_skills);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
	
		//	System.out.print(rs.getLong("id")+"\t");
		//	System.out.println(rs.getString("name"));
			Long id= rs.getLong(1);
			
			String name= rs.getString(2);		
			skill = new Skill(id,name);
			skill.setSkillid(id);
			skill.setSkillname(name);
			skillList.add(skill);
		}
		
		return skillList;
		
	}
}

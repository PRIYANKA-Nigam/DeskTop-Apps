package medical;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.util.List;

public class JModelList {
public List<JModel> findAll(){
	List<JModel> list = new ArrayList<JModel>();
	try {
		PreparedStatement ps = db.getConnection().prepareStatement("select * from janitor");
		ResultSet rs =ps.executeQuery();
		while(rs.next()) {
		JModel jm = new JModel();
	//	jm.setId(rs.getInt("id"));
		jm.setName(rs.getString("name"));
		jm.setAge(rs.getInt("age"));
		jm.setGender(rs.getString("gender"));
		jm.setPost(rs.getString("post"));
		jm.setTime(rs.getString("timing"));
		jm.setPhoto(rs.getBytes("image"));
		list.add(jm);
		}
	}catch(Exception e) {
		list = null;
	}
	return list;
}

public boolean create(JModel jm){
	try {
		PreparedStatement ps = db.getConnection().prepareStatement("insert into janitor values(?,?,?,?,?,?)");
	 //   ps.setInt(1, jm.getId());
		ps.setString(1, jm.getName());
		ps.setInt(2, jm.getAge());
		ps.setString(3, jm.getGender());
		ps.setString(4,jm.getPost());
		ps.setString(5, jm.getTime());
	    ps.setBytes(6, jm.getPhoto());
	    return ps.executeUpdate()>0;
	}catch(Exception e) {
		return false;
	}
	
}
public boolean update(JModel jm){
	try {
		PreparedStatement ps = db.getConnection().prepareStatement("update image=? where age=?");
	 //   ps.setInt(1, jm.getId());
	    ps.setBytes(6, jm.getPhoto());
	    return ps.executeUpdate()>0;
	}catch(Exception e) {
		return false;
	}
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

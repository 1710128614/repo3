package dao.impl;

import dao.BaseDao;
import dao.StudentDao;
import entity.StudentInfo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl extends BaseDao implements StudentDao {
    @Override
    public List<StudentInfo> getAllInfos() {
        List<StudentInfo> infoList = new ArrayList<>();
        String sql = "SELECT `sid`,`sname`,`sgender`,`sage`,`saddress`,`semail` FROM `studentinfo`";
        ResultSet rs = null;
        try {
            rs = this.executeQuery(sql);
            while (rs.next()) {
                StudentInfo stu = new StudentInfo(rs.getInt("sid"), rs.getString("sname"),
                        rs.getString("sgender"), rs.getInt("sage"),
                        rs.getString("saddress"), rs.getString("semail"));
                infoList.add(stu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return infoList;
    }

    @Override
    public StudentInfo getAllInfosBySid(int sid) {
        StudentInfo stu = null;
        String sql = "SELECT `sid`,`sname`,`sgender`,`sage`,`saddress`,`semail` FROM `studentinfo` where `sid` =?";
        ResultSet rs = null;
        try {
            rs = this.executeQuery(sql, sid);
            if (rs.next()) {
                stu = new StudentInfo(rs.getInt("sid"), rs.getString("sname"),
                        rs.getString("sgender"), rs.getInt("sage"),
                        rs.getString("saddress"), rs.getString("semail"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stu;
    }

    @Override
    public int update(StudentInfo stu) {
        int result = 0;
        String sql = "UPDATE `studentinfo` SET `sname`=?,`sgender`=?,`sage`=?,`saddress`=?,`semail`=?  WHERE `sid`=?";
        result=this.executeUpdate(sql,stu);
        
        return result;
    }
}

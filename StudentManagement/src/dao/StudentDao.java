package dao;

import entity.StudentInfo;

import java.util.List;

public interface StudentDao {

    /**
     * 查询所有学员信息
     * @return
     */
    List<StudentInfo> getAllInfos();

    /**
     * 根据学员编号查询特定学员信息
     * @return
     */
    StudentInfo getAllInfosBySid(int sid);

    /**
     * 修改特定学员信息
     * @param stu
     * @return
     */
    int update(StudentInfo stu);
}

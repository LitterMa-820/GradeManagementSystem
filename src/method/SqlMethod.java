package method;
import dialog.ErrDialog;
import java_bean.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @ProjectName: StudentAchievementManagementSystem
 * @Package: PACKAGE_NAME
 * @ClassName: SqlMethod
 * @Author: 82042
 * @Description: 这个用于存放各种操作数据库的方法
 * @Date: 2020/8/14 23:55
 * @Version: 1.0
 */
public class SqlMethod {
    static User user=new User();//User对象用于存储用户
    static PreparedStatement pstmt=null;//sql执行对象
    static ResultSet resultSet=null;//结果集对象
    static Connection conn=null;//连接对象
    //登录方法
    public static boolean login(String id,String password){
        String sql="select *from user where hm=? and pwd=?";
        try {//异常处理
            conn= JDBCUtils.getConnection();//获取连接
            pstmt=conn.prepareStatement(sql);//获取执行sql对象
            pstmt.setString(1,id);//设置?中的内容
            pstmt.setString(2,password);
            resultSet = pstmt.executeQuery();//执行sql
            boolean loginFlag;//登录成功的标志
            loginFlag=resultSet.next();
            //获取用户名和权限
            String hm = resultSet.getString("hm");
            int role = resultSet.getInt("role");
            user.setUsername(hm);//使用user对象存储用户名和权限
            user.setRole(role);
            return loginFlag;
        } catch (SQLException e) {
            System.out.println("错误");
        }
        finally {
            JDBCUtils.close(resultSet,pstmt,conn);
        }
        return false;
    }
    //返回User对象的方法
    public static User getUser(){
        return user;
    }
    //查看学生表的方法
    public static ArrayList<Student> showS(){
        String sql="select * from s;";//查询语句
        ArrayList<Student> students = new ArrayList<>();
        try {
            conn= JDBCUtils.getConnection();
            pstmt=conn.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            while (resultSet.next())
            {
                Student student = new Student();
                student.setSno(resultSet.getInt("sno"));
                student.setName(resultSet.getString("sname"));
                student.setSex(resultSet.getString("sex"));
                student.setAge(resultSet.getInt("age"));
                student.setDept(resultSet.getString("dept"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            new ErrDialog("操作失败",1);
        }finally {
            JDBCUtils.close(resultSet,pstmt,conn);
        }
        return students;
    }
    //删除一条学生信息的方法
    public static void DeleteS(int sno){
        String sql="delete  from s where sno=?;";
        deleteMethod(sno, sql);
    }
    //公用的删除方法
    private static void deleteMethod(int sno, String sql) {
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, sno);
            int count = pstmt.executeUpdate();
            if (count > 0) new ErrDialog("删除成功",1);
            else new ErrDialog("删除失败",1);
        } catch (SQLException e) {
            new ErrDialog("删除失败",1);
        }finally {
            JDBCUtils.close(pstmt,conn);
        }
    }
    //增加一条学生信息的方法
    public static void addS(int sno,String name,String sex,int age,String dept){
        String sql="insert into s VALUES (?,?,?,?,?);";
        try {
            conn= JDBCUtils.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,sno);
            pstmt.setString(2,name);
            pstmt.setString(3,sex);
            pstmt.setInt(4,age);
            pstmt.setString(5,dept);
            int count = pstmt.executeUpdate();
            if (count>0) new ErrDialog("增加成功",1);
            else new ErrDialog("增加失败",1);
        } catch (SQLException e) {
            new ErrDialog("增加失败",1);
        }finally {
            JDBCUtils.close(pstmt,conn);
        }
    }
    //删除一条课程的方法
    public static void deleteC(int cno){
        String sql="delete from c where cno=?;";
        deleteMethod(cno, sql);
    }
    //展示课表的方法
    public static ArrayList<Lesson> showC(){
        String sql="select * from c ;";
        ArrayList<Lesson> lessons = new ArrayList<>();
        try {
            conn= JDBCUtils.getConnection();
            pstmt=conn.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            while (resultSet.next())
            {
                Lesson lesson = new Lesson();
                lesson.setCno(resultSet.getInt("cno"));
                lesson.setCname(resultSet.getString("cname"));
                lesson.setTeacher(resultSet.getString("teacher"));
                lesson.setCredit(resultSet.getInt("credit"));
                lessons.add(lesson);
            }
        } catch (SQLException e) {
            new ErrDialog("操作失败",1);
        }finally {
            JDBCUtils.close(resultSet,pstmt,conn);
        }
        return lessons;
    }
    //添加一条课表的方法
    public static void addC(int addCno,String addCname,String addTeacher,int addCredit){
        String sql="insert into c values (?,?,?,?);";
        try {
            conn= JDBCUtils.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,addCno);
            pstmt.setString(2,addCname);
            pstmt.setString(3,addTeacher);
            pstmt.setDouble(4,addCredit);
            int count = pstmt.executeUpdate();
            if (count>0) new ErrDialog("增加成功",1);
            else new ErrDialog("增加失败",1);
        } catch (SQLException e) {
            new ErrDialog("增加失败",1);
        }finally {
            JDBCUtils.close(pstmt,conn);
        }
    }
    //查看所有选课信息的方法
    public static ArrayList<SC> showSC(){
        String sql="select * from sc;";
        ArrayList<SC> scArrayList = new ArrayList<>();
        try {
            conn= JDBCUtils.getConnection();
            pstmt=conn.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()){
                SC sc=new SC();
                sc.setSno(resultSet.getInt("sno"));
                sc.setCno(resultSet.getInt("cno"));
                sc.setGrade(resultSet.getDouble("grade"));
                sc.setCredit(resultSet.getDouble("credit"));
                scArrayList.add(sc);
            }
        } catch (SQLException e) {
            new ErrDialog("操作失败",1);
        }finally {
            JDBCUtils.close(resultSet,pstmt,conn);
        }
        return scArrayList;
    }
    //添加一条选课信息
    public static void addSC(int sno,int cno,double grade){
        String sql="insert into sc values (?,?,?,?);";
        try {
            //学分=(成绩-50)/10,若成绩不足60分则学分为0
            double addCredit=0.0;
            if (grade>=60)
                addCredit=(grade-50)/10;
            conn= JDBCUtils.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1, sno);
            pstmt.setInt(2,cno);
            pstmt.setDouble(3,grade);
            pstmt.setDouble(4,addCredit);
            int count = pstmt.executeUpdate();
            if (count>0) new ErrDialog("增加成功",1);
            else new ErrDialog("增加失败",1);
        } catch (SQLException e) {
            new ErrDialog("增加失败",1);
        }
    }
    //删除一条选课信息
    public static void deleteSC(int sno,int cno){
        String sql="delete from sc where sno=? and cno=?;";
        try {
            conn= JDBCUtils.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,sno);
            pstmt.setInt(2,cno);
            int count = pstmt.executeUpdate();
            if (count>0) new ErrDialog("删除成功",1);
            else new ErrDialog("删除失败",1);
        } catch (SQLException e) {
            new ErrDialog("删除失败",1);
        }finally {
            JDBCUtils.close(pstmt,conn);
        }
    }
    //按照学号查询学生情况
    public static String selectSBySno(int sno){
        String sql="select * from s where sno=?";
        Student student = new Student();
        try {
            conn= JDBCUtils.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,sno);
            resultSet = pstmt.executeQuery();
            if(resultSet.next()){
                student.setSno(resultSet.getInt("sno"));
                student.setName(resultSet.getString("sname"));
                student.setSex(resultSet.getString("sex"));
                student.setAge(resultSet.getInt("age"));
                student.setDept(resultSet.getString("dept"));
            }
            else new ErrDialog("没有该学生的信息",1);
        } catch (SQLException e) {
            new ErrDialog("操作失败",1);
        }finally {
            JDBCUtils.close(resultSet,pstmt,conn);
        }
        return student.toString();
    }
    //按班级统计不及格人数及比例
    public static ArrayList<FailScale> failScale(){
        String sql="select c2.cname,sum(IF(grade < 60, 1, 0)) as failTotal,count(sno) as total\n" +
                "from sc\n" +
                "left join c c2 on sc.cno = c2.cno\n" +
                "group by c2.cname;";
        ArrayList<FailScale> list=new ArrayList<>();
        try {
            conn= JDBCUtils.getConnection();
            pstmt=conn.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()){
                FailScale failScale = new FailScale();
                failScale.setCname(resultSet.getString("cname"));
                failScale.setFails(resultSet.getInt("failTotal"));
                failScale.setTotal(resultSet.getInt("total"));
                failScale.setScale(scale(failScale.getFails(),failScale.getTotal()));
                list.add(failScale);
            }
        } catch (SQLException e) {
            new ErrDialog("操作失败",1);
        }finally {
            JDBCUtils.close(resultSet,pstmt,conn);
        }
        return list;
    }
    //修改密码
    public static void changePassword(String userName,String old_password,String new_password){
        String sql1="select pwd from user where hm=?";
        String sql2="update user set pwd=? where hm=? and pwd=?;";
        try {
            conn= JDBCUtils.getConnection();
            pstmt=conn.prepareStatement(sql1);
            pstmt.setString(1,userName);
            resultSet = pstmt.executeQuery();
            if (resultSet.next())
            {
                pstmt=conn.prepareStatement(sql2);
                pstmt.setString(1,new_password);
                pstmt.setString(2,userName);
                pstmt.setString(3,old_password);
                int count = pstmt.executeUpdate();
                if (count>0) new ErrDialog("修改成功",1);
                else new ErrDialog("修改失败",1);
            }
            else new ErrDialog("密码错误",1);
        } catch (SQLException e) {
            new ErrDialog("操作失败",1);
        }finally {
            JDBCUtils.close(resultSet,pstmt,conn);
        }
    }
    //求两个数之比的方法
    public static String scale(int p ,int q){
        int r=gcd(p,q);
        return p/r+":"+q/r;//转换为String类型并返回
    }
    //求最大公约数的算法
    public static int gcd(int p,int q){
        if (q==0)return p;
        int r=p%q;
        return gcd(q,r);
    }
    //转存储数据库到本地
    public static void localStorage(){
        try {
            BufferedWriter bw1= new BufferedWriter(new FileWriter("src\\data\\s.txt")); //用于存储学生表
            BufferedWriter bw2= new BufferedWriter(new FileWriter("src\\data\\c.txt"));//用于存储课表
            BufferedWriter bw3= new BufferedWriter(new FileWriter("src\\data\\sc.txt"));//用于存储选课表
            BufferedWriter bw4= new BufferedWriter(new FileWriter("src\\data\\user.txt"));//用于存储用户表
            String sql1="select *from s;";
            String sql2="select *from c ";
            String sql3="select *from sc";
            String sql4="select *from user";
            conn= JDBCUtils.getConnection();
            pstmt=conn.prepareStatement(sql1);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()){
                bw1.write("学号: "+resultSet.getInt("sno")+" ");
                bw1.write("姓名: "+resultSet.getString("sname")+" ");
                bw1.write("性别: "+resultSet.getString("sex")+" ");
                bw1.write("年龄: "+resultSet.getInt("age")+" ");
                bw1.write("系名: "+resultSet.getString("dept")+" ");
                bw1.newLine();
            }
            bw1.flush();
            bw1.close();
            pstmt=conn.prepareStatement(sql2);
            resultSet=pstmt.executeQuery();
            while (resultSet.next()){
                bw2.write("课号: "+resultSet.getInt("cno")+" ");
                bw2.write("课名: "+resultSet.getString("cname")+" ");
                bw2.write("教师: "+resultSet.getString("teacher")+" ");
                bw2.write("学分: "+resultSet.getDouble("credit")+" ");
                bw2.newLine();
            }
            bw2.flush();
            bw2.close();
            pstmt=conn.prepareStatement(sql3);
            resultSet=pstmt.executeQuery();
            while (resultSet.next()){
                bw3.write("学号: "+resultSet.getInt("sno")+" ");
                bw3.write("课号: "+resultSet.getInt("cno")+" ");
                bw3.write("分数: "+resultSet.getDouble("grade")+" ");
                bw3.write("学分: "+resultSet.getDouble("credit")+" ");
                bw3.newLine();
            }
            bw3.flush();
            bw3.close();
            pstmt=conn.prepareStatement(sql4);
            resultSet=pstmt.executeQuery();
            while (resultSet.next()){
                bw4.write("用户名: "+resultSet.getString("hm")+" ");
                bw4.write("密码: "+resultSet.getString("pwd")+" ");
                bw4.write("权限: "+resultSet.getInt("role")+" ");
                bw4.newLine();
            }
            bw4.flush();
            bw4.close();
            new ErrDialog("存储成功",1);
        } catch (IOException | SQLException e) {
            new ErrDialog("存储失败",1);
        }finally {
            JDBCUtils.close(resultSet,pstmt,conn);
        }
    }
}

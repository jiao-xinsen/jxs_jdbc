package test;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.Scanner;

public class lianjie {
    public void add(shiti st){
        Scanner sc =new Scanner(System.in);
        String sql = "insert into book(name,author,prices) values (?,?,? )";
        Object[] params ={
                st.getName(),
                st.getAuthor(),
                st.getPrices()
        };
        int num = zengshan.zs(sql,params);
        if (num > 0) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
    }



//    public void add(shiti s) {
//        //设置常量
//
//        Connection co = huoqu.getConnection();
//        Statement st = null;
//        try {
//            String sql = "insert into book(name,author,prices) values ('" + s.getName() + "','" + s.getAuthor() + "','" + s.getPrices() + "');";
//
//            //dataSql = "INSERT INTO `ts_userName` VALUES (" + null + ", 's.getName()'CN'," + orderno
//            //   + ", '700', '', '700', '44552', '30', NULL, '2019-07-04', '10:44:00', 1, '', '', 'ABSS', '', '', '700010A9999', '201907041112', '', '', NULL, NULL, NULL, NULL, '', '', '', '', NULL, '', '', '', '', '', '', '', '', '', 2, '2019-07-04 10:44:08', 0, NULL, 99, NULL, '', '', '', '', '');";
//
//            System.out.println(sql);
//            st = co.createStatement();
//            int num = st.executeUpdate(sql);
//            if (num > 0) {
//                System.out.println("成功");
//            } else {
//                System.out.println("失败");
//            }
//            huoqu.close(st, co, null);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }

    public void update(shiti st){
        Scanner sc =new Scanner(System.in);
        String sql = "update book set prices = ? ,author= ?  where name=?";
        Object[] params ={
                st.getPrices(),
                st.getAuthor(),
                st.getName()
        };
        int num = zengshan.zs(sql,params);
        if (num > 0) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
    }


//    public void update(shiti s) {
//        //设置常量
//
//        Connection co = huoqu.getConnection();
//        Statement st = null;
//        try {
//
//            String sql = "update book set prices = " + s.getPrices() + ",author='" + s.getAuthor() + "' where name='" + s.getName() + "'";
//            st = co.createStatement();
//            int num = st.executeUpdate(sql);
//            if (num > 0) {
//                System.out.println("成功");
//            } else {
//                System.out.println("失败");
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } finally {
//            huoqu.close(st, co, null);
//        }
//    }








           //     删除
        public  void dele(shiti st){
            Scanner sc =new Scanner(System.in);
            String sql = "DELETE FROM book WHERE id=?";
            Object[] params ={
                    st.getId()
            };
            int num = zengshan.zs(sql,params);
            if (num > 0) {
                System.out.println("成功");
            } else {
                System.out.println("失败");
            }
        }



//    public void delet(shiti s) {
//        Connection co = huoqu.getConnection();
//        Statement st = null;
//        try {
//            String sql = "DELETE FROM book WHERE id=" + s.getId() + ";";
//            st = co.createStatement();
//            int num = st.executeUpdate(sql);
//            if (num > 0) {
//                System.out.println("成功");
//            } else {
//                System.out.println("失败");
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } finally {
//            huoqu.close(st, co, null);
//        }
//    }


    public void select(shiti s) {
        Connection connection = huoqu.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from book where id =?";
            ps = connection.prepareStatement(sql);
            ps.setObject(1, s.getId());
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                double prices = rs.getDouble("prices");
                System.out.println(id + "     " + name + "    " + author + "      " + prices);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            huoqu.close(ps, connection, rs);
        }
    };





package com.test;

import java.sql.*; 
public class UpdateProductDAO { 
public int z=0; 
public int update(ProductBean pb) { 
try { 
Connection con = DBConnection.getCon(); 
PreparedStatement ps = con.prepareStatement 
("update Product52 set price=?,qty=? where code=?"); 
ps.setFloat(1, pb.getPrice()); 
ps.setInt(2, pb.getQty()); 
ps.setString(3, pb.getCode()); 
z = ps.executeUpdate(); 
}catch(Exception e) {e.printStackTrace();} 
return z; 
} 
} 

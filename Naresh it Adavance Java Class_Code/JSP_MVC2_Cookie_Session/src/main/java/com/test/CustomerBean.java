package com.test;

import java.io.*; 
@SuppressWarnings("serial") 
public class CustomerBean implements Serializable{ 
private int id; 
private String name,city,mId; 
private long phNo; 
public CustomerBean() {} 
public int getId() { 
return id; 
} 
public void setId(int id) { 
this.id = id; 
} 
public String getName() { 
return name; 
} 
public void setName(String name) { 
this.name = name; 
} 
public String getCity() { 
return city; 
} 
public void setCity(String city) { 
this.city = city; 
} 
public String getmId() { 
return mId; 
} 
public void setmId(String mId) { 
this.mId = mId; 
} 
public long getPhNo() { 
return phNo; 
} 
public void setPhNo(long phNo) { 
this.phNo = phNo; 
} 
}

package com.gaozhd.studydemo.androidbase.greendao.entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Property;

/**
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: DBUser
 * @Description: ${todo}
 * @date 2016/10/18 17:20
 */
@Entity(nameInDb = "user")
public class DBUser {

    @Property(nameInDb = "id")
    private String id;
    @Property(nameInDb = "number")
    private String number;
    @Property(nameInDb = "name")
    private String name;
    @Property(nameInDb = "sex")
    private String sex;
    @Property(nameInDb = "class")
    private String classID;

    @Generated(hash = 354713538)
    public DBUser(String id, String number, String name, String sex,
                  String classID) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.sex = sex;
        this.classID = classID;
    }

    @Generated(hash = 138933025)
    public DBUser() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }
}

package entity;

public class Students {

    private Integer sid;
    private String sname;
    private String password;
    private String sex;
    private String email;

    public Students() {
    }

    public Students(Integer sid, String sname, String password, String sex, String email) {
        this.sid = sid;
        this.sname = sname;
        this.password = password;
        this.sex = sex;
        this.email = email;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

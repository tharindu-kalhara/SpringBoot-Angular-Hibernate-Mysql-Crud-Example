package com.sample.dto.user;

/**
 * Created by Tharindu Kalhara on 9/21/2017.
 */
public class ViewUserDto {
    private Integer userId;
    private String username;
    private int gender;
    private String nic;

    public ViewUserDto() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }
}

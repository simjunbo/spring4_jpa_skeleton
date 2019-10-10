package com.sjb.api.user.model;

import javax.persistence.*;


@Table
@Entity(name = "user_info")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_info_seqno")
    Long userInfoSeqno;

    @Column(name = "user_id", length = 100, unique = true, nullable = false)
    String userId;

    @Column(name = "user_name", length = 10)
    String userName;

    @Column(name = "mobile_no", length = 20)
    String mobileNo;

    public void setUserInfoSeqno(Long userInfoSeqno) {
        this.userInfoSeqno = userInfoSeqno;
    }

    public Long getUserInfoSeqno() {
        return userInfoSeqno;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }
}

package cn.artisan323.domain;

import java.io.Serializable;

/**
 * @author wannengqingnian
 */
public class Usr implements Serializable {
    private Integer usrCde;

    private String usrName;

    private String usrIdNo;

    private String usrTel;

    private String usrEmail;

    private String usrOccupation;

    private String usrPassword;

    private String usrStoreName;

    private String usrLoginName;

    public Integer getUsrCde() {
        return usrCde;
    }

    public void setUsrCde(Integer usrCde) {
        this.usrCde = usrCde;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName == null ? null : usrName.trim();
    }

    public String getUsrIdNo() {
        return usrIdNo;
    }

    public void setUsrIdNo(String usrIdNo) {
        this.usrIdNo = usrIdNo == null ? null : usrIdNo.trim();
    }

    public String getUsrTel() {
        return usrTel;
    }

    public void setUsrTel(String usrTel) {
        this.usrTel = usrTel == null ? null : usrTel.trim();
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail == null ? null : usrEmail.trim();
    }

    public String getUsrOccupation() {
        return usrOccupation;
    }

    public void setUsrOccupation(String usrOccupation) {
        this.usrOccupation = usrOccupation == null ? null : usrOccupation.trim();
    }

    public String getUsrPassword() {
        return usrPassword;
    }

    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword == null ? null : usrPassword.trim();
    }

    public String getUsrStoreName() {
        return usrStoreName;
    }

    public void setUsrStoreName(String usrStoreName) {
        this.usrStoreName = usrStoreName == null ? null : usrStoreName.trim();
    }

    public String getUsrLoginName() {
        return usrLoginName;
    }

    public void setUsrLoginName(String usrLoginName) {
        this.usrLoginName = usrLoginName == null ? null : usrLoginName.trim();
    }

    @Override
    public String toString() {
        return "Usr{" +
                "usrCde=" + usrCde +
                ", usrName='" + usrName + '\'' +
                ", usrIdNo='" + usrIdNo + '\'' +
                ", usrTel='" + usrTel + '\'' +
                ", usrEmail='" + usrEmail + '\'' +
                ", usrOccupation='" + usrOccupation + '\'' +
                ", usrPassword='" + usrPassword + '\'' +
                ", usrStoreName='" + usrStoreName + '\'' +
                ", usrLoginName='" + usrLoginName + '\'' +
                '}';
    }
}
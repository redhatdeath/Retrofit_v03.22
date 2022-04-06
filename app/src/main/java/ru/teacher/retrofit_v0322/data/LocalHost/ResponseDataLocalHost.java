package ru.teacher.retrofit_v0322.data.LocalHost;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseDataLocalHost {

    @SerializedName("Key")
    @Expose
    private Integer _id;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Surname")
    @Expose
    private String surname;
    @SerializedName("SecondName")
    @Expose
    private String secondName;
    @SerializedName("Mark")
    @Expose
    private Integer mark;

    public Integer getKey() {
        return _id;
    }

    public void setKey(Integer id) {
        this._id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("{_id=").append(_id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", secondName='").append(secondName).append('\'');
        sb.append(", mark=").append(mark);
        sb.append("}\n");
        return sb.toString();
    }
}

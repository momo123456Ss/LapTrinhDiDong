package com.example.bth6_bai1;

public class Student {
    String _id;
    String _name;
    String _email;
    String _phone;

    public Student(String _id, String _name, String _email, String _phone) {
        this._id = _id;
        this._name = _name;
        this._email = _email;
        this._phone = _phone;
    }

    public Student(){

    }
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public String get_phone() {
        return _phone;
    }

    public void set_phone(String _phone) {
        this._phone = _phone;
    }


}

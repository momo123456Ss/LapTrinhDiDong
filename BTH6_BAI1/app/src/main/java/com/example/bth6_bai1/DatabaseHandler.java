package com.example.bth6_bai1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "StudentManagement";
    private static final String TABLE_NAME = "students";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PHONE = "phone";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    void addStudent(Student s) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put(KEY_ID, s.get_id());
        val.put(KEY_NAME, s.get_name());
        val.put(KEY_EMAIL, s.get_email());
        val.put(KEY_PHONE, s.get_phone());

        db.insert(TABLE_NAME, null, val);
        db.close();
    }
    public void deleteStudent(int studentId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_ID + " = ?", new String[] { String.valueOf(studentId) });
        db.close();
    }

    void addStudent1(Student s) {
        SQLiteDatabase db = this.getWritableDatabase();
        String INSERT_STUDENT = "INSERT INTO " + TABLE_NAME +
                "(" + KEY_ID + "," + KEY_NAME + "," + KEY_EMAIL + "," + KEY_PHONE + ")"
                + " VALUES(" + s.get_id() + "," + s.get_name() + "," + s.get_email() + "," + s.get_phone() + ")";
        db.execSQL(INSERT_STUDENT);
        db.close();
    }
    Student getStudent(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.query(TABLE_NAME,
                new String[]{KEY_ID,KEY_NAME,KEY_EMAIL,KEY_PHONE},KEY_ID + "=?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if(c != null)
            c.moveToFirst();
        Student s = new Student(c.getString(0),c.getString(1),c.getString(2),c.getString(3));
        db.close();
        return s;
    }
    public List<Student> getAllStudent(){
        List<Student> lst = new ArrayList<Student>();
        String SELCET_QUERY = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor c = db.rawQuery(SELCET_QUERY,null);

        if(c.moveToFirst()){
            do{
                Student s = new Student();
                s.set_id(c.getString(0));
                s.set_name(c.getString(1));
                s.set_email(c.getString(2));
                s.set_phone(c.getString(3));
                lst.add(s);
            }while (c.moveToNext());
        }
        c.close();
        db.close();
        return lst;
    }
    public void updateStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, student.get_name());
        values.put(KEY_EMAIL, student.get_email());
        values.put(KEY_PHONE, student.get_phone());

        db.update(TABLE_NAME, values, KEY_ID + " = ?", new String[] { String.valueOf(student.get_id()) });
        db.close();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_STUDENT_TABLE =
                "CREATE TABLE " + TABLE_NAME + "("
                        + KEY_ID + " TEXT PRIMARY KEY,"
                        + KEY_NAME + " TEXT,"
                        + KEY_EMAIL + " TEXT,"
                        + KEY_PHONE + " TEXT)";
        db.execSQL(CREATE_STUDENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int old_version, int new_version) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

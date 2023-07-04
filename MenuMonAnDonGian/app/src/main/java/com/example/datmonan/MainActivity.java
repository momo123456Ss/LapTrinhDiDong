package com.example.datmonan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener, View.OnClickListener, TextWatcher {
    CheckBox cb_themNam;
    CheckBox cb_themPhoMai;
    CheckBox cb_themXiuMai;
    CheckBox cb_themChanTrau;
    CheckBox cb_themPhoMaiTraSua;
    CheckBox cb_themThach;
    EditText edt_maGiamGia;

    TextView tv_soTienGiam;
    TextView tv_soTienPhaiTra;
    TextView tv_SoLuongPizza;
    TextView tv_soLuongTraSua;

    Button btn_truSlPizza;
    Button btn_congSlPizza;
    Button btn_truSlTraSua;
    Button btn_congSlTraSua;
    Button btn_datHang;
    Button btn_lamLai;

    RadioButton rb_GaBbq;
    RadioButton rb_PzHawaii;
    RadioButton rb_PzMacDinh;
    RadioButton rb_kichCoLon;
    RadioButton rb_kichCoVua;
    RadioButton rb_kichCoNho;

    RadioGroup rdg_loaiKichCo;
    RadioGroup rdg_loaiP;
    int loaiP = 0;
    int pricep, priceTs;
    int countp, countTs;
    int kichco;
    double dc = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        CheckChange();
        SoLuongPizza();
        SoLuongTraSua();
        LamLai();

        btn_datHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Price();
                Toast.makeText(MainActivity.this,"Đặt hàng thành công!",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void LamLai() {
        btn_lamLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cb_themChanTrau.setChecked(false);
                cb_themPhoMaiTraSua.setChecked(false);
                cb_themThach.setChecked(false);
                cb_themNam.setChecked(false);
                cb_themXiuMai.setChecked(false);
                cb_themPhoMai.setChecked(false);

                rb_PzHawaii.setChecked(false);
                rb_GaBbq.setChecked(false);
                rb_PzMacDinh.setChecked(false);
                rb_kichCoLon.setChecked(false);
                rb_kichCoVua.setChecked(false);
                rb_kichCoNho.setChecked(false);

                tv_SoLuongPizza.setText("0");
                tv_soLuongTraSua.setText("0");
                tv_soTienGiam.setText("");
                tv_soTienPhaiTra.setText("");

                edt_maGiamGia.setText("");

                countp = 0;
                countTs =0;

                Price();
            }
        });
    }

    private void CheckChange() {
        cb_themThach.setOnCheckedChangeListener(this);
        cb_themChanTrau.setOnCheckedChangeListener(this);
        cb_themPhoMaiTraSua.setOnCheckedChangeListener(this);
        cb_themNam.setOnCheckedChangeListener(this);
        cb_themPhoMai.setOnCheckedChangeListener(this);
        cb_themXiuMai.setOnCheckedChangeListener(this);

        rb_GaBbq.setOnCheckedChangeListener(this);
        rb_PzHawaii.setOnCheckedChangeListener(this);
        rb_PzMacDinh.setOnCheckedChangeListener(this);
        rb_kichCoLon.setOnCheckedChangeListener(this);
        rb_kichCoVua.setOnCheckedChangeListener(this);
        rb_kichCoNho.setOnCheckedChangeListener(this);

        rdg_loaiKichCo.setOnCheckedChangeListener(this);

        edt_maGiamGia.addTextChangedListener(this);

    }

    private void SoLuongPizza() {
        btn_congSlPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countp = Integer.parseInt(tv_SoLuongPizza.getText().toString());
                countp++;
                tv_SoLuongPizza.setText(String.valueOf(countp));
                Price();
            }
        });
        btn_truSlPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countp = Integer.parseInt(tv_SoLuongPizza.getText().toString());
                if (countp > 0) {
                    countp--;
                }
                tv_SoLuongPizza.setText(String.valueOf(countp));
                Price();
            }
        });
    }
    private void SoLuongTraSua(){
        btn_congSlTraSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countTs = Integer.parseInt(tv_soLuongTraSua.getText().toString());
                countTs++;
                tv_soLuongTraSua.setText(String.valueOf(countTs));
                Price();
            }
        });
        btn_truSlTraSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countTs = Integer.parseInt(tv_soLuongTraSua.getText().toString());
                if (countTs > 0) {
                    countTs--;
                }
                tv_soLuongTraSua.setText(String.valueOf(countTs));
                Price();
            }
        });
    }

    private void Price() {
        double price = 0;
        int totalPriceP = 0, totalPriceTs = 0;
        int price1 = 100, price2 = 45;
//        GiamGia();
        if (countp > 0) {
            totalPriceP = (price1 + pricep + loaiP + kichco) * countp;
        }
        if (countTs > 0) {
            totalPriceTs = (price2 + priceTs) * countTs;
        }
        price = (totalPriceP + totalPriceTs);
        tv_soTienGiam.setText("Số tiền giảm là: " + (String.valueOf(Math.round(price * dc))));
        tv_soTienPhaiTra.setText("Số tiền phải trả: " + (String.valueOf(Math.round(price * (1 - dc)))));

    }

    private void GiamGia() {
        String dis = edt_maGiamGia.getText().toString().toLowerCase().trim();
        if (dis.equals("HHT07".toLowerCase())) {
            dc = 0.2;
        } else if (dis.equals("HHT05".toLowerCase())) {
            dc = 0.05;
        } else dc = 0;
    }

    private void anhXa() {
        rdg_loaiKichCo= (RadioGroup)findViewById(R.id.rdg_loaiKichCo);
        rdg_loaiP= (RadioGroup)findViewById(R.id.rdg_loaiP);

        cb_themNam = (CheckBox) findViewById(R.id.cb_themNam);
        cb_themPhoMai = (CheckBox) findViewById(R.id.cb_themPhoMai);
        cb_themXiuMai = (CheckBox) findViewById(R.id.cb_themXiuMai);
        cb_themChanTrau = (CheckBox) findViewById(R.id.cb_themChanTrau);
        cb_themPhoMaiTraSua = (CheckBox) findViewById(R.id.cb_themPhoMaiTraSua);
        cb_themThach = (CheckBox) findViewById(R.id.cb_themThach);
        edt_maGiamGia = (EditText) findViewById(R.id.edt_maGiamGia);
        tv_soTienGiam = (TextView) findViewById(R.id.tv_soTienGiam);
        tv_soTienPhaiTra = (TextView) findViewById(R.id.tv_soTienPhaiTra);
        tv_SoLuongPizza = (TextView) findViewById(R.id.tv_SoLuongPizza);
        tv_soLuongTraSua = (TextView) findViewById(R.id.tv_soLuongTraSua);
        btn_truSlPizza = (Button) findViewById(R.id.btn_truSlPizza);
        btn_congSlPizza = (Button) findViewById(R.id.btn_congSlPizza);
        btn_truSlTraSua = (Button) findViewById(R.id.btn_truSlTraSua);
        btn_congSlTraSua = (Button) findViewById(R.id.btn_congSlTraSua);
        btn_datHang = (Button) findViewById(R.id.btn_datHang);
        btn_lamLai = (Button) findViewById(R.id.btn_lamLai);
        rb_GaBbq = (RadioButton) findViewById(R.id.rb_GaBbq);
        rb_PzHawaii = (RadioButton) findViewById(R.id.rb_PzHawaii);
        rb_PzMacDinh = (RadioButton) findViewById(R.id.rb_PzMacDinh);
        rb_kichCoLon = (RadioButton) findViewById(R.id.rb_kichCoLon);
        rb_kichCoVua = (RadioButton) findViewById(R.id.rb_kichCoVua);
        rb_kichCoNho = (RadioButton) findViewById(R.id.rb_kichCoNho);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int id = buttonView.getId();
        if (isChecked) {
            if (id == R.id.cb_themChanTrau) {
                priceTs += 10;
                Price();
            }
            if (id == R.id.cb_themPhoMaiTraSua) {
                priceTs += 20;
                Price();
            }
            if (id == R.id.cb_themThach) {
                priceTs += 25;
                Price();
            }
            if (id == R.id.cb_themNam) {
                pricep += 15;
                Price();
            }
            if (id == R.id.cb_themPhoMai) {
                pricep += 20;
                Price();
            }
            if (id == R.id.cb_themXiuMai) {
                pricep += 30;
                Price();
            }
        } else {
            if (id == R.id.cb_themChanTrau) {
                priceTs -= 10;
                Price();
            }
            if (id == R.id.cb_themPhoMaiTraSua) {
                priceTs -= 20;
                Price();
            }
            if (id == R.id.cb_themThach) {
                priceTs -= 25;
                Price();
            }
            if (id == R.id.cb_themNam) {
                pricep -= 15;
                Price();
            }
            if (id == R.id.cb_themPhoMai) {
                pricep -= 20;
                Price();
            }
            if (id == R.id.cb_themXiuMai) {
                pricep -= 30;
                Price();
            }
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        rdg_loaiP.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rb_GaBbq){
                    loaiP = 80;
                    Price();

                }
                if(checkedId == R.id.rb_PzHawaii){
                    loaiP = 70;
                    Price();

                }
                if(checkedId == R.id.rb_PzMacDinh){
                    loaiP = 50;
                    Price();

                }
            }
        });
        rdg_loaiKichCo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rb_kichCoLon){
                    kichco = 20;
                    Price();

                }
                if(checkedId == R.id.rb_kichCoVua){
                    kichco = 15;
                    Price();

                }
                if(checkedId == R.id.rb_kichCoNho){
                    kichco = 10;
                    Price();

                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        String dis = edt_maGiamGia.getText().toString().toLowerCase().trim();
        if (dis.equals("HHT07".toLowerCase())) {
            dc = 0.2;
        } else if (dis.equals("HHT05".toLowerCase())) {
            dc = 0.05;
        } else dc = 0;
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        String dis = edt_maGiamGia.getText().toString().toLowerCase().trim();
        if (dis.equals("HHT07".toLowerCase())) {
            dc = 0.2;
        } else if (dis.equals("HHT05".toLowerCase())) {
            dc = 0.05;
        } else dc = 0;

        Price();
    }
}
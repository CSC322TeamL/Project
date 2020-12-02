package com.example.simplerestaurant;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;

import com.example.simplerestaurant.beans.UserBasicInfoBean;
import com.google.android.material.textfield.TextInputLayout;

public class UserPersonalInfoActivity extends BaseActivity implements View.OnClickListener{

    private UserBasicInfoBean userInfo;
    private TextInputLayout tiFirstName, tiLastName, tiDisplayName
            , tiEmail, tiPhone, tiStreet, tiCity, tiState, tiZipCode;
    private String firstName, lastName, displayName, email, phone
            , street, city, state, zipCode;

    private ImageButton backward;
    private Button submit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_user_personal_info);

        tiFirstName = (TextInputLayout)findViewById(R.id.textinput_user_firstname);
        tiLastName = (TextInputLayout)findViewById(R.id.textinput_user_lastname);
        tiDisplayName = (TextInputLayout)findViewById(R.id.textinput_user_displayname);
        tiEmail = (TextInputLayout)findViewById(R.id.textinput_user_email);
        tiPhone = (TextInputLayout)findViewById(R.id.textinput_user_phone);
        tiStreet = (TextInputLayout)findViewById(R.id.textinput_user_street);
        tiCity = (TextInputLayout)findViewById(R.id.textinput_user_city);
        tiState = (TextInputLayout)findViewById(R.id.textinput_user_state);
        tiZipCode = (TextInputLayout)findViewById(R.id.textinput_user_zipcode);

        backward = (ImageButton) findViewById(R.id.imagebtn_backward);
        submit = (Button) findViewById(R.id.button_user_info_submit);

        Intent intent = getIntent();
        userInfo = UnitTools.getGson().fromJson(intent.getStringExtra("userInfo"), UserBasicInfoBean.class);
        Log.i("acc", userInfo.toString());
        setUpFields(userInfo);
    }

    private void setUpFields(UserBasicInfoBean userinfo){
        if(null == tiFirstName){
            return;
        }
        tiFirstName.getEditText().setText(userinfo.getBasicInfo().getFistName());
        tiLastName.getEditText().setText(userinfo.getBasicInfo().getLastName());
        tiEmail.getEditText().setText(userinfo.getContact().getEmail());
        tiDisplayName.getEditText().setText(userinfo.getDisplayName());
        tiPhone.getEditText().setText(userinfo.getContact().getPhone());
        tiStreet.getEditText().setText(userinfo.getContact().getAddress().getStreet());
        tiCity.getEditText().setText(userinfo.getContact().getAddress().getCity());
        tiState.getEditText().setText(userinfo.getContact().getAddress().getState());
        tiZipCode.getEditText().setText(userinfo.getContact().getAddress().getZipCode());
    }

    private UserBasicInfoBean getInfoFromfields(){
        firstName = tiFirstName.getEditText().getText().toString().trim();
        lastName = tiLastName.getEditText().getText().toString().trim();
        displayName = tiDisplayName.getEditText().getText().toString().trim();
        phone = tiPhone.getEditText().getText().toString().trim();
        street = tiStreet.getEditText().getText().toString().trim();
        city = tiCity.getEditText().getText().toString().trim();
        state = tiState.getEditText().getText().toString().trim();
        zipCode = tiZipCode.getEditText().getText().toString().trim();
        if(null == firstName){
            tiFirstName.getEditText().setError("First Name empty");
            return null;
        }
        if(null == lastName){
            tiLastName.getEditText().setError("First Name empty");
            return null;
        }
        if(null == displayName){
            tiDisplayName.getEditText().setError("First Name empty");
            return null;
        }
        if(null == phone){
            tiPhone.getEditText().setError("First Name empty");
            return null;
        }
        if(null == street){
            tiStreet.getEditText().setError("First Name empty");
            return null;
        }
        if(null == city){
            tiCity.getEditText().setError("First Name empty");
            return null;
        }
        if(null == state){
            tiState.getEditText().setError("First Name empty");
            return null;
        }
        if(null == zipCode){
            tiZipCode.getEditText().setError("First Name empty");
            return null;
        }
        userInfo.getBasicInfo().setFistName(firstName);
        userInfo.getBasicInfo().setLastName(lastName);
        userInfo.setDisplayName(displayName);
        userInfo.getContact().setPhone(phone);
        userInfo.getContact().getAddress().setState(state);
        userInfo.getContact().getAddress().setCity(city);
        userInfo.getContact().getAddress().setStreet(street);
        userInfo.getContact().getAddress().setZipCode(zipCode);

        return userInfo;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_user_info_submit:

                break;
            case R.id.imagebtn_backward:
                finish();
                break;
        }
    }
}

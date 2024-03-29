package com.android.attendance.activity;

import com.android.attendance.bean.FacultyBean;
import com.android.attendance.db.DBAdapter;
import com.example.androidattendancesystem.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddFacultyActivity extends Activity {

	Button registerButton;
	EditText textFirstName;
	EditText textLastName;
	EditText textcontact;
	EditText textaddress;
	EditText textusername;
	EditText textpassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addfaculty);


		textFirstName=findViewById(R.id.editTextFirstName);
		textLastName=findViewById(R.id.editTextLastName);
		textcontact=findViewById(R.id.editTextPhone);
		textaddress=findViewById(R.id.editTextaddr);
		textusername=findViewById(R.id.editTextUserName);
		textpassword=findViewById(R.id.editTextPassword);
		registerButton=findViewById(R.id.RegisterButton);

		registerButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				String first_name = textFirstName.getText().toString();
				String last_name = textLastName.getText().toString();
				String userName = textusername.getText().toString();
				String passWord = textpassword.getText().toString();
				String phone_no = textcontact.getText().toString();
				String address = textaddress.getText().toString();

				if (TextUtils.isEmpty(first_name)) {
					textFirstName.setError("Please Enter First Name");
				}
				else if (TextUtils.isEmpty(last_name)) {
					textLastName.setError("Please Enter Last Name");
				}
				else if (TextUtils.isEmpty(userName)) {
					textusername.setError("Please Enter UserName");
				}
				else if (TextUtils.isEmpty(passWord)) {
					textpassword.setError("Please Enter Password");
				}
				else if (TextUtils.isEmpty(phone_no)) {
					textcontact.setError("Please Enter Phone No");
				}
				else if (TextUtils.isEmpty(address)) {
					textaddress.setError("Please Enter Address");
				}
				else { 
					
					FacultyBean facultyBean = new FacultyBean();
					facultyBean.setFaculty_firstname(first_name);
					facultyBean.setFaculty_lastname(last_name);
					facultyBean.setFaculty_mobilenumber(phone_no);
					facultyBean.setFaculty_address(address);
					facultyBean.setFaculty_username(userName);
					facultyBean.setFaculty_password(passWord);
					
					DBAdapter dbAdapter = new DBAdapter(AddFacultyActivity.this);
					dbAdapter.addFaculty(facultyBean);
					
					Intent intent =new Intent(AddFacultyActivity.this,MenuActivity.class);
					startActivity(intent);
					Toast.makeText(getApplicationContext(), "Faculty added successfully", Toast.LENGTH_SHORT).show();

				}
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}

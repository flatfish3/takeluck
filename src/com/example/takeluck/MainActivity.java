package com.example.takeluck;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	TextView txt_rp, txt_number, txt_msg;
	EditText edit_rp;
	Button btn_odd, btn_even;
	
	int rand;
	int rp;
	int betting_rp;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txt_rp = (TextView)findViewById(R.id.textView2);
        txt_number = (TextView)findViewById(R.id.textView4);
        txt_msg = (TextView)findViewById(R.id.textView5);
        edit_rp = (EditText)findViewById(R.id.editText1);
        btn_odd = (Button)findViewById(R.id.button1);
        btn_even = (Button)findViewById(R.id.button2);
        
        btn_odd.setOnClickListener(this);
        btn_even.setOnClickListener(this);
        
        rp = 1000;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if(rp <= 0){
			Toast.makeText(this, "RP가 없습니다. 게임을 다시 실행하세요.", 1000).show();
			return;
		}
		
		if(edit_rp.getText().toString().equals("")){
			Toast.makeText(this, "Betting RP 금액을 입력해 주세요.", 1000).show();				
			return;
		}
		
		betting_rp = Integer.parseInt(edit_rp.getText().toString());
		
		if(betting_rp > rp){
			Toast.makeText(this, "Betting RP 금액이 너무 많습니다.", 1000).show();				
			return;			
		}
		
		rand = (int)Math.round(Math.random() * 99);
		
		for(int i = 0 ; i <= rand ; i++){
			txt_number.setText(Integer.toString(i));
		}
		
		switch(v.getId()){
		case R.id.button1:
				
			if(rand%2 == 1){
				rp += betting_rp;
				
				txt_msg.setText("Odd(홀수)입니다. 맞췄습니다. " + betting_rp + "RP 를 획득했습니다.");
				txt_rp.setText("User Riot Points : " + rp);
			}
			else	{
				rp -= betting_rp;
				
				txt_msg.setText("Even(짝수)입니다. 틀렸습니다. " + betting_rp + "RP 를 빼겼습니다 .");
				txt_rp.setText("User Riot Points : " + rp);
			}
			break;
			
		case R.id.button2:
			if(rand%2 == 0){
				rp += betting_rp;
				
				txt_msg.setText("Even(짝수)입니다. 맞췄습니다. " + betting_rp + "RP 를 획득했습니다.");
				txt_rp.setText("User Riot Points : " + rp);
			}
			else	{
				rp -= betting_rp;
				
				txt_msg.setText("Odd(홀수)입니다. 틀렸습니다. " + betting_rp + "RP 를 빼겼습니다 .");
				txt_rp.setText("User Riot Points : " + rp);
			}
			break;			
		}
	}
    
}

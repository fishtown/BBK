package com.android.bbk;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class BBKActivity extends Activity implements OnClickListener {
	private Button mButtonjb ;
	private Button mButtonics ;
	private Button mButtongb ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mButtonjb = (Button) this.findViewById(R.id.jb);
        mButtonics = (Button) this.findViewById(R.id.ics);
        mButtongb = (Button) this.findViewById(R.id.gb);
        mButtonjb.setOnClickListener(this);
        mButtonics.setOnClickListener(this);
        mButtongb.setOnClickListener(this);
}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.equals(mButtonics)) {
			Intent intent = new Intent();
        	intent.setClass(BBKActivity.this,ICSActivity.class);
        	startActivity(intent);
		}	else if(v.equals(mButtonjb)) {
			Intent intent = new Intent();
        	intent.setClass(BBKActivity.this,JBActivity.class);
        	startActivity(intent);
		} 	else if(v.equals(mButtongb)) {
    			Intent intent = new Intent();
            	intent.setClass(BBKActivity.this,GBActivity.class);
            	startActivity(intent);
		} else {
		
		}
		
	}
}
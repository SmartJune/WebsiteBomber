package com.example.messagebomber;

import com.example.service.Bomber;
import com.example.service.Init;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	EditText editText;
	Button sendButton;
	WebView webView;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		editText = (EditText)findViewById(R.id.phoneNumber);
		sendButton = (Button)findViewById(R.id.button);
		sendButton.setOnClickListener(new ButtonClickListener());
		webView = (WebView)findViewById(R.id.webview);

	}
	
	private class ButtonClickListener implements View.OnClickListener{
			
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String phoneNumber = editText.getText().toString();
			Bomber.bomb(phoneNumber,webView);
			Toast.makeText(getApplicationContext(),getResources().getString(R.string.begin)+phoneNumber, Toast.LENGTH_SHORT).show();
			Init init = new Init(getApplicationContext());
			init.init();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
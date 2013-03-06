package il.ac.huji.tipcalculators;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;
import android.view.Menu;

/**
 *
 * @author talya.
 *         Created Mar 3, 2013.
 */
public class TipCalculator extends Activity {
	
	private EditText bill;
	private TextView tip;
	private CheckBox round;	
	private double tipRate = 0.12;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
		
		this.bill = (EditText)findViewById(R.id.edtBillAmount);
		this.tip = (TextView)findViewById(R.id.txtTipResult);
		this.round = (CheckBox)findViewById(R.id.chkRound);
	}
	
	
	/**
	 * 
	 * Calculates the tip according to the given bill.
	 *
	 * @param v the button that got clicked
	 */
	public void calcTip(View v){
		
		String finalTip = null;
		
		double bill = Double.parseDouble(this.bill.getText().toString());
		double notRoundedTip = bill*this.tipRate;
		
		if(this.round.isChecked()){
			notRoundedTip = Math.round(notRoundedTip);
			finalTip = Integer.toString((int)notRoundedTip);
		}
		else{
			DecimalFormat df = new DecimalFormat("#.##");
			df.setMinimumFractionDigits(2);
			finalTip = df.format(notRoundedTip);
		}
		
		this.tip.setText("$"+finalTip);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_tip_calculator, menu);
		return true;
	}

}

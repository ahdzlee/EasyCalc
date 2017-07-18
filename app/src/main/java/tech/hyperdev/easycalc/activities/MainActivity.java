package tech.hyperdev.easycalc.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import tech.hyperdev.easycalc.R;
import tech.hyperdev.easycalc.controllers.CalculatorController;

public class MainActivity extends AppCompatActivity {

    private EditText mEtFirstNo;
    private EditText mEtSecondNo;
    private TextView mTvResult;

    private CalculatorController mController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        mController = new CalculatorController();
    }

    private void findViews() {
        mEtFirstNo = (EditText) findViewById(R.id.etFirstNumber);
        mEtSecondNo = (EditText) findViewById(R.id.etSecondNumber);
        mTvResult = (TextView) findViewById(R.id.tvResult);
    }

    public void onOperationClicked(View view) {
        if (view instanceof Button) {
            String txtOp = ((Button) view).getText().toString();

            if (txtOp.equals(getString(R.string.text_clear))) {
                clear();
                return;
            }
            if (txtOp.equals(getString(R.string.text_exit))) {
                finish();
                return;
            }

            String firstText = mEtFirstNo.getText().toString();
            String secondText = mEtSecondNo.getText().toString();

            // Conduct checking if the values are valid before performing calculations
            if (!mController.isValid(firstText)) {
                mEtFirstNo.setError(getString(R.string.text_enter_valid_number));
                return;
            }
            if (!mController.isValid(secondText)) {
                mEtSecondNo.setError(getString(R.string.text_enter_valid_number));
                return;
            }

            // If both first and second number text are valid, clear the error message in the EditText
            mEtFirstNo.setError(null);
            mEtSecondNo.setError(null);

            // Pass the valid numbers to controller and perform calculation
            double n1 = Double.parseDouble(firstText);
            double n2 = Double.parseDouble(secondText);
            double result = -1;

            if (txtOp.equals(getString(R.string.text_plus))) {
                result = mController.add(n1, n2);
            } else if (txtOp.equals(getString(R.string.text_minus))) {
                result = mController.subtract(n1, n2);
            } else if (txtOp.equals(getString(R.string.text_times))) {
                result = mController.multiply(n1, n2);
            } else if (txtOp.equals(getString(R.string.text_divide))) {
                result = mController.divide(n1, n2);
            }

            // Once result is retrieved, format and display the result into the TextView
            mTvResult.setText(mController.format(result));
        }
    }

    private void clear() {
        mEtFirstNo.setError(null);
        mEtSecondNo.setError(null);

        mEtFirstNo.setText("");
        mEtSecondNo.setText("");
    }
}

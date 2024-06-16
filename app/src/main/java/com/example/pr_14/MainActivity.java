package com.example.pr_14;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvResult;
    private double currentValue = 0.0;
    private double lastValue = 0.0;
    private char lastOperation = '+';
    private boolean isResultShown = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);

        findViewById(R.id.btn0).setOnClickListener(this);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
        findViewById(R.id.btn8).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);
        findViewById(R.id.btnDot).setOnClickListener(this);
        findViewById(R.id.btnAdd).setOnClickListener(this);
        findViewById(R.id.btnSub).setOnClickListener(this);
        findViewById(R.id.btnMul).setOnClickListener(this);
        findViewById(R.id.btnDiv).setOnClickListener(this);
        findViewById(R.id.btnEqual).setOnClickListener(this);
        findViewById(R.id.btnClear).setOnClickListener(this);
    }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btn0) {
                handleNumberClick((Button) v);
            } else if (v.getId() == R.id.btn1) {
                handleNumberClick((Button) v);
            } else if (v.getId() == R.id.btn2) {
                handleNumberClick((Button) v);
            } else if (v.getId() == R.id.btn3) {
                handleNumberClick((Button) v);
            } else if (v.getId() == R.id.btn4) {
                handleNumberClick((Button) v);
            } else if (v.getId() == R.id.btn5) {
                handleNumberClick((Button) v);
            } else if (v.getId() == R.id.btn6) {
                handleNumberClick((Button) v);
            } else if (v.getId() == R.id.btn7) {
                handleNumberClick((Button) v);
            } else if (v.getId() == R.id.btn8) {
                handleNumberClick((Button) v);
            } else if (v.getId() == R.id.btn9) {
                handleNumberClick((Button) v);
            } else if (v.getId() == R.id.btnDot) {
                handleDotClick();
            } else if (v.getId() == R.id.btnAdd) {
                handleOperationClick('+');
            } else if (v.getId() == R.id.btnSub) {
                handleOperationClick('-');
            } else if (v.getId() == R.id.btnMul) {
                handleOperationClick('*');
            } else if (v.getId() == R.id.btnDiv) {
                handleOperationClick('/');
            } else if (v.getId() == R.id.btnEqual) {
                handleEqualsClick();
            } else if (v.getId() == R.id.btnClear) {
                handleClearClick();
            }
        }
    private void handleNumberClick(Button btn) {
        String digit = btn.getText().toString();
        if (isResultShown) {
            currentValue = 0.0;
            isResultShown = false;
        }
        currentValue = currentValue * 10 + Double.parseDouble(digit);
        updateResult();
    }

    private void handleDotClick() {
        if (currentValue == (int) currentValue) {
            currentValue += 0.0;
        }
    }

    private void handleOperationClick(char operation) {
        if (isResultShown) {
            lastOperation = operation;
        } else {
            performOperation(lastOperation);
            lastValue = currentValue;
            lastOperation = operation;
            currentValue = 0.0;
        }
    }

    private void handleEqualsClick() {
        performOperation(lastOperation);
        isResultShown = true;
    }

    private void handleClearClick() {
        currentValue = 0.0;
        lastValue = 0.0;
        lastOperation = '+';
        isResultShown = false;
        updateResult();
    }

    private void performOperation(char operation) {
        switch (operation) {
            case '+':
                currentValue = lastValue + currentValue;
                break;
            case '-':
                currentValue = lastValue - currentValue;
                break;
            case '*':
                currentValue = lastValue * currentValue;
                break;
            case '/':
                currentValue = lastValue / currentValue;
                break;
        }
        updateResult();
    }

    @SuppressLint("DefaultLocale")
    private void updateResult() {
        tvResult.setText(String.format("%.2f", currentValue));
    }
}

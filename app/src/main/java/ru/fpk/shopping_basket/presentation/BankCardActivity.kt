package ru.fpk.shopping_basket.presentation

import android.os.Bundle
import android.text.InputType
import android.widget.Button
import com.braintreepayments.cardform.view.CardForm
import dagger.android.support.DaggerAppCompatActivity
import ru.fpk.R

class BankCardActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bank_card)
        val cardForm = findViewById<CardForm>(R.id.card_form)
        val buyButton = findViewById<Button>(R.id.btnBuy)

        cardForm.cardRequired(true)
            .expirationRequired(true)
            .cvvRequired(true)
            .postalCodeRequired(true)
            .mobileNumberRequired(true)
            .mobileNumberExplanation("SMS is required on this number")
            .setup(this)

        cardForm.cvvEditText.inputType =
            InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_VARIATION_PASSWORD

        buyButton.setOnClickListener {
            setResult(100)
            finish()
        }
    }
}

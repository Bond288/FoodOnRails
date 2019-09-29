package ru.fpk.shopping_basket.presentation

import android.os.Bundle
import android.text.InputType
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.braintreepayments.cardform.view.CardForm
import ru.fpk.R
import toothpick.Toothpick


class BankCardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val scope = Toothpick.openScopes(application, this)
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

    override fun onDestroy() {
        super.onDestroy()
        Toothpick.closeScope(this)
    }
}

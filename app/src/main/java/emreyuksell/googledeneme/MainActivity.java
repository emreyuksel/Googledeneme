package emreyuksell.googledeneme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox);
        boolean hasWhippedCream = checkBox.isChecked();
        Log.v("UYARIIIII!!!!", "Burası çek edildiği yer" + hasWhippedCream);

        int price=  calculatePrice();
        String priceMessage = createOrderSummary(price,hasWhippedCream);
        displayMessage(priceMessage);

    }
    /**
     * Calculates the price of the order.
     *
     */
    private int calculatePrice()  {
        return quantity * 5;
    }

    private String createOrderSummary(int price, boolean addWhippedCream){

        String priceMessage =   " İsim: Emre Yüksel";
        priceMessage += "\n Whipped Cream add? : " +addWhippedCream;
        priceMessage += "\n Qunatity: " +quantity;
        priceMessage += "\n " + quantity + " kahve için " + price + "$ ödemeniz gereklidir" ;
        priceMessage += "\n Teşekkürler";

        return priceMessage;

    }

    public void displayQuantity(int numberOfCoffee) {
        TextView textView = (TextView) findViewById(R.id.textOrder);
        textView.setText("" + numberOfCoffee);

    }


    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(    R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    public void increment(View view) {

        quantity++;
        displayQuantity(quantity);

    }

    public void decrement(View view) {

        quantity--;
        displayQuantity(quantity);

        if (quantity < 0) {
            quantity = 0;
            displayQuantity(quantity);
        }


    }


}

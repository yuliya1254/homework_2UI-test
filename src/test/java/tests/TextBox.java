package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBox {

    TextBoxPage textBoxPage = new TextBoxPage();
    @Test
    void fillFormTextBox() {
        textBoxPage.beforeAllCase()
                .openPage()
                .setFullNameInput("Ivan Ivanov")
                .setEmailInput("abc@abc.com")
                .setCurrentAddressInput("Los Angeles, Big street, house 4")
                .setPermanentAddressInput("Los Angeles, Big street, house 4")
                .clickButtonSubmit()

                .checkResult("Name:","Ivan Ivanov" )
                .checkResult("Email:","abc@abc.com" )
                .checkResult("Current Address :","Los Angeles, Big street, house 4" )
                .checkResult("Permananet Address :","Los Angeles, Big street, house 4" );



    }


}

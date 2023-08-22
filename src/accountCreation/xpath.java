package accountCreation;

public class xpath {
    static final String staticPageTitle = "//div[@title='Google']";
    static final String staticCreateAccount = "//span[text()='Create account']";
    static final String staticPersonalUse ="//span[text()='For my personal use']";
    static final String staticFirstName = "firstName"; //id
    static final String staticLastName = "lastName"; //id
    static final String staticNextBtn = "//span[text()='Weiter']";
    static final String staticDateDOB = "//input[@name='day']";
    static final String staticMonthDOB = "//select[@id='month']";
    static final String staticYearDOB = "year"; //id
    static final String staticGender = "//select[@id='gender']";
    static final String staticSelectGmailAdressRadioBtn = "(//div[@role='radio'])[1]";
    static final String staticTextSelectGmailAddress = "//span[text()=\"Gmail-Adresse ausw\u00E4hlen oder eine eigene erstellen\"]";
    static final String staticTextEnterGmailAddress = "//span[text()=\"Erstellen Sie eine Gmail-Adresse, um sich in Ihrem Google-Konto anzumelden\"]";
    static final String staticEnterGmailAddress = "//input[@name='Username']";
    static final String staticLogo ="//div[@id ='logo' and @title ='Google']";
    static final String staticEnterPassword = "//input[@name='Passwd']";
    static final String staticEnterPasswordAgain = "//input[@name='PasswdAgain']";
    static final String staticNextBtnPasswordPage = "//div[@id='createpasswordNext']//button";
}

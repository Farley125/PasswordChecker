public class SecurePassword
{
    private String password;

    public SecurePassword(String password)
    {
        this.password = password;
    }

    public void setPassword(String newPassword)
    {
        password = newPassword;
    }

    public boolean isSecure()
    {
        if (isLongEnough() && containsUppercase() && containsLowercase() && containsSpecialSymbol() && containsDigit())
        {
            return true;
        }
        else return false;
    }

    public String status()
    {
        String output = "";
        if (isLongEnough() == false)
        {
            output += "The password must be at least 8 characters" + '\n';
        }
        if (containsUppercase() == false)
        {
            output += "The password must contain an uppercase character" + '\n';
        }
        if (containsLowercase() == false)
        {
            output += "The password must contain a lowercase character" + '\n';
        }
        if (containsSpecialSymbol() == false)
        {
            output += "The password must contain a special symbol: ! @ # $ % ^ & * ?" + '\n';
        }
        if (containsDigit() == false)
        {
            output += "The password must contain a numerical digit" + '\n';
        }
        if (output.equals(""))
        {
            return "Password is secure.";
        }
        else
        {
            return output;
        }
    }

    private boolean isLongEnough()
    {
        return (password.length() >= 8);
    }

    private boolean containsUppercase()
    {
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return checkString(upperCaseLetters);
    }

    private boolean containsLowercase()
    {
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        return checkString(lowerCaseLetters);
    }

    private boolean containsDigit()
    {
        String digits = "0123456789";
        return checkString(digits);
    }

    private boolean containsSpecialSymbol()
    {
        String specialSymbols = "!@#$%^&*?";
        return checkString(specialSymbols);
    }

    private boolean checkString(String characterString)
    {
        for (int i = 0; i < password.length(); i++)
        {
            for (int count = 0; count < characterString.length(); count++)
            {
                if (password.substring(i,i+1).equals(characterString.substring(count, count+1)))
                {
                    return true;
                }
            }
        }
        return false;
    }
}

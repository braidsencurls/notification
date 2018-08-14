package com.psi.beans;

/**
 * @author kul_grace
 */
public class EmailConfigurationBean
{

    private String smtpUser;

    private String smtpPassword;

    public String getSmtpUser()
    {
        return smtpUser;
    }

    public void setSmtpUser( String smtpUser )
    {
        this.smtpUser = smtpUser;
    }

    public String getSmtpPassword()
    {
        return smtpPassword;
    }

    public void setSmtpPassword( String smtpPassword )
    {
        this.smtpPassword = smtpPassword;
    }

    @Override
    public String toString()
    {
        return "Smtp User: " + this.getSmtpUser() + "\n" + "\n" + "Smtp Password: " + this.getSmtpPassword()
            + "\n";
    }

}

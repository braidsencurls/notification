package com.psi.services;

import java.util.Properties;
import java.util.Set;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.psi.beans.EmailBean;
import com.psi.beans.EmailConfigurationBean;
import com.psi.beans.EmailHeaderBean;

/**
 * @author kul_grace
 */
public class EmailServiceImp implements EmailService
{

    private static final Logger logger = LoggerFactory.getLogger( EmailServiceImp.class );

    @Override
    public boolean sendEmail( EmailBean emailBean, Properties properties )
    {

        EmailConfigurationBean emailConfig = emailBean.getEmailConfiguration();
        EmailHeaderBean emailHeader = emailBean.getEmailHeader();

        final String user = emailConfig.getSmtpUser();
        final String password = emailConfig.getSmtpPassword();

        Session session = Session.getDefaultInstance( properties, new Authenticator()
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication( user, password );
            }
        } );

        try
        {
            Message message = new MimeMessage( session );
            message.setFrom( new InternetAddress( emailHeader.getSender() ) );
            message.setSubject( emailHeader.getSubject() );
            Set< String > recipientList = emailHeader.getRecipients();
            String recipients = "";
            for( String recipient : recipientList )
            {
                recipients = recipients + recipient.trim() + ",";
            }
            message.addRecipients( Message.RecipientType.TO,
                InternetAddress.parse( recipients.substring( 0, recipients.length() - 1 ) ) );
            Set< String > replyToList = emailHeader.getReplyTo();
            if( replyToList != null )
            {
                for( String replyTo : replyToList )
                {
                    message.setReplyTo( InternetAddress.parse( replyTo ) );
                }
            }
            String format = emailBean.getFormat() != null ? emailBean.getFormat() : "text/html";
            message.setContent( emailBean.getMessage(), format );
            Transport.send( message );
            logger.info( "Message Successfully Sent" );
            return true;
        }
        catch( MessagingException e )
        {
            e.printStackTrace();
            logger.error( "Message Sending Failed. " + e.getMessage() );
            return false;
        }
    }

    @Override
    public boolean sendEmailWithAttachment( EmailBean emailBean )
    {

        return false;
    }

}

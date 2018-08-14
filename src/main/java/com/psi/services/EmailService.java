package com.psi.services;

import java.util.Properties;

import com.psi.beans.EmailBean;

/**
 * @author kul_grace
 */

public interface EmailService
{

    /**
     * Send email without attachment
     * 
     * @param emailBean
     * @return
     */
    public boolean sendEmail( EmailBean emailBean, Properties properties );

    /**
     * Send email with attachment/s
     * 
     * @param emailBean
     * @return
     */
    public boolean sendEmailWithAttachment( EmailBean emailBean );

}

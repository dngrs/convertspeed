package utils;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Set;

/**
 * Created by Igor Odokienko
 */
public class HeaderHandler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        Boolean outboundProperty = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (outboundProperty) {
            SOAPMessage message = context.getMessage();

            try {
                SOAPEnvelope envelope = context.getMessage().getSOAPPart().getEnvelope();
                SOAPHeader header = envelope.getHeader();

                if(header == null){
                    header = envelope.addHeader();
                } else {
                    SOAPElement security =
                            header.addChildElement("Security", "wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
                    //Set 'mustUnderstand' attribute to '1';
                    security.addAttribute(new QName("http://schemas.xmlsoap.org/soap/envelope/", "mustUnderstand", "soapenv"), "1");

                    SOAPElement usernameToken =
                            security.addChildElement("UsernameToken", "wsse");
                    usernameToken.addAttribute(new QName("xmlns:wsu"), "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");

                    SOAPElement username =
                            usernameToken.addChildElement("Username", "wsse");
                    username.addTextNode("admin");

                    SOAPElement password =
                            usernameToken.addChildElement("Password", "wsse");
                    password.setAttribute("Type", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");
                    password.addTextNode("pass");

                    message.saveChanges();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return false;
    }

    @Override
    public void close(MessageContext context) {

    }
}

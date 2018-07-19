// by md5_salt
package burp;

public class BurpExtender implements IBurpExtender
{
    public void registerExtenderCallbacks(
            IBurpExtenderCallbacks callbacks)
    {
        callbacks.setExtensionName("Show Http Host");
        callbacks.registerProxyListener(new ProxyListener());
    }
}

class ProxyListener implements IProxyListener{
    public void processProxyMessage(boolean messageIsRequest,
                                    IInterceptedProxyMessage message) {

        byte[] request = message.getMessageInfo().getRequest();
        String reqstr = this.byteArrayToStr(request);
        String[] headers = reqstr.split("\n");
        for(int i = 1; i < headers.length; i++){
            String header = headers[i].trim().toLowerCase();
            if(header.startsWith("host:")){
                message.getMessageInfo().setComment(header.substring(5).trim());
            }
        }
    }
    public String byteArrayToStr(byte[] byteArray) {
        if (byteArray == null) {
            return null;
        }
        String str = new String(byteArray);
        return str;
    }
}
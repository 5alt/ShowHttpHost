# ShowHttpHost
ShowHttpHost is a burpsuite extension that shows http request host in the comment field.

## why & how
When I use frida to do some [ssl unpinning](https://codeshare.frida.re/@pcipolloni/universal-android-ssl-pinning-bypass-with-frida/) stuff on Android and use burpsuite as a proxy server, I find the `Host` field in burpsuite's `proxy->HTTP history` tab is an ip address but not a domain name. I find out that it is because the `CONNECT` request for the https handshake uses ip address as the hostname, so burpsuite mistakenly use the ip addrrss as `Host`. It is very inconvenient for a pentester to review http logs.

The solution here is an extension for burpsuite. It parses the http request body and extracts the host field and fill it into the `Comment` field.

## install
There is a pre-compiled jar. Install the jar file the same way as other burpsuite extensions.

`Extender -> Extensions -> Add`

## compile (copied from portswigger's tutorial)

Create a new empty project, with whatever name you like.

Within the project, create a package called "burp".

Use Burp Suite to export the latest Burp Extender interface files. You can do this at Extender / APIs / Save interface files. Save the interface files into the folder that was created for the burp package.

Within the burp package, copy the `BurpExtender.java` in to this folder.

Build the project, and find the location of the JAR file that was created by the IDE (usually in a folder called "dist").

In Burp (v1.5.01 or later), go to the Extender tool, and the Extensions tab, and add a new extension. Select the extension type "Java", and specify the location of your JAR file.

## contact
md5_salt [AT] qq.com

## reference
https://portswigger.net/blog/writing-your-first-burp-suite-extension
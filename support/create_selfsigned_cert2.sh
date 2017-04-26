#!/bin/bash

export PW=`cat password`

# Create a self signed key pair root CA certificate.
keytool -genkeypair -v \
  -alias techlyricca \
  -dname "CN=techlyric.org, OU=Techlyric Org, O=Techlyric LLC, L=Laurel, ST=Maryland, C=US" \
  -keystore techlyricca.jks \
  -keypass:env PW \
  -storepass:env PW \
  -keyalg RSA \
  -keysize 2048 \
  -ext KeyUsage="keyCertSign" \
  -ext BasicConstraints:"critical=ca:true" \
  -validity 100

# Export the CA public certificate so that it can be used in trust stores..
keytool -export -v \
  -alias techlyricca \
  -file techlyricca.crt \
  -keypass:env PW \
  -storepass:env PW \
  -keystore techlyricca.jks \
  -rfc

keytool -genkeypair -v -alias tomcat -dname "CN=*.techlyric.org, OU=DEMO DEV, O=techlyric LLC, L=Laurel, ST=Maryland, C=US" \
   -keyalg RSA -keysize 2048 \
   -sigalg SHA256withRSA \
   -keystore tomcat.jks -keypass:env PW  -storepass:env PW 

keytool -certreq -keyalg RSA -sigalg SHA256withRSA -alias tomcat -file tomcat.csr -keystore tomcat.jks  -keypass:env PW  -storepass:env PW

keytool -gencert \
    -alias techlyricca \
    -keystore techlyricca.jks -keypass:env PW  -storepass:env PW \
    -infile tomcat.csr \
    -rfc \
    -outfile tomcat.pem \
    -keyalg RSA \
    -sigalg SHA256withRSA \
    -ext KeyUsage:critical="keyEncipherment,digitalSignature" \
    -ext SAN="DNS:zed" \
    -ext EKU="serverAuth,clientAuth" 

keytool -import -trustcacerts -alias techlyricca -file techlyricca.crt -keystore tomcat.jks -keypass:env PW  -storepass:env PW 
keytool -import -trustcacerts -alias tomcat -file tomcat.pem -keystore tomcat.jks -keypass:env PW  -storepass:env PW 

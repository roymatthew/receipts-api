#java -Xdebug -Xrunjdwp:transport=dtsocket,server=y,address=8000,suspend=n -jar receipts-api.
java "-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=0.0.0.0:8000" -jar receipts-api.jar
================== Spring boot proxy =================

1. Setup the application:

   - Download the latest version of artifactId (dist zip packaging) : custom-reverse-proxy
   - Unzip the package
   - inside there should be the following files and folders:
       * config - contains the application configuration - application.properties
       * lib - contains the spring boot jar
       * run-reverse-proxy.cmd - script for booting the proxy on windows
       * run-reverse-proxy.sh - script for booting the proxy on linux
       * Tomcat applications that we will be accessed from the proxy needs to have the following configuration in server.xml :
         <Valve
          className="org.apache.catalina.valves.RemoteIpValve"
          remoteIpHeader="x-forwarded-for"
          portHeader="x-forwarded-port"
          proxiesHeader="x-forwarded-by"
          protocolHeader="x-forwarded-proto" />

2. Running the application

    On Windows - double click the script run-reverse-proxy.cmd script
    On Linux - sh run-reverse-proxy.sh

3. Proxy server port

   Configured in config/application.properties with the entry

   server.port=8999

   if you want to change the port change this value.

4. Configuring Routes

    Routes are configured in config/application.properties file with the following format:

      zuul.routes.<UNIQUE-ROUTE-IDENTIFIER>.url=<URL_TO_REDIRECT>
      zuul.routes.<UNIQUE-ROUTE-IDENTIFIER>.path=<MAPPED_PATH>

5. Checking active routes:

    at url: http://localhost:<PROXY_PORT>/routes
      example: http://localhost:8999/routes, assuming that the proxy port is 8999.

6. Configuring Routes without restarting the application:

    This would require little bit extra work :)

    1. Add / Edit / Delete a route in config/application.properties then and save the file.

    2. make post request (easyest way with POSTMAN) to http://localhost:<PROXY_PORT>/refresh  --> no request params or body is required.

        example post to http://localhost:8999/refresh, assuming that the proxy port is 8999.

       You can check the changes on http://localhost:<PROXY_PORT>/routes.

        example post to http://localhost:8999/routes, assuming that the proxy port is 8999.




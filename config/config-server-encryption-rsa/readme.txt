1、执行以下命令
cd到工作目录
keytool -genkeypair -alias mytestkey -keyalg RSA -dname "CN=Web Server,OU=Unit,O=Organization,L=City,S=State,C=US" -keypass changeme -keystore server.jks -storepass letmein

2、将生成的server.jks文件复制到项目的classpath下

3、bootstrap.yml

4、curl http://localhost:18064/encrypt -d mysecret
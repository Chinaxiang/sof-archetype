# sof-archetype

微服务应用架构脚手架。

可快速创建用于开发环境的基础应用架构。

模板生成应用架构组成

![](http://qcdn.xinlijinrong.com/blog/screenshot_20170727154338.png/blog)

生成代码结构

![](http://qcdn.xinlijinrong.com/blog/screenshot_20170727154714.png/blog)

模块是可以自己配置的。

- dal: 数据访问层，脚手架中采用的是mybatis, druid.
- biz: 逻辑处理层，依赖dal，处理业务逻辑，事务等。
- facade: 微服务接口层，对外提供的接口定义，参数定义，数据传输格式定义等。
- facade-impl: 微服务接口实现层，具体的微服务逻辑，包括服务的注册发布等，依赖biz层。
- integration: 第三方服务层，如果需要调用别的系统发布的服务，可以在这一层订阅具体的服务供内部使用。
- web: 视图接口层，处理http请求，响应数据或页面，可以依赖biz和integration.
- assembly: 打包处理，将各模块组装成war包。
- conf: 配置文件，配合assembly实现不同环境使用不同配置信息的功能。
- webdocs: 静态资源文件，模板引擎使用的是freemarker, 当然，你可以自行替换。

## 安装脚手架

关于 maven 脚手架相关的知识请自行搜索或查阅相关书籍文档。

将本项目克隆或下载到本地目录，执行

```
mvn clean install
```

将脚手架发布到本地maven仓库中。

如果需要将其发布到私服中，修改脚手架的pom文件中的 distributionManagement 元素内容为自己的私服地址即可。（前提是你得有私服的发布账号及密码）

执行

```
mvn clean deploy
```

将脚手架发布到私服。

查看仓库中会多一个：archetype-catalog.xml 文件。

内容大致如下：

```
...
<archetype>
  <groupId>com.quanshi</groupId>
  <artifactId>sof-archetype</artifactId>
  <version>1.0.0</version>
  <description>sof-archetype</description>
</archetype>
...
```

## 使用脚手架

当脚手架发布成功后，就可以使用了。

使用交互的方式：

```
mvn archetype:generate
```

出现脚手架列表：

```
Choose archetype:
...
10: internal -> org.apache.maven.archetypes:maven-archetype-webapp (An archetype which contains a sample Maven Webapp project.)
11: local -> com.quanshi:sof-archetype (sof-archetype)
Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): 7: 
```

选择 `11: local -> com.quanshi:sof-archetype (sof-archetype)`

按照提示，输入下面几项内容：

- groupId: 你要创建的项目的groupId
- artifactId: 你要创建的项目的artifactId
- version: 项目版本号
- package: 项目基础包路径


```
Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): 7: 11
Define value for property 'groupId': com.coder4j
Define value for property 'artifactId': demo
Define value for property 'version' 1.0-SNAPSHOT: : 1.0.0
Define value for property 'package' com.coder4j: : com.coder4j.demo
Confirm properties configuration:
groupId: com.coder4j
artifactId: demo
version: 1.0.0
package: com.coder4j.demo
 Y: : y
[INFO] ----------------------------------------------------------------------------
[INFO] Using following parameters for creating project from Archetype: sof-archetype:1.0.0
[INFO] ----------------------------------------------------------------------------
[INFO] Parameter: groupId, Value: com.coder4j
[INFO] Parameter: artifactId, Value: demo
[INFO] Parameter: version, Value: 1.0.0
[INFO] Parameter: package, Value: com.coder4j.demo
[INFO] Parameter: packageInPathFormat, Value: com/coder4j/demo
[INFO] Parameter: package, Value: com.coder4j.demo
[INFO] Parameter: version, Value: 1.0.0
[INFO] Parameter: groupId, Value: com.coder4j
[INFO] Parameter: artifactId, Value: demo
[INFO] Parent element not overwritten in C:\Users\yanxiang.huang\workspace\test\demo\app\dal\pom.xml
[INFO] Parent element not overwritten in C:\Users\yanxiang.huang\workspace\test\demo\app\biz\pom.xml
[INFO] Parent element not overwritten in C:\Users\yanxiang.huang\workspace\test\demo\app\facade\pom.xml
[INFO] Parent element not overwritten in C:\Users\yanxiang.huang\workspace\test\demo\app\facade-impl\pom.xml
[INFO] Parent element not overwritten in C:\Users\yanxiang.huang\workspace\test\demo\app\integration\pom.xml
[INFO] Parent element not overwritten in C:\Users\yanxiang.huang\workspace\test\demo\app\web\pom.xml
[INFO] Parent element not overwritten in C:\Users\yanxiang.huang\workspace\test\demo\assembly\pom.xml
[INFO] Parent element not overwritten in C:\Users\yanxiang.huang\workspace\test\demo\webdocs\pom.xml
[INFO] Project created from Archetype in dir: C:\Users\yanxiang.huang\workspace\test\demo
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 06:50 min
[INFO] Finished at: 2017-07-27T16:16:00+08:00
[INFO] Final Memory: 13M/243M
[INFO] ------------------------------------------------------------------------

```

最终得到项目。

或者可以使用一条命令快速生成：

```
mvn archetype:generate \
-DarchetypeGroupId=com.quanshi \
-DarchetypeArtifactId=sof-archetype \
-DarchetypeVersion=1.0.0 \
-DgroupId=com.coder4j \
-DartifactId=bee \
-Dversion=1.0.0 \
-Dpackage=com.coder4j.bee
```

如果是别人发布到私服，你通过私服来创建的话。

将私服地址配置到setting.xml中。

配置mirror或者repository均可。

## 项目配置

通过脚手架得到的项目需要简单的配置部分内容。

### 日志路径

项目日志路径的配置文件在：`conf/config/logback.xml` 中，自行更改一个可以使用的日志路径。

### 数据库

初始项目的dal层是有初始代码的，需要用到一张表：`t_demo`

表结构在 `dal/src/main/resources/test.sql` 中。

数据库的配置文件在 `conf/config/application.properties`

我这里没有配置到 `conf/filter` 下，如果你们需要不同环境，请将配置放置到filter目录的不同文件内，assembly打包模块会将filter中的文件填充到config中。

## 项目启动

配置更改完毕后，下面开始编译启动。

```
mvn clean package
```

启动完成，将  `target/${artifactId}.war` 文件拷贝到 tomcat 的webapps下，启动tomcat即可。

项目默认使用的jdk 1.8编译。

访问：

```
http://localhost:8080/${artifactId}/
```

## 其他

脚手架中继承了一些常用的工具，如mybatis-generator, druid监控等。

### mybatis-generator的使用

在dal模块下，更改resources目录下的`init.properties`为你个人项目的配置信息。执行：

```
mvn mybatis-generator:generate
```

如果使用eclipse的话，可以点击dal项目右键，run as -> maven build..., 在goals中输入：

```
mybatis-generator:generate
```

关于generator的使用不再过多介绍。

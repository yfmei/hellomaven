# 概述
- 新建一个maven项目
    - 可以选择从maven模板创建，需要自己在src/main下增加java和main同级增加test目录，并分别标记为source和test
    - 也可以自己创建maven项目，不过没有webapp目录，需自行添加
- maven会自动在main/java下寻找项目主目录，所以在main/java下新建HelloWorld类  
- 执行clean compile
    - 可以看到日志输出先是clean，清理输出目录target
    - 然后是resource,暂时没有，先跳过
    - 最后compile,将项目主代码编译到target目录
- 因为maven的历史原因,有的maven版本的核心插件compile可能不支持你当前的java版本，需要在pom中添加如下信息指定支持java1.8
```<build>
        <finalName>helloworld/finalName>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
```
- clean test
    - 先是编译测试用例到target/test-classes/形成二进制文件
    - 然后执行surefire,surefire是maven中的测试插件，显示测试了多少，失败了多少，跳过了多少
- 打包和运行 package
    - 默认是打包成jar，不过在pom中指定pacakging为war所以打成了war包
    - 实际上是war插件 
    - 可以从控制台看到，在target/生成了war包名称helllo-world.war并复制src/main下的webapp打进war包里
    - 最后生成war包
- install
    - 复制上一步生成的jar或者war到需要的地方就可以使用HelloWorld 类
    - 为了让maven项目直接使用HelloWorld类，我们执行install命令，将jar或者war安装maven的本地仓库中
- 测试实例 mail
-    

# 坐标定义
- maven通过项目坐标来在中央仓库或者本地仓库查找jar包
- 定义：
```
<groupId></groupId>  # 定义当前maven模块所属的实际项目，比如springframework这一实际项目
<artifactId></artifactId>  # 定义实际项目中的一个模块，推荐使用实际项目的名称作为artifactId的前缀 比如spring-core,因为默认情况下maven生成的构件是以artifactId作为前缀的，比如core.jar
<version></version>  # 定义当前项目的版本
# 可选
<packaging></packaging>  #　指定打包的格式默认是jar，还可以制定为war和pom,通常和maven生成的构件后缀相对应
<classifier></classifier>  # 利用其他插件,帮助定义构件输出的附属构件，如javadoc文档，source源代码

```
- 约定:   
    一般构件生成的文件名:artifactIc-version[-classifier].packaging,[-classifier]表示可选
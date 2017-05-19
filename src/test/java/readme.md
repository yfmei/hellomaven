# 测试流程
- 准备测试类及数据 
```
HelloWold helloWorld = new HelloWorld();
```
- 执行测试行为
```
result = helloWorld.sayHello();
```
- 检查结果
```
assertEquals("hello maven",result);
```
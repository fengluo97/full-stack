# 类加载子系统

## 一、类加载过程

### 1、加载

- 通过类的全限定名获取定义此类的二进制字节流
- 将这个字节流所代表的静态存储结构转化为方法区的运行时数据结构
- 在堆内存中生成一个代表这个类的 java.lang.Class 对象，作为方法区这个类的各种数据的访问入口

加载途径包括：本地系统直接加载、通过网络加载、jar/war包获取、运行时计算生成比如动态代理等

### 2、链接

#### （1）验证 Verify

- 确保 Class 文件的字节流中包含信息符合当前虚拟机要求，保证被加载类的正确性，不会危害虚拟机的安全
- 包括四种验证，文件格式验证（CAFEBABE），元数据验证，字节码验证，符号引用验证

#### （2）准备 Prepare

- 为类变量分配内存，并设置为默认零值，这里不包含 final 修饰的 static，final 在编译的时候就会分配了，准备阶段会显式初始化

#### （3）解析 Resolve

- 将常量池里的符合引用转换为直接引用，也就是得到类、字段、方法在内存中的指针或者偏移量

### 3、初始化

- 初始化阶段就是执行类初始化方法 \<clinit\>() 的过程 即 class init，此方法不需要定义，是 javac 编译器自动收集类中的所有**类变量（static）**的赋值动作和**静态代码块**中的语句合并而来，并且指令按照代码中的顺序执行
- 子类加载之前必须保证父类已加载，且父类的 clinit 方法执行完毕
- 虚拟机必须保证一个类的 clinit 方法只会被执行一次，多线程下必须同步，其他线程会被阻塞，所以 clinit 可能会产生死锁问题！



1、父类静态方法、静态代码块

2、子类静态方法、静态代码块

3、父类的构造代码块

4、父类的构造方法

5、子类的构造代码块

6、子类的构造方法

7、子类的某个方法
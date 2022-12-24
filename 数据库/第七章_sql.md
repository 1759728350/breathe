##### 支持数据库运行的文件

支持数据库运行的文件有（主数据文件.mdf)，(辅助数据文件.ndf）和（日志文件.ldf)，
其中必不可少的文件是（主数据文件.mdf）和(日志文件.ldf);
2、在支持数据库运行的各种文件中，
个数可以是0或多个的是（辅助数据文件.ndf）文件;
个数可以是1或多个的是（日志文件.ldf）文件;
个数只能是1个且不可增减的是（主数据文件.mdf)文件。

#### 创建数据库
![](img/Pasted%20image%2020221224200849.png)
![](img/Pasted%20image%2020221224201008.png)
primary可省略(组名,类似于操作系统的组)

以默认方式创建数据库LV
```sql
create database LV;
```
2、定义数据库LV，其主数据文件逻辑名LV，存在D: \Data文件夹中;
事务日志文件逻辑名LV_log，存在和主数据文件相同目录下
```sql
create database LV on (name=LV,filename="D:\Data\LV.mdf")
log on (name=LV_log,filename="D:\Data\LV_log.ldf")
```
![](img/Pasted%20image%2020221224203529.png)
```sql
create database students on primary
    (name=students,filename="F:\Data\students.mdf",size=1,
    Filegrowth=3),
    (name=students_datal,filename="F:\Data\students_datal.ndf",
    size=5MB,maxsize=10,filegrowth=1MB)
    log on
    (name=students_log,size=2MB,filegrowth=10%,maxsize=6MB,
    filename="F:\Data\students_log.ldf")
```
MB单位可省略
name逻辑名不需要加单位,必须在filename之前写
filename地址名

#### 删除数据库
```sql
drop database LV #删除数据库LV
```

#### 修改数据库
##### 修改
在原有文件上修改
![](img/Pasted%20image%2020221224214645.png)
例,为教学管理数据库JXGL增加容量,原来的数据库文件JXGL. mdf的初始分配空间为3MB(默认值),现在将增至10MB。
```sql
alter database JXGL 
modify file
(name=JXGL,size=10)    ##文件逻辑名不加后缀,物理名才加
```

##### 增加
增加了一个文件
![](img/Pasted%20image%2020221224220354.png)
例5.5为教学管理数据库JXGL<font color=#66CC99 style=" font-weight:bold;">增加</font>辅助数据<font color=#66CC99 style=" font-weight:bold;">文件</font>JXGL_1.NDF,存在D: \Data,初始大小为5MB,最大长度为30MB,按照5%增长。
```sql
alter database JXGL 
add file
(name=JXGL_1,filename='D: \Data\JXGL_1.ndf',size=5,
maxsize=30,filegrowth=5%)
```
![](img/Pasted%20image%2020221224220454.png)

##### 删除
![](img/Pasted%20image%2020221224220603.png)
删除教学管理数据库JXGL中的辅助数据文件JXGL_1.ndf。
```sql
alter database JXGL
remove file JXGL_1    #文件逻辑名不加后缀
```

总结:二级命令主要是:modify file ,add file,add log file,remove file

#### 数据库表
##### 数据类型


#### 创建表

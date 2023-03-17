##### 四种sql分类
DDL包括create alter drop  
DQL是select语句  
DCL是grant deny revoke  
![](img/Pasted%20image%2020230316233727.png)
![](img/Pasted%20image%2020230317000820.png)

##### 支持数据库运行的文件  
  
支持数据库运行的文件有（主数据文件.mdf)，(辅助数据文件.ndf）和（日志文件.ldf)，  
其中必不可少的文件是（主数据文件.mdf）和(日志文件.ldf);  
2、在支持数据库运行的各种文件中，  
个数可以是0或多个的是（辅助数据文件.ndf）文件;  
个数可以是1或多个的是（日志文件.ldf）文件;  
个数只能是1个且不可增减的是（主数据文件.mdf)文件。  
### 数据库增删改
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
  
#### 修改数据库配置  
<font color=#F09B59 style=" font-weight:bold;">用的是add remove modify,注意和crud区别</font>  
##### 修改文件  
在原有文件上修改  
![](img/Pasted%20image%2020221224214645.png)  
例,为教学管理数据库JXGL增加容量,原来的数据库文件JXGL. mdf的初始分配空间为3MB(默认值),现在将增至10MB。  
```sql  
alter database JXGL   
modify file  
(name=JXGL,size=10)    ##文件逻辑名不加后缀,物理名才加  
```  
  
##### 增加文件  
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
  
##### 删除文件  
![](img/Pasted%20image%2020221224220603.png)  
删除教学管理数据库JXGL中的辅助数据文件JXGL_1.ndf。  
```sql  
alter database JXGL  
remove file JXGL_1    #文件逻辑名不加后缀  
```  
  
总结:二级命令主要是:modify file ,add file,add log file,remove file  

### 表增删改
#### 创建表  
主键多个就放在表级约束  
多个表末尾不要忘记加  "  ;  "  
![](img/Pasted%20image%2020221226155036.png)  
![](img/Pasted%20image%2020221226155220.png)  

![](img/Pasted%20image%2020230316234250.png)
![](img/Pasted%20image%2020230317000739.png)


#### 删除表  
```sql  
drop table 表名  
```  
![](img/Pasted%20image%2020230316234541.png)

区分drop和delete  
delete删除一行行元组记录的  
#### 修改表结构  
<font color=#F09B59 style=" font-weight:bold;">add drop alter区别于crud</font>
##### 修改列  
修改表中列的数据类型  
```sql  
alter table 表名  
alter column 列名 <数据类型> <约束>  ##数据类型和约束需要改哪个  
##就写哪个  
ALTER TABLE S  
ALTER COLUMN SEX CHAR(1)##将sex列数据类型修改为char  
```  
  
##### 增加列  
<font color=#66CC99 style=" font-weight:bold;">增加列不需要加column</font>
```sql  
alter table 表名  
add 列名 数据类型 约束  ##add语句不需要加column  
```  
![](img/Pasted%20image%2020230316235459.png)
##### 删除列  
```sql  
alter table 表名  
drop column 列名  
```  
修改列名:  
因为没有修改列名的语句  
可以先删后加  
```sql  
##在学生表S中,将AGE列名改为BIRTHDAY,数据类型为DATE  
alter table S  
drop column AGE;  
alter table S  
add BIRTHDAT DATE;  
```  
![](img/Pasted%20image%2020230317000038.png)


### 约束
##### 增加删除约束  
```sql  
alter table 表名  
add constraint 约束名 约束内容  
##删除约束  
alter table 表名  
drop constraint 约束名  
```  

##### 约束
```sql
主键,外键,非空not null
唯一约束unique,直接后面加unique
检查约束check
age int check(age >= 18 and age <=60)//模糊条件一般用check约束
```


### 增删改查总结
数据库create drop alter  
数据库里的alter包含add remove modify    
表create drop alter   
表中列的alter中包含add drop alter   

<font color=#F09B59 style=" font-weight:bold;">一律用create drop alter其他的就是       
</font>   
<font color=#F09B59 style=" font-weight:bold;">列的增加是add,库文件的删除和修改是remove和modify</font>


##### 代码大题
技能课会考  
![](img/Pasted%20image%2020230317215358.png)

1.写出建表语句
```sql
create table 职工
(
    职工号 char(6) primary key,
    姓名 varchar(8) not null,
    性别 char(2),
    年龄 int,
    职务 varchar(20),
    ...
)
```
```sql
create table 保健所
(
    保健所编号 char(6) primary key,
    保健所名称 varchar(20) not null,
    ...
)
```
```sql
create table 保健
(
    职工号 char(6) not null,
    保健所编号 char(6) not null,
    检查日期 datetime not null,
    健康状况 varchar(10) not null,
    
    primary key(职工号,保健所编号,检查日期),  ##这一行注意了!!!
    
    foreign key(职工号) references 职工(职工号),
    
    //外键要加references 表(属性)
    
    foreign key(保健所编号) references 保健所(保健所编号)
)
```
2）为职工表添加一列联系电话。(要求为11位数字)  
```sql
alter table 职工
add 联系电话 char(4) check(联系电话 like '[0-9][0-9][0-9][0-9]'
```

3）将记录(000011,皇姑区第二保健所,皇姑区泰山路58号,35896652)插入到保健所表。
```sql
insert into 保健所 values('',''...)
```
6）查询健康状况为”良好”的职工的姓名、性别和年龄。
```sql
select 姓名,性别,年龄 from 职工,保健  //两个表用逗号隔开
where 职工.职工号 = 保健.职工号
and 保健.健康状况='良好';

或者
select 姓名,性别,年龄 from 职工
join 保健 on 职工.职工号 = 保健.职工号
where 保健.健康状况='良好';
```



### 其他
null只有在update的set后面可以用等号  
其余都只能用is  
![](img/Pasted%20image%2020230316232200.png)





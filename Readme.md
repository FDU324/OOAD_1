## OOAD Project

- 14302010038 王翀
-  14302010049 蒲实

1. 架构
- PJ实现了数据层和业务层，主要使用到Spring和Hibernate
- 数据层使用Hibernate封装，实现在`src\main.common`和`src\main.model`中
    - 其中`main.model`实现了数据库的ORM映射
    - `main.common`封装了基本的数据库操作，对外提供操作的接口
- 业务层实现在`src\main.service`中，对于每个用例提供了操作的接口，最后的测试也是在这里提供的接口上进行测试
    - 业务层对数据库的操作完全通过数据层提供的接口实现

---

2. 数据层 `src\main.common`
    - ORM `src\main.model` 
        - `Company`：企业
        - `RiskCheckTemplateItem`：检查条目，为某一具体的检查条目
        - `RiskCheckTemplate`：检查模版，包括了一个检查项的集合
        - `RiskCheckPlan`：检查计划，包括了对应了检查模版
        - `RiskCheck`：检查任务，一次检查包括了对应的企业、计划，并包含了具体的检查条目
        - `RiskCheckItem`：企业可见的某一具体的检查条目，企业可以对其录入进度
        - 其中`eunums`有`Company`和`RiskCheck`的`state`的枚举，以及相应的数据库转换器类
    - 数据库操作`src\main.common`
        - `src\main.common\IPersistenceManager`提供对数据库所有操作的接口
        - `src\main.common\PMHibernateImpl`为上述接口的实现
    - 数据库 Mysql
        - host : 115.28.169.114:3306
        - username: kadoufall
        - password: 123456
        - table : ooad1
        
---

3. 业务逻辑层 `src\main.service`
    - `ICompanyService` ： 封装了企业的相关操作
    - `IRiskCheckTemplateItemService` ： 封装了具体的检查条目的添加和搜索
    - `IRiskCheckTemplateService` ： 封装了检查模版的添加、编辑、搜索和添加具体的检查条目
    - `IRiskCheckPlanService` ： 封装了检查计划的添加、编辑、搜索和删除
    - `IRiskCheckService` ： 封装了分配一次任务的操作
    
---

4. JUnit单元测试  `src-test`
    - 测试的内容标注在注释中

---

5. 项目配置 `src-config`
    - 配置数据源、`Hibernate`以及数据层和业务层的位置

---

PS ： PJ的数据库持久化参考了张天戈老师的demo

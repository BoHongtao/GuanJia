#管家记账软件#


- app         启动main
- controller  控制器负责service层和view层的传递数据
- dao         直接操作数据库
- service		service负责逻辑计算，传递给DAO层入库
- tools		封装的连接jdbc的驱动类
- view		负责界面的显示
- domain		模型类，保存数据

# webUIPractice
web UI实战

- 不同浏览器访问baidu
    - [Firefox](src/main/java/com/test/java/webui/accessBaiduDemo/FirefoxAccessBaidu.java) -- 火狐访问百度
    - [Chrome](src/main/java/com/test/java/webui/accessBaiduDemo/ChromeAccessBaidu.java) -- Chrome访问百度
    - [IE](src/main/java/com/test/java/webui/accessBaiduDemo/IEAccessBaidu.java) -- IE访问百度
    - [小小封装下变成Common](src/main/java/com/test/java/webui/accessBaiduDemo/CommonAccessBaidu.java) -- 简单封装思路
    - [一个业务实例](src/main/java/com/test/java/webui/accessBaiduDemo/SearchTestOnBaidu.java) -- 百度一下Test，并记录下第一个div的文本
- SeleniumIDE
    - 定位元素方式
        - id
        - name
        - css
        - xpath(重点)
    - 使用
    - 录制回放
- TestNG基本介绍
    - TODO 什么是TestNG？跟JUnit区别在哪
    - [基本写法](src/main/java/com/test/java/testng/BasicDemo.java) -- before, test, after, assert
- 基本API
    - WebDriver
        - [浏览器最大化](src/main/java/com/test/java/webui/api/driver/MaximumBrowser.java)
    - WebElement
        - [getText](src/main/java/com/test/java/webui/api/element/GetTextTest.java) --获取元素文本
        - [getAttribute](src/main/java/com/test/java/webui/api/element/GetAttrubuteTest.java) --获取元素属性

- 高级技巧
    - Actions(键盘事件、鼠标双击)
        - [鼠标双击](src/main/java/com/test/java/webui/api/highLevelSkills/actions/ActionsDemo)
    - 执行JS
        - [用jQuery框架辅助](src/main/java/com/test/java/webui/api/highLevelSkills/jsExecutor/SelectElement.java)
    - 截图
        - [截图功能](src/main/java/com/test/java/webui/api/screenshot/highLevelSkills/TakesScreenshotTest.java)
    - 下拉列表
        - [选择下拉列表中的值](src/main/java/com/test/java/webui/api/highLevelSkills/select/SelectDemo.java)
    - 测试流控制
        - 等待
            - 隐式等待(src/main/java/com/test/java/webui/api/highLevelSkills/testFlowControl/ImplicitlyWaitDemo.java)
            - 显式等待(src/main/java/com/test/java/webui/api/highLevelSkills/testFlowControl/ConditionWaitDemo.java)
            - 自定义期望条件同步
        - 检查元素
            - 是否存在
            - 状态
        - 弹出窗口
            - 名称识别
            - 标题识别
            - 内容识别
        - 警告框
            - 警告框
            - 确认框
            - 提示框
        - 框架
- TestNG数据驱动
- TestNG xml运行




# webUIPractice
web UI实战

- 基础知识概览
    - [HTML](https://github.com/vagabond1-1983/blog/issues/39)
    - 作业： 设计一个注册表单
          这个网页标题为：系统注册页面
          表单包括：用户名、密码、确认密码、性别单选、所在省市、提交
          表单要规范，用表格形式呈现
    - [JavaScript](https://github.com/vagabond1-1983/blog/issues/40)
        - 表单验证部分代码 - formValidate.html
        - 随堂练习：注册页面在提交时，检查用户名的合法性（不为空、首字母不是空格、_），如果不合法，提示输入不正确，重新输入，如果合法，提示用户名输入正确
    - [DOM](https://github.com/vagabond1-1983/blog/issues/41)
        - 随堂练习：用DOM查找元素的方式，重写检查用户名的方法
    - [JQuery](https://github.com/vagabond1-1983/blog/issues/42)
        - 随堂练习：用JQuery查找元素的方式，重写检查用户名的方法
    - 作业：注册表单完善，包含JavaScript交互:
        提交后验证下列字段：
        用户名不能为空、用户名不能以数字开头
        密码不少于8位
        密码和确认密码相同
        注册提交后，用户输入的信息展示：用户名，性别，所在省市
- Selenium热身：不同浏览器自动化访问baidu
    - [什么是selenium](https://www.ibm.com/developerworks/cn/web/wa-selenium2/)
    - 软件安装：firefox, selenium IDE [百度云盘的软件共享](http://yun.baidu.com/pcloud/album/info?uk=1913063318&album_id=2794016679837573555)
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
    - 单元测试及框架 JUnit
    - 什么是TestNG？跟JUnit区别在哪
    - 为什么用单元测试框架
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
        - 检查元素
            - 是否存在(src/main/java/com/test/java/webui/api/highLevelSkills/testFlowControl/ElementPresentDemo.java)
            - 状态(src/main/java/com/test/java/webui/api/highLevelSkills/testFlowControl/ElementStatusCheckDemo.java)
        - 弹出窗口
            - 名称识别(src/main/java/com/test/java/webui/api/highLevelSkills/testFlowControl/WindowPopupDemo.java) -- windowsNameTest()
            - 标题识别(src/main/java/com/test/java/webui/api/highLevelSkills/testFlowControl/WindowPopupDemo.java) -- windowsTitleTest()
            - 内容识别(src/main/java/com/test/java/webui/api/highLevelSkills/testFlowControl/WindowPopupDemo.java) -- windowsContentTest()
        - 警告框
            - 警告框(src/main/java/com/test/java/webui/api/highLevelSkills/testFlowControl/AlertDemo.java) -- alertTest()
            - 确认框(src/main/java/com/test/java/webui/api/highLevelSkills/testFlowControl/AlertDemo.java) -- confirmTest()
        - 框架
            - 通过id或者name进入框架(src/main/java/com/test/java/webui/api/highLevelSkills/testFlowControl/FrameDemo.java) -- frameByIdOrNameTest()
            - 通过页面内容进入框架(src/main/java/com/test/java/webui/api/highLevelSkills/testFlowControl/FrameDemo.java) -- frameByContentTest()
- TestNG数据驱动
    - DataProvider
- TestNG xml运行
    - suite, test 套件的概念
- 模拟项目 自动化下单操作 -- 用哪个网站做例子。在前面应该穿插这样的技术铺垫



附录：
- 书籍文章推荐
    - [JavaScript秘密花园](http://bonsaiden.github.io/JavaScript-Garden/zh/)




#定位元素
搜索输入框
- id
    id=kw
- name
    name=wd
- css
    css=#kw
- xpath
    - 通过属性值定位元素 //input[@id='kw']
    - 通过tag路径定位元素 //span/input
“搜索一下”按钮
    - 通过属性值定位元素 //input[@value='百度一下']
新闻链接
    - 通过值定位元素 //a[contains(text(),'新闻')]
    - 通过兄弟节点定位 //a[contains(text(),'糯米')]/following::a




Refer：http://yangdan1988.blog.51cto.com/6983723/1205230
selenium-webdriver提供了强大的元素定位方法，支持以下三种方法：
 单个对象的定位方法
 多个对象的定位方法
层级定位

注意：
selenium-webdriver通过findElement()\findElements()等find方法调用"By"对象来定位和查询元素。By类只是提供查询的方式进行分类。findElement返回一个元素对象否则抛出异常，findElements返回符合条件的元素 List，如果不存在符合条件的就返回一个空的list。

一、定位单个元素
A.使用className进行定位
当所定位的元素具有class属性的时候我们可以通过classname来定位该元素。
例：下面的例子定位页面上class为"username"的li。
 WebElement element = driver.findElement(By.className("username"));
 System.out.println(element.getTagName());

输出结果：Li

B.使用id属性定位
例：<input id="passport_user" type="text" value="" title="用户名/邮箱" name="passport_user">
 WebElement element = dr.findElement(By.id("passport_user"));
 System.out.println(element.getAttribute("title"));

输出结果：用户名/邮箱

C.使用name属性定位
例：<input id="passport_user" type="text" value="" title="用户名/邮箱" name="passport_user">
 WebElement e = dr.findElement(By.name("passport_user"));

D.使用css属性定位
例：<input id="passport_user" type="text" value="" title="用户名/邮箱" name="passport_user">
 WebElement e1 = dr.findElement(By.cssSelector("#passport_user"));
详解：
1.css之后代选择器
<p>
 <em>location1</em>
</p>
<ol>
<li><em>location2</em></li>
</ol>
可以通过css=p em这个可以选中文本为location1的em元素
css=ol em这个可以选中文本为location2的em元素
css后代选择器和xpath中//div//a一样：取得所有div下面所有的a节点。这个是忽略了父子节点
<div>
 <p><em>location1</em></p>
</div>
<div>
<ol>
 <li><strong><em>location2</em></strong></li>
 <li><em>location3</em></li>
 <li><em>location4</em></li>
</ol>
</div>
可以通过css=p>em来定位location1
css之父子节点选择器给后代选择器加了一个限制，类似xpath中//div/p/em：所有div下的子元素p的子元素em。
css=li+li em来定位location3，location4的em
css=li+strong+em来定位文本为location2的em
2.css之id选择器
<input id="location1" type="button"/>
<input id="location2" type="radio"/>
通过css=#location1来定位type为button的按钮
通过css=#location2来定位type为radio的单选框
3.css之类选择器
<input class="location1" type="button" value="确定"/>
<input class="location2" type="button" value="取消"/>
通过css=input.location1来选择value值为确定的按钮
通过css=input.location2来选择value值为取消的按钮
4.css之属性选择器
<input class="location1" type="button" value="确定"/>
<input class="location2" type="button" />
通过css=[class=location1]可以定位第一个按钮
通过css=[class~=1]可以定位第一个按钮
通过css=[value="确定"]可以定位第一个按钮
通过css=input[class="location"]可以定位第二个按钮

E.按标记（tag）名称查找
元素的DOM标记名称
<iframe src=\'#\'" /iframe>
WebElement frame = driver.findElement(By.tagName("iframe"));
F.按链接文本查找
<a href="http://www.google.com/search?q=cheese">cheese</a>>
WebElement cheese = driver.findElement(By.linkText("cheese"));
按部分链接文本查找
<a href="http://www.google.com/search?q=cheese">search for cheese</a>>
WebElement cheese = driver.findElement(By.partialLinkText("cheese"));
G.使用 XPATH定位
例：<input id="passport_user" type="text" value="" title="用户名/邮箱" name="passport_user">
 WebElement element =dr.findElement(By.xpath("//input[@id='passport_user']"));
parent::返回父节点
following::返回此节点后面的兄弟节点
preceding::返回此节点前面的兄弟节点
div>
<input id="location1" type="button" />
<input type="button" />
</div>
通过id为location1可以很随意的定位到兄弟节点
//div/input[@id='location1']/following::input
也可以通过location1很随意的定位到父类节点div。
//div/input[@id='location1']/parent::div。
也可以通过索引为2的input定位到id为location1的input
//div/input[2]/preceding-sibling::input
有几个非常有用的Firefox插件，有助于发现一个元素的XPath：
XPath Checker - suggests XPath and can be used to test XPath results.
Firebug - XPath suggestions are just one of the many powerful features of this very useful add-on.
XPath Checker - 建议XPath并可以用于测试XPath的结果
Firebug - XPath建议仅仅是这非常有用的插件的许多强有力特征中的一个。
参考网站：http://www.w3school.com.cn/xpath/index.asp
二、定位多个元素
//定位到所有<input>标签的元素，然后输出他们的id
 List<WebElement> element = driver.findElements(By.tagName("input"));
 for (WebElement e : element)
 System.out.println(e.getAttribute("id"));

三、层级定位
层级定位的思想是先定位父元素，然后再从父元素中精确定位出其我们需要选取的子元素。
层级定位一般的应用场景是无法直接定位到需要选取的元素，但是其父元素比较容易定位，通过定位父元素再遍历其子元素选择需要的目标元素，或者需要定位某个元素下所有的子元素。

下面的代码演示了如何使用层级定位class为"login"的div，然后再取得它下面的所有label，并打印出他们的文本
//定位class为"login"的div，然后再取得它下面的所有label，并打印出他们的值
 WebElement element = driver.findElement(By.className("login"));
 List<WebElement> el = element.findElements(By.tagName("label"));
 for(WebElement e : el)
 System.out.println(e.getText());
四、使用Javascript
你可以执行任何Javascript，以找到一个元素，只要你找到一个DOM元素，它将自动转换为WebElement对
象。
WebElement element = (WebElement) ((JavascriptExecutor)driver).executeScript("return
$('.cheese')[0]");
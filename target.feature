###Feature:###
Background: 
		1.在公司业务和人员架构重组的背景下，公司将只保留安居客平台，用户端产品的合并，直接要求网站导航、网站客户/用户入口的重新调整和统一规划。
/*
*该文件主要用于验证用户端首页合并-导航项目中列表页和单页的搜索框的测试要点
*writer:minzhao* 	
*/
@P2 @1 A
Scenario : 二手房-房源列表页的搜索框样式
	Given  访问安居客首页
	And  点击二手房tab
	And  点击二手房二级导航房源tab
	When  查看页面的搜索模块样式
	Then  搜索框中的文案显示为：请输入房源特征、户型、地址或小区名…
	And  搜索按钮文案为“搜索”
	And  地图找房的文案为：“地图找房”
	And  搜索框右侧无"X"
@P2 @2 A
Scenario : 点击二手房-房源列表页的搜索框模块中地图找房图标
	Given  访问安居客首页
	And  点击二手房tab
	And  点击二手房二级导航房源tab
	When  点击房源列表页的搜索框模块中的地图找房图标
	Then  新开页面至二级导航对应的地图找房频道
@P2 @3 A
Scenario : 点击二手房-房源列表页的搜索框，验证搜索框内文字提示不消失
	Given  访问安居客首页
	And  点击二手房tab
	And  点击二手房二级导航房源tab
	When  点击房源列表页的搜索框
	And  查看搜索框内文字提示是否存在
	Then  存在
@P1 @4 A
Scenario : 在二手房-房源列表页搜索框中输入关键词后，查看搜索框显示样式变化
	Given  访问安居客首页
	And  点击二手房tab
	And  点击二手房二级导航房源tab
	When  在搜索框中输入“绿”
	And  查看搜索框样式变化
	Then  出现关键词联想
	And  输入框的右部出现"X"
@P2 @5 A
Scenario : 在二手房-房源列表页搜索框中输入关键词后，查看每一条下拉联想词
	Given  访问安居客二手房下面二级导航房源tab
	When  在搜索框中输入“绿”
	And  查看每一条下拉联想的样式
	Then  显示为：{联想词}+约{n}套
@P2 @6 A
Scenario : 在二手房-房源列表页搜索框中输入关键词后，查看下拉联想的房源套数{n}是否与二手房列表页数目是否一致
	Given  访问安居客二手房下面二级导航房源tab
	When  在搜索框中输入“绿”
	And  查看下拉联想的房源套数{n}是否与二手房列表页数目是否一致
	Then  一致
@P2 @7 A
Scenario : 在二手房-房源列表页搜索框中输入关键词后，然后点击右侧“X”符号
	Given  访问安居客二手房下面二级导航房源tab
	When  在搜索框中输入“绿”
	And  点击右侧"X"
	Then  输入框中的关键词消失
	And 关键词消失后右侧"X"也消失
@P2 @8 A
Scenario : 在二手房-房源列表页搜索框中输入关键词后，鼠标在下拉联想中移动，查看搜索框样式
	Given  访问安居客二手房下面二级导航房源tab
	When  在搜索框中输入“绿”
	And  用鼠标在下拉联想中移动
	Then  输入框内的文案不变，右侧有"X"
	And  移动到某一条下拉联想时，该下拉联想高亮
@P2 @9 A
Scenario : 在二手房-房源列表页搜索框中输入关键词后，键盘在下拉联想中移动，查看搜索框样式
	Given  访问安居客二手房下面二级导航房源tab
	When  在搜索框中输入“绿”
	And  用键盘箭头在下拉联想中移动
	Then  输入框内的文案随着键盘定位的文案而对应改变
	And 搜索框右侧有"X"
	And  移动到某一条下拉联想时，该下拉联想高亮
@P3 @10 A
Scenario : 在二手房-房源列表页中输入关键词后，在搜索框中点击enter键，查看搜索结果
	Given  访问安居客二手房下面二级导航房源tab
	When  在搜索框中输入“绿”
	And  在搜索框中点击enter键
	Then  跳转到以“绿”为关键词的搜索结果页
@P3 @11 A
Scenario : 在二手房-房源列表页中输入关键词后，点击“搜索”按钮，查看搜索结果
	Given  访问安居客二手房下面二级导航房源tab
	When  在搜索框中输入“绿”
	And  点击搜索按钮
	Then  跳转到以“绿”为关键词的搜索结果页
@P3 @12 A
Scenario : 在二手房-房源列表页中输入关键词后，在下拉联想中点击enter键，查看搜索结果
	Given  访问安居客二手房下面二级导航房源tab
	When  在搜索框中输入“绿”
	And  在下拉联想中点击enter键
	Then  跳转到以{下拉联想词}为关键词的搜索结果页
@P3 @13 A
Scenario : 在二手房-房源列表页中输入关键词后，用鼠标点击下拉联想，查看搜索结果
	Given  访问安居客二手房下面二级导航房源tab
	When  在搜索框中输入“绿”
	And  用鼠标点击下拉联想词
	Then  跳转到以{下拉联想词}为关键词的搜索结果页
	
@P2 @14 A
Scenario : 二手房-小区列表页的搜索框样式
	Given  访问安居客首页
	And  点击二手房tab
	And  点击二手房二级导航小区tab
	When  查看页面的搜索模块样式
	Then  搜索框中的文案显示为：请输入房源特征、户型、地址或小区名…
	And  搜索按钮文案为“搜索”
	And  搜索框右侧无"X"
@P2 @16 A
Scenario : 点击二手房-小区列表页的搜索框，验证搜索框内文字提示不消失
	Given  访问安居客首页
	And  点击二手房tab
	And  点击二手房二级导航小区tab
	When  点击小区列表页的搜索框
	And  查看搜索框内文字提示是否存在
	Then  存在
@P1 @17 A
Scenario : 在二手房-小区列表页搜索框中输入关键词后，查看搜索框显示样式变化
	Given  访问安居客首页
	And  点击二手房tab
	And  点击二手房二级导航小区tab
	When  在搜索框中输入“绿”
	And  查看搜索框样式变化
	Then  出现关键词联想
	And  输入框的右部出现"X"
@P2 @18 A
Scenario : 在二手房-小区列表页搜索框中输入关键词后，查看每一条下拉联想词
	Given  访问安居客二手房下面二级导航小区tab
	When  在搜索框中输入“绿”
	And  查看每一条下拉联想的样式
	Then  显示为：{联想词}+约{n}套
@P2 @19 A
Scenario : 在二手房-小区列表页搜索框中输入关键词后，查看下拉联想的小区套数{n}是否与小区列表页搜索结果数目是否一致
	Given  访问安居客二手房下面二级导航小区tab
	When  在搜索框中输入“绿”
	And  查看下拉联想的小区套数{n}是否与二手房列表页数目是否一致
	Then  一致
@P2 @20 A
Scenario : 在二手房-小区列表页搜索框中输入关键词后，然后点击右侧“X”符号
	Given  访问安居客二手房下面二级导航小区tab
	When  在搜索框中输入“绿”
	And  点击右侧"X"
	Then  输入框中的关键词消失
	And 关键词消失后右侧"X"也消失
@P2 @21 A
Scenario : 在二手房-小区列表页搜索框中输入关键词后，鼠标在下拉联想中移动，查看搜索框样式
	Given  访问安居客二手房下面二级导航小区tab
	When  在搜索框中输入“绿”
	And  用鼠标在下拉联想中移动
	Then  输入框内的文案不变，右侧有"X"
	And  移动到某一条下拉联想时，该下拉联想高亮
@P2 @22 A
Scenario : 在二手房-小区列表页搜索框中输入关键词后，键盘在下拉联想中移动，查看搜索框样式
	Given  访问安居客二手房下面二级导航小区tab
	When  在搜索框中输入“绿”
	And  用键盘箭头在下拉联想中移动
	Then  输入框内的文案随着键盘定位的文案而对应改变
	And 搜索框右侧有"X"
	And  移动到某一条下拉联想时，该下拉联想高亮
@P3 @23 A
Scenario : 在二手房-小区列表页中输入关键词后，在搜索框中点击enter键，查看搜索结果
	Given  访问安居客二手房下面二级导航小区tab
	When  在搜索框中输入“绿”
	And  在搜索框中点击enter键
	Then  跳转到以“绿”为关键词的搜索结果页
@P3 @24 A
Scenario : 在二手房-小区列表页中输入关键词后，点击“搜索”按钮，查看搜索结果
	Given  访问安居客二手房下面二级导航小区tab
	When  在搜索框中输入“绿”
	And  点击搜索按钮
	Then  跳转到以“绿”为关键词的搜索结果页
@P3 @25 A
Scenario : 在二手房-小区列表页中输入关键词后，在下拉联想中点击enter键，查看搜索结果
	Given  访问安居客二手房下面二级导航小区tab
	When  在搜索框中输入“绿”
	And  在下拉联想中点击enter键
	Then  跳转到以{下拉联想词}为关键词的搜索结果页
@P3 @26 A
Scenario : 在二手房-小区列表页中输入关键词后，用鼠标点击下拉联想，查看搜索结果
	Given  访问安居客二手房下面二级导航小区tab
	When  在搜索框中输入“绿”
	And  用鼠标点击下拉联想词
	Then  跳转到以{下拉联想词}为关键词的搜索结果页
@P3 @27 A
Scenario : 点击二手房-地图找房tab，查看跳转
	Given  点击安居客二手房tab
	When  再点击二手房下二级导航地图找房tab
	Then  跳转地图找房页面


	
@P2 @28 A
Scenario : 租房-房源列表页的搜索框样式
	Given  访问安居客首页
	And  点击租房tab
	And  点击租房二级导航房源tab
	When  查看页面的搜索模块样式
	Then  搜索框中的文案显示为：请输入房源特征、户型、地址或小区名…
	And  搜索按钮文案为“搜索”
	And  地图找房的文案为：“地图找房”
	And  搜索框右侧无"X"
@P2 @29 A
Scenario : 点击租房-房源列表页的搜索框模块中地图找房图标
	Given  访问安居客首页
	And  点击租房tab
	And  点击租房二级导航房源tab
	When  点击房源列表页的搜索框模块中的地图找房图标
	Then  新开页面至二级导航对应的地图找房频道
@P2 @30 A
Scenario : 点击租房-房源列表页的搜索框，验证搜索框内文字提示不消失
	Given  访问安居客首页
	And  点击租房tab
	And  点击租房二级导航房源tab
	When  点击房源列表页的搜索框
	And  查看搜索框内文字提示是否存在
	Then  存在
@P1 @31 A
Scenario : 在租房-房源列表页搜索框中输入关键词后，查看搜索框显示样式变化
	Given  访问安居客首页
	And  点击租房tab
	And  点击租房二级导航房源tab
	When  在搜索框中输入“绿”
	And  查看搜索框样式变化
	Then  出现关键词联想
	And  输入框的右部出现"X"
@P2 @32 A
Scenario : 在租房-房源列表页搜索框中输入关键词后，查看每一条下拉联想词
	Given  访问安居客租房下面二级导航房源tab
	When  在搜索框中输入“绿”
	And  查看每一条下拉联想的样式
	Then  显示为：{联想词}+约{n}套
@P2 @33 A
Scenario : 在租房-房源列表页搜索框中输入关键词后，查看下拉联想的房源套数{n}是否与租房列表页数目是否一致
	Given  访问安居客租房下面二级导航房源tab
	When  在搜索框中输入“绿”
	And  查看下拉联想的房源套数{n}是否与租房列表页数目是否一致
	Then  一致
@P2 @34 A
Scenario : 在租房-房源列表页搜索框中输入关键词后，然后点击右侧“X”符号
	Given  访问安居客租房下面二级导航房源tab
	When  在搜索框中输入“绿”
	And  点击右侧"X"
	Then  输入框中的关键词消失
	And 关键词消失后右侧"X"也消失
@P2 @35 A
Scenario : 在租房-房源列表页搜索框中输入关键词后，鼠标在下拉联想中移动，查看搜索框样式
	Given  访问安居客租房下面二级导航房源tab
	When  在搜索框中输入“绿”
	And  用鼠标在下拉联想中移动
	Then  输入框内的文案不变，右侧有"X"
	And  移动到某一条下拉联想时，该下拉联想高亮
@P2 @36 A
Scenario : 在租房-房源列表页搜索框中输入关键词后，键盘在下拉联想中移动，查看搜索框样式
	Given  访问安居客租房下面二级导航房源tab
	When  在搜索框中输入“绿”
	And  用键盘箭头在下拉联想中移动
	Then  输入框内的文案随着键盘定位的文案而对应改变
	And 搜索框右侧有"X"
	And  移动到某一条下拉联想时，该下拉联想高亮
@P3 @37 A
Scenario : 在租房-房源列表页中输入关键词后，在搜索框中点击enter键，查看搜索结果
	Given  访问安居客租房下面二级导航房源tab
	When  在搜索框中输入“绿”
	And  在搜索框中点击enter键
	Then  跳转到以“绿”为关键词的搜索结果页
@P3 @38 A
Scenario : 在租房-房源列表页中输入关键词后，点击“搜索”按钮，查看搜索结果
	Given  访问安居客租房下面二级导航房源tab
	When  在搜索框中输入“绿”
	And  点击搜索按钮
	Then  跳转到以“绿”为关键词的搜索结果页
@P3 @39 A
Scenario : 在租房-房源列表页中输入关键词后，在下拉联想中点击enter键，查看搜索结果
	Given  访问安居客租房下面二级导航房源tab
	When  在搜索框中输入“绿”
	And  在下拉联想中点击enter键
	Then  跳转到以{下拉联想词}为关键词的搜索结果页
@P3 @40 A
Scenario : 在租房-房源列表页中输入关键词后，用鼠标点击下拉联想，查看搜索结果
	Given  访问安居客租房下面二级导航房源tab
	When  在搜索框中输入“绿”
	And  用鼠标点击下拉联想词
	Then  跳转到以{下拉联想词}为关键词的搜索结果页
	
@P2 @41 A
Scenario : 租房-小区列表页的搜索框样式
	Given  访问安居客首页
	And  点击租房tab
	And  点击租房二级导航小区tab
	When  查看页面的搜索模块样式
	Then  搜索框中的文案显示为：请输入房源特征、户型、地址或小区名…
	And  搜索按钮文案为“搜索”
	And  搜索框右侧无"X"
@P2 @43 A
Scenario : 点击租房-小区列表页的搜索框，验证搜索框内文字提示不消失
	Given  访问安居客首页
	And  点击租房tab
	And  点击租房二级导航小区tab
	When  点击小区列表页的搜索框
	And  查看搜索框内文字提示是否存在
	Then  存在
@P1 @44 A
Scenario : 在租房-小区列表页搜索框中输入关键词后，查看搜索框显示样式变化
	Given  访问安居客首页
	And  点击租房tab
	And  点击租房二级导航小区tab
	When  在搜索框中输入“绿”
	And  查看搜索框样式变化
	Then  出现关键词联想
	And  输入框的右部出现"X"
@P2 @45 A
Scenario : 在租房-小区列表页搜索框中输入关键词后，查看每一条下拉联想词
	Given  访问安居客租房下面二级导航小区tab
	When  在搜索框中输入“绿”
	And  查看每一条下拉联想的样式
	Then  显示为：{联想词}+约{n}套
@P2 @46 A
Scenario : 在租房-小区列表页搜索框中输入关键词后，查看下拉联想的小区套数{n}是否与小区列表页搜索结果数目是否一致
	Given  访问安居客租房下面二级导航小区tab
	When  在搜索框中输入“绿”
	And  查看下拉联想的小区套数{n}是否与租房列表页数目是否一致
	Then  一致
@P2 @47 A
Scenario : 在租房-小区列表页搜索框中输入关键词后，然后点击右侧“X”符号
	Given  访问安居客租房下面二级导航小区tab
	When  在搜索框中输入“绿”
	And  点击右侧"X"
	Then  输入框中的关键词消失
	And 关键词消失后右侧"X"也消失
@P2 @48 A
Scenario : 在租房-小区列表页搜索框中输入关键词后，鼠标在下拉联想中移动，查看搜索框样式
	Given  访问安居客租房下面二级导航小区tab
	When  在搜索框中输入“绿”
	And  用鼠标在下拉联想中移动
	Then  输入框内的文案不变，右侧有"X"
	And  移动到某一条下拉联想时，该下拉联想高亮
@P2 @49 A
Scenario : 在租房-小区列表页搜索框中输入关键词后，键盘在下拉联想中移动，查看搜索框样式
	Given  访问安居客租房下面二级导航小区tab
	When  在搜索框中输入“绿”
	And  用键盘箭头在下拉联想中移动
	Then  输入框内的文案随着键盘定位的文案而对应改变
	And 搜索框右侧有"X"
	And  移动到某一条下拉联想时，该下拉联想高亮
@P3 @50 A
Scenario : 在租房-小区列表页中输入关键词后，在搜索框中点击enter键，查看搜索结果
	Given  访问安居客租房下面二级导航小区tab
	When  在搜索框中输入“绿”
	And  在搜索框中点击enter键
	Then  跳转到以“绿”为关键词的搜索结果页
@P3 @51 A
Scenario : 在租房-小区列表页中输入关键词后，点击“搜索”按钮，查看搜索结果
	Given  访问安居客租房下面二级导航小区tab
	When  在搜索框中输入“绿”
	And  点击搜索按钮
	Then  跳转到以“绿”为关键词的搜索结果页
@P3 @52 A
Scenario : 在租房-小区列表页中输入关键词后，在下拉联想中点击enter键，查看搜索结果
	Given  访问安居客租房下面二级导航小区tab
	When  在搜索框中输入“绿”
	And  在下拉联想中点击enter键
	Then  跳转到以{下拉联想词}为关键词的搜索结果页
@P3 @53 A
Scenario : 在租房-小区列表页中输入关键词后，用鼠标点击下拉联想，查看搜索结果
	Given  访问安居客租房下面二级导航小区tab
	When  在搜索框中输入“绿”
	And  用鼠标点击下拉联想词
	Then  跳转到以{下拉联想词}为关键词的搜索结果页
@P3 @54 A
Scenario : 点击租房-地图找房tab，查看跳转
	Given  点击安居客租房tab
	When  再点击租房下二级导航地图找房tab
	Then  跳转地图找房页面
		
@P2 @55 A
Scenario : 写字楼-出租列表页的搜索框样式
	Given  访问安居客首页
	And  点击写字楼tab
	And  点击写字楼二级导航出租tab
	When  查看页面的搜索模块样式
	Then  搜索框中的文案显示为：请输入房源特征、户型、地址或小区名…
	And  搜索按钮文案为“搜索”
	And  地图找房的文案为：“地图找房”
	And  搜索框右侧无"X"
@P2 @56 A
Scenario : 点击写字楼-出租列表页的搜索框模块中地图找房图标
	Given  访问安居客首页
	And  点击写字楼tab
	And  点击写字楼二级导航出租tab
	When  点击出租列表页的搜索框模块中的地图找房图标
	Then  新开页面至二级导航对应的地图找房频道
@P2 @57 A
Scenario : 点击写字楼-出租列表页的搜索框，验证搜索框内文字提示不消失
	Given  访问安居客首页
	And  点击写字楼tab
	And  点击写字楼二级导航出租tab
	When  点击出租列表页的搜索框
	And  查看搜索框内文字提示是否存在
	Then  存在
@P1 @58 A
Scenario : 在写字楼-出租列表页搜索框中输入关键词后，查看搜索框显示样式变化
	Given  访问安居客首页
	And  点击写字楼tab
	And  点击写字楼二级导航出租tab
	When  在搜索框中输入“绿”
	And  查看搜索框样式变化
	Then  出现关键词联想
	And  输入框的右部出现"X"
@P2 @59 A
Scenario : 在写字楼-出租列表页搜索框中输入关键词后，查看每一条下拉联想词
	Given  访问安居客写字楼下面二级导航出租tab
	When  在搜索框中输入“绿”
	And  查看每一条下拉联想的样式
	Then  显示为：{联想词}+约{n}套
@P2 @60 A
Scenario : 在写字楼-出租列表页搜索框中输入关键词后，查看下拉联想的出租套数{n}是否与写字楼列表页数目是否一致
	Given  访问安居客写字楼下面二级导航出租tab
	When  在搜索框中输入“绿”
	And  查看下拉联想的出租套数{n}是否与写字楼列表页数目是否一致
	Then  一致
@P2 @61 A
Scenario : 在写字楼-出租列表页搜索框中输入关键词后，然后点击右侧“X”符号
	Given  访问安居客写字楼下面二级导航出租tab
	When  在搜索框中输入“绿”
	And  点击右侧"X"
	Then  输入框中的关键词消失
	And 关键词消失后右侧"X"也消失
@P2 @62 A
Scenario : 在写字楼-出租列表页搜索框中输入关键词后，鼠标在下拉联想中移动，查看搜索框样式
	Given  访问安居客写字楼下面二级导航出租tab
	When  在搜索框中输入“绿”
	And  用鼠标在下拉联想中移动
	Then  输入框内的文案不变，右侧有"X"
	And  移动到某一条下拉联想时，该下拉联想高亮
@P2 @63 A
Scenario : 在写字楼-出租列表页搜索框中输入关键词后，键盘在下拉联想中移动，查看搜索框样式
	Given  访问安居客写字楼下面二级导航出租tab
	When  在搜索框中输入“绿”
	And  用键盘箭头在下拉联想中移动
	Then  输入框内的文案随着键盘定位的文案而对应改变
	And 搜索框右侧有"X"
	And  移动到某一条下拉联想时，该下拉联想高亮
@P3 @64 A
Scenario : 在写字楼-出租列表页中输入关键词后，在搜索框中点击enter键，查看搜索结果
	Given  访问安居客写字楼下面二级导航出租tab
	When  在搜索框中输入“绿”
	And  在搜索框中点击enter键
	Then  跳转到以“绿”为关键词的搜索结果页
@P3 @65 A
Scenario : 在写字楼-出租列表页中输入关键词后，点击“搜索”按钮，查看搜索结果
	Given  访问安居客写字楼下面二级导航出租tab
	When  在搜索框中输入“绿”
	And  点击搜索按钮
	Then  跳转到以“绿”为关键词的搜索结果页
@P3 @66 A
Scenario : 在写字楼-出租列表页中输入关键词后，在下拉联想中点击enter键，查看搜索结果
	Given  访问安居客写字楼下面二级导航出租tab
	When  在搜索框中输入“绿”
	And  在下拉联想中点击enter键
	Then  跳转到以{下拉联想词}为关键词的搜索结果页
@P3 @67 A
Scenario : 在写字楼-出租列表页中输入关键词后，用鼠标点击下拉联想，查看搜索结果
	Given  访问安居客写字楼下面二级导航出租tab
	When  在搜索框中输入“绿”
	And  用鼠标点击下拉联想词
	Then  跳转到以{下拉联想词}为关键词的搜索结果页
	
@P2 @68 A
Scenario : 写字楼-出售列表页的搜索框样式
	Given  访问安居客首页
	And  点击写字楼tab
	And  点击写字楼二级导航出售tab
	When  查看页面的搜索模块样式
	Then  搜索框中的文案显示为：请输入房源特征、户型、地址或小区名…
	And  搜索按钮文案为“搜索”
	And  地图找房的文案为：“地图找房”
	And  搜索框右侧无"X"
@P2 @69 A
Scenario : 点击写字楼-出售列表页的搜索框模块中地图找房图标
	Given  访问安居客首页
	And  点击写字楼tab
	And  点击写字楼二级导航出售tab
	When  点击出售列表页的搜索框模块中的地图找房图标
	Then  新开页面至二级导航对应的地图找房频道
@P2 @70 A
Scenario : 点击写字楼-出售列表页的搜索框，验证搜索框内文字提示不消失
	Given  访问安居客首页
	And  点击写字楼tab
	And  点击写字楼二级导航出售tab
	When  点击出售列表页的搜索框
	And  查看搜索框内文字提示是否存在
	Then  存在
	
@P1 @71 A
Scenario : 在写字楼-出售列表页搜索框中输入关键词后，查看搜索框显示样式变化
	Given  访问安居客首页
	And  点击写字楼tab
	And  点击写字楼二级导航出售tab
	When  在搜索框中输入“绿”
	And  查看搜索框样式变化
	Then  出现关键词联想
	And  输入框的右部出现"X"
@P2 @72 A
Scenario : 在写字楼-出售列表页搜索框中输入关键词后，查看每一条下拉联想词
	Given  访问安居客写字楼下面二级导航出售tab
	When  在搜索框中输入“绿”
	And  查看每一条下拉联想的样式
	Then  显示为：{联想词}+约{n}套
@P2 @73 A
Scenario : 在写字楼-出售列表页搜索框中输入关键词后，查看下拉联想的出售套数{n}是否与出售列表页搜索结果数目是否一致
	Given  访问安居客写字楼下面二级导航出售tab
	When  在搜索框中输入“绿”
	And  查看下拉联想的出售套数{n}是否与写字楼列表页数目是否一致
	Then  一致
@P2 @74 A
Scenario : 在写字楼-出售列表页搜索框中输入关键词后，然后点击右侧“X”符号
	Given  访问安居客写字楼下面二级导航出售tab
	When  在搜索框中输入“绿”
	And  点击右侧"X"
	Then  输入框中的关键词消失
	And 关键词消失后右侧"X"也消失
@P2 @75 A
Scenario : 在写字楼-出售列表页搜索框中输入关键词后，鼠标在下拉联想中移动，查看搜索框样式
	Given  访问安居客写字楼下面二级导航出售tab
	When  在搜索框中输入“绿”
	And  用鼠标在下拉联想中移动
	Then  输入框内的文案不变，右侧有"X"
	And  移动到某一条下拉联想时，该下拉联想高亮
@P2 @76 A
Scenario : 在写字楼-出售列表页搜索框中输入关键词后，键盘在下拉联想中移动，查看搜索框样式
	Given  访问安居客写字楼下面二级导航出售tab
	When  在搜索框中输入“绿”
	And  用键盘箭头在下拉联想中移动
	Then  输入框内的文案随着键盘定位的文案而对应改变
	And 搜索框右侧有"X"
	And  移动到某一条下拉联想时，该下拉联想高亮
@P3 @77 A
Scenario : 在写字楼-出售列表页中输入关键词后，在搜索框中点击enter键，查看搜索结果
	Given  访问安居客写字楼下面二级导航出售tab
	When  在搜索框中输入“绿”
	And  在搜索框中点击enter键
	Then  跳转到以“绿”为关键词的搜索结果页
@P3 @78 A
Scenario : 在写字楼-出售列表页中输入关键词后，点击“搜索”按钮，查看搜索结果
	Given  访问安居客写字楼下面二级导航出售tab
	When  在搜索框中输入“绿”
	And  点击搜索按钮
	Then  跳转到以“绿”为关键词的搜索结果页
@P3 @79 A
Scenario : 在写字楼-出售列表页中输入关键词后，在下拉联想中点击enter键，查看搜索结果
	Given  访问安居客写字楼下面二级导航出售tab
	When  在搜索框中输入“绿”
	And  在下拉联想中点击enter键
	Then  跳转到以{下拉联想词}为关键词的搜索结果页
@P3 @80 A
Scenario : 在写字楼-出售列表页中输入关键词后，用鼠标点击下拉联想，查看搜索结果
	Given  访问安居客写字楼下面二级导航出售tab
	When  在搜索框中输入“绿”
	And  用鼠标点击下拉联想词
	Then  跳转到以{下拉联想词}为关键词的搜索结果页
		
@P2 @81 A
Scenario : 写字楼-楼盘列表页的搜索框样式
	Given  访问安居客首页
	And  点击写字楼tab
	And  点击写字楼二级导航楼盘tab
	When  查看页面的搜索模块样式
	Then  搜索框中的文案显示为：请输入房源特征、户型、地址或小区名…
	And  搜索按钮文案为“搜索”
	And  搜索框右侧无"X"
@P2 @82 A
Scenario : 点击写字楼-楼盘列表页的搜索框，验证搜索框内文字提示不消失
	Given  访问安居客首页
	And  点击写字楼tab
	And  点击写字楼二级导航楼盘tab
	When  点击楼盘列表页的搜索框
	And  查看搜索框内文字提示是否存在
	Then  存在
@P1 @71 A
Scenario : 在写字楼-楼盘列表页搜索框中输入关键词后，查看搜索框显示样式变化
	Given  访问安居客首页
	And  点击写字楼tab
	And  点击写字楼二级导航楼盘tab
	When  在搜索框中输入“绿”
	And  查看搜索框样式变化
	Then  出现关键词联想
	And  输入框的右部出现"X"
@P2 @72 A
Scenario : 在写字楼-楼盘列表页搜索框中输入关键词后，查看每一条下拉联想词
	Given  访问安居客写字楼下面二级导航楼盘tab
	When  在搜索框中输入“绿”
	And  查看每一条下拉联想的样式
	Then  显示为：{联想词}+约{n}套
@P2 @73 A
Scenario : 在写字楼-楼盘列表页搜索框中输入关键词后，查看下拉联想的楼盘套数{n}是否与楼盘列表页搜索结果数目是否一致
	Given  访问安居客写字楼下面二级导航楼盘tab
	When  在搜索框中输入“绿”
	And  查看下拉联想的楼盘套数{n}是否与写字楼列表页数目是否一致
	Then  一致
@P2 @74 A
Scenario : 在写字楼-楼盘列表页搜索框中输入关键词后，然后点击右侧“X”符号
	Given  访问安居客写字楼下面二级导航楼盘tab
	When  在搜索框中输入“绿”
	And  点击右侧"X"
	Then  输入框中的关键词消失
	And 关键词消失后右侧"X"也消失
@P2 @75 A
Scenario : 在写字楼-楼盘列表页搜索框中输入关键词后，鼠标在下拉联想中移动，查看搜索框样式
	Given  访问安居客写字楼下面二级导航楼盘tab
	When  在搜索框中输入“绿”
	And  用鼠标在下拉联想中移动
	Then  输入框内的文案不变，右侧有"X"
	And  移动到某一条下拉联想时，该下拉联想高亮
@P2 @76 A
Scenario : 在写字楼-楼盘列表页搜索框中输入关键词后，键盘在下拉联想中移动，查看搜索框样式
	Given  访问安居客写字楼下面二级导航楼盘tab
	When  在搜索框中输入“绿”
	And  用键盘箭头在下拉联想中移动
	Then  输入框内的文案随着键盘定位的文案而对应改变
	And 搜索框右侧有"X"
	And  移动到某一条下拉联想时，该下拉联想高亮
@P3 @77 A
Scenario : 在写字楼-楼盘列表页中输入关键词后，在搜索框中点击enter键，查看搜索结果
	Given  访问安居客写字楼下面二级导航楼盘tab
	When  在搜索框中输入“绿”
	And  在搜索框中点击enter键
	Then  跳转到以“绿”为关键词的搜索结果页
@P3 @78 A
Scenario : 在写字楼-楼盘列表页中输入关键词后，点击“搜索”按钮，查看搜索结果
	Given  访问安居客写字楼下面二级导航楼盘tab
	When  在搜索框中输入“绿”
	And  点击搜索按钮
	Then  跳转到以“绿”为关键词的搜索结果页
@P3 @79 A
Scenario : 在写字楼-楼盘列表页中输入关键词后，在下拉联想中点击enter键，查看搜索结果
	Given  访问安居客写字楼下面二级导航楼盘tab
	When  在搜索框中输入“绿”
	And  在下拉联想中点击enter键
	Then  跳转到以{下拉联想词}为关键词的搜索结果页
@P3 @90 A
Scenario : 在写字楼-楼盘列表页中输入关键词后，用鼠标点击下拉联想，查看搜索结果
	Given  访问安居客写字楼下面二级导航楼盘tab
	When  在搜索框中输入“绿”
	And  用鼠标点击下拉联想词
	Then  跳转到以{下拉联想词}为关键词的搜索结果页
	

	
	
	
	
	
	
@P2 @55 A
Scenario : 商铺-出租列表页的搜索框样式
	Given  访问安居客首页
	And  点击商铺tab
	And  点击商铺二级导航出租tab
	When  查看页面的搜索模块样式
	Then  搜索框中的文案显示为：请输入房源特征、户型、地址或小区名…
	And  搜索按钮文案为“搜索”
	And  地图找房的文案为：“地图找房”
	And  搜索框右侧无"X"
@P2 @56 A
Scenario : 点击商铺-出租列表页的搜索框模块中地图找房图标
	Given  访问安居客首页
	And  点击商铺tab
	And  点击商铺二级导航出租tab
	When  点击出租列表页的搜索框模块中的地图找房图标
	Then  新开页面至二级导航对应的地图找房频道
@P2 @57 A
Scenario : 点击商铺-出租列表页的搜索框，验证搜索框内文字提示不消失
	Given  访问安居客首页
	And  点击商铺tab
	And  点击商铺二级导航出租tab
	When  点击出租列表页的搜索框
	And  查看搜索框内文字提示是否存在
	Then  存在
@P1 @58 A
Scenario : 在商铺-出租列表页搜索框中输入关键词后，查看搜索框显示样式变化
	Given  访问安居客首页
	And  点击商铺tab
	And  点击商铺二级导航出租tab
	When  在搜索框中输入“绿”
	And  查看搜索框样式变化
	Then  出现关键词联想
	And  输入框的右部出现"X"
@P2 @59 A
Scenario : 在商铺-出租列表页搜索框中输入关键词后，查看每一条下拉联想词
	Given  访问安居客商铺下面二级导航出租tab
	When  在搜索框中输入“绿”
	And  查看每一条下拉联想的样式
	Then  显示为：{联想词}+约{n}套
@P2 @60 A
Scenario : 在商铺-出租列表页搜索框中输入关键词后，查看下拉联想的出租套数{n}是否与商铺列表页数目是否一致
	Given  访问安居客商铺下面二级导航出租tab
	When  在搜索框中输入“绿”
	And  查看下拉联想的出租套数{n}是否与商铺列表页数目是否一致
	Then  一致
@P2 @61 A
Scenario : 在商铺-出租列表页搜索框中输入关键词后，然后点击右侧“X”符号
	Given  访问安居客商铺下面二级导航出租tab
	When  在搜索框中输入“绿”
	And  点击右侧"X"
	Then  输入框中的关键词消失
	And 关键词消失后右侧"X"也消失
@P2 @62 A
Scenario : 在商铺-出租列表页搜索框中输入关键词后，鼠标在下拉联想中移动，查看搜索框样式
	Given  访问安居客商铺下面二级导航出租tab
	When  在搜索框中输入“绿”
	And  用鼠标在下拉联想中移动
	Then  输入框内的文案不变，右侧有"X"
	And  移动到某一条下拉联想时，该下拉联想高亮
@P2 @63 A
Scenario : 在商铺-出租列表页搜索框中输入关键词后，键盘在下拉联想中移动，查看搜索框样式
	Given  访问安居客商铺下面二级导航出租tab
	When  在搜索框中输入“绿”
	And  用键盘箭头在下拉联想中移动
	Then  输入框内的文案随着键盘定位的文案而对应改变
	And 搜索框右侧有"X"
	And  移动到某一条下拉联想时，该下拉联想高亮
@P3 @64 A
Scenario : 在商铺-出租列表页中输入关键词后，在搜索框中点击enter键，查看搜索结果
	Given  访问安居客商铺下面二级导航出租tab
	When  在搜索框中输入“绿”
	And  在搜索框中点击enter键
	Then  跳转到以“绿”为关键词的搜索结果页
@P3 @65 A
Scenario : 在商铺-出租列表页中输入关键词后，点击“搜索”按钮，查看搜索结果
	Given  访问安居客商铺下面二级导航出租tab
	When  在搜索框中输入“绿”
	And  点击搜索按钮
	Then  跳转到以“绿”为关键词的搜索结果页
@P3 @66 A
Scenario : 在商铺-出租列表页中输入关键词后，在下拉联想中点击enter键，查看搜索结果
	Given  访问安居客商铺下面二级导航出租tab
	When  在搜索框中输入“绿”
	And  在下拉联想中点击enter键
	Then  跳转到以{下拉联想词}为关键词的搜索结果页
@P3 @67 A
Scenario : 在商铺-出租列表页中输入关键词后，用鼠标点击下拉联想，查看搜索结果
	Given  访问安居客商铺下面二级导航出租tab
	When  在搜索框中输入“绿”
	And  用鼠标点击下拉联想词
	Then  跳转到以{下拉联想词}为关键词的搜索结果页
	
@P2 @68 A
Scenario : 商铺-出售列表页的搜索框样式
	Given  访问安居客首页
	And  点击商铺tab
	And  点击商铺二级导航出售tab
	When  查看页面的搜索模块样式
	Then  搜索框中的文案显示为：请输入房源特征、户型、地址或小区名…
	And  搜索按钮文案为“搜索”
	And  地图找房的文案为：“地图找房”
	And  搜索框右侧无"X"
@P2 @69 A
Scenario : 点击商铺-出售列表页的搜索框模块中地图找房图标
	Given  访问安居客首页
	And  点击商铺tab
	And  点击商铺二级导航出售tab
	When  点击出售列表页的搜索框模块中的地图找房图标
	Then  新开页面至二级导航对应的地图找房频道
@P2 @70 A
Scenario : 点击商铺-出售列表页的搜索框，验证搜索框内文字提示不消失
	Given  访问安居客首页
	And  点击商铺tab
	And  点击商铺二级导航出售tab
	When  点击出售列表页的搜索框
	And  查看搜索框内文字提示是否存在
	Then  存在	
@P1 @71 A
Scenario : 在商铺-出售列表页搜索框中输入关键词后，查看搜索框显示样式变化
	Given  访问安居客首页
	And  点击商铺tab
	And  点击商铺二级导航出售tab
	When  在搜索框中输入“绿”
	And  查看搜索框样式变化
	Then  出现关键词联想
	And  输入框的右部出现"X"
@P2 @72 A
Scenario : 在商铺-出售列表页搜索框中输入关键词后，查看每一条下拉联想词
	Given  访问安居客商铺下面二级导航出售tab
	When  在搜索框中输入“绿”
	And  查看每一条下拉联想的样式
	Then  显示为：{联想词}+约{n}套
@P2 @73 A
Scenario : 在商铺-出售列表页搜索框中输入关键词后，查看下拉联想的出售套数{n}是否与出售列表页搜索结果数目是否一致
	Given  访问安居客商铺下面二级导航出售tab
	When  在搜索框中输入“绿”
	And  查看下拉联想的出售套数{n}是否与商铺列表页数目是否一致
	Then  一致
@P2 @74 A
Scenario : 在商铺-出售列表页搜索框中输入关键词后，然后点击右侧“X”符号
	Given  访问安居客商铺下面二级导航出售tab
	When  在搜索框中输入“绿”
	And  点击右侧"X"
	Then  输入框中的关键词消失
	And 关键词消失后右侧"X"也消失
@P2 @75 A
Scenario : 在商铺-出售列表页搜索框中输入关键词后，鼠标在下拉联想中移动，查看搜索框样式
	Given  访问安居客商铺下面二级导航出售tab
	When  在搜索框中输入“绿”
	And  用鼠标在下拉联想中移动
	Then  输入框内的文案不变，右侧有"X"
	And  移动到某一条下拉联想时，该下拉联想高亮
@P2 @76 A
Scenario : 在商铺-出售列表页搜索框中输入关键词后，键盘在下拉联想中移动，查看搜索框样式
	Given  访问安居客商铺下面二级导航出售tab
	When  在搜索框中输入“绿”
	And  用键盘箭头在下拉联想中移动
	Then  输入框内的文案随着键盘定位的文案而对应改变
	And 搜索框右侧有"X"
	And  移动到某一条下拉联想时，该下拉联想高亮
@P3 @77 A
Scenario : 在商铺-出售列表页中输入关键词后，在搜索框中点击enter键，查看搜索结果
	Given  访问安居客商铺下面二级导航出售tab
	When  在搜索框中输入“绿”
	And  在搜索框中点击enter键
	Then  跳转到以“绿”为关键词的搜索结果页
@P3 @78 A
Scenario : 在商铺-出售列表页中输入关键词后，点击“搜索”按钮，查看搜索结果
	Given  访问安居客商铺下面二级导航出售tab
	When  在搜索框中输入“绿”
	And  点击搜索按钮
	Then  跳转到以“绿”为关键词的搜索结果页
@P3 @79 A
Scenario : 在商铺-出售列表页中输入关键词后，在下拉联想中点击enter键，查看搜索结果
	Given  访问安居客商铺下面二级导航出售tab
	When  在搜索框中输入“绿”
	And  在下拉联想中点击enter键
	Then  跳转到以{下拉联想词}为关键词的搜索结果页
@P3 @80 A
Scenario : 在商铺-出售列表页中输入关键词后，用鼠标点击下拉联想，查看搜索结果
	Given  访问安居客商铺下面二级导航出售tab
	When  在搜索框中输入“绿”
	And  用鼠标点击下拉联想词
	Then  跳转到以{下拉联想词}为关键词的搜索结果页

	
	
@P2 @68 A
Scenario : 商铺-物业列表页的搜索框样式
	Given  访问安居客首页
	And  点击商铺tab
	And  点击商铺二级导航物业tab
	When  查看页面的搜索模块样式
	Then  搜索框中的文案显示为：请输入房源特征、户型、地址或小区名…
	And  搜索按钮文案为“搜索”
	And  搜索框右侧无"X"
@P2 @70 A
Scenario : 点击商铺-物业列表页的搜索框，验证搜索框内文字提示不消失
	Given  访问安居客首页
	And  点击商铺tab
	And  点击商铺二级导航物业tab
	When  点击物业列表页的搜索框
	And  查看搜索框内文字提示是否存在
	Then  存在
@P1 @71 A
Scenario : 在商铺-物业列表页搜索框中输入关键词后，查看搜索框显示样式变化
	Given  访问安居客首页
	And  点击商铺tab
	And  点击商铺二级导航物业tab
	When  在搜索框中输入“绿”
	And  查看搜索框样式变化
	Then  出现关键词联想
	And  输入框的右部出现"X"
@P2 @72 A
Scenario : 在商铺-物业列表页搜索框中输入关键词后，查看每一条下拉联想词
	Given  访问安居客商铺下面二级导航物业tab
	When  在搜索框中输入“绿”
	And  查看每一条下拉联想的样式
	Then  显示为：{联想词}+约{n}套
@P2 @73 A
Scenario : 在商铺-物业列表页搜索框中输入关键词后，查看下拉联想的物业套数{n}是否与物业列表页搜索结果数目是否一致
	Given  访问安居客商铺下面二级导航物业tab
	When  在搜索框中输入“绿”
	And  查看下拉联想的物业套数{n}是否与商铺列表页数目是否一致
	Then  一致
@P2 @74 A
Scenario : 在商铺-物业列表页搜索框中输入关键词后，然后点击右侧“X”符号
	Given  访问安居客商铺下面二级导航物业tab
	When  在搜索框中输入“绿”
	And  点击右侧"X"
	Then  输入框中的关键词消失
	And 关键词消失后右侧"X"也消失
@P2 @75 A
Scenario : 在商铺-物业列表页搜索框中输入关键词后，鼠标在下拉联想中移动，查看搜索框样式
	Given  访问安居客商铺下面二级导航物业tab
	When  在搜索框中输入“绿”
	And  用鼠标在下拉联想中移动
	Then  输入框内的文案不变，右侧有"X"
	And  移动到某一条下拉联想时，该下拉联想高亮
@P2 @76 A
Scenario : 在商铺-物业列表页搜索框中输入关键词后，键盘在下拉联想中移动，查看搜索框样式
	Given  访问安居客商铺下面二级导航物业tab
	When  在搜索框中输入“绿”
	And  用键盘箭头在下拉联想中移动
	Then  输入框内的文案随着键盘定位的文案而对应改变
	And 搜索框右侧有"X"
	And  移动到某一条下拉联想时，该下拉联想高亮
@P3 @77 A
Scenario : 在商铺-物业列表页中输入关键词后，在搜索框中点击enter键，查看搜索结果
	Given  访问安居客商铺下面二级导航物业tab
	When  在搜索框中输入“绿”
	And  在搜索框中点击enter键
	Then  跳转到以“绿”为关键词的搜索结果页
@P3 @78 A
Scenario : 在商铺-物业列表页中输入关键词后，点击“搜索”按钮，查看搜索结果
	Given  访问安居客商铺下面二级导航物业tab
	When  在搜索框中输入“绿”
	And  点击搜索按钮
	Then  跳转到以“绿”为关键词的搜索结果页
@P3 @79 A
Scenario : 在商铺-物业列表页中输入关键词后，在下拉联想中点击enter键，查看搜索结果
	Given  访问安居客商铺下面二级导航物业tab
	When  在搜索框中输入“绿”
	And  在下拉联想中点击enter键
	Then  跳转到以{下拉联想词}为关键词的搜索结果页
@P3 @80 A
Scenario : 在商铺-物业列表页中输入关键词后，用鼠标点击下拉联想，查看搜索结果
	Given  访问安居客商铺下面二级导航物业tab
	When  在搜索框中输入“绿”
	And  用鼠标点击下拉联想词
	Then  跳转到以{下拉联想词}为关键词的搜索结果页

@P3 @81 A
Scenario: 二手房房源单页、二手房小区单页、租房房源单页、租房小区单页、写字楼出售单页、写字楼出租单页、写字楼楼盘单页、
         商铺出售单页、商铺出租单页、商铺物业单页中的搜索框样式（以二手房房源单页为例）
	Given 访问安居客首页
	When  访问二手房房源单页
	And  查看搜索框样式
	Then  应为：请输入房源特征、地址、小区、楼盘名或…+搜索
Who	URL	Method	Scene	Response	E	R
any	/users	POST	创建用户	201创建成功	10	
any	/users	POST	创建用户	400信息错误创建失败	5	
{uid}	/users/{uid}	GET	查看自己信息	200成功查看	8	
{uid}	/users/{uid}	GET	查看自己信息	404查看不成功	3	
other	/users/{uid}	GET	非法查看用户信息	404非法查看	10	
{uid}	/users/{uid}/boughtsonglibrary	GET	查看已买歌曲	200成功查看	8	
{uid}	/users/{uid}/boughtsonglibrary	GET	查看已买歌曲	404查看不成功	3	
other	/users/{uid}/boughtsonglibrary	GET	非法查看其他人已买歌曲列表	404非法操作	5	
{uid}	/users/{uid}/orders	POST	创建订单	201创建成功	10	
{uid}	/users/{uid}/orders	POST	创建订单	400信息错误创建失败	5	
other	/users/{uid}/orders	POST	非法创建其他人订单	404非法操作	5	
{uid}	/users/{uid}/orders	GET	获取所有订单	200成功查看	8	
{uid}	/users/{uid}/orders	GET	获取所有订单	404查看不成功	3	
other	/users/{uid}/orders	GET	非法查看其他人所有订单	404非法操作	5	
{uid}	/users/{uid}/orders/{oid}	GET	查看某个订单	200成功查看	8	
{uid}	/users/{uid}/orders/{oid}	GET	查看某个订单	404查看不成功	3	
other	/users/{uid}/orders/{oid}	GET	非法查看其他人某个订单	404非法操作	5	
{uid}	/users/{uid}/orders/{oid}/payment	GET	查看支付信息	200成功查看	8	
{uid}	/users/{uid}/orders/{oid}/payment	GET	查看支付信息	404查看不成功	3	
other	/users/{uid}/orders/{oid}/payment	GET	非法查看其他人支付信息	404非法操作	5	
{uid}	/users/{uid}/orders/{oid}/products	GET	查看订单中的商品(买会员 or 买歌曲)	200成功查看	8	
{uid}	/users/{uid}/orders/{oid}/products	GET	查看订单中的商品(买会员 or 买歌曲)	404查看不成功	3	
other	/users/{uid}/orders/{oid}/products	GET	非法查看订单中的商品	404非法操作	5	
{uid}	/users/{uid}/downloadreceipt	POST	创建下载凭证	201创建成功	8	
{uid}	/users/{uid}/downloadreceipt	POST	创建下载凭证	400信息错误创建失败	3	
other	/users/{uid}/downloadreceipt	POST	非法创建其他人下载凭证	404非法操作	5	
admin	/songs	POST	上架歌曲	201上架成功	8	
admin	/songs	POST	上架歌曲	400上架失败	3	
any	/songs	GET	获取所有歌曲列表	200成功查看	8	
any	/songs	GET	获取所有歌曲列表	404查看不成功	3	
any	/songs/{sid}	GET	获取歌曲信息	200成功查看	8	
any	/songs/{sid}	GET	获取歌曲信息	404查看不成功	3	
                                                185	0

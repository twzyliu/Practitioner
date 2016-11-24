
Who	URL	Method	Scene	Response	E	R	

any	/users	POST	创建用户	成功创建201	8	19	gradle不熟	Jersey test不熟	Mock eq?



any	/users	POST	创建用户	用户已存在400	 3	 2	



{uid}	/users/{uid}	GET	查看自己用户信息	成功获取200	8	6	



{uid}	/users/{uid}	GET	查看自己用户信息	找不到用户信息404	2	1	



{others}	/users/{uid}	GET	非法查看用户信息	非法操作404	3	11	建currentUser	



{uid}	/users/{uid}/session	POST	登陆成功创建session	成功创建201	8	0	



{uid}	/users/{uid}/session	POST	登陆成功创建session	创建失败400	2	0	



{others}	/users/{uid}/session	POST	非法创建session	非法操作404	3	0	



{uid}	/users/{uid}/session	GET	获取登陆信息	成功获取200	8	0	



{uid}	/users/{uid}/session	GET	获取登陆信息	获取信息失败404	2	0	



{others}	/users/{uid}/session	GET	非法获取登陆信息	非法操作404	3	0	



{uid}	/users/{uid}/orders	POST	买家下单	成功创建201	8	30	重构API	


{uid}	/users/{uid}/orders	POST	买家下单	订单未生成400	2	2	



others	/users/{uid}/orders	POST	非法下单	非法操作404	3	4	



{uid}	/users/{uid}/orders	GET	查看自己所有订单	成功获取200	8	15	List tojson	


{uid}	/users/{uid}/orders	GET	查看自己所有订单	找不到用户订单404	2	2	



others	/users/{uid}/orders	GET	非法查看订单	非法操作404	3	4	



{uid}	/users/{uid}/orders/{oid}	GET	查看订单信息	成功获取200	8	20	Mock any()	


{uid}	/users/{uid}/orders/{oid}	GET	查看订单信息	订单未找到404	2	3	



{others}	/users/{uid}/orders/{oid}	GET	非法查看订单信息	非法操作404	3	2	



{uid}	/users/{uid}/orders/{oid}/orderItems	GET	查看订单中所有货物	成功获取200	8	0	



{uid}	/users/{uid}/orders/{oid}/orderItems	GET	查看订单中所有货物	没有货物404	2	0	



others	/users/{uid}/orders/{oid}/orderItems	GET	非法查看订单中所有货物	非法操作404	3	0	



{uid}	/users/{uid}/orders/{oid}/orderItems/{pid}	GET	查看订单中某个货物信息	成功获取200	8	0	



{uid}	/users/{uid}/orders/{oid}/orderItems/{pid}	GET	查看订单中某个货物信息	找不到货物404	2	0	



{others}	/users/{uid}/orders/{oid}/orderItems/{pid}	GET	非法查看订单中某个货物信息	非法操作404	3	0	



{uid}	/users/{uid}/orders/{oid}/payment	GET	获得应付款账单	成功获取200	8	2	



{uid}	/users/{uid}/orders/{oid}/payment	GET	获得应付款账单	未找到账单404	2	4	



{others}	/users/{uid}/orders/{oid}/payment	GET	非法获得账单	非法操作404	3	2	



{uid}	/users/{uid}/refundOrders	POST	买家创建退货单	成功创建201	8	7	



{uid}	/users/{uid}/refundOrders	POST	买家创建退货单	退货单不能成功创建400	2	1	



{others}	/users/{uid}/refundOrders	POST	非法创建退货单	非法操作404	3	1	



{uid}	/users/{uid}/refundOrders	GET	查看所有退货单	成功获取200	8	3	



{uid}	/users/{uid}/refundOrders	GET	查看所有退货单	退货单不存在404	2	3	



{others}	/users/{uid}/refundOrders	GET	非法查看所有退货单	非法操作404	3	1	



{uid}	/users/{uid}/refundOrders/{roid}	GET	查看退货单	成功获取200	8	5	



{uid}	/users/{uid}/refundOrders/{roid}	GET	查看退货单	退货单不存在404	2	2	



{others}	/users/{uid}/refundOrders/{roid}	GET	非法查看退货单	非法操作404	3	6	



{uid}	/users/{uid}/refundOrder/{roid}/refund	GET	查看退货款	成功获取200	8	10	重构	


{uid}	/users/{uid}/refundOrder/{roid}/refund	GET	查看退货款	未找到退货款404	2	4	



{others}	/users/{uid}/refundOrder/{roid}/refund	GET	非法查看退货款	非法操作404	3	2	



{uid}	/users/{uid}/products	POST	卖家上架货物	成功创建201	8	16	



{uid}	/users/{uid}/products	POST	卖家上架货物	货物上架失败400	2	1	



{others}	/users/{uid}/products	POST	非法上架货物	非法操作404	3	2	



any	/users/{uid}/products	GET	查看卖家所有上架货物	成功获取200	8	9	



any	/users/{uid}/products	GET	查看卖家所有上架货物	无货物404	3	1	



any	/users/{uid}/products/{pid}	GET	查看卖家某个上架货物	成功获取200	8	7	



any	/users/{uid}/products/{pid}	GET	查看卖家某个上架货物	无货物404	3	2	


                                                                   215	212	




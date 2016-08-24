# clothes-matchingAndcommenting
服装设计网站


每次请求首先登陆
/user/login?username=admin&password=123


1：上传接口
/cloth/upload

传入参数：1：file：文件信息 2：content：图片描述信息

返回值（如下json格式，图片信息是个base64,直接存放到src即可）：
{"content":"123131","iconPath":"data:image/jpg;base64,/9j/4AAQSkZJRgABAgAAAQABAAD/2wBDAAgGBgc................opFH//2Q==","isSuccess":"success","userName":"admin"}

查询服装图片信息
2：/cloth/query
传入参数：1：pageNumber：第几页 2：pageSize：每页大小（不传入默认10页） 3：serach：模糊搜索

返回值(图片为base64,直接存放到src即可)：
{"result":{"totalCount":7,"pageSize":1,"pageNo":1,"list":[{"isSuccess":null,"cause":null,"clothId":31,"clothIcon":"data:image/jpg;base64,/9j/4AA........Df8Ay8/8A/rWFW74b/5ef+Af1qnsc1L4kb1cXff8f9z/ANdW/ma7SuLvv+P+5/66t/M0omtbZFjRv+QtB/oxUdgooopFH//2Q==","clothDesc":"","likeCount":0,"commentCount":0,"userId":3,"userName":"admin","userIcon":"data:image/jpg;base64,/9j/4AAQSkZJRgABAgAAAQABAAD/2wBD........gooopFH//2Q==","createTime":null}],"firstResult":0,"segment":[1,2,3,4,5,6,7],"prePage":1,"nextPage":2,"lastPage":false,"totalPage":7,"firstPage":true}}

点赞接口
3:/cloth/like
传入数据 clothId：服装id
返回值：{"result":"success"} 

收藏接口
4:/cloth/collect
传入数据 clothId：服装id
返回值：{"result":0} 0:已经收藏 1：收藏成功 2：缺乏必要的参数

详情页
5：/cloth/detail
传入参数：clothId：服装id
{"result":{"isSuccess":null,"cause":null,"clothId":31,"clothIcon":"b2854ebe-fe37-4fad-baeb-797fa4a4efd1","clothDesc":"data:image/jpg;base64,/9j/4AAQSkZJRgABAgAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcp........./2Q==","createTime":1471686463852}} 如果result为0服务器异常，1：参数不合法


查询评论接口
6：/comment/list
传入参数：pageNumber：页码，pageSize：每页数据，clothId：服装id，type：评论类型（ 1：达人，2：点评师）
返回值：
{"result":{"totalCount":3,"pageSize":10,"pageNo":1,"list":[{"isSuccess":null,"cause":null,"comment":{"id":3,"topicId":1,"topicType":1,"content":"0","fromId":3,"createTime":1471762956657,"userId":null,"userIcon":"data:image/jpg;base64,/9j/4AAQSkZJRgABAgAAAQABAAD/2wBgooopFH//2Q==","userName":"admin"},"replyList":[{"id":1,"commentId":1,"replyId":1,"replyType":2,"content":"asdfa啊打发法啊","fromUid":2,"toUid":1,"createTime":1471260989584},{"id":2,"commentId":1,"replyId":1,"replyType":null,"content":"0","fromUid":3,"toUid":null,"createTime":1471763004959},{"id":3,"commentId":1,"replyId":1,"replyType":null,"content":"0","fromUid":3,"toUid":null,"createTime":1472040008496},{"id":4,"commentId":1,"replyId":1,"replyType":null,"content":"0","fromUid":3,"toUid":null,"createTime":1472040742656}],"hasMoreReply":false},{"isSuccess":null,"cause":null,"comment":{"id":2,"topicId":1,"topicType":1,"content":"0","fromId":3,"createTime":1471762803351,"userId":null,"userIcon":"data:image/jpg;base64,/9j/4AAQSkZJRgABAgAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJC7/55wf8AfJ/FH//2Q==","userName":"admin"},"replyList":[{"id":1,"commentId":1,"replyId":1,"replyType":2,"content":"asdfa啊打发法啊","fromUid":2,"toUid":1,"createTime":1471260989584},{"id":2,"commentId":1,"replyId":1,"replyType":null,"content":"0","fromUid":3,"toUid":null,"createTime":1471763004959},{"id":3,"commentId":1,"replyId":1,"replyType":null,"content":"0","fromUid":3,"toUid":null,"createTime":1472040008496},{"id":4,"commentId":1,"replyId":1,"replyType":null,"content":"0","fromUid":3,"toUid":null,"createTime":1472040742656}],"hasMoreReply":false}],"firstResult":0,"segment":[1],"totalPage":1,"lastPage":true,"nextPage":1,"prePage":1,"firstPage":true}} 如果result为0服务器异常，1：参数不合法

评论接口
7:/comment/insert
传入参数：clothId:服装id，content：评论信息
返回值{"result":"success"} 如果result为0服务器异常，1或者2：参数不合法

回复接口
8：/comment/reply
传入参数：commentId： 评论消息id， content：回复内容，toUserId：评论用户id
{"result":{"isSuccess":"success","cause":null,"reply":{"id":null,"commentId":1,"replyId":1,"replyType":null,"content":"0","fromUid":3,"toUid":null,"createTime":1472040742656}}}

获取回复消息
9：/comment/replyList
传入参数 ：pageNumber: 页码，pageSize: 数量，commentId:评论id
{"result":{"totalCount":4,"pageSize":10,"pageNo":1,"list":[{"id":2,"commentId":1,"replyId":1,"replyType":null,"content":"0","fromUid":3,"toUid":null,"createTime":1471763004959},{"id":3,"commentId":1,"replyId":1,"replyType":null,"content":"0","fromUid":3,"toUid":null,"createTime":1472040008496},{"id":4,"commentId":1,"replyId":1,"replyType":null,"content":"0","fromUid":3,"toUid":null,"createTime":1472040742656}],"firstResult":0,"segment":[1],"totalPage":1,"firstPage":true,"lastPage":true,"nextPage":1,"prePage":1}}
 如果result为0服务器异常，1或者2：参数不合法

 如有问题请提出issue到https://github.com/strictnerd/clothes-matchingAndcommenting.git
